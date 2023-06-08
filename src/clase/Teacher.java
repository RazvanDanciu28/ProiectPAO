package clase;
import enums.Materii;
import enums.Zile;

import java.time.LocalDate;


public class Teacher extends  Person{
    private Materii materie;

    private double rating;
    private int notePrimite;

    public Teacher(String firstName, String lastName, String phoneNumber, String email, int age, Materii materie, double rating, int notePrimite){
        super(firstName, lastName, phoneNumber, email, age);
        this.materie = materie;
        this.rating = rating;
        this.notePrimite = notePrimite;
    }

    public Teacher(){}

    //getters
    public String getMaterie(){
        return materie.toString();
    }

    public double getRating(){
        return rating;
    }
    public int getNotePrimite(){
        return notePrimite;
    }


    //nu am setter la materie pentru ca nu are sens ca un profesor sa isi schimbe materia

    //setters
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
