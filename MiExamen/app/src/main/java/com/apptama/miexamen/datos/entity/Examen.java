package com.apptama.miexamen.datos.entity;

/**
 * Created by jose_ on 16/11/2018.
 */

public class Examen {

    private Integer idCurso;
    private Integer nroPregunta;
    private String pregunta;
    private String Rspta1;
    private boolean isRspta1;
    private String Rspta2;
    private boolean isRspta2;
    private String Rspta3;
    private boolean isRspta3;
    private String Rspta4;
    private boolean isRspta4;

    public Examen() {
    }

    public Examen(Integer idCurso, Integer nroPregunta, String pregunta, String rspta1, boolean isRspta1, String rspta2, boolean isRspta2, String rspta3, boolean isRspta3, String rspta4, boolean isRspta4) {
        this.idCurso = idCurso;
        this.nroPregunta = nroPregunta;
        this.pregunta = pregunta;
        Rspta1 = rspta1;
        this.isRspta1 = isRspta1;
        Rspta2 = rspta2;
        this.isRspta2 = isRspta2;
        Rspta3 = rspta3;
        this.isRspta3 = isRspta3;
        Rspta4 = rspta4;
        this.isRspta4 = isRspta4;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getNroPregunta() {
        return nroPregunta;
    }

    public void setNroPregunta(Integer nroPregunta) {
        this.nroPregunta = nroPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRspta1() {
        return Rspta1;
    }

    public void setRspta1(String rspta1) {
        Rspta1 = rspta1;
    }

    public boolean isRspta1() {
        return isRspta1;
    }

    public void setIsRspta1(boolean rspta1) {
        isRspta1 = rspta1;
    }

    public String getRspta2() {
        return Rspta2;
    }

    public void setRspta2(String rspta2) {
        Rspta2 = rspta2;
    }

    public boolean isRspta2() {
        return isRspta2;
    }

    public void setIsRspta2(boolean rspta2) {
        isRspta2 = rspta2;
    }

    public String getRspta3() {
        return Rspta3;
    }

    public void setRspta3(String rspta3) {
        Rspta3 = rspta3;
    }

    public boolean isRspta3() {
        return isRspta3;
    }

    public void setIsRspta3(boolean rspta3) {
        isRspta3 = rspta3;
    }

    public String getRspta4() {
        return Rspta4;
    }

    public void setRspta4(String rspta4) {
        Rspta4 = rspta4;
    }

    public boolean isRspta4() {
        return isRspta4;
    }

    public void setIsRspta4(boolean rspta4) {
        isRspta4 = rspta4;
    }
}
