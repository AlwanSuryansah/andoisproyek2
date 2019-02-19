package com.example.alwansuryansah.pembayaran;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.alwansuryansah.pembayaran.model.SessionManajer;

public class halaman_toko extends AppCompatActivity {

    private CardView diri,transaksi,penarikan;
    private Button logoutt;
    SessionManajer sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_toko);


        sessionManager = new SessionManajer(getApplicationContext());
        diri = (CardView)findViewById(R.id.datadiri1);
        transaksi = (CardView)findViewById(R.id.transaksi);
        penarikan = (CardView)findViewById(R.id.penarikan);
        logoutt = (Button) findViewById(R.id.logout);


        diri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(halaman_toko.this,datatoko.class);
                startActivity(intent);
            }
        });

        transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(halaman_toko.this,history.class);
                startActivity(intent);
            }
        });

        penarikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(halaman_toko.this,scan.class);
//                startActivity(intent);
            }
        });

        logoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


    }

    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Anda yakin ingin logout ?");
        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                sessionManager.logout();
                startActivity(new Intent(getApplicationContext(), logintoko.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}
