package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.destinyapp.mading.API.ApiRequest;
import com.destinyapp.mading.API.RetroServer;
import com.destinyapp.mading.Activity.About.AboutActivity;
import com.destinyapp.mading.Model.Musupadi;
import com.destinyapp.mading.Model.ResponseModel;
import com.destinyapp.mading.R;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImageView ivHeader;
    TextView tvHeader,tvTgl;
    LinearLayout Berita,About,Pelajaran,Ujian;
    Button feedback;
    Dialog myDialog;
    EditText etFeedback;
    Button submit,close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTgl=findViewById(R.id.tvTgl);
        ivHeader=findViewById(R.id.ivHeader);
        tvHeader=findViewById(R.id.tvHeader);

        Berita=findViewById(R.id.linearBerita);
        About=findViewById(R.id.linearAbout);
        Pelajaran=findViewById(R.id.linearPelajaran);
        Ujian=findViewById(R.id.linearUjian);
        feedback=findViewById(R.id.cardFeedback);
        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.dialog_feedback);
        etFeedback = myDialog.findViewById(R.id.etFeedback);
        submit = myDialog.findViewById(R.id.btnSubmit);
        close = myDialog.findViewById(R.id.btnClose);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hour > 4 && hour < 11){
            tvHeader.setText("Selamat Pagi, ");
            ivHeader.setImageResource(R.drawable.morning);
        }else if(hour >= 11 && hour <15){
            tvHeader.setText("Selamat Siang, ");
            ivHeader.setImageResource(R.drawable.afternoon);
        }else if(hour >= 15 && hour <18){
            tvHeader.setText("Selamat Sore, ");
            ivHeader.setImageResource(R.drawable.evening);
        }else{
            tvHeader.setText("Selamat Malam, ");
            ivHeader.setImageResource(R.drawable.night);
        }

        Berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BeritaLimitActivity.class);
                startActivity(intent);
            }
        });
        Pelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PelajaranActivity.class);
                startActivity(intent);
            }
        });
        Ujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UjianActivity.class);
                startActivity(intent);
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.hide();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Mengirimkan Feedback");
                pd.show();
                Musupadi musupadi = new Musupadi();
                ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
                Call<ResponseModel> data = api.FeedBack(etFeedback.getText().toString(),musupadi.getThisDate());
                data.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        try {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            pd.hide();
                        }catch (Exception e){
                            pd.hide();
                            Toast.makeText(MainActivity.this, "Terjadi kesalahan pada "+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        pd.hide();
                        Toast.makeText(MainActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}