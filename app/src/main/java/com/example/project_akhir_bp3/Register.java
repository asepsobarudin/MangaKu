package com.example.project_akhir_bp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

//class ini berfungsi untuk melakukan registrasi akun baru dan ini terhubung langsung dengan database firebase

public class Register extends AppCompatActivity {

    private EditText inUsername;
    private EditText inEmail;
    private EditText inPassword;
    private EditText inConfirmPass;
    private Account account;
    private FirebaseAuth mAuth;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.login));

        dialog = new  Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        mAuth = FirebaseAuth.getInstance();

        inUsername = findViewById(R.id.in_username);
        inEmail = findViewById(R.id.in_email);
        inPassword = findViewById(R.id.in_password);
        inConfirmPass = findViewById(R.id.in_password_confirm);
        account = new Account();
    }

    public void Login(View view){
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        finish();
    }

    public void btnRegister(View view){
        String username = inUsername.getText().toString().trim();
        String email = inEmail.getText().toString().trim();
        String password = inPassword.getText().toString().trim();
        String confirmPass = inConfirmPass.getText().toString().trim();

        boolean isInvalid = false;

        if(TextUtils.isEmpty(username)){
            isInvalid = true;
            inUsername.setError("Username is required");
        }

        if(TextUtils.isEmpty((email))){
            isInvalid = true;
            inEmail.setError("Email is required");
        }

        if(TextUtils.isEmpty(password)){
            isInvalid = true;
            inPassword.setError("Password is required");
        }

        if(TextUtils.isEmpty(confirmPass)){
            isInvalid = true;
            inConfirmPass.setError("Confirm Password is required");
        }

        if(!confirmPass.equals(password)){
            isInvalid = true;
            inConfirmPass.setError("Passwords must be the same");
        }

        if(!isInvalid){
            InsertAccount(username, email, password);
        }
    }

    private void InsertAccount (String username, String email, String password) {
        dialog.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult() != null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if(firebaseUser != null) {
                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(username).build();

                    firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            reload();
                        }
                    });
                    }else{
                        Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
    }

    public void reload () {
        Intent intent = new Intent(Register.this, Home.class);
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