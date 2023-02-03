package com.example.drowsinessdetectorapp.activity;

import com.example.drowsinessdetectorapp.R;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,RegesterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
    public void Start(View View){
        startActivity(new Intent(this,StartingActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}