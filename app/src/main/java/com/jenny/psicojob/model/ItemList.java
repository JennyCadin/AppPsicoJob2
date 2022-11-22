package com.jenny.psicojob.model;

import java.io.Serializable;

public class ItemList implements Serializable {
    private String titulo;
    private String descripcion;
    private int imgResource;
    private String descripcionLarga;

    public ItemList(String titulo, String descripcion, String descripcionLarga, int imgResource) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgResource = imgResource;
        this.descripcionLarga = descripcionLarga;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getDescripcionLarga() { return descripcionLarga; }

    }
