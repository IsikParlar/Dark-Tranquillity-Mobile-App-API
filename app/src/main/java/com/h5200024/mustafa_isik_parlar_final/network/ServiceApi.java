package com.h5200024.mustafa_isik_parlar_final.network;

import com.h5200024.mustafa_isik_parlar_final.model.Grup;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("uyeler.json")
    Observable<List<Grup>> grupUyeleriniGetir();

}
