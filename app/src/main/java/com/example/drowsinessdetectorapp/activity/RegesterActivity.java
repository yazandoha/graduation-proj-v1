package com.example.drowsinessdetectorapp.activity;

import com.example.drowsinessdetectorapp.R;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Patterns;

public class RegesterActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView cirRegisterButton;
    private EditText editTextName,editTextEmail,editTextMobile,editTextPassword;//-------------------------new
    private ProgressBar progressBar;//-------------------------new
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_regester);
        changeStatusBarColor();

        cirRegisterButton =(Button) findViewById(R.id.cirRegisterButton);
        cirRegisterButton.setOnClickListener(this);

        editTextName =(EditText)findViewById(R.id.editTextName);
        editTextEmail =(EditText)findViewById(R.id.editTextEmail);
        editTextMobile =(EditText)findViewById(R.id.editTextMobile);
        editTextPassword =(EditText)findViewById(R.id.editTextPassword);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cirRegisterButton:
                registerUser();
                break;
        }
    }
    public void registerUser(){
        String name=editTextName.getText().toString().trim();
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String mobile=editTextMobile.getText().toString().trim();

        if(name.isEmpty()){
            editTextName.setError("name is required !");
            editTextName.requestFocus();
            return;
        }
        if(mobile.isEmpty()){
            editTextMobile.setError("mobile is required !");
            editTextMobile.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("email is required !");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("pleas provide valid email !");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("password is required !");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<7){
            editTextPassword.setError("Error .. password length less than 7 !");
            editTextPassword.requestFocus();
            return;
        }
    }


}
