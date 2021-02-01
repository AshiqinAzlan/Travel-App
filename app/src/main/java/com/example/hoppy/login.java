package com.example.hoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    //variable declaration
    TextView t1 ;

    //two edit text because one is username and another one is password
    EditText e1,e2;

    //submit button
    Button b1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        e1 = (EditText) findViewById(R.id.emailLogin);
        e2 = (EditText) findViewById(R.id.passwordLogin);
        t1 = (TextView) findViewById(R.id.loginSignup);
        b1 = (Button) findViewById(R.id.loginButton);
        mAuth=FirebaseAuth.getInstance();

        //this on click listener allows component to act whenever its clicked
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function to navigate user to that particular page,
                startActivity(new Intent(login.this, createAccount.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }
    private void userLogin(){
        String mail = e1.getText().toString();
        String pass = e2.getText().toString();

       if(mail.isEmpty() || pass.isEmpty()){
           Toast.makeText(login.this, "Please ensure all details are filled in",
                   Toast.LENGTH_LONG).show();
       }

        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
//                    finish();
                    Intent intent = new Intent(login.this, home.class);
                    intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    startActivity(intent);
                    Toast.makeText(login.this, "Login successful",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
