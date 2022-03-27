package com.h5200024.mustafa_isik_parlar_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5200024.mustafa_isik_parlar_final.R;
import com.h5200024.mustafa_isik_parlar_final.util.Constants;
import com.h5200024.mustafa_isik_parlar_final.util.GlideUtil;

public class GrupDetayActivity extends AppCompatActivity {

    TextView txtViewIsimBaslik,textViewHTMLGrupAciklama;
    ImageView imageViewGrupResim, imgGrupUyesi;
    String resimUrl ="https://www.logolynx.com/images/logolynx/49/49f9cb03dba6911cfce96ba5a3afa2fe.jpeg";
    String htmlString;


    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grup_detay);

        imgGrupUyesi = findViewById(R.id.imgGrupUyesi);
        imageViewGrupResim = findViewById(R.id.imageViewGrupResim);
        textViewHTMLGrupAciklama = findViewById(R.id.textViewHTMLGrupAciklama);
        txtViewIsimBaslik = findViewById(R.id.txtViewIsimBaslik);


        txtViewIsimBaslik.setText(getIntent().getStringExtra(Constants.Detay_Gecis_Adi));
        htmlString = (getIntent().getStringExtra(Constants.Detay_Gecis_Aciklama));
        textViewHTMLGrupAciklama.setText(Html.fromHtml(htmlString));
        GlideUtil.resmiIndiripGoster(getApplicationContext(),resimUrl,imageViewGrupResim);




    }


}
