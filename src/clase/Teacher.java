package clase;
import enums.Materii;
import enums.Zile;


public class Teacher extends  Person{
    private Materii materie;
    private Orar orar;
    private double rating;
    private int notePrimite;

    public Teacher(String firstName, String lastName, String phoneNumber, String email, int age, Materii materie, double rating, int notePrimite){
        super(firstName, lastName, phoneNumber, email, age);
        this.materie = materie;
        this.orar = new Orar();
        this.rating = rating;
        this.notePrimite = notePrimite;
    }

    public Teacher(){}

    //getters
    public String getMaterie(){
        return materie.toString();
    }
    public Orar getOrar(){
        return orar;
    }
    public String getDisp(Zile zi, int ora){
        return orar.getStatusOra(zi, ora);
    }
    public double getRating(){
        return rating;
    }
    public int getNotePrimite(){
        return notePrimite;
    }

    //nu am setter la materie pentru ca nu are sens ca un profesor sa isi schimbe materia

    //setters
    public void changeDisp(Zile zi, int ora){
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
    public String toString() {
        return "Teacher{" +
                "materie=" + materie +
                ", orar=" + orar +
                ", rating=" + rating +
                ", notePrimite=" + notePrimite +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }


}
