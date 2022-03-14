package com.strangersforsalik.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public FirebaseAuth mAuth;
    EditText emailBox, passwordBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        //findViewById(R.id.editTextTextPersonName)
        //findViewById(R.id.editTextTextPassword)
        //findViewById(R.id.button)
        //findViewById(R.id.textView)
        emailBox = findViewById(R.id.editTextTextPersonName);
        passwordBox = findViewById(R.id.editTextTextPassword);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailBox.getText().toString();
                String password=passwordBox.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                //error message
                                startActivity(new Intent(MainActivity.this,Dashboars.class));

                            }else{
                                //success message
                                Toast.makeText(MainActivity.this, "Authentication fail", Toast.LENGTH_SHORT).show();

                            }
                        });

            }
        });


        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
            }
        });




    }

}