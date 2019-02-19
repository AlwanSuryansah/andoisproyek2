package com.example.alwansuryansah.pembayaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;
import com.example.alwansuryansah.pembayaran.model.SessionManajer;
import com.example.alwansuryansah.pembayaran.model.pelanggan;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class datapengguna extends AppCompatActivity {

    private TextView id,nama,alamat,jenis,username,password,saldo,status;
    SessionManajer sessionManajer;
    private Button edit;
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapengguna);

        sessionManajer = new SessionManajer(getApplicationContext());
        map = sessionManajer.getDetailLogin();
        String id_user = map.get(SessionManajer.KEY_NAMA);


        id = (TextView) findViewById(R.id.idvalue);
        nama = (TextView) findViewById(R.id.namavalue);
        alamat = (TextView) findViewById(R.id.alamatvalue);
        jenis = (TextView) findViewById(R.id.jeniskelaminvalue);
        username = (TextView) findViewById(R.id.usernamevalue);
        password = (TextView) findViewById(R.id.passwordvalue);
        saldo = (TextView) findViewById(R.id.saldovalue);
        status = (TextView) findViewById(R.id.statusvalue);
        edit = (Button) findViewById(R.id.edit);

        getpelanggan(id_user);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
    }

    private void getpelanggan(String id_user) {
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponPelanggan> getTahun = apiService.get_pelanggan(id_user);
        getTahun.enqueue(new Callback<ResponPelanggan>() {
            @Override
            public void onResponse(Call<ResponPelanggan> call, Response<ResponPelanggan> response) {
                ResponPelanggan res = response.body();
                List<pelanggan> user = res.getResult();
                if (res.getKode().equals("1")) {
                    id.setText(user.get(0).getId_pelanggan());
                    nama.setText(user.get(0).getNama_pelanggan());
                    alamat.setText(user.get(0).getAlamat());
                    jenis.setText(user.get(0).getJenis_kelami());
                    username.setText(user.get(0).getUsername());
                    password.setText(user.get(0).getPassword());
                    saldo.setText(user.get(0).getSaldo_pelanggan());
                    status.setText(user.get(0).getStatus());
                } else {
                    Toast.makeText(getApplicationContext(), res.getPesan(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponPelanggan> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void edit() {
        String ids,namas,alamats,jeniss,usernames,passwords;
        ids = id.getText().toString();
        namas = nama.getText().toString();
        alamats = alamat.getText().toString();
        jeniss = jenis.getText().toString();
        usernames = username.getText().toString();
        passwords = password.getText().toString();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponPelanggan> getTahun = apiService.edit(ids,namas,alamats,jeniss,usernames,passwords);
        getTahun.enqueue(new Callback<ResponPelanggan>() {
            @Override
            public void onResponse(Call<ResponPelanggan> call, Response<ResponPelanggan> response) {
                Toast.makeText(getApplicationContext(), "Data berhasil di update!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), halaman_utama.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<ResponPelanggan> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
