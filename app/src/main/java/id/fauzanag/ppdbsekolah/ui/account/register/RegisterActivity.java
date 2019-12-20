package id.fauzanag.ppdbsekolah.ui.account.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.fauzanag.ppdbsekolah.R;
import id.fauzanag.ppdbsekolah.ui.account.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        onClick();
    }

    private void initView() {
        tvLogin = (TextView) findViewById(R.id.tv_Login);
    }

    private void onClick() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchToLogin();
                finish();
            }
        });
    }

    private void LaunchToLogin() {
        Intent moveLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        moveLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(moveLogin);
    }
}
