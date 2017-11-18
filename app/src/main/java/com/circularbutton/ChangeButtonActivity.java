package com.circularbutton;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Indeterminate Progress Sample
 */
public class ChangeButtonActivity extends Activity
{
    @BindView(R.id.btnCaregiverButtonImage)
    ImageButton btnCaregiverButtonImage;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    public static void startThisActivity(Activity activity) {
        activity.startActivity(new Intent(activity, ChangeButtonActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_button);

        ButterKnife.bind(this);

        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.IndeterminateProgressSample);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                progressBar.setProgress(50);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {

                progressBar.setVisibility(View.INVISIBLE);
                btnCaregiverButtonImage.setImageResource(R.drawable.icon_success_green);
            }
        }, 5000);

        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
    }
}
