package com.example.project_akhir_bp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//class ini merupakan class untuk proses login dan tehubung langsung denga database firebase

public class Login extends AppCompatActivity{
    private FirebaseAuth mAuth;
    private EditText getEmail;
    private EditText getPassword;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getEmail = findViewById(R.id.inputEmail);
        getPassword = findViewById(R.id.inputPassword);

        mAuth = FirebaseAuth.getInstance();

        dialog = new  Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        getSupportActionBar().hide();
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.login));
    }

    public void btnLogin (View view){
        String email = getEmail.getText().toString().trim();
        String password = getPassword.getText().toString().trim();

        boolean isInvalid = false;

        if(TextUtils.isEmpty(email)){
            isInvalid = true;
            getEmail.setError("Silahkan Masukan Email");
        }

        if(TextUtils.isEmpty(password)){
            isInvalid = true;
            getPassword.setError("Silahkan Maskukan Passsword");
        }

        if (!isInvalid){
            singIn(email, password);
        }
    }

    public void Register(View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
        finish();
    }

    private void singIn(String email, String password) {
        dialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult() != null){
                    if(task.getResult().getUser() != null){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
    }

    public void reload () {
        Intent intent = new Intent(Login.this, Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
}