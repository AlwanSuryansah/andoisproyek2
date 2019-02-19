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
import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registrasi extends AppCompatActivity {

    public EditText idpelangganEdit, namaEdit, alamatEdit, jeniskelaminedit, usernameEdit, passwordEdit , statusedit ;
    public TextView saldo_pelangganedit;
    public Button registerr;
    private ProgressDialog loading;
    private String id_pelanggan,nama_pelanggan, alamat, jenis_kelimi, username, password,saldo_pelanggan, status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        idpelangganEdit = (EditText)findViewById(R.id.id_pelanggan);
        namaEdit = (EditText)findViewById(R.id.nama_pelanggan);
        alamatEdit = (EditText)findViewById(R.id.alamat);
        jeniskelaminedit = (EditText)findViewById(R.id.jeniskelamin);
        usernameEdit = (EditText)findViewById(R.id.username);
        passwordEdit = (EditText)findViewById(R.id.password);
        saldo_pelangganedit = (TextView)findViewById(R.id.saldopelanggan);
        statusedit = (EditText)findViewById(R.id.status);

        registerr = (Button)findViewById(R.id.buttonregis);

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

        id_pelanggan = idpelangganEdit.getText().toString();
        nama_pelanggan = namaEdit.getText().toString();
        alamat = alamatEdit.getText().toString();
        jenis_kelimi = jeniskelaminedit.getText().toString();
        username = usernameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        saldo_pelanggan = saldo_pelangganedit.getText().toString();
        status = statusedit.getText().toString();

        // Check for a valid name.
        if (TextUtils.isEmpty(id_pelanggan)) {
            idpelangganEdit.setError(getString(R.string.error_field_required));
            focusView = idpelangganEdit;
            cancel = true;

        }


        if (TextUtils.isEmpty(nama_pelanggan)) {
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

        if (TextUtils.isEmpty(jenis_kelimi)) {
            jeniskelaminedit.setError(getString(R.string.error_field_required));
            focusView = jeniskelaminedit;
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

        if (TextUtils.isEmpty(saldo_pelanggan)) {
            saldo_pelangganedit.setError(getString(R.string.error_field_required));
            focusView = saldo_pelangganedit;
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
        Call<ResponPelanggan> register = apiService.register(id_pelanggan, nama_pelanggan, alamat, jenis_kelimi, username, password, saldo_pelanggan,
                status);
        register.enqueue(new Callback<ResponPelanggan>() {
            @Override
            public void onResponse(@NonNull Call<ResponPelanggan> call, @NonNull Response<ResponPelanggan> response) {
                loading.dismiss();
                String kode = response.body().getKode();
                String message = response.body().getPesan();
                if (kode.equals("1")) {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), login.class);
                    startActivity(register);
                } else {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponPelanggan> call, @NonNull Throwable t) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
