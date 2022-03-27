package com.h5200024.mustafa_isik_parlar_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grup {

    @SerializedName("Adi")
    @Expose
    private String adiSoyadi;
    @SerializedName("Rol")
    @Expose
    private String rol;
    @SerializedName("ResimURL")
    @Expose
    private String resimURL;
    @SerializedName("Yasi")
    @Expose
    private String yas;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;


    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }



}