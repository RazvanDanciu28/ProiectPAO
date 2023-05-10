package clase;

import enums.Materii;
import enums.Zile;

public class Curs {
    protected Materii numeMaterie;
    protected int length;
    protected Teacher prof;
    protected Orar.Day intervalOrar;
    protected Zile zi;
    protected int price;

    public Curs(Materii numeMaterie, int length, Teacher prof, Zile zi, Orar.Day intervalOrarint, int price){
        this.numeMaterie = numeMaterie;
        this.length = length;
        this.prof = prof;
        this.zi = zi;
        this.intervalOrar = intervalOrar;
        this.price = price;
    }
    public Curs(){}

    //getters
    public String getNumeMaterie(){
        return numeMaterie.toString();
    }
    public int getLength(){
        return length;
    }
    public Teacher getProf(){
        return prof;
    }
    public int getIntervalOrar(){
        if (intervalOrar.optZece) return 8;
        else if (intervalOrar.zeceDoispe) return 10;
        else if (intervalOrar.doispePaispe) return 12;
        else if (intervalOrar.paispeSaispe) return 14;
        else if (intervalOrar.saispeOptispe) return 16;
        else return 18;
    }
    public Zile getZi(){
        return zi;
    }

    public int getPrice(){
        return price;
    }


    //setters

    public void setNumeMaterie(Materii numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setProf(Teacher prof) {
        this.prof = prof;
    }

    public void setIntervalOrar(int newOra) {
        if (intervalOrar.optZece) intervalOrar.optZece = false;
        else if (intervalOrar.zeceDoispe) intervalOrar.zeceDoispe = false;
        else if (intervalOrar.doispePaispe) intervalOrar.doispePaispe = false;
        else if (intervalOrar.paispeSaispe) intervalOrar.paispeSaispe = false;
        else if (intervalOrar.saispeOptispe) intervalOrar.saispeOptispe = false;
        else intervalOrar.saispeOptispe = false;

        switch (newOra) {
            case 8 -> intervalOrar.optZece = true;
            case 10 -> intervalOrar.zeceDoispe = true;
            case 12 -> intervalOrar.doispePaispe = true;
            case 14 -> intervalOrar.paispeSaispe = true;
            case 16 -> intervalOrar.saispeOptispe = true;
            default -> intervalOrar.optispeDouazeci = true;
        };
    }

    public void setZi(Zile zi){
        this.zi = zi;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "{" + "Materie: " + numeMaterie +
                " Durata: " + length +
                " Pret: " + price +
                " Profesor: " + prof.getLastName() + " " + prof.getFirstName() +
                " Zi: " + zi +
                " Ora: " + this.getIntervalOrar() + "}";
    }
}
