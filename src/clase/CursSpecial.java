package clase;
import enums.Materii;
import enums.Zile;
import enums.tipSpecial;

public class CursSpecial extends Curs{
    private tipSpecial tip;
    private int nrMaximStudenti;
    private Quizz simulare;

    public CursSpecial(Materii numeMaterie, int length, Teacher prof, Zile zi, Orar.Day intervalOrar, int price, tipSpecial tip, int nrMaximStudenti, Quizz simulare){
        super(numeMaterie, length, prof, zi, intervalOrar, price);
        this.tip = tip;
        this.nrMaximStudenti = nrMaximStudenti;
        this.simulare = simulare;

        //pretul unui curs special este cu un procent mai scump fata de cursul normal, procentul depinde de tipul cursului;
        switch (tip) {
            case Admitere -> this.price = (int) (this.price + this.price * 0.3);
            case Olimpiada -> this.price = (int) (this.price + this.price * 0.2);
            default -> this.price = (int) (this.price + this.price * 0.1);
        }
    }
    public CursSpecial(){}


    //getters
    public String getTip(){
        return tip.toString();
    }
    public int getNrMaximStudenti(){
        return nrMaximStudenti;
    }
    public Quizz getSimualre(){
        return simulare;
    }


    //setters

    public void setNrMaximStudenti(int nrMaximStudenti) {
        this.nrMaximStudenti = nrMaximStudenti;
    }

    public void setTip(tipSpecial tip) {
        this.tip = tip;
    }
    public void setSimulare(Quizz simulare){
        this.simulare = simulare;
    }



    //maybe to string?
}
