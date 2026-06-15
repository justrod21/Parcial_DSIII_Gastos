package com.proyecto.gasto.model;

import java.time.LocalDate;

public class GastoModel {

    private int id;
    private String descripcion;
    private double monto;
    private String categoria;
    private LocalDate fecha;

    public GastoModel() {
    }

    public GastoModel(int id, String descripcion, double monto, String categoria, LocalDate fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}