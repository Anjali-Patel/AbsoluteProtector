package com.example.absoluteprotector;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {
    String str1,str2,str3,str4,name,email;
    EditText tv1,tv2,tv3,tv4;
    TextView update,save;

    SharedPreferences sharedPreferences;
    ImageView back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        tv1=findViewById(R.id.et1);
        tv2=findViewById(R.id.et2);
        update=(TextView)findViewById(R.id.update);

        tv3=findViewById(R.id.et3);

        tv4=findViewById(R.id.et4);
        back_button=findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences prefs = getSharedPreferences("preferences", MODE_PRIVATE);

        str1 = prefs.getString("name", "");
        str2 = prefs.getString("email", "");
        str3 = prefs.getString("deviceId", "");
        str4 = prefs.getString("mobilenumber", "");
        tv1.setText(str1);
        tv2.setText(str2);

        tv3.setText(str3);

        tv4.setText(str4);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=tv1.getText().toString();
                email=tv2.getText().toString();


                SharedPreferences.Editor editor = getSharedPreferences("preferences", MODE_PRIVATE).edit();
                editor.putString("name1", name);
                editor.putString("email1", email);
                editor.apply();


            }
        });


    }
}
