package Problema;

import java.io.Serializable;

public class SistemCalcul extends Echipament implements Serializable
{
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private SistemOperare sistem_operare;

    public SistemCalcul(String denumire, int nr_inv, float pret, String zona_mag, Status status, String tip_mon, float vit_proc, int c_hdd, SistemOperare sistem_operare) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem_operare = sistem_operare;
    }

    @Override
    public String toString()
    {
        return super.toString()+" "+tip_mon+" "+vit_proc+" "+ c_hdd+" "+ sistem_operare;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public float getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemOperare getSistem_operare() {
        return sistem_operare;
    }

    public void setSistem_operare(SistemOperare sistem_operare) {
        this.sistem_operare = sistem_operare;
    }
}

enum SistemOperare
{
    Windows,
    windows,
    Linux,
    linux
};
