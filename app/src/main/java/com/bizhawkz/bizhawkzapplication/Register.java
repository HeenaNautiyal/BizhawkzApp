package com.bizhawkz.bizhawkzapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
EditText usernem,useremail;
    Button submit;
    String user,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernem=(EditText)findViewById(R.id.et_user);
        useremail=(EditText)findViewById(R.id.et_email);
        submit=(Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             user=usernem.getText().toString();
             mail=useremail.getText().toString();
               // new registerlog().execute();
            }
        });

          /*Intent it = new Intent(Register.this,MainActivity.class);
        startActivity(it);*/
    }


   /* private class registerlog extends AsyncTask<> {
    }*/
}
