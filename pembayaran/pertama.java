package com.example.alwansuryansah.pembayaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class pertama extends AppCompatActivity {

    private CardView pelanggan,toko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertama);

        pelanggan = (CardView)findViewById(R.id.loginpelanggan);
        toko = (CardView)findViewById(R.id.logintoko);

        pelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pertama.this,login.class);
                startActivity(intent);
            }
        });

        toko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pertama.this,logintoko.class);
                startActivity(intent);
            }
        });
    }
}
