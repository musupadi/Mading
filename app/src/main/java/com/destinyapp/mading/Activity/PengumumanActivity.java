package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Adapter.AdapterPengumuman;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengumumanActivity extends AppCompatActivity {
    RecyclerView rv;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman);
        rv=findViewById(R.id.recyclerView);
        LOGIC();
    }
    private void LOGIC(){
        rv.setLayoutManager(new GridLayoutManager(PengumumanActivity.this, 2));
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data = api.Pengumuman();
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                mAdapter = new AdapterPengumuman(PengumumanActivity.this,mItems);
                rv.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PengumumanActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}