package com.strangersforsalik.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;


public class SignupActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    EditText emailBox, passwordBox;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //findViewById(R.id.editTextTextPersonName)
        //findViewById(R.id.editTextTextPassword)
        b1=findViewById(R.id.button);
        //findViewById(R.id.textView)


        mAuth = FirebaseAuth.getInstance();
        emailBox = findViewById(R.id.editTextTextPersonName);
        passwordBox = findViewById(R.id.editTextTextPassword);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailBox.getText().toString();
                String password=passwordBox.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                //error message
                                startActivity(new Intent(SignupActivity.this,Dashboars.class));

                            }else{
                                //success message
                                Toast.makeText(SignupActivity.this, "Authentication fail", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });





    }
}