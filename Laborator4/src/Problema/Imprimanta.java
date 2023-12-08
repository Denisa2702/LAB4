package Problema;

import java.io.Serializable;

public class Imprimanta extends Echipament implements Serializable
{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private ModTiparire mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, Status status, int ppm, String rezolutie, int p_car, ModTiparire mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire=mod_tiparire;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ppm + " " + rezolutie + " " + p_car + " " + mod_tiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getMod_tiparire() {
        return mod_tiparire;
    }

    public void setMod_tiparire(ModTiparire mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }
}

enum ModTiparire{
    Color,
    color,
    alb_negru,
    Alb_Negru
};
