package com.example.alwansuryansah.pembayaran.adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alwansuryansah.pembayaran.R;
import com.example.alwansuryansah.pembayaran.history;
import com.example.alwansuryansah.pembayaran.historypelanggan;
import com.example.alwansuryansah.pembayaran.model.transaksi;
import com.example.alwansuryansah.pembayaran.model.transaksitoko;

import java.util.List;

public class transaksitokoadaptor extends RecyclerView.Adapter<transaksitokoadaptor.HolderData> {

    private List<transaksitoko> listtransaksitoko;
    private Context context;

    public transaksitokoadaptor(Context context, List<transaksitoko> listtransaksitoko) {
        this.context = context;
        this.listtransaksitoko = listtransaksitoko;
    }

    public void setListtransaksitoko(List<transaksitoko> listtransaksitoko) {
        this.listtransaksitoko = listtransaksitoko;
    }

    @NonNull
    @Override
    public transaksitokoadaptor.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listtransaksitoko,parent, false);
        transaksitokoadaptor.HolderData holder = new transaksitokoadaptor.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull transaksitokoadaptor.HolderData holder, @SuppressLint("RecyclerView") final int position) {
        final transaksitoko transaksitoko = listtransaksitoko.get(position);
        holder.noTransaksiText.setText(transaksitoko.getId_transaksi());
        holder.jumlahText.setText(transaksitoko.getJumlah_transaksi());
        holder.idpelangganText.setText(transaksitoko.getId_pelanggan());
        holder.namatokoText.setText(transaksitoko.getNama_toko());
        holder.transaksitoko = transaksitoko;
    }

    @Override
    public int getItemCount() {
        return listtransaksitoko.size();

    }

    public class HolderData extends RecyclerView.ViewHolder {
        private TextView noTransaksiText , jumlahText , namatokoText , idpelangganText;
        transaksitoko transaksitoko;
        HolderData(View v) {
            super(v);
            noTransaksiText = v.findViewById(R.id.noTransaksiValues);
            jumlahText = v.findViewById(R.id.jumlahValue);
            namatokoText = v.findViewById(R.id.namatokoValue);
            idpelangganText = v.findViewById(R.id.idpelangganValue);

        }
    }
}
