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

import com.example.alwansuryansah.pembayaran.R;
import com.example.alwansuryansah.pembayaran.history;
import com.example.alwansuryansah.pembayaran.historypelanggan;
import com.example.alwansuryansah.pembayaran.model.pelanggan;
import com.example.alwansuryansah.pembayaran.model.transaksi;

import java.util.List;

public class transaksiadaptor extends RecyclerView.Adapter<transaksiadaptor.HolderData>  {

    private List<transaksi> listtransaksi;
    private Context context;

    public transaksiadaptor(Context context, List<transaksi> listtransaksi) {
        this.context = context;
        this.listtransaksi = listtransaksi;
    }

    public void setListtransaksi(List<transaksi> listtransaksi) {
        this.listtransaksi = listtransaksi;
    }

    @NonNull
    @Override
    public transaksiadaptor.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpelanggan,parent, false);
        transaksiadaptor.HolderData holder = new transaksiadaptor.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull transaksiadaptor.HolderData holder, @SuppressLint("RecyclerView") final int position) {
        final transaksi transaksi = listtransaksi.get(position);
        holder.id.setText(transaksi.getId_transaksi());
        holder.jumlah.setText(transaksi.getJumlah_transaksi());
        holder.pelanggan.setText(transaksi.getId_pelanggan());
        holder.toko.setText(transaksi.getId_toko());
        holder.transaksi = transaksi;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, historypelanggan.class);
                detail.putExtra("id_transaksi", transaksi.getId_transaksi());
                detail.putExtra("jumlah_transaksi", transaksi.getJumlah_transaksi());
                detail.putExtra("id_pelanggan", transaksi.getId_pelanggan());
                detail.putExtra("id_toko", transaksi.getId_toko());
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
      return listtransaksi.size();
    }

    class HolderData extends  RecyclerView.ViewHolder{

        private EditText id , jumlah , pelanggan , toko;

        CardView cardView;
        com.example.alwansuryansah.pembayaran.model.transaksi transaksi;
        HolderData(View v) {
            super(v);
            id = v.findViewById(R.id.id_transaksi1);
            jumlah = v.findViewById(R.id.jumlah_transaksi1);
            pelanggan = v.findViewById(R.id.id_pelanggan2);
            toko = v.findViewById(R.id.id_toko2);
        }
    }
}
