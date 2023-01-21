package com.example.project_akhir_bp3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

//List hero adapter merupakan adapter yang digunakan saat layout berbentuk list dan selain itu berungsi untuk menampilkan data pada card manga di home dan melakuakan aksi perpindahan halaman menuju Detail activity dan sekaligus mengirim data detail manga.

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<Hero> listHero;

    public ListHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position){
        Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext()).load(hero.getPhoto()).apply(new RequestOptions().override(200, 200)).into(holder.imgPhoto);
        holder.tvTitle.setText(hero.getTitle());
        holder.tvSynopsis.setText(hero.getSynopsis());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = {
                        hero.getId(),
                        hero.getTitle(),
                        hero.getType(),
                        hero.getPublished(),
                        hero.getGendre(),
                        hero.getAuthors(),
                        hero.getSynopsis(),
                        hero.getScore(),
                        hero.getCapter()
                };
                Intent intent = new Intent(v.getContext(), Detail.class);
                intent.putExtra("arrayKey", data );
                v.getContext().startActivity(intent);
        }
        });
    }

    @Override
    public int getItemCount(){
        return listHero.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvTitle, tvSynopsis;

        ListViewHolder(@NonNull View view){
            super(view);
            imgPhoto = view.findViewById(R.id.tv_image);
            tvTitle = view.findViewById(R.id.tv_title);
            tvSynopsis = view.findViewById(R.id.tv_synopsis);
        }
    }
}
