package services;
import clase.*;
import enums.*;
import loader.*;
import services.StudentService;

import java.util.Scanner;

public class MeniuService {
    public static boolean inCont = false;
    public static void Ecran1(){
        System.out.println("Poiect PAO - Danciu Razvan");
        System.out.println("Apasa orice tasta pentru a continua");

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
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


    public static void Lectii(){
        System.out.println("\n");
        System.out.println("Variante disponibile: ");
        System.out.println("1. Cumpara o lectie individuala");
        System.out.println("2. Inscrie-te la un curs special");
        System.out.println("Introdu comanda:");

        Scanner in = new Scanner(System.in);
        int comanda = in.nextInt();
        if (comanda == 1) StudentService.LectiiNeSpec();
        else if (comanda == 2){
            //
        }
    }

    public static void Meniu() {
        if (!inCont){ //nu sunt conectat in niciun cont
            System.out.println("\n");
            System.out.println("Variante disponibile");
            System.out.println("1. Inregistreaza-te");
            System.out.println("2. Autentifica-te");
            System.out.println("3. Iesire");
            System.out.println("Introdu comanda:");

            Scanner in = new Scanner(System.in);
            int comanda = in.nextInt();
            if (comanda == 1) StudentService.Inreg();
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
            if (comanda == 1) Lectii();
            else if (comanda == 2) inCont = false;
            else if (comanda == 3) return;
            else System.out.println("Comanda gresita");
        }
        Meniu();
    }
}
