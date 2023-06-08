package loader;

import clase.*;
import enums.Materii;
import enums.Zile;
import enums.tipSpecial;

import java.util.ArrayList;

public class loadCursuri {
    public static ArrayList<Curs> cursuri = new ArrayList<>();
    public static ArrayList<CursSpecial> cursuriSpeciale = new ArrayList<>();

    public static void load(){
        cursuri.add(new Curs(Materii.Informatica, 120));
        cursuri.add(new Curs(Materii.Geografie, 80));
        cursuri.add(new Curs(Materii.Biologie, 100));
        cursuri.add(new Curs(Materii.Istorie, 90));
        cursuri.add(new Curs(Materii.Chimie, 100));
        cursuri.add(new Curs(Materii.Matematica, 120));
        cursuri.add(new Curs(Materii.LimbaRomana, 100));

        //Informatica
        cursuriSpeciale.add(new CursSpecial(Materii.Informatica,
                120,
                loadTeachers.teachers.get(3),
                Zile.Luni,
                10,
                tipSpecial.Olimpiada,
                15,
                60
        ));
        loadTeachers.teachers.get(3).getOrar().setStatusRecurent(10, true, Zile.Luni);


        cursuriSpeciale.add(new CursSpecial(Materii.Informatica,
                120,
                loadTeachers.teachers.get(10),
                Zile.Marti,
                10,
                tipSpecial.Bacalaureat,
                40,
                100
        ));
        loadTeachers.teachers.get(10).getOrar().setStatusRecurent(10, true, Zile.Marti);

        cursuriSpeciale.add(new CursSpecial(Materii.Informatica,
                120,
                loadTeachers.teachers.get(10),
                Zile.Miercuri,
                10,
                tipSpecial.Admitere,
                6,
                30
        ));
        loadTeachers.teachers.get(10).getOrar().setStatusRecurent(10, true, Zile.Miercuri);

        //Matematica
        cursuriSpeciale.add(new CursSpecial(Materii.Matematica,
                120,
                loadTeachers.teachers.get(2),
                Zile.Luni,
                8,
                tipSpecial.Olimpiada,
                10,
                40
        ));
        loadTeachers.teachers.get(2).getOrar().setStatusRecurent(8, true, Zile.Luni);


        cursuriSpeciale.add(new CursSpecial(Materii.Informatica,
                120,
                loadTeachers.teachers.get(4),
                Zile.Marti,
                12,
                tipSpecial.Bacalaureat,
                40,
                100
        ));
        loadTeachers.teachers.get(4).getOrar().setStatusRecurent(12, true, Zile.Marti);

        cursuriSpeciale.add(new CursSpecial(Materii.Informatica,
                120,
                loadTeachers.teachers.get(4),
                Zile.Miercuri,
                8,
                tipSpecial.Admitere,
                6,
                30
        ));
        loadTeachers.teachers.get(4).getOrar().setStatusRecurent(8, true, Zile.Miercuri);


        //de adaugat mai multe



    }


}
