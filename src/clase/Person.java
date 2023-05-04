package clase;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int age;

    //constructor
    public Person(String firstName, String lastName, String phoneNumber, String email, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
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


    @Override
    public String toString() {
        return "{" +
                "First Name= " + firstName +
                ", Last Name= " + lastName +
                ", Phone Number= " + phoneNumber +
                ", email= " + email +
                ", age= " + Integer.toString(age) +
                "}";
    }
}
