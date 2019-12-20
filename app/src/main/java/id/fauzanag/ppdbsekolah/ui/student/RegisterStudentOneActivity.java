package id.fauzanag.ppdbsekolah.ui.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import id.fauzanag.ppdbsekolah.R;

public class RegisterStudentOneActivity extends AppCompatActivity {

    private RadioGroup radioGroupJenisKel;
    private RadioButton radioButtonJenisKel;
    private Button btnRegiserOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_one);

        initView();
        addListenerRadioGroup();
        onClick();
    }

    private void initView() {
        radioGroupJenisKel = (RadioGroup) findViewById(R.id.radioGrupJK);
        btnRegiserOne = (Button) findViewById(R.id.btn_RegisterOne);
    }

    private void addListenerRadioGroup() {
        //Pilih radio button yang ada di Radio Group
        int selectedID = radioGroupJenisKel.getCheckedRadioButtonId();

        //Mencari radio Button
        radioButtonJenisKel = (RadioButton) findViewById(selectedID);
    }

    private void onClick() {
        btnRegiserOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchToRegisterTwo();
            }
        });
    }

    private void LaunchToRegisterTwo() {
        Intent moveRegisterTwo = new Intent(RegisterStudentOneActivity.this, RegisterStudentTwoActivity.class);
        moveRegisterTwo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveRegisterTwo);
    }
}
