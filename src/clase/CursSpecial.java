package clase;
import enums.Materii;
import enums.Zile;
import enums.tipSpecial;

public class CursSpecial extends Curs{
    private tipSpecial tip;
    private int nrMaximStudenti;
    private Quizz simulare;

    public CursSpecial(Materii numeMaterie, int length, Teacher prof, Zile zi, Orar.Day intervalOrar, tipSpecial tip, int nrMaximStudenti, Quizz simulare){
        super(numeMaterie, length, prof, zi, intervalOrar);
        this.tip = tip;
        this.nrMaximStudenti = nrMaximStudenti;
        this.simulare = simulare;
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
