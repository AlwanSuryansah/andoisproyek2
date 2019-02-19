package com.example.alwansuryansah.pembayaran.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

public class SessionManajer {


    public static final String KEY_NAMA = "id_pelanggan";
    public static final String KEY_ID = "id_toko";
    private static final String is_login = "logginstatus";
    private static final String SHARE_NAME = "loginsession";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public SessionManajer (Context context) {
        sp = context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor = sp.edit();
    }

    public void storeLogin(String id_pelanggan) {
        editor.putBoolean(is_login, true);
        editor.putString(KEY_NAMA ,id_pelanggan);
        editor.commit();
    }

    public void storeLoginToko(String id_toko) {
        editor.putBoolean(is_login, true);
        editor.putString(KEY_ID ,id_toko);
        editor.commit();
    }

    public HashMap getDetailLogin() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_NAMA, sp.getString(KEY_NAMA, null));
        return map;
    }

    public HashMap getDetailLoginToko() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_ID, sp.getString(KEY_ID, null));
        return map;
    }

    public HashMap getTransaksi() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_NAMA, sp.getString(KEY_NAMA, null));
        return map;
    }

    public void storeTransaksi(String id_pelanggan) {
        editor.putBoolean(SHARE_NAME, true);
        editor.putString(KEY_NAMA ,id_pelanggan);
        editor.commit();
    }



    public Boolean Loggin() {
        return sp.getBoolean(is_login, false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

}
