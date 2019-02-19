package com.example.alwansuryansah.pembayaran.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponPelanggan {

    @SerializedName("kode")
    private String kode;

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("result")
    private List<pelanggan> result;

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

    public List<pelanggan> getResult() {
        return result;
    }

    public void setResult(List<pelanggan> result) {
        this.result = result;
    }
}
