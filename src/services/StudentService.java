package services;
import clase.*;
import loader.*;

import java.util.Objects;

public class StudentService {
    public static String cautaElev(String email, String parola){
        for (Student it: loadElevi.elevi){
            if (Objects.equals(it.getEmail(), email) && Objects.equals(it.getParola(), parola)){
                loadElevi.elevCurent = it;
                return "OK";
            }
        }

        return "Email si/sau parola gresite!";
    }
}
