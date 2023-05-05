package clase;

import enums.Materii;

public class Quizz {
    private Materii materie;
    private int nrIntrebari;
    private int scorMinimTrecere;

    public Quizz(Materii materie, int nrIntrebari, int scorMinimTrecere){
        this.materie = materie;
        this.nrIntrebari = nrIntrebari;
        this.scorMinimTrecere = nrIntrebari;
    }
    public Quizz(){}

    //getters
    public String getMaterie(){
        return materie.toString();
    }
    public int getNrIntrebari(){
        return nrIntrebari;
    }
    public int getScorMinimTrecere(){
        return scorMinimTrecere;
    }

    //setters

    public void setMaterie(Materii materie) {
        this.materie = materie;
    }

    public void setNrIntrebari(int nrIntrebari) {
        this.nrIntrebari = nrIntrebari;
    }

    public void setScorMinimTrecere(int scorMinimTrecere) {
        this.scorMinimTrecere = scorMinimTrecere;
    }


}
