package com.example.alwansuryansah.pembayaran.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class transaksitoko {

    @SerializedName("id_transaksi")
    @Expose
    private String id_transaksi;

    @SerializedName("jumlah_transaksi")
    @Expose
    private String jumlah_transaksi;

    @SerializedName("id_pelanggan")
    @Expose
    private String id_pelanggan;

    @SerializedName("nama_toko")
    @Expose
    private String nama_toko;

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(String jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }
}
