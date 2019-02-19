package com.example.alwansuryansah.pembayaran;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;
import com.example.alwansuryansah.pembayaran.model.SessionManajer;
import com.example.alwansuryansah.pembayaran.model.pelanggan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private Button login , registrasi ;
    private EditText usernameEdit ,passwordEdit;
    private SessionManajer sessionManager;

    ProgressDialog loading;
    private static final String TAG =  login.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdit = (EditText) findViewById(R.id.user);
        passwordEdit = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);
        registrasi = (Button) findViewById(R.id.registrasi);


        loading = new ProgressDialog(this);
        sessionManager = new SessionManajer(this);

        if (sessionManager.Loggin()){
            startActivity(new Intent(getApplicationContext(), halaman_utama.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funLogin();
            }
        });


        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis = new Intent(getApplicationContext(), registrasi.class);
                startActivity(regis);
            }
        });

    }

    private void funLogin() {
        loading.setMessage("Loading ...");
        loading.show();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponPelanggan> login = apiService.login(usernameEdit.getText().toString(), passwordEdit.getText().toString());
        login.enqueue(new Callback<ResponPelanggan>() {
            @Override
            public void onResponse(@NonNull Call<ResponPelanggan> call, @NonNull Response<ResponPelanggan> response) {
                loading.dismiss();
                ResponPelanggan res = response.body();
                List<pelanggan> user = res.getResult();
                if (res.getKode().equals("1")) {
                    sessionManager.storeLogin(user.get(0).getId_pelanggan());
                    Toast.makeText(getApplicationContext(), res.getPesan(), Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(getApplicationContext(), halaman_utama.class);
                    login.putExtra("id_pelanggan", user.get(0).getId_pelanggan());
                    startActivity(login);
                } else {
                    Toast.makeText(getApplicationContext(), res.getPesan(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponPelanggan> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ", "Message : " + String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
