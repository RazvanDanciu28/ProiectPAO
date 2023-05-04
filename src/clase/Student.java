package clase;
import enums.Materii;
import java.util.ArrayList;

public class Student extends Person{
    private Orar orar;
    private int buget;
    private ArrayList<Materii> materiiList;

    public Student(String firstName, String lastName, String phoneNumber, String email, int age, Materii materie, Orar orar, int buget){
        super(firstName, lastName, phoneNumber, email, age);
        this.orar = orar;
        this.buget = buget;
        this.materiiList = new ArrayList<>();
    }

    public Student(){}

    //getters
    public Orar getOrar(){
        return orar;
    }
    public String getDisp(String zi, int ora){
        return orar.getStatusOra(zi, ora);
    }

    public ArrayList<Materii> getMaterii(){
        return materiiList;
    }


    public void changeDisp(String zi, int ora){
        orar.changeStatusOra(zi, ora);
    }
    

}
