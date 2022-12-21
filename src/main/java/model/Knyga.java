package model;

public class Knyga {
    private int id;
    private String pavadinimas;
    private int puslapiu_skaicius;
    private String leidejas;
    private double ivertinimas;

    public Knyga(){

    }

    public Knyga(int id, String pavadinimas, int puslapiu_skaicius, String leidejas, double ivertinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.puslapiu_skaicius = puslapiu_skaicius;
        this.leidejas = leidejas;
        this.ivertinimas = ivertinimas;
    }

    public Knyga(String pavadinimas, int puslapiu_skaicius, String leidejas, double ivertinimas) {
        this.pavadinimas = pavadinimas;
        this.puslapiu_skaicius = puslapiu_skaicius;
        this.leidejas = leidejas;
        this.ivertinimas = ivertinimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getPuslapiu_skaicius() {
        return puslapiu_skaicius;
    }

    public void setPuslapiu_skaicius(int puslapiu_skaicius) {
        this.puslapiu_skaicius = puslapiu_skaicius;
    }

    public String getLeidejas() {
        return leidejas;
    }

    public void setLeidejas(String leidejas) {
        this.leidejas = leidejas;
    }

    public double getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(double ivertinimas) {
        this.ivertinimas = ivertinimas;
    }

    @Override
    public String toString() {
        return "Knyga{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", puslapiu_skaicius=" + puslapiu_skaicius +
                ", leidejas='" + leidejas + '\'' +
                ", ivertinimas=" + ivertinimas +
                '}';
    }
}
