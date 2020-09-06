package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Adapter.AdapterPelajaran;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerJurusan;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerKelas;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPelajaranDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<DataModel> mItems = new ArrayList<>();
    private AdapterSpinnerJurusan aJurusan;
    private AdapterSpinnerKelas aKelas;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pelajaran);
        Intent data = getIntent();
        String JURUSAN = data.getStringExtra("JURUSAN");
        String KELAS = data.getStringExtra("KELAS");
        String HARI = data.getStringExtra("HARI");
        getSupportActionBar().setTitle("Jadwal Kuliah");
        recyclerView = findViewById(R.id.recyclerView);
        logic(JURUSAN,KELAS,HARI);
    }
    private void logic(final String jurusan, final String kelas, final String hari){
        recyclerView.setLayoutManager(new GridLayoutManager(ListPelajaranDetailActivity.this, 2));
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data = api.JadwalPelajaran(jurusan,kelas,hari);
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                Toast.makeText(PelajaranActivity.this, "Jurusan : "+jurusan+" Kelas : "+kelas+" hari : "+hari, Toast.LENGTH_SHORT).show();
                mItems=response.body().getData();
                mAdapter = new AdapterPelajaran(ListPelajaranDetailActivity.this,mItems);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(ListPelajaranDetailActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}