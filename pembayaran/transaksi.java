package com.example.alwansuryansah.pembayaran;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;
import com.example.alwansuryansah.pembayaran.model.ResponTransaksi;
import com.example.alwansuryansah.pembayaran.model.SessionManajer;
import com.example.alwansuryansah.pembayaran.model.pelanggan;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class transaksi extends AppCompatActivity {


    private Button enter , batal ;
    private EditText nominal ;
    private ProgressDialog loading;
    private String id_transaksiEdit,jumlah_transakiEdit, id_tokoEdit="166211", id_pelanggankuu;
    HashMap<String, String> map;
    SessionManajer sessionManajer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        enter = (Button)findViewById(R.id.enter);
        batal = (Button)findViewById(R.id.batal);
        nominal = (EditText) findViewById(R.id.nominal);
        loading = new ProgressDialog(this);
        map = sessionManajer.getTransaksi();
        id_pelanggankuu = map.get(SessionManajer.KEY_NAMA);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });


        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transaksi.this,halaman_utama.class);
                startActivity(intent);
            }
        });

    }


    private void buat() {
        jumlah_transakiEdit = nominal.getText().toString();
        loading.setMessage("Mengirim data ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        final Call<ResponTransaksi> transaksi = apiService.transaksi(id_transaksiEdit,jumlah_transakiEdit, id_tokoEdit, id_pelanggankuu);
        transaksi.enqueue(new Callback<ResponTransaksi>() {
            @Override
            public void onResponse(@NonNull Call<ResponTransaksi> call, @NonNull Response<ResponTransaksi> response) {
                loading.dismiss();
                String kode = response.body().getKode();
                String message = response.body().getPesan();
                if (kode.equals("1")) {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Intent transakssi = new Intent(getApplicationContext(), halaman_utama.class);
                    startActivity(transakssi);
                } else {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
        }

            @Override
            public void onFailure(@NonNull Call<ResponTransaksi> call, @NonNull Throwable t) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validasi(){

        boolean cancel = false;
        View focusView = null;

        jumlah_transakiEdit = nominal.getText().toString();


        // Check for a valid name.
        if (TextUtils.isEmpty(jumlah_transakiEdit)) {
            nominal.setError(getString(R.string.error_field_required));
            focusView = nominal;
            cancel = true;

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            buat();
        }
    }
}
