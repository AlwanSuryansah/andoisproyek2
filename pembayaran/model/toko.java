package com.example.alwansuryansah.pembayaran.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class toko {

    @SerializedName("id_toko")
    @Expose
    private String id_toko;

    @SerializedName("nama_toko")
    @Expose
    private String nama_toko;

    @SerializedName("alamat_toko")
    @Expose
    private String alamat_toko;

    @SerializedName("jenis_toko")
    @Expose
    private String jenis_toko;


    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("saldo_toko")
    @Expose
    private String saldo_toko;

    @SerializedName("status")
    @Expose
    private String status;

    public String getId_toko() {
        return id_toko;
    }

    public void setId_toko(String id_toko) {
        this.id_toko = id_toko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getAlamat_toko() {
        return alamat_toko;
    }

    public void setAlamat_toko(String alamat_toko) {
        this.alamat_toko = alamat_toko;
    }

    public String getJenis_toko() {
        return jenis_toko;
    }

    public void setJenis_toko(String jenis_toko) {
        this.jenis_toko = jenis_toko;
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

    public String getSaldo_toko() {
        return saldo_toko;
    }

    public void setSaldo_toko(String saldo_toko) {
        this.saldo_toko = saldo_toko;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
