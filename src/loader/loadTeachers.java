package loader;

import clase.Teacher;
import enums.Materii;

import java.util.ArrayList;

public class loadTeachers {

    public static ArrayList<Teacher> teachers = new ArrayList<>();
    public static void load(){
        teachers.add(new Teacher("Ozana",
                "Atanasie",
                "0762182783",
                "atanasieozana@gmail.com",
                35,
                Materii.Biologie,
                8.57,
                16
        ));

        teachers.add(new Teacher("Vali",
                "Ivan",
                "0702087416",
                "ivanvali@gmail.com",
                28,
                Materii.Istorie,
                9.02,
                24
        ));

        teachers.add(new Teacher("Ariton",
                "Ionut",
                "0754987126",
                "ariton_i@gmail.com",
                31,
                Materii.Matematica,
                8.15,
                14
        ));

        teachers.add(new Teacher("Candale",
                "Silviu",
                "0754832167",
                "cansi_1990@gmail.com",
                33,
                Materii.Informatica,
                9.30,
                45
        ));

        teachers.add(new Teacher("Rusu",
                "Alex",
                "0758987416",
                "alexrsu@gmail.com",
                21,
                Materii.Matematica,
                7.25,
                5
        ));

        teachers.add(new Teacher("Ladislau",
                "Alexia",
                "070157698",
                "alexy_2002@gmail.com",
                21,
                Materii.LimbaRomana,
                9.95,
                19
        ));

        teachers.add(new Teacher("Gavrila",
                "Dorinel",
                "0748526117",
                "gavrila_dorinel@gmail.com",
                30,
                Materii.Geografie,
                6.20,
                16
        ));

        teachers.add(new Teacher("Antoniu",
                "Romeo",
                "0742537204",
                "romeofantastik27@gmail.com",
                27,
                Materii.Biologie,
                10,
                30
        ));

        teachers.add(new Teacher("Leonard",
                "Bogdan",
                "0755687459",
                "leodicaprio12@gmail.com",
                36,
                Materii.Chimie,
                9.2,
                10
        ));

        teachers.add(new Teacher("Mihai",
                "Amalia",
                "07548621545",
                "amyhai@gmail.com",
                28,
                Materii.LimbaRomana,
                8.77,
                15
        ));

        teachers.add(new Teacher("Petre",
                "Cecilia",
                "07585478557",
                "cicipe@yahoo.com",
                34,
                Materii.Informatica,
                9.00,
                32
        ));
    }




    public static ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public static void addTeacher(Teacher prof){
        teachers.add(prof);
    }


}
