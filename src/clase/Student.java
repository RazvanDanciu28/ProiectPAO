package clase;
import enums.Materii;
import java.util.ArrayList;
import enums.Zile;

public class Student extends Person{
    private Orar orar;
    private int buget;
    private String parola;
    private ArrayList<Materii> materiiList;

    public Student(String firstName, String lastName, String phoneNumber, String email, String parola, int age, int buget){
        super(firstName, lastName, phoneNumber, email, age);
        this.parola = parola;
        this.orar = new Orar();
        this.buget = buget;
        this.materiiList = new ArrayList<>();
    }

    public Student(){}

    //getters
    public Orar getOrar(){
        return orar;
    }
    public String getDisp(Zile zi, int ora){
        return orar.getStatusOra(zi, ora);
    }

    public ArrayList<Materii> getMaterii(){
        return materiiList;
    }

    public String getParola() {
        return parola;
    }

    public int getBuget() {
        return buget;
    }

    //setters
    public void changeDisp(Zile zi, int ora){
        orar.changeStatusOra(zi, ora);
    }
    public void setBuget(int buget){
        this.buget = buget;
    }
    public void addMaterie(Materii materie){
        if (!materiiList.contains(materie)) {
            materiiList.add(materie);
        }
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Student{" +
                "orar=" + orar +
                ", buget=" + buget +
                ", materiiList=" + materiiList +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }


}
