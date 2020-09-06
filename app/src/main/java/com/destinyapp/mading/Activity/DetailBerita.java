package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.destinyapp.mading.R;

public class DetailBerita extends AppCompatActivity {
    ImageView gambar;
    TextView judul,berita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        Intent data = getIntent();
        String JUDUL = data.getStringExtra("JUDUL");
        String BERITA = data.getStringExtra("BERITA");
        String GAMBAR = data.getStringExtra("GAMBAR");

        gambar=findViewById(R.id.ivGambar);
        judul=findViewById(R.id.tvJudul);
        berita=findViewById(R.id.tvBerita);

        judul.setText(JUDUL);
        berita.setText(BERITA);
        String BASE_URL = getString(R.string.BASE_URL);
        String URL = BASE_URL+"img/berita/"+GAMBAR;
        Glide.with(this)
                .load(URL)
                .into(gambar);
    }
}