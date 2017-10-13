package com.example.flias.temperaturamunicipios.api;

import com.example.flias.temperaturamunicipios.models.Municipio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Flias on 12/10/2017.
 */

public interface DatosApi
{
    @GET("panu-4x37.json")
    Call<List<Municipio>> obtenerListaMunicipios();

}
