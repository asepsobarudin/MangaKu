package com.example.project_akhir_bp3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

//karena apliaksi memerlukan intenet agar terhubung ke data base maka class ini dibuat agar pengguna harus terhubung ke internet.

public class CheckInternetConnection {
    private static String cekConnect = CheckInternetConnection.class.getSimpleName();

    public static boolean checkInternet (Context context){
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null){
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
