package loader;
import clase.*;

import java.util.ArrayList;

public class loadElevi {
    public static Student elevCurent = new Student();
    public static ArrayList<Student> elevi = new ArrayList<>();

    public static void addElev(Student e){
        elevi.add(e);
    }
}
