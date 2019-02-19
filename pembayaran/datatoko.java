package com.example.alwansuryansah.pembayaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;
import com.example.alwansuryansah.pembayaran.model.ResponToko;
import com.example.alwansuryansah.pembayaran.model.SessionManajer;
import com.example.alwansuryansah.pembayaran.model.pelanggan;
import com.example.alwansuryansah.pembayaran.model.toko;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class datatoko extends AppCompatActivity {

    private TextView id,nama,alamat,jenis,username,password,saldo,status;
    SessionManajer sessionManajer;
    private Button edit;
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatoko);

        sessionManajer = new SessionManajer(getApplicationContext());
        map = sessionManajer.getDetailLoginToko();
        String id_user = map.get(SessionManajer.KEY_ID);

        id = (TextView) findViewById(R.id.idtokovalue);
        nama = (TextView) findViewById(R.id.namatokovalue);
        alamat = (TextView) findViewById(R.id.alamattokovalue);
        jenis = (TextView) findViewById(R.id.jenistokovalue);
        username = (TextView) findViewById(R.id.usernametokovalue);
        password = (TextView) findViewById(R.id.passwordtokovalue);
        saldo = (TextView) findViewById(R.id.saldototkovalue);
        status = (TextView) findViewById(R.id.statustokovalue);
        edit = (Button) findViewById(R.id.edittoko);

        gettoko(id_user);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });

    }

    private void gettoko(String id_user) {
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponToko> getTahun = apiService.get_toko(id_user);
        getTahun.enqueue(new Callback<ResponToko>() {
            @Override
            public void onResponse(Call<ResponToko> call, Response<ResponToko> response) {
                ResponToko res = response.body();
                List<toko> user = res.getResult();
                if (res.getKode().equals("1")) {
                    id.setText(user.get(0).getId_toko());
                    nama.setText(user.get(0).getNama_toko());
                    alamat.setText(user.get(0).getAlamat_toko());
                    jenis.setText(user.get(0).getJenis_toko());
                    username.setText(user.get(0).getUsername());
                    password.setText(user.get(0).getPassword());
                    saldo.setText(user.get(0).getSaldo_toko());
                    status.setText(user.get(0).getStatus());
                } else {
                    Toast.makeText(getApplicationContext(), res.getPesan(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponToko> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void edit() {
        String ids, namas, alamats, jeniss, usernames, passwords;
        ids = id.getText().toString();
        namas = nama.getText().toString();
        alamats = alamat.getText().toString();
        jeniss = jenis.getText().toString();
        usernames = username.getText().toString();
        passwords = password.getText().toString();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponToko> getTahun = apiService.edittoko(ids, namas, alamats, jeniss, usernames, passwords);
        getTahun.enqueue(new Callback<ResponToko>() {
            @Override
            public void onResponse(Call<ResponToko> call, Response<ResponToko> response) {
                Toast.makeText(getApplicationContext(), "Data berhasil di update!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), halaman_toko.class);
                startActivity(intent);


            }



            @Override
            public void onFailure(Call<ResponToko> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
