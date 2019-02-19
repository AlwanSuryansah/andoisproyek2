package com.example.alwansuryansah.pembayaran;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alwansuryansah.pembayaran.API.BaseApiServices;
import com.example.alwansuryansah.pembayaran.API.server;
import com.example.alwansuryansah.pembayaran.model.ResponToko;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registrasiToko extends AppCompatActivity {


    public EditText idtokoEdit, namaEdit, alamatEdit, jenistokoedit, usernameEdit, passwordEdit , statusedit ;
    public TextView saldo_tokoedit;
    public Button registerr;
    private ProgressDialog loading;
    private String id_toko,nama_toko, alamat, jenis_toko, username, password,saldo_toko, status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_toko);


        idtokoEdit = (EditText)findViewById(R.id.id_toko);
        namaEdit = (EditText)findViewById(R.id.nama_yoko);
        alamatEdit = (EditText)findViewById(R.id.alamattoko);
        jenistokoedit = (EditText)findViewById(R.id.jenistoko);
        usernameEdit = (EditText)findViewById(R.id.username);
        passwordEdit = (EditText)findViewById(R.id.password);
        saldo_tokoedit = (TextView) findViewById(R.id.saldotoko);
        statusedit = (EditText)findViewById(R.id.status);

        registerr = (Button)findViewById(R.id.regis);

        loading = new ProgressDialog(this);

        registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            validation();
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void validation() {

        boolean cancel = false;
        View focusView = null;

        id_toko = idtokoEdit.getText().toString();
        nama_toko = namaEdit.getText().toString();
        alamat = alamatEdit.getText().toString();
        jenis_toko = jenistokoedit.getText().toString();
        username = usernameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        saldo_toko = saldo_tokoedit.getText().toString();
        status = statusedit.getText().toString();

        // Check for a valid name.
        if (TextUtils.isEmpty(id_toko)) {
            idtokoEdit.setError(getString(R.string.error_field_required));
            focusView = idtokoEdit;
            cancel = true;

        }


        if (TextUtils.isEmpty(nama_toko)) {
            namaEdit.setError(getString(R.string.error_field_required));
            focusView = namaEdit;
            cancel = true;

        }


        // Check for a valid address
        if (TextUtils.isEmpty(alamat)) {
            alamatEdit.setError(getString(R.string.error_field_required));
            focusView = alamatEdit;
            cancel = true;

        }

        if (TextUtils.isEmpty(jenis_toko)) {
            jenistokoedit.setError(getString(R.string.error_field_required));
            focusView = jenistokoedit;
            cancel = true;

        }

        // Check for a valid username
        if (TextUtils.isEmpty(username)) {
            usernameEdit.setError(getString(R.string.error_field_required));
            focusView = usernameEdit;
            cancel = true;

        }

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordEdit.setError(getString(R.string.error_invalid_password));
            focusView = passwordEdit;
            cancel = true;
        } else if (TextUtils.isEmpty(password)) {
            passwordEdit.setError(getString(R.string.error_field_required));
            focusView = passwordEdit;
            cancel = true;
        }

        if (TextUtils.isEmpty(saldo_toko)) {
            saldo_tokoedit.setError(getString(R.string.error_field_required));
            focusView = saldo_tokoedit;
            cancel = true;

        }

        if (TextUtils.isEmpty(status)) {
            statusedit.setError(getString(R.string.error_field_required));
            focusView = statusedit;
            cancel = true;

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            register();
        }

    }
    private void register() {
        loading.setMessage("Mengirim Register ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiServices apiService = server.getUrl().create(BaseApiServices.class);
        Call<ResponToko> register = apiService.registertoko(id_toko, nama_toko, alamat, jenis_toko, username, password, saldo_toko,
                status);
        register.enqueue(new Callback<ResponToko>() {
            @Override
            public void onResponse(@NonNull Call<ResponToko> call, @NonNull Response<ResponToko> response) {
                loading.dismiss();
                String kode = response.body().getKode();
                String message = response.body().getPesan();
                if (kode.equals("1")) {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), logintoko.class);
                    startActivity(register);
                } else {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponToko> call, @NonNull Throwable t) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
