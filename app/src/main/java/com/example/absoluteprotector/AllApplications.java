package com.example.absoluteprotector;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class AllApplications extends AppCompatActivity {
    ImageView update;
ImageView play_alarm,detect_your_device,location_log,relative_info,user_profile,device_status,about_us,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_all_applications);
update=findViewById(R.id.update);
play_alarm=findViewById(R.id.play_alarm);
detect_your_device=findViewById(R.id.detect_your_device);
location_log=findViewById(R.id.location_log);
relative_info=findViewById(R.id.relative_info);
user_profile=findViewById(R.id.user_profile);
device_status=findViewById(R.id.device_status);
about_us=findViewById(R.id.about_us);
logout=findViewById(R.id.logout);


play_alarm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,PlayAlarmActivity.class);
        startActivity(intent);

    }
});
detect_your_device.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,DetectYourDeviceActivity.class);
        startActivity(intent);
    }
});
device_status.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,DeviceStatusActivity.class);
        startActivity(intent);
    }
});
relative_info.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,RelativeInfoActivity.class);
        startActivity(intent);
    }
});
user_profile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(AllApplications.this,UserProfileActivity.class);
        startActivity(intent);
    }
});
about_us.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,AboutUsActivity.class);
        startActivity(intent);
    }
});
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AllApplications.this);
                builder.create();
                builder.setMessage("Are You Sure You Want to Logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AllApplications.this, LoginScreen.class);

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
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckUpdate();
            }
        });
location_log.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AllApplications.this,LocationLogActivity.class);
        startActivity(intent);
    }
});
    }

    @Override
    public void onBackPressed() {
      /*  if (back_pressed + 1000 > System.currentTimeMillis())
            finishAffinity();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();*/
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
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
    public void CheckUpdate() {
        Intent intent=new Intent(AllApplications.this,CheckForUpdates.class);
        startActivity(intent);
    }

}
