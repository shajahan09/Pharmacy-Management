package com.test.pharmecyproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.test.pharmecyproject.db.DatabaseHelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity_signup extends AppCompatActivity {
ImageButton imageButton;
EditText signupName,signupEmail,signupPass,signupconfpass,phone;
Button signupBtn;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper(this);
        signupName = findViewById(R.id.sgnName);
        signupEmail = findViewById(R.id.sgnEmail);
        phone = findViewById(R.id.sgnPhn);
        signupPass = findViewById(R.id.sgnPass);
        signupconfpass = findViewById(R.id.sgnConfPass);
        signupBtn =findViewById(R.id.signupBtn);

    imageButton =findViewById(R.id.signBack);

imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity_signup.this,Main2Activity.class);
        startActivity(intent);
    }
});
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String user  = signupName.getText().toString().trim();
                String email  = signupEmail.getText().toString().trim();
                String pass  = signupPass.getText().toString().trim();
                String conpass  = signupconfpass.getText().toString().trim();
                String phones  = phone.getText().toString().trim();
                Log.d("value---> ",email);
                Log.d("test---> ",pass);
                if(pass.equals(conpass)){
                    Long val = db.addUser(email,pass);
                    if(val>1){
                        Toast.makeText(MainActivity_signup.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity_signup.this,Main2Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity_signup.this,"Failed registered",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity_signup.this,"password Mismatch",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
