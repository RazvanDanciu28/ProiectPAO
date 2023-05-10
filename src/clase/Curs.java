package clase;

import enums.Materii;

public class Curs {
    protected Materii numeMaterie;
    protected int price;


    public Curs(Materii numeMaterie, int price){
        this.numeMaterie = numeMaterie;
        this.price = price;
    }
    public Curs(){}

    //getters
    public String getNumeMaterie(){
        return numeMaterie.toString();
    }

    public int getPrice(){
        return price;
    }


    //setters

    public void setNumeMaterie(Materii numeMaterie) {
        this.numeMaterie = numeMaterie;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "numeMaterie=" + numeMaterie +
                ", price=" + price +
                '}';
    }
}
