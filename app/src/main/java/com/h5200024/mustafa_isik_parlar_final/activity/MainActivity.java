package com.h5200024.mustafa_isik_parlar_final.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.h5200024.mustafa_isik_parlar_final.util.Constants;
import com.h5200024.mustafa_isik_parlar_final.util.GlideUtil;
import com.h5200024.mustafa_isik_parlar_final.model.Grup;
import com.h5200024.mustafa_isik_parlar_final.adaptor.GrupAdaptor;
import com.h5200024.mustafa_isik_parlar_final.R;
import com.h5200024.mustafa_isik_parlar_final.network.Service;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Context context;
    ImageView imgKapak;
    String resimUrl ="https://www.logolynx.com/images/logolynx/49/49f9cb03dba6911cfce96ba5a3afa2fe.jpeg";
    RecyclerView recyclerView;

    private static int BeklemeSuresi=3000;

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    protected void onResume(){
        super.onResume();
        CheckInternet();
    }

    protected void CheckInternet(){

        if (isConnected()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //ekranGecisYap();
                }
            }, BeklemeSuresi);
        }
        else {
            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        kapakResminiCek();
        grupUyeleriniGetir();
    }

    private void kapakResminiCek()
    {
        imgKapak =findViewById(R.id.imgKapak);
        GlideUtil.resmiIndiripGoster(getApplicationContext(),resimUrl,imgKapak);
    }

    private void initRecycleView(List<Grup> grupList)
    {
        recyclerView =findViewById(R.id.rcvGrupUyeleri);

        GrupAdaptor grupAdaptor =new GrupAdaptor(grupList, getApplicationContext(), new GrupAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(Grup tiklananGrupUyesi) {


                Intent Detaygecis = new Intent(MainActivity.this,GrupDetayActivity.class);
                Detaygecis.putExtra(Constants.Detay_Gecis_Adi,tiklananGrupUyesi.getAdiSoyadi());
                Detaygecis.putExtra(Constants.Detay_Gecis_Aciklama,tiklananGrupUyesi.getAciklama());
               // Detaygecis.putExtra(Constants.Detay_Gecis_Resim,tiklananGrupUyesi.getResimURL() );

                startActivity(Detaygecis);

                Toast.makeText(getApplicationContext(),
                        "Tıklanan Grup Üyesi : "+tiklananGrupUyesi.getAdiSoyadi(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(grupAdaptor);
    }

    void grupUyeleriniGetir(){

        new Service().getServiceApi().grupUyeleriniGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Grup>>() {
                    List<Grup> grupUyeleri=new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<Grup> grupListParam) {
                        grupUyeleri= grupListParam;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete()
                    {
                        if(grupUyeleri.size()>0) {
                            for (Grup item:grupUyeleri ){
                                initRecycleView(grupUyeleri);
                            }
                        }
                    }
                });

    }
}