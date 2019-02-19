package com.example.alwansuryansah.pembayaran;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.adaptor.transaksitokoadaptor;
import com.example.alwansuryansah.pembayaran.model.ResponTransaksi;
import com.example.alwansuryansah.pembayaran.model.ResponTransaksiToko;
import com.example.alwansuryansah.pembayaran.model.SessionManajer;
import com.example.alwansuryansah.pembayaran.model.transaksitoko;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class history extends AppCompatActivity {

    private RecyclerView rv ;
    private ProgressDialog loading;

    SessionManajer sessionManager;
    HashMap<String, String> map;

    String id_toko;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sessionManager = new SessionManajer(getApplicationContext());
        map = sessionManager.getDetailLoginToko();
        id_toko = map.get(SessionManajer.KEY_ID);
        rv = (RecyclerView) findViewById(R.id.rv_transaksi);

        loading = new ProgressDialog(this);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setId_transaksi();
    }



    private void setId_transaksi() {loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponTransaksiToko> getdata = apiService.get_transaksitoko(id_toko);
        getdata.enqueue(new Callback<ResponTransaksiToko>() {
            @Override
            public void onResponse(@NonNull Call<ResponTransaksiToko> call, @NonNull Response<ResponTransaksiToko> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    List<transaksitoko> listTransaksi = response.body().getResult();

                    transaksitokoadaptor questionAdapter = new transaksitokoadaptor(getApplicationContext(), listTransaksi);
                    questionAdapter.setListtransaksitoko(listTransaksi);
                    questionAdapter.notifyDataSetChanged();
                    rv.setAdapter(questionAdapter);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Resi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponTransaksiToko> call,@NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }

        });
    }

    }

