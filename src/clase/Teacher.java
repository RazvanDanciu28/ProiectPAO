package clase;
import enums.Materii;


public class Teacher extends  Person{
    private Materii materie;
    private Orar orar;
    private double rating;
    private int notePrimite;

    public Teacher(String firstName, String lastName, String phoneNumber, String email, int age, Materii materie, Orar orar, double rating, int notePrimite){
        super(firstName, lastName, phoneNumber, email, age);
        this.materie = materie;
        this.orar = orar;
        this.rating = rating;
        this.notePrimite = notePrimite;
    }

    public Teacher(){}

    public Materii getMaterie(){
        return materie;
    }
    public Orar getOrar(){
        return orar;
    }
    public String getDisp(String zi, int ora){
        return orar.getStatusOra(zi, ora);
    }
    public double getRating(){
        return rating;
    }
    public int getNotePrimite(){
        return notePrimite;
    }

    //nu am setter la materie pentru ca nu are sens ca un profesor sa isi schimbe materia

    public void changeDisp(String zi, int ora){
        orar.changeStatusOra(zi, ora);
    }
    public void setNotePrimite(int nrNote){
        notePrimite = nrNote;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public void addNota(int nota){
        notePrimite++;
        rating += nota;
        rating /= notePrimite;
    }

    @Override
    public String toString(){
         return super.toString() +
                 "materie= " + materie;
    }

    //ok
}
