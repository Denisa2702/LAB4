package Problema;

import java.io.Serializable;

public class Echipament implements Serializable
{
    private transient String denumire;
    private int nr_inv;
    private transient float pret;
    private String zona_mag;
    private Status status;

    public Echipament(String denumire, int nr_inv, float pret, String zona_mag, Status status) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.status = status;

    }

    @Override
    public String toString() {
        return denumire+" "+nr_inv+" "+pret+" "+zona_mag+" "+status;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

enum Status{
    achizitionat,
    expus,
    vandut
};