package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Adapter.AdapterPelajaran;
import com.destinyapp.mading.Adapter.AdapterUjian;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerJurusan;
import com.destinyapp.mading.Adapter.Spinner.AdapterSpinnerKelas;
import com.destinyapp.mading.Model.DataModel;
import com.destinyapp.mading.Model.Musupadi;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UjianActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private List<DataModel> mItems = new ArrayList<>();
    private AdapterSpinnerJurusan aJurusan;
    private AdapterSpinnerKelas aKelas;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    Spinner Jurusan,Kelas,Hari,Program,Class;
    RecyclerView recyclerView;
    TextView IdJurusan,IDKelas;
    Button tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ujian);
        Jurusan = findViewById(R.id.spinnerJurusan);
        Kelas = findViewById(R.id.spinnerKelas);
        Hari = findViewById(R.id.spinnerHari);
        recyclerView = findViewById(R.id.recyclerView);
        IdJurusan = findViewById(R.id.idJurusan);
        IDKelas = findViewById(R.id.idKelas);
        Program = findViewById(R.id.spinnerProgram);
        Class = findViewById(R.id.spinnerClass);
        tanggal = findViewById(R.id.btnTanggal);
        Musupadi method = new Musupadi();
        getJurusan();
        aJurusan = new AdapterSpinnerJurusan(UjianActivity.this,mItems);
        Jurusan.setAdapter(aJurusan);
        Jurusan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                String clickedItems = clickedItem.getId_jurusan();
                IdJurusan.setText(clickedItems);
                ChangeListener();
                aKelas = new AdapterSpinnerKelas(UjianActivity.this,mItems);
                Kelas.setAdapter(aKelas);
                Kelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                        String clickedItems = clickedItem.getId_kelas();
                        IDKelas.setText(clickedItems);
//                        logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),Hari.getSelectedItem().toString());
                        Logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),"");
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                Logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }
    private void showDatePicker(){
        DatePickerDialog dialog = new DatePickerDialog(this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = year+"-"+month+"-"+day;
        Musupadi musupadi = new Musupadi();
        tanggal.setText(musupadi.getDataTanggal(day+"/"+month+"/"+year)+", "+day+"-"+month+"-"+year);
        Logic(IdJurusan.getText().toString(),IDKelas.getText().toString(),date);
    }
    private void Logic(final String jurusan, final String kelas,final String tanggal){
        recyclerView.setLayoutManager(new GridLayoutManager(UjianActivity.this, 1));
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> Data = api.JadwalUjian(jurusan,kelas,tanggal);
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                mAdapter = new AdapterUjian(UjianActivity.this,mItems);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
    private void getJurusan(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getProvinsi = api.AllJurusan();
        getProvinsi.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                AdapterSpinnerJurusan adapter = new AdapterSpinnerJurusan(UjianActivity.this,mItems);
                Jurusan.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UjianActivity.this,"Koneksi Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getKelas(String IDJurusan){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getProvinsi = api.Kelas(IDJurusan,Program.getSelectedItem().toString(),Class.getSelectedItem().toString());
        getProvinsi.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mItems=response.body().getData();
                AdapterSpinnerKelas adapter = new AdapterSpinnerKelas(UjianActivity.this,mItems);
                Kelas.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UjianActivity.this,"Koneksi Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ChangeListener(){
        Program.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getKelas(IdJurusan.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getKelas(IdJurusan.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getKelas(IdJurusan.getText().toString());
    }
}