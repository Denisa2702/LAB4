package Problema;

import java.io.Serializable;

public class Copiator extends Echipament implements Serializable
{

    private int p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, Status status, int p_ton, Format format) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.p_ton = p_ton;
        this.format = format;
    }

    @Override
    public String toString()
    {
        return super.toString()+" "+ p_ton+" "+format;
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}

enum Format
{
    A3,
    A4
};
