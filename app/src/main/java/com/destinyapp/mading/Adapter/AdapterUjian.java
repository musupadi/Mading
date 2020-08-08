package com.destinyapp.mading.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.Musupadi;
import com.destinyapp.mading.R;

import java.util.List;

public class AdapterUjian extends RecyclerView.Adapter<AdapterUjian.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Dialog myDialog;

    String username,nama,email,profile,alamat,level;
    Musupadi method;
    public AdapterUjian (Context ctx,List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_ujian,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUjian.HolderData holderData, int posistion) {
        DataModel dm = mList.get(posistion);
        method=new Musupadi();
        holderData.matakuliah.setText(dm.getNama_matkul());
        holderData.mulai.setText(": "+dm.getMulai());
        holderData.selesai.setText(": "+dm.getSelesai());
        holderData.dosen.setText(dm.getNama_dosen());
        holderData.Kelas.setText(": "+dm.getProgram()+" "+dm.getClassy()+"-"+dm.getNama_kelas());
        holderData.jenis.setText(": "+dm.getJenis_ujian());
        holderData.tanggal.setText(": "+method.getDataTanggal(method.formatTanggal(dm.getTanggal()))+", "+dm.getTanggal());
        holderData.dm=dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView matakuliah,mulai,selesai,dosen,jenis,Kelas,tanggal;
        ImageView gambar;
        DataModel dm;
        HolderData(View v){
            super(v);
            matakuliah = v.findViewById(R.id.tvMataKuliah);
            mulai = v.findViewById(R.id.tvMulai);
            Kelas = v.findViewById(R.id.tvKelas);
            selesai = v.findViewById(R.id.tvSelesai);
            dosen = v.findViewById(R.id.tvDosen);
            jenis = v.findViewById(R.id.tvJenis);
            tanggal = v.findViewById(R.id.tvTanggal);
        }
    }
}

