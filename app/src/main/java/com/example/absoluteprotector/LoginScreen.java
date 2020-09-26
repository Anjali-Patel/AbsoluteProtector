package com.example.absoluteprotector;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class LoginScreen extends AppCompatActivity {
    TextView bt,forgot_code;
    EditText et1,et2,et3,et4,et5;
    String name,email,deviceId,mobilenumber,code;
    CheckBox checkTerms;
    TextView view_terms;
    SharedPreferences sharedPreferences;

    public static final String TERMSNCONDITIONS ="http://absolutestoreindia.com/terms/Absolute-Term&Condition.html";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);
        bt = (TextView)findViewById(R.id.Registration_submit);
        view_terms=findViewById(R.id.viewTerms);
et1=(EditText)findViewById(R.id.et1);
        forgot_code=findViewById(R.id.forgot_code);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        checkTerms=findViewById(R.id.checkTerms);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=et2.getText().toString();
                deviceId=et3.getText().toString();
                mobilenumber=et4.getText().toString();

                code=et5.getText().toString();
                name=et1.getText().toString().trim();
                SharedPreferences.Editor editor = getSharedPreferences("preferences", MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("deviceId", deviceId);
                editor.putString("mobilenumber", mobilenumber);
                editor.apply();
                validatioon();

            }
        });
        view_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TermsConditions.class);
                i.putExtra("AppName", "Terms & Conditions");
                i.putExtra("Url", TERMSNCONDITIONS);
                startActivity(i);
            }
        });
        forgot_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(LoginScreen.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }
    private void validatioon(){
//        if(name.equalsIgnoreCase("")){
//            Toast.makeText(LoginScreen.this,"Please Enter Your Name",Toast.LENGTH_LONG).show();
//
//        }
//       else if(email.equalsIgnoreCase("")){
//            Toast.makeText(LoginScreen.this,"Please Enter Your Email",Toast.LENGTH_LONG).show();
//
//        }
//       else if(mobilenumber.equalsIgnoreCase("")){
//            Toast.makeText(LoginScreen.this,"Please Enter Your Mobile Number",Toast.LENGTH_LONG).show();
//
//        }
//       else if(deviceId.equalsIgnoreCase("")){
//            Toast.makeText(LoginScreen.this,"Please Enter Your Device Id",Toast.LENGTH_LONG).show();

//        }
      if(!checkTerms.isChecked()) {
            Toast.makeText(LoginScreen.this,"Please Accept terms and Conditions",Toast.LENGTH_LONG).show();
        }
//       else if(code.equalsIgnoreCase("")){
//        Toast.makeText(LoginScreen.this, "Please Enter Your Code", Toast.LENGTH_LONG).show();
//    }

        else {
            Intent intent = new Intent(LoginScreen.this, AllApplications.class);
            startActivity(intent);
            finish();
        }

    }
    @Override
    public void onBackPressed() {
      /*  if (back_pressed + 1000 > System.currentTimeMillis())
            finishAffinity();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginScreen.this);
        builder.create();
        builder.setMessage("Are You Sure You Want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}

