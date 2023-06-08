package services;

import loader.*;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class MeniuService {
   public static String toRomana(String luna){
       return switch (luna.toLowerCase()){
           case "january" -> "Ianuarie";
           case "february" -> "Februarie";
           case "march" -> "Martie";
           case "april" -> "Aprilie";
           case "may" -> "Mai";
           case "june" -> "Iunie";
           case "july" -> "Iulie";
           case "august" -> "August";
           case "september" -> "Septembrie";
           case "october" -> "Octomrbie";
           case "november" -> "Noimebrie";
           case "december" -> "Decembrie";
           default -> "Decembrie";
       };
   }

    public static boolean inCont = false;
    public static void Ecran1(){
        System.out.println("Poiect PAO - Danciu Razvan");
        System.out.println("Apasa orice tasta pentru a continua");

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
    }


    public static void Lectii(){
        System.out.println("\n");
        System.out.println("Variante disponibile: ");
        System.out.println("1. Cumpara o lectie individuala");
        System.out.println("2. Inscrie-te la un curs special");
        System.out.println("3. Iesire");
        System.out.println("Introdu comanda:");

        Scanner in = new Scanner(System.in);
        int comanda = in.nextInt();
        if (comanda == 1) StudentService.LectiiNeSpec();
        else if (comanda == 2) StudentService.LectiiSpec();
        else if (comanda == 3) return;
        else System.out.println("Comanda gresita");

        Lectii();
    }

    public static void Setari(){
        System.out.println();
        System.out.println("Variante disponibile: ");
        System.out.println("1. Deconectare");
        System.out.println("2. Schimba parola");
        System.out.println("3. Adauga bani in cont");
        System.out.println("4. Iesire");
        System.out.println("Introdu comanda");

        int comanda = new Scanner(System.in).nextInt();
        if (comanda == 1){
            inCont = false;
            System.out.println("Te-ai deconecat cu succes");
            return;
        }
        else if (comanda == 2){
            try {
                StudentService.changePass();
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        else if (comanda == 3){
            try {
                StudentService.addMoney();
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        else if (comanda == 4) return;
        else System.out.println("Comanda gresita");

        Setari();
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
            if (comanda == 1){
                try{
                    StudentService.Inreg();
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
            }
            else if (comanda == 2) StudentService.Autentificare();
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
            else if (comanda == 2) Setari();
            else if (comanda == 3) return;
            else System.out.println("Comanda gresita");
        }
        Meniu();
    }
}
