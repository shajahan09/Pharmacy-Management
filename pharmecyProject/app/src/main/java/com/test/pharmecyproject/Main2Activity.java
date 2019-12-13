package com.test.pharmecyproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.test.pharmecyproject.db.DatabaseHelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         final EditText emailText,passwordText;

       Button login = findViewById(R.id.login);
        Button button1 = findViewById(R.id.register);
        emailText = findViewById(R.id.logiEmail);
        passwordText = findViewById(R.id.loginPass);




        db = new DatabaseHelper(this);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  user = emailText.getText().toString().trim();
                String  pass = passwordText.getText().toString().trim();
                Boolean res = db.checkUser(user,pass);

                try {
                    if(res == true){
                        Toast.makeText(Main2Activity.this,"Successfull Login",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent);
                    }

                }catch (Exception e){
                    Log.d("ErrorLogin-->",e.getMessage());

                    Toast.makeText(Main2Activity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }


}

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() ==R.id.register){
                    Intent intent =  new Intent(Main2Activity.this,MainActivity_signup.class);
                    startActivity(intent);

                }

            }
        });
    }

}
