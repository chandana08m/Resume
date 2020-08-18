package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView name;
        TextView desc;
        TextView mail;
        TextView phone;
        TextView city;
        TextView skill;
        ImageView mail_im;
        ImageView phone_im;
        mail_im=findViewById(R.id.imageView);
        phone_im=findViewById(R.id.imageView2);
        name=findViewById(R.id.name);
        desc=findViewById(R.id.desc);
        city=findViewById(R.id.city);
        mail=findViewById(R.id.mail);
        phone=findViewById(R.id.phone);
        skill=findViewById(R.id.skills);
        Intent extra=getIntent();
        String name1 = extra.getStringExtra("name");
        String desc1 = extra.getStringExtra("desc");
        final String mail1 = extra.getStringExtra("mail");
        final String phone1 = extra.getStringExtra("phone");
        String city1 = extra.getStringExtra("city");
        String skill1 = extra.getStringExtra("skills");
        name.setText(name1);
        desc.setText(desc1);
        mail.setText(mail1);
        phone.setText(phone1);
        city.setText(city1);
        skill.setText(skill1);
        mail_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_SEND);
                intent3.setData(Uri.parse("Mail to:"));
                intent3.putExtra(Intent.EXTRA_EMAIL,mail1);
                intent3.putExtra(Intent.EXTRA_SUBJECT,"resume APPROVED");
                intent3.putExtra(Intent.EXTRA_TEXT,"CONGRATULATION !!");
                intent3.setType("message/rfc822 ");
                startActivity(Intent.createChooser(intent3,"CHOOSE ANY ONE"));
            }
        });
        phone_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Main2Activity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    String dial="tel:"+phone1;
                    startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
                }

            }
        });




    }
}
