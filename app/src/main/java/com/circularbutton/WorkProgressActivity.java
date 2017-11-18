package com.circularbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import static android.view.View.GONE;


public class WorkProgressActivity extends AppCompatActivity
{
    public static void startThisActivity(Activity activity)
    {
        activity.startActivity(new Intent(activity, WorkProgressActivity.class));
    }


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.caregiver_decision_progress_layout)
    RelativeLayout caregiver_decision_progress_layout;

    @BindView(R.id.pbLookForCaregiver)
    ProgressBar pbLookForCaregiver;

    @BindView(R.id.btnCaregiverButtonImage)
    ImageButton btnCaregiverButtonImage;

    @BindView(R.id.txtLookForCaregiver)
    TextView txtLookForCaregiver;


    @BindView(R.id.caregiver_task_progress_layout)
    RelativeLayout caregiver_task_progress_layout;

    @BindView(R.id.pbCaregiverOnTheWay)
    ProgressBar pbCaregiverOnTheWay;

    @BindView(R.id.btnCaregiverArrived)
    ImageButton btnCaregiverArrived;

    @BindView(R.id.txtCaregiverOnTheWay)
    TextView txtCaregiverOnTheWay;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_status);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                pbLookForCaregiver.setVisibility(GONE);
                btnCaregiverButtonImage.setImageResource(R.drawable.icon_success_green);
                txtLookForCaregiver.setText("CAREGIVER FOUND");
                txtLookForCaregiver.setTextColor(getResources().getColor(R.color.color_font_green));
                caregiver_decision_progress_layout.setBackgroundResource(R.drawable.bg_green_box);


                caregiver_task_progress_layout.setBackgroundResource(R.drawable.bg_blue_box);
                pbCaregiverOnTheWay.setVisibility(View.VISIBLE);
                btnCaregiverArrived.setImageResource(R.drawable.ic_white_circle_caregiver_blue);
                txtCaregiverOnTheWay.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                pbCaregiverOnTheWay.setVisibility(View.GONE);

                caregiver_task_progress_layout.setBackgroundResource(R.drawable.bg_green_box);
                btnCaregiverArrived.setImageResource(R.drawable.icon_success_green);
                txtCaregiverOnTheWay.setTextColor(getResources().getColor(R.color.color_font_green));
                txtCaregiverOnTheWay.setText("CAREGIVER ARRIVED");
            }
        }, 10000);


    }


}
