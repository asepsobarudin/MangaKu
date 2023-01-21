package com.example.project_akhir_bp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

//class ini digunakan sebagai tampilan utama setelah melakukan login dan pada class ini juga dapat berubah.

public class Home extends AppCompatActivity {
    private RecyclerView rvHero;
    private FirebaseAuth mAuth;
    Context context;
    RecyclerView.Adapter recyclerviewAdapter;
    final private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        rvHero = findViewById(R.id.layout_content);
        rvHero.setHasFixedSize(true);

        list.addAll(HeroData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHero.setAdapter(listHeroAdapter);
    }

    private void showRecyclerGrid() {
        rvHero.setLayoutManager(new
                GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHero.setAdapter(gridHeroAdapter);
    }

    String viewCon = "List";

    public void viewItem(View view){

        ImageButton btnView = findViewById(R.id.view_content);

        if(viewCon.equals("List")){
            showRecyclerGrid();
            btnView.setImageResource(R.drawable.list_check_2);
            viewCon = "Grid";
        }else if(viewCon.equals("Grid")){
            showRecyclerList();
            btnView.setImageResource(R.drawable.layout_grid_line);
            viewCon = "List";
        }
    }

    public void btnAbout (View view){
        Intent intent = new Intent(Home.this, AboutAccount.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(Home.this).toBundle());
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            reload();
        }
    }

    public void reload () {
        Intent intent = new Intent(Home.this, Login.class);
        startActivity(intent);
        finish();
    }
}