package id.fauzanag.ppdbsekolah.ui.onboarding.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.fauzanag.ppdbsekolah.R;
import id.fauzanag.ppdbsekolah.ui.student.RegisterStudentOneActivity;

public class TwoBoardingActivity extends AppCompatActivity {

    private Button btFinishStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_boarding);

        initView();
        onClick();
    }

    private void initView() {
        btFinishStep = (Button) findViewById(R.id.finishStep2);
    }

    private void onClick() {
        btFinishStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchToRegisterStudent();
            }
        });
    }

    private void launchToRegisterStudent() {
        Intent moveRegister = new Intent(TwoBoardingActivity.this, RegisterStudentOneActivity.class);
        moveRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveRegister);
    }
}
