package com.destinyapp.mading.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destinyapp.mading.Activity.DetailBerita;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.Musupadi;
import com.destinyapp.mading.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Dialog myDialog;

    String username,nama,email,profile,alamat,level;
    Musupadi method;
    public AdapterBerita (Context ctx,List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_berita,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerita.HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        method=new Musupadi();
        holderData.judul.setText(dm.getJudul_berita());
        holderData.berita.setText(method.MiniDescription(dm.getBerita()));
        String BASE_URL = ctx.getString(R.string.BASE_URL);
        String URL = BASE_URL+"img/berita/"+dm.getGambar();
        Glide.with(ctx)
                .load(URL)
                .into(holderData.gambar);
        holderData.LayoutCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(ctx, DetailBerita.class);
                goInput.putExtra("JUDUL",dm.getJudul_berita());
                goInput.putExtra("BERITA",dm.getBerita());
                goInput.putExtra("GAMBAR",dm.getGambar());
                ctx.startActivities(new Intent[]{goInput});
            }
        });
        holderData.dm=dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView judul,berita;
        ImageView gambar;
        DataModel dm;
        CardView LayoutCardView;
        HolderData(View v){
            super(v);
            judul = v.findViewById(R.id.tvJudul);
            berita = v.findViewById(R.id.tvBerita);
            gambar = v.findViewById(R.id.ivGambar);
            LayoutCardView = v.findViewById(R.id.LayoutCardView);
        }
    }
}


