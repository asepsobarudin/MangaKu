package com.example.project_akhir_bp3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//ini merpakan adapter untuk menampilkan list capter

public class ListCapterAdapter extends RecyclerView.Adapter<ListCapterAdapter.ListCapterHolder> {

    private ArrayList<String> data;

    public ListCapterAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public ListCapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.capter_view, parent, false);
        return new ListCapterHolder(view);
    }

    @Override
    public void onBindViewHolder(ListCapterHolder holder, int position) {
        holder.tvCapter.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ListCapterHolder extends RecyclerView.ViewHolder{
        TextView tvCapter;

        ListCapterHolder(@NonNull View view){
            super(view);
            tvCapter = view.findViewById(R.id.text_capter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Capter view menu is not yet available 🙏", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

