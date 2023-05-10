package clase;
import enums.Materii;
import enums.Zile;
import enums.tipSpecial;
import clase.Orar;

public class CursSpecial extends Curs{
    private tipSpecial tip;
    private int nrMaximStudenti;
    private int nrStudenti;
    private Teacher prof;
    private Zile zi;
    private int ora;

    public CursSpecial(Materii numeMaterie, int price, Teacher prof, Zile zi, int ora, tipSpecial tip, int nrStudenti, int nrMaximStudenti){
        super(numeMaterie,price);
        this.tip = tip;
        this.nrStudenti = nrStudenti;
        this.nrMaximStudenti = nrMaximStudenti;
        this.prof = prof;
        this.zi = zi;
        this.ora = ora;

        //pretul unui curs special este cu un procent mai scump fata de cursul normal, procentul depinde de tipul cursului;
        switch (tip) {
            case Admitere -> this.price = (int) (this.price + this.price * 0.3);
            case Olimpiada -> this.price = (int) (this.price + this.price * 0.2);
            case Bacalaureat -> this.price = (int) (this.price + this.price * 0.1);
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

    public int getOra() {
        return ora;
    }
    public Zile getZi(){
        return zi;
    }
    public Teacher getProf(){
        return prof;
    }

    public int getNrStudenti() {
        return nrStudenti;
    }
    //setters

    public void setNrMaximStudenti(int nrMaximStudenti) {
        this.nrMaximStudenti = nrMaximStudenti;
    }

    public void setTip(tipSpecial tip) {
        this.tip = tip;
    }
    public void setProf(Teacher prof) {
        this.prof = prof;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public void setZi(Zile zi){
        this.zi = zi;
    }

    public void setNrStudenti(int nrStudenti) {
        this.nrStudenti = nrStudenti;
    }
    //maybe to string?
}
