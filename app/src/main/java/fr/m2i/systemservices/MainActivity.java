package fr.m2i.systemservices;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// demander autorisation d'acces au compte a l operateur
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCOUNT_MANAGER},1);
    }

    public void testWifi(View v){
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
       if( wm.getWifiState() == WifiManager.WIFI_STATE_ENABLED){
           Toast.makeText(this, "Wifi disponible", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, "Wifi indisponible", Toast.LENGTH_SHORT).show();
       }
    }

   // public void testVibreur(View v){

   //     Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

    //    if(vib.hasVibrator()){
//            vib.vibrate( : 1000);




      //  }
   // }

    public void getUser(View v){

        AccountManager am = (AccountManager) getApplicationContext().getSystemService(Context.ACCOUNT_SERVICE) ;
        Account[] comptes = am.getAccounts();

        if(comptes.length == 0){
            Toast.makeText(this, "pas de compte",   Toast.LENGTH_LONG).show();
            return;
        }

        //récupère le premier compte
        Account compte = comptes[0];

        //afficher le nom du premier compte
        Toast.makeText(this, compte.name,  Toast.LENGTH_SHORT).show();


    }
}
