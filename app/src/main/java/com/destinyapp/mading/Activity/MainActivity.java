package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.destinyapp.mading.Activity.About.AboutActivity;
import com.destinyapp.mading.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ImageView ivHeader;
    TextView tvHeader,tvTgl;
    LinearLayout Berita,About,Pelajaran,Ujian;
    CardView feedback;
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
    }
}