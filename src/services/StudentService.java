package services;

import clase.*;
import enums.Materii;
import loader.*;
import database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

import static loader.loadElevi.elevCurent;
import static loader.loadElevi.elevi;
import static services.MeniuService.*;

public interface StudentService {

    public static void Inreg() throws SQLException {
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

        if (elevi.containsKey(email))
            System.out.println("Contul exista deja");
        else {
            elevi.put(email, new Student(prenume, nume, tel, email, parola, age, buget));
            elevCurent = elevi.get(email);
            Connection conn = database.getDatabaseConnection();
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement("INSERT INTO studenti(email, parola, nume, prenume, buget, varsta, nr_tel) VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, email);
            pstmt.setString(2, parola);
            pstmt.setString(3, nume);
            pstmt.setString(4, prenume);
            pstmt.setInt(5, buget);
            pstmt.setInt(6, age);
            pstmt.setString(7, tel);
            pstmt.executeUpdate();
            inCont = true;
        }
    }

    public static void Autentificare(){
        System.out.println("\n");
        System.out.println("Introdu email si parola pentru a te conecta: ");

        Scanner in = new Scanner(System.in);
        String email = in.nextLine();
        String parola = in.nextLine();

        if (elevi.containsKey(email)){
            if (elevi.get(email).getParola().equals(parola)){
                elevCurent = elevi.get(email);
                inCont = true;
            }
            else
                System.out.println("Date invalide");
        }
        else
            System.out.println("Date invalide");
    }

    public static void LectiiNeSpec(){
        String materie = "";
        Curs materieCurs = new Curs();
        Teacher prof = new Teacher();
        String luna = "";
        int lunaInt = 0;
        String zi = "";
        int ziInt = 0;
        int ora = 0;
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

        //LUNA
        ok = false;
        while (!ok){
            System.out.println("\n");
            System.out.println("Alege luna: ");
            LocalDate data = LocalDate.now();
            int contor = 1;
            do{
                System.out.println(contor + ". " + MeniuService.toRomana(data.getMonth().toString()));
                contor++;
                data = data.plusMonths(1);
            }while(!data.getMonth().toString().toLowerCase().equals("december"));
            System.out.println("Introdu comanda: ");
            int comanda = new Scanner(System.in).nextInt();
            System.out.println(comanda);
            ok = true;
            if (comanda > contor){
                System.out.println("Comanda gresita");
                ok = false;
            }
            else{
                data = LocalDate.now();
                int contor2 = 1;
                while (contor2 < comanda){
                    contor2++;
                    data = data.plusMonths(1);
                }
                luna = MeniuService.toRomana(data.getMonth().toString());
                lunaInt = data.getMonthValue();
                //System.out.println("gata");
            }
        }

        ///ZI
        ok = false;
        while (!ok){
            System.out.println("Alege ziua: ");
            System.out.println();

            //afisare luna in stil calendar
            LocalDate data = LocalDate.of(LocalDate.now().getYear(), lunaInt, 1);
            int daysInMonth = data.getMonth().length(data.isLeapYear());
            char[] zile = {'L', 'M', 'M', 'J', 'V', 'S', 'D'};

            for (int i = 0; i < 7; i++)
                System.out.print(" " + zile[i] + " ");
            System.out.println();

            int firstDayOfWeekValue = data.getDayOfWeek().getValue();
            int dayToday = LocalDate.now().getDayOfMonth();

            for (int day = 1; day <= daysInMonth; day++){
                if (day == 1){
                    for (int i = 1; i < firstDayOfWeekValue; i++)
                        System.out.print("   ");
                }

                if (day < dayToday)
                    System.out.print("   ");
                else
                    System.out.printf("%2d ", day);

                if (data.getDayOfWeek().getValue() == 7)
                    System.out.println();

                data = data.plusDays(1);
            }

            ok = true;
            System.out.println();
            int comanda = new Scanner(System.in).nextInt();
            if (comanda > daysInMonth || comanda < dayToday){
                System.out.println("Comanda gresita");
                ok = false;
            }
            else{
                ziInt = comanda;
                zi = MeniuService.toRomana(LocalDate.of(LocalDate.now().getYear(), lunaInt, ziInt).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()).toString());
            }


        }

        //ORA
        ok = false;
        while (!ok){
            System.out.println("Alege ora: ");
            LocalDate dataAleasa = LocalDate.of(LocalDate.now().getYear(), lunaInt, ziInt);
            Map<Integer, Boolean> ore = prof.getOrar().getOreZi(dataAleasa);
            int contor = 0;
            for (int i = 8; i <= 20; i += 2){
                if (!ore.get(i)){
                    contor++;
                    System.out.println(contor + ". " + i);
                }
            }
            System.out.println("Alege comanda: ");
            int comanda = new Scanner(System.in).nextInt();
            ok = true;
            if (comanda > contor){
                System.out.println("Comanda gresita");
                ok = false;
            }
            else{
                int contor2 = 0;
                for (int i = 8; i <= 20; i += 2){
                    if (!ore.get(i)){
                        contor2++;
                    }
                    if (contor2 == contor){
                        ora = i;
                        break;
                    }
                }
            }
        }

        if (materieCurs.getPrice() > loadElevi.elevCurent.getBuget()){
            System.out.println("Buget insuficient");
        }
        else{
            prof.setDisp(LocalDate.of(LocalDate.now().getYear(), lunaInt, ziInt), ora, true);
            loadElevi.elevCurent.setDisp(LocalDate.of(LocalDate.now().getYear(), lunaInt, ziInt), ora, true);
            loadElevi.elevCurent.setBuget(loadElevi.elevCurent.getBuget() - materieCurs.getPrice());
            System.out.println("Lectie cumparata cu succes");
        }

    }


    public static void LectiiSpec(){
        boolean ok = false;
        CursSpecial materieCurs = new CursSpecial();
        String materie = "";

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


        ///tipSpecial
        ok = false;
        boolean exista = false;
        while (!ok){
            System.out.println();
            System.out.println("Alege tipul cursului special: ");
            System.out.println("1. Bacalaureat");
            System.out.println("2. Olimpiada");
            System.out.println("3. Admitere");
            System.out.println("Introdu comanda");

            ok = true;
            int comanda = new Scanner(System.in).nextInt();
            if (comanda == 1){
                for (CursSpecial curs: loadCursuri.cursuriSpeciale){
                    if (curs.getNumeMaterie().equals(materie) && curs.getTip().toLowerCase().equals("bacalaureat")){
                        materieCurs = curs;
                        exista = true;
                        break;
                    }
                }
            }
            else if (comanda == 2){
                for (CursSpecial curs: loadCursuri.cursuriSpeciale){
                    if (curs.getNumeMaterie().equals(materie) && curs.getTip().toLowerCase().equals("admitere")){
                        materieCurs = curs;
                        exista = true;
                        break;
                    }
                }
            }
            else if (comanda == 3){
                for (CursSpecial curs: loadCursuri.cursuriSpeciale){
                    if (curs.getNumeMaterie().equals(materie) && curs.getTip().toLowerCase().equals("olimpiada")){
                        materieCurs = curs;
                        exista = true;
                        break;
                    }
                }
            }
            else{
                System.out.println("Comanda gresita");
                ok = false;
            }
        }

        if (!exista){
            System.out.println("Nu te poti inscrie la curs pentru ca momentan nu este disponibil acest tip de curs pentru aceasta materie");
        }
        else if (materieCurs.getNrStudenti() == materieCurs.getNrMaximStudenti())
            System.out.println("Nu te poti inscrie la curs pentru ca numarul maxim de studenti a fost atins!");
        else if (materieCurs.getPrice() > elevCurent.getBuget())
            System.out.println("Nu te poti inscrie la curs pentru ca nu ai fonduri suficiente!");
        else if (elevCurent.getOrar().getStatusOraRecurent(materieCurs.getOra(), materieCurs.getZi()))
            System.out.println("Nu te poti inscrie la acest curs pentru ca nu ai liber in cand este cursul!");
        else{
            elevCurent.getOrar().setStatusRecurent(materieCurs.getOra(), true, materieCurs.getZi());
            elevCurent.setBuget(elevCurent.getBuget() - materieCurs.getPrice());
            materieCurs.setNrStudenti(materieCurs.getNrStudenti() + 1);
            System.out.println("Te-ai inscris la curs cu succes!");
        }

    }



    public static void changePass() throws SQLException {
        System.out.println();
        System.out.println("Introdu parola noua");
        String parola = new Scanner(System.in).nextLine();
        elevCurent.setParola(parola);

        Connection conn = database.getDatabaseConnection();
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("UPDATE studenti SET parola =? where email=?");
        pstmt.setString(1, parola);
        pstmt.setString(2, elevCurent.getEmail());
        pstmt.executeUpdate();

        System.out.println("Parola modificata cu succes!");
    }

    public static void addMoney() throws SQLException {
        System.out.println();
        System.out.println("Bugetul curent este de " + elevCurent.getBuget() + " lei");
        System.out.println("Introdu suma pe care vrei sa o adaugi: ");
        int bani = new Scanner(System.in).nextInt();
        elevCurent.setBuget(elevCurent.getBuget() + bani);

        Connection conn = database.getDatabaseConnection();
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("UPDATE studenti set buget=? where email=?");
        pstmt.setInt(1, elevCurent.getBuget());
        pstmt.setString(2, elevCurent.getEmail());
        System.out.println("Suma a fost adaugata cu succes, noul buget curent este de " + elevCurent.getBuget() + " lei");
    }
}
