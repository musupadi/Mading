package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Adapter.AdapterBerita;
import com.destinyapp.mading.Adapter.AdapterPengumuman;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengumumanLimitActivity extends AppCompatActivity {
    RecyclerView rv;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    Button all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman_limit);
        rv=findViewById(R.id.recyclerView);
        all=findViewById(R.id.btnAll);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PengumumanLimitActivity.this,PengumumanActivity.class);
                startActivity(intent);
            }
        });
        LOGIC();
    }
    private void LOGIC(){
        rv.setLayoutManager(new GridLayoutManager(PengumumanLimitActivity.this, 2));
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data = api.Pengumuman();
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                mAdapter = new AdapterPengumuman(PengumumanLimitActivity.this,mItems);
                rv.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PengumumanLimitActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}