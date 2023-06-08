import loader.*;
import services.MeniuService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        loadTeachers.load();
        loadCursuri.load();
        try{
            loadElevi.load();
        }
        catch (SQLException e){
            System.out.println("problema la conectare");
            throw new RuntimeException(e);
        }

        MeniuService.Ecran1();
        MeniuService.Meniu();
    }
}