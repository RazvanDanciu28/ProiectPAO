import loader.*;
import enums.*;
import clase.*;
import services.StudentService;
import java.util.Scanner;


public class Main {
    public static boolean inCont = false;
    static void Ecran1(){
        System.out.println("Poiect PAO - Danciu Razvan");
        System.out.println("Apasa orice tasta pentru a continua");

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
    }

    public static void Inreg() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introdu urmatoarele date: ");

        System.out.println("Prenume: ");
        String prenume = in.nextLine();

        System.out.println("Nume: " );
        String nume = in.nextLine();

        System.out.println("Nr de telefon: " );
        String tel = in.nextLine();

        System.out.println("email: " );
        String email = in.nextLine();

        System.out.println("Parola: " );
        String parola = in.nextLine();

        System.out.println("Varsta: " );
        int age = in.nextInt();

        System.out.println("Buget de inceput (vei fi redirectionat pentru a plati dupa finalizarea contului): ");
        int buget = in.nextInt();

        inCont = true;
        loadElevi.addElev(new Student(prenume, nume, tel, email, parola, age, buget));
        loadElevi.elevCurent = loadElevi.elevi.get(loadElevi.elevi.size() - 1);

    }

    public static void Aut(){
        System.out.println("\n");
        System.out.println("Introdu email si parola pentru a te conecta: ");

        Scanner in = new Scanner(System.in);
        String email = in.nextLine();
        String parola = in.nextLine();

        if (StudentService.cautaElev(email, parola).equals("OK")) inCont = true;
        else System.out.println(StudentService.cautaElev(email,parola));
    }
    static void Meniu() {
        if (!inCont){ //nu sunt conectat in niciun cont
            System.out.println("\n");
            System.out.println("Variante disponibile");
            System.out.println("1. Inregistreaza-te");
            System.out.println("2. Autentifica-te");
            System.out.println("3. Iesire");
            System.out.println("Introdu comanda:");

            Scanner in = new Scanner(System.in);
            int comanda = in.nextInt();
            if (comanda == 1) Inreg();
            else if (comanda == 2) Aut();
            else if (comanda == 3) return;
            else System.out.println("Comanda gresita");
        }
        else{
            System.out.println("\n");;
            System.out.println("Salut, " + loadElevi.elevCurent.getFirstName() + "! \n" + "Variante disponibile");
            System.out.println("1. Cumpara o lectie");
            System.out.println("2. Setari cont");
            System.out.println("3. Iesire");
            System.out.println("Introdu comanda:");

            Scanner in = new Scanner(System.in);
            int comanda = in.nextInt();
            if (comanda == 1) System.out.println("Lectie cumparata!");
            else if (comanda == 2) inCont = false;
            else if (comanda == 3) return;
            else System.out.println("Comanda gresita");
        }
        Meniu();
    }
    public static void main(String[] args) {
        loadTeachers.load();
        loadCursuri.load();

        Ecran1();
        Meniu();
    }
}