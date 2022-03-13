package com.example.trackandtrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    Button login;
    Button signup;
    EditText email,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(signup.this,Login.class);
                startActivity(I);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();
            }
        });
    }

    private void signup() {
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




        if(pass.length() < 6)
        {
            password.setError("Password length must be greater than 6 characters");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailid, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            User user= new User(emailid);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(signup.this, "User has been registered successfully", Toast.LENGTH_LONG).show();

                                                Intent I=new Intent(signup.this,MainActivity.class);
                                                startActivity(I);

                                    }

                                    else
                                    {
                                        Toast.makeText(signup.this, "Failed to register!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        }

                        else
                        {
                            Toast.makeText(signup.this, "Failed to register User! Try again.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}