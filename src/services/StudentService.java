package services;
import clase.*;
import enums.Materii;
import enums.Zile;
import loader.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static services.MeniuService.*;

public class StudentService {
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


    public static String cautaElev(String email, String parola){
        for (Student it: loadElevi.elevi){
            if (Objects.equals(it.getEmail(), email) && Objects.equals(it.getParola(), parola)){
                loadElevi.elevCurent = it;
                return "OK";
            }
        }

        return "Email si/sau parola gresite!";
    }

    public static void LectiiNeSpec(){
        String materie = "";
        Curs materieCurs = new Curs();
        Teacher prof = new Teacher();
        String zi = "";
        boolean ok = false;

        ///MATERIE
        ok = false;
        while (!ok){
            System.out.println("\n");
            System.out.println("Alege materie: ");
            System.out.println("1. Matematica");
            System.out.println("2. Informatica");
            System.out.println("3. Biologie");
            System.out.println("4. Limba Romana");
            System.out.println("5. Chimie");
            System.out.println("6. Istorie");
            System.out.println("7. Geografie");
            System.out.println("8. Iesire");

            System.out.println("Introdu comanda: ");
            Scanner in = new Scanner(System.in);
            int comanda = in.nextInt();
            ok = true;

            switch (comanda) {
                case 1 -> materie = Materii.Matematica.toString();
                case 2 -> materie = Materii.Informatica.toString();
                case 3 -> materie = Materii.Biologie.toString();
                case 4 -> materie = Materii.LimbaRomana.toString();
                case 5 -> materie = Materii.Chimie.toString();
                case 6 -> materie = Materii.Istorie.toString();
                case 7 -> materie = Materii.Geografie.toString();
                default -> {
                    System.out.println("Comanda gresita");
                    ok = false;
                }
            }
        }

        for (Curs it: loadCursuri.cursuri){
            if (materie.equals(it.getNumeMaterie())) materieCurs = it;
        }


        ///PROFESOR
        ok = false;
        while (!ok){
            ///ALEGE PROF
            System.out.println("\n");
            System.out.println("Alege profesor: ");
            int contor = 0;
            for (Teacher it: loadTeachers.teachers){
                if (it.getMaterie().equals(materie)){
                    contor += 1;
                    System.out.println(contor + ". " + it.getLastName() + " " + it.getFirstName());
                }
            }

            System.out.println("Introdu comanda");
            Scanner in = new Scanner(System.in);
            int comanda = in.nextInt();
            ok = true;
            if (comanda > contor){
                System.out.println("Comanda gresita");
                ok = false;
            }
            else{
                int contor2 = 0;
                for (Teacher it: loadTeachers.teachers){
                    if (it.getMaterie().equals(materie)){
                        contor2++;
                        if (contor2 == contor){
                            prof = it;
                            break;
                        }
                    }
                }
            }
        }



        ///ZI
        ok = false;
        ArrayList<String> zile = new ArrayList<>();
        zile.add("Luni");
        zile.add("Marti");
        zile.add("Miercuri");
        zile.add("Joi");
        zile.add("Vineri");
        zile.add("Sambata");
        zile.add("Duminica");
        while (!ok){
            System.out.println("\n");
            System.out.println("Alege ziua in care doresti lectia");

            int contor = 0;
            for (String it: zile){
                contor++;
                System.out.println(contor + ". " + it);
            }

            System.out.println("Introdu comanda: ");
            Scanner in  = new Scanner(System.in);
            int comanda = in.nextInt();
            if (comanda > contor){
                System.out.println("Comanda gresita");
                ok = false;
            }
            else {
                int c2 = 0;
                for (String it: zile){
                    c2++;
                    if (c2 == comanda){
                        zi = it;
                        break;
                    }
                }

                ok = false;
                System.out.println("\n");
                System.out.println("Alege interval orar: ");
                int contorOra = 0;
                for (int i = 8; i <= 20; i += 2){
                    if (prof.getOrar().getStatusOra(Zile.toZile(zi), i).equals("Liber")){
                        contorOra++;
                        System.out.println(contorOra + ". " + i);
                        ok = true;
                    }
                }
                if (!ok){
                    System.out.println("Nu exista intervale disponibile in ziua respectiva");
                    zile.remove(zi);
                }
                else{
                    System.out.println("Introdu comanda:");
                    comanda = in.nextInt();
                    if (comanda > contorOra){
                        ok = false;
                        System.out.println("Comnada gresita");
                    }
                    else{
                        int ccur = 0;
                        for (int i = 8; i <= 20; i += 2){
                            if (prof.getOrar().getStatusOra(Zile.toZile(zi), i).equals("Liber")){
                                ccur++;
                                if (ccur == comanda){
                                    prof.getOrar().changeStatusOra(Zile.toZile(zi), i);
                                    loadElevi.elevCurent.getOrar().changeStatusOra(Zile.toZile(zi), i);
                                    loadElevi.elevCurent.setBuget(loadElevi.elevCurent.getBuget()-materieCurs.getPrice());
                                }
                            }
                        }
                    }
                }
            }

        }
        System.out.println("Lectie cumparata cu succes");
    }
}
