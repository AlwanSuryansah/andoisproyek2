package com.example.alwansuryansah.pembayaran.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pelanggan {

    @SerializedName("id_pelanggan")
    @Expose
    private String id_pelanggan;

    @SerializedName("nama_pelanggan")
    @Expose
    private String nama_pelanggan;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("jenis_kelami")
    @Expose
    private String jenis_kelami;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("saldo_pelanggan")
    @Expose
    private String saldo_pelanggan;

    @SerializedName("status")
    @Expose
    private String status;

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelami() {
        return jenis_kelami;
    }

    public void setJenis_kelami(String jenis_kelami) {
        this.jenis_kelami = jenis_kelami;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSaldo_pelanggan() {
        return saldo_pelanggan;
    }

    public void setSaldo_pelanggan(String saldo_pelanggan) {
        this.saldo_pelanggan = saldo_pelanggan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
