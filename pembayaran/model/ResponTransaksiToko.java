package com.example.alwansuryansah.pembayaran.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponTransaksiToko {

    @SerializedName("kode")
    private String kode;

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("result")
    private List<transaksitoko> result;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<transaksitoko> getResult() {
        return result;
    }

    public void setResult(List<transaksitoko> result) {
        this.result = result;
    }
}
