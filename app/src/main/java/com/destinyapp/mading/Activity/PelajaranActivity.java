package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Adapter.AdapterBerita;
import com.destinyapp.mading.Adapter.AdapterPelajaran;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerJurusan;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerKelas;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.Musupadi;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PelajaranActivity extends AppCompatActivity {
    private List<DataModel> mItems = new ArrayList<>();
    private AdapterSpinnerJurusan aJurusan;
    private AdapterSpinnerKelas aKelas;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    Spinner Jurusan,Kelas,Hari;
    RecyclerView recyclerView;
    TextView IdJurusan,IDKelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);
        Jurusan = findViewById(R.id.spinnerJurusan);
        Kelas = findViewById(R.id.spinnerKelas);
        Hari = findViewById(R.id.spinnerHari);
        recyclerView = findViewById(R.id.recyclerView);
        IdJurusan = findViewById(R.id.idJurusan);
        IDKelas = findViewById(R.id.idKelas);

        Musupadi method = new Musupadi();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        if (method.getToday().equals("Senin")){
            Hari.setSelection(0);
        }else if(method.getToday().equals("Selasa")){
            Hari.setSelection(1);
        }else if(method.getToday().equals("Rabu")){
            Hari.setSelection(2);
        }else if(method.getToday().equals("Kamis")){
            Hari.setSelection(3);
        }else if(method.getToday().equals("Jumat")){
            Hari.setSelection(4);
        }else if(method.getToday().equals("Sabtu")){
            Hari.setSelection(5);
        }else if(method.getToday().equals("Minggu")){
            Hari.setSelection(6);
        }
        Hari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getJurusan();
        aJurusan = new AdapterSpinnerJurusan(PelajaranActivity.this,mItems);
        Jurusan.setAdapter(aJurusan);
        Jurusan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                String clickedItems = clickedItem.getId_jurusan();
                IdJurusan.setText(clickedItems);
                getKelas(IdJurusan.getText().toString());
                aKelas = new AdapterSpinnerKelas(PelajaranActivity.this,mItems);
                Kelas.setAdapter(aKelas);
                Kelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                        String clickedItems = clickedItem.getId_kelas();
                        IDKelas.setText(clickedItems);
                        //Test
                        Hari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),Hari.getSelectedItem().toString());
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),Hari.getSelectedItem().toString());

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        Toast.makeText(PelajaranActivity.this, IdJurusan.getText().toString(), Toast.LENGTH_SHORT).show();
//        getKelas();
//        aKelas = new AdapterSpinnerKelas(PelajaranActivity.this,mItems);
//        Kelas.setAdapter(aKelas);

    }

    private void getJurusan(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getProvinsi = api.AllJurusan();
        getProvinsi.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                AdapterSpinnerJurusan adapter = new AdapterSpinnerJurusan(PelajaranActivity.this,mItems);
                Jurusan.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PelajaranActivity.this,"Koneksi Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getKelas(String IDJurusan){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getProvinsi = api.Kelas(IDJurusan);
        getProvinsi.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                AdapterSpinnerKelas adapter = new AdapterSpinnerKelas(PelajaranActivity.this,mItems);
                Kelas.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PelajaranActivity.this,"Koneksi Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void logic(final String jurusan, final String kelas, final String hari){
        recyclerView.setLayoutManager(new GridLayoutManager(PelajaranActivity.this, 2));
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data = api.JadwalPelajaran(jurusan,kelas,hari);
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                Toast.makeText(PelajaranActivity.this, "Jurusan : "+jurusan+" Kelas : "+kelas+" hari : "+hari, Toast.LENGTH_SHORT).show();
                mItems=response.body().getData();
                mAdapter = new AdapterPelajaran(PelajaranActivity.this,mItems);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PelajaranActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}