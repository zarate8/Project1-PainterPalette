package edu.utah.cs4962.project1;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class PaintActivity extends Activity {

    //PaintView _paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        View view = new View(this);
        view.setBackgroundColor(Color.RED);

        rootLayout.addView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        final PaletteView paletteLayout = new PaletteView(this);
        //rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.addView(paletteLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));

        // Determine how many splotches we want on the palette
        for (int splotchIndex = 0; splotchIndex < 6; splotchIndex++) {

            PaintView paintView = new PaintView(this);
            paintView.setBackgroundColor(Color.TRANSPARENT);

            if(splotchIndex == 0) {
                paintView.setColor(Color.RED);
            }
            if(splotchIndex == 1) {
                paintView.setColor(0xFFFFA500);
            }
            if(splotchIndex == 2) {
                paintView.setColor(Color.YELLOW);
            }
            if(splotchIndex == 3) {
                paintView.setColor(Color.BLUE);
            }
            if(splotchIndex == 4) {
                paintView.setColor(Color.GREEN);
            }
            if(splotchIndex == 6) {
                paintView.setColor(0xFF800080);
            }

            paletteLayout.addView(paintView, new LinearLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT));

            paintView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //((PaintView)v).setVisibility(View.GONE);
                    paletteLayout.removeColor((PaintView)v);
                }
            });

            //paletteLayout.removeColor(paintView);

            // _paintView.setOnSplotchTouchListener() -> Just a method.
            // new View.OnSplotchTouchListener() -> Interface definition.
            // The rest -> an anonymous class definition. (An anonymous inner class of activity)
            paintView.setOnSplotchTouchListener(new PaintView.OnSplotchTouchListener() {
                @Override
                public void onSplotchTouched(PaintView v) {
                    ((PaintView)v).setColor(Color.DKGRAY);
                }
            });
        }
        setContentView(rootLayout);


    }
}