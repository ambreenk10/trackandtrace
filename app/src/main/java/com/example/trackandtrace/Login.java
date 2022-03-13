package com.example.trackandtrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button register;
    Button signin;
    EditText email, password;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        signin = findViewById(R.id.signin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(Login.this,signup.class);
                startActivity(I);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userlogin();
            }
        });
    }

    private void Userlogin() {

        String emailid = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(emailid.isEmpty())
        {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailid).matches())
        {
            email.setError("Please provide valid Email!");
            email.requestFocus();
            return;
        }

        if(pass.isEmpty())
        {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(emailid, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent I=new Intent(Login.this,MainActivity.class);
                    startActivity(I);
                }

                else
                {
                    Toast.makeText(Login.this, "Failed to Login!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
