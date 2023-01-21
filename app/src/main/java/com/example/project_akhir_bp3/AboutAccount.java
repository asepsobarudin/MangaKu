package com.example.project_akhir_bp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//ini merupakan class untuk menampilkan data pengguna.

public class AboutAccount extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageView imageView;
    private Button btnLogOut;
    private TextView username, email;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_account);
        getSupportActionBar().hide();

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        imageButton = findViewById(R.id.btnBack);
        imageView = findViewById(R.id.userImage);
        username = findViewById(R.id.getUsername);
        email = findViewById(R.id.getEmail);
        btnLogOut = findViewById(R.id.btnLogOut);

        Glide.with(AboutAccount.this).load(R.drawable.user_image).apply(new RequestOptions().override(300,300).transform(new CircleCrop())).into(imageView);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){
            username.setText(firebaseUser.getDisplayName());
            email.setText(firebaseUser.getEmail());
        }
    }

    public void btnBack(View view){
        finish();
    }

    public void btnLogout(View view){
        FirebaseAuth.getInstance().getCurrentUser();
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(AboutAccount.this, Login.class));
        finish();
    }
}