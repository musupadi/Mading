package com.destinyapp.mading.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.destinyapp.mading.R;

public class FullScreenImgActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_img);

        Intent data = getIntent();
        String GAMBAR = data.getStringExtra("GAMBAR");

        img = findViewById(R.id.ivGambar);
        String BASE_URL = this.getString(R.string.BASE_URL);
        String URL = BASE_URL+"img/pengumuman/"+GAMBAR;
        Glide.with(this)
                .load(URL)
                .into(img);
    }
}