package com.apptama.miexamen.datos.entity;

/**
 * Created by jose_ on 13/11/2018.
 */

public class Curso {

    private Integer idCurso;
    private String nombre;
    private String color;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, String color) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.color = color;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
