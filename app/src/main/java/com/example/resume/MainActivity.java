package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit;
        final EditText name;
        final EditText desc;
        final EditText city;
        final EditText mail;
        final EditText phone;
        final EditText skills;
        submit=findViewById(R.id.button_1);
        name=findViewById(R.id.edit_name);
        desc=findViewById(R.id.edit_describe);
        city=findViewById(R.id.edit_city);
        mail=findViewById(R.id.edit_mail);
        phone=findViewById(R.id.edit_phone);
        skills=findViewById(R.id.edit_skill);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string1=name.getText().toString();
                String string2=desc.getText().toString();
                String string3=mail.getText().toString();
                String string4=phone.getText().toString();
                String string5=city.getText().toString();
                String string6=skills.getText().toString();
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("name", string1);
                intent.putExtra("desc", string2);
                intent.putExtra("mail", string3);
                intent.putExtra("phone", string4);
                intent.putExtra("city", string5);
                intent.putExtra("skills", string6);
                startActivity(intent);
                finish();
            }
        });
      }
}
