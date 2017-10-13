package com.example.flias.temperaturamunicipios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.flias.temperaturamunicipios.api.DatosApi;
import com.example.flias.temperaturamunicipios.models.Municipio;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    public final static String TAG = "Datos colombia";
    private RecyclerView rv;
    private RecyclerViewAdaptador adaptadorMunicipio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));






        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        obtenerDatos();
        DatosApi service = retrofit.create(DatosApi.class);



    }







    public void obtenerDatos() {

        DatosApi service = retrofit.create(DatosApi.class);
        Call<List<Municipio>> municipioCall = service.obtenerListaMunicipios();


        municipioCall.enqueue(new Callback<List<Municipio>>() {
            @Override
            public void onResponse(Call<List<Municipio>> call, Response<List<Municipio>> response) {
                if (response.isSuccessful()) {
                    List milista = response.body();
                    for (int i = 0; i < milista.size(); i++) {
                        Municipio m = (Municipio) milista.get(i);
                        adaptadorMunicipio = new RecyclerViewAdaptador(milista);
                        rv.setAdapter(adaptadorMunicipio);

                    }
                } else {
                    Log.e(TAG, "OnResponse" + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Municipio>> call, Throwable t) {
                Log.e(TAG, "OnFailure" + t.getMessage());//mensaje en rojo
            }
        });//En cola


    }
}

