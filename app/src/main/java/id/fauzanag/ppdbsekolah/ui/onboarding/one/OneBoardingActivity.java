package id.fauzanag.ppdbsekolah.ui.onboarding.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.fauzanag.ppdbsekolah.R;
import id.fauzanag.ppdbsekolah.ui.onboarding.two.TwoBoardingActivity;

public class OneBoardingActivity extends AppCompatActivity {

    private Button btNextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_boarding);

        initView();
        onClick();
    }

    private void initView() {
        btNextStep = (Button) findViewById(R.id.btn_nextStep1);
    }

    private void onClick() {
        btNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchToNextStep();
            }
        });
    }

    private void launchToNextStep() {
        Intent moveStep = new Intent(OneBoardingActivity.this, TwoBoardingActivity.class);
        moveStep.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveStep);
    }
}
