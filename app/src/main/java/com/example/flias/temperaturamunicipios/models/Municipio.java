package com.example.flias.temperaturamunicipios.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Flias on 12/10/2017.
 */

public class Municipio {
    @SerializedName("anhodesmovilizacion")
    @Expose
    private String anhodesmovilizacion;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("numerodesmovilizados")
    @Expose
    private String numerodesmovilizados;





    public Municipio(String pdepartamento, String pnumero) {
        this.departamento= pdepartamento;
        this.numerodesmovilizados=pnumero;

    }

    public String getAnhodesmovilizacion() {
        return anhodesmovilizacion;
    }

    public void setAnhodesmovilizacion(String anhodesmovilizacion) {
        this.anhodesmovilizacion = anhodesmovilizacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNumerodesmovilizados() {
        return numerodesmovilizados;
    }

    public void setNumerodesmovilizados(String numerodesmovilizados) {
        this.numerodesmovilizados = numerodesmovilizados;
    }

}

