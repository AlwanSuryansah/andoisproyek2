//package com.example.alwansuryansah.pembayaran.adaptor;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.example.alwansuryansah.pembayaran.R;R
//import com.example.alwansuryansah.pembayaran.model.pelanggan;
//
//import java.util.List;
//
//public class pelangganadaptor extends RecyclerView.Adapter<pelangganadaptor.HolderData>  {
//
//
//    private List<pelanggan> listpelanggan;
//    private Context context;
//
//    public pelangganadaptor(Context context, List<pelanggan> listpelanggan) {
//        this.context = context;
//        this.listpelanggan = listpelanggan;
//    }
//
//    public void setListResi(List<pelanggan> listResi) {
//        this.listpelanggan = listResi;
//    }
//
//    @NonNull
//    @Override
//    public pelangganadaptor.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpelanggan,parent, false);
//        HolderData holder = new HolderData(layout);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull pelangganadaptor.HolderData holder, @SuppressLint("RecyclerView") final int position) {
//        final pelanggan pelanggan = listpelanggan.get(position);
//        holder.namapelanggan.setText(pelanggan.getNama_pelanggan());
//        holder.saldopelanggan.setText(pelanggan.getSaldo());
//        holder.pelanggan = pelanggan;
////        holder.cardView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent detail = new Intent(context, DetailResiActivity.class);
////                detail.putExtra("id_Pelanggan", pelanggan.getId_pelanggan());
////                detail.putExtra("nama_pelanggan", pelanggan.getNama_pelanggan());
////                detail.putExtra("saldo", pelanggan.getSaldo());
////                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(detail);
////            }
////        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return listpelanggan.size();
//    }
//
//    class HolderData extends  RecyclerView.ViewHolder{
//
//        private EditText namapelanggan , saldopelanggan;
//
//        CardView cardView;
//        pelanggan pelanggan;
//        HolderData(View v) {
//            super(v);
//           namapelanggan = v.findViewById(R.id.namapelanggan);
//           saldopelanggan = v.findViewById(R.id.saldo);
//        }
//    }
//}
