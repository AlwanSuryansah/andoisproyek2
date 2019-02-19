package com.example.alwansuryansah.pembayaran.API;

import com.example.alwansuryansah.pembayaran.model.ResponPelanggan;
import com.example.alwansuryansah.pembayaran.model.ResponToko;
import com.example.alwansuryansah.pembayaran.model.ResponTransaksi;
import com.example.alwansuryansah.pembayaran.model.ResponTransaksiToko;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiServices {

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponPelanggan> register(@Field("id_pelanggan") String id_pelanggan,
                              @Field("nama_pelanggan") String nama_pelanggan,
                              @Field("alamat") String alamat,
                              @Field("jenis_kelami") String jenis_kelami,
                              @Field("username") String username,
                              @Field("password") String password,
                              @Field("saldo_pelanggan") String saldo_pelanggan,
                              @Field("status") String status);

    @FormUrlEncoded
    @POST("edit.php")
    Call<ResponPelanggan> edit(@Field("id_pelanggan") String id_pelanggan,
                                   @Field("nama_pelanggan") String nama_pelanggan,
                                   @Field("alamat") String alamat,
                                   @Field("jenis_kelami") String jenis_kelami,
                                   @Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("transaksi.php")
    Call<ResponTransaksi> transaksi(@Field("id_transaksi") String id_transaksi,
                                    @Field("jumlah_transaksi") String jumlah_transaksi,
                                    @Field("id_pelanggan") String id_pelanggan,
                                    @Field("id_toko") String id_toko);


    @FormUrlEncoded
    @POST("registertoko.php")
    Call<ResponToko> registertoko(@Field("id_toko") String id_toko,
                                  @Field("nama_toko") String nama_toko,
                                  @Field("alamat_toko") String alamat_toko,
                                  @Field("jenis_toko") String jenis_toko,
                                  @Field("username") String username,
                                  @Field("password") String password,
                                  @Field("saldo_toko") String saldo_toko,
                                  @Field("status") String status);

    @FormUrlEncoded
    @POST("edittoko.php")
    Call<ResponToko> edittoko(@Field("id_toko") String id_toko,
                                  @Field("nama_toko") String nama_toko,
                                  @Field("alamat_toko") String alamat_toko,
                                  @Field("jenis_toko") String jenis_toko,
                                  @Field("username") String username,
                                  @Field("password") String password);


    @FormUrlEncoded
    @POST("login.php")
    Call<ResponPelanggan> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("logintoko.php")
    Call<ResponToko> loginToko(@Field("username") String username,
                                @Field("password") String password);

    @GET("get_pelanggan.php")
    Call<ResponPelanggan> get_pelanggan(@Query("id_pelanggan") String id_pelanggan);

    @GET("get_toko.php")
    Call<ResponToko> get_toko(@Query("id_toko") String id_toko);

    @GET("get_transaksi.php")
    Call<ResponToko> get_transaksi(@Query("id_pelanggan") String id_pelanggan);

    @GET("get_transaksitoko.php")
    Call<ResponTransaksiToko> get_transaksitoko(@Query("id_toko") String id_toko);
}
