package id.fauzanag.ppdbsekolah.ui.account.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.fauzanag.ppdbsekolah.R;
import id.fauzanag.ppdbsekolah.ui.account.register.RegisterActivity;
import id.fauzanag.ppdbsekolah.ui.onboarding.one.OneBoardingActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView tvRegister;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        onClick();
    }

    private void initView() {
        tvRegister = (TextView) findViewById(R.id.tv_Register);
        btLogin = (Button) findViewById(R.id.btn_login);
    }

    private void onClick() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchToRegister();
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchToOneBoarding();
            }
        });
    }

    private void LaunchToRegister() {
        Intent moveRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        moveRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveRegister);
    }

    private void LaunchToOneBoarding() {
        Intent moveRegisterStudent = new Intent(LoginActivity.this, OneBoardingActivity.class);
        moveRegisterStudent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveRegisterStudent);
    }
}
