package com.example.project_akhir_bp3;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

//Ini merupakan class yang dibuat untuk menampilkan detail lebih rinci manga yang ada pada tampilan home

public class Detail extends AppCompatActivity {
    private ImageButton imageButton;
    RecyclerView recyclerView;
    ArrayList<String> capterList = new ArrayList<>();

    private static int[] imageHero = {
            R.drawable.one_punch_man,
            R.drawable.jujutsu_kaisen,
            R.drawable.boruto,
            R.drawable.kage_no_jitsuryokusha_ni_naritakute,
            R.drawable.one_piece,
            R.drawable.breserk,
            R.drawable.vinlan_saga,
            R.drawable.solo_leveling,
            R.drawable.date_note,
            R.drawable.chainsaw_man
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.home));

        imageButton = findViewById(R.id.btnBack);

        ImageView imageCover = findViewById(R.id.image);

        TextView setTitle = findViewById(R.id.title);
        TextView setType = findViewById(R.id.type);
        TextView setPublished = findViewById(R.id.published);
        TextView setGendre = findViewById(R.id.gendre);
        TextView setAuthors = findViewById(R.id.authors);
        TextView setSynopsis = findViewById(R.id.synopsis);
        TextView setScore = findViewById(R.id.score);

        String[] getPosition = getIntent().getStringArrayExtra("arrayKey");

        setTitle.setText(getPosition[1]);
        setType.setText(getPosition[2]);
        setPublished.setText(getPosition[3]);
        setGendre.setText(getPosition[4]);
        setAuthors.setText(getPosition[5]);
        setSynopsis.setText(getPosition[6]);
        setScore.setText(getPosition[7]);

        Glide.with(Detail.this).load(imageHero[parseInt(getPosition[0]) - 1]).apply(new RequestOptions().override(300, 300)).into(imageCover);

        recyclerView = findViewById(R.id.capter_view);
        recyclerView.setHasFixedSize(true);

        int capterNum = parseInt(getPosition[8]);

        for(int i = 0; i <= capterNum; i++){
            String type;
            if(getPosition[2].equals("Light Novel")){
                type = "Volume ";
            }else{
                type = "Capter ";
            }
            String nameCapter = type + (i + 1) + "";
            capterList.add(nameCapter);
        }
        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListCapterAdapter listCapterAdapter = new ListCapterAdapter(capterList);
        recyclerView.setAdapter(listCapterAdapter);
    }

    public void btnBack(View view){
        finish();
    }
}