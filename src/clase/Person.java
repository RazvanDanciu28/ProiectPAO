package clase;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected int age;
    protected Orar orar;

    //constructor
    public Person(String firstName, String lastName, String phoneNumber, String email, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.orar = new Orar();
    }

    //cc
    public Person(){}

    //getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Orar getOrar(){
        return orar;
    }

    public boolean getDisp(LocalDate data, int ora){
        return orar.getStatusOra(data, ora);
    }

    //setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDisp(LocalDate data, int ora, boolean status){
        orar.setStatus(data, ora, status);
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
