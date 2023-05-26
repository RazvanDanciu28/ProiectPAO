import loader.*;
import enums.*;
import clase.*;
import services.StudentService;
import java.util.Scanner;
import services.MeniuService;


public class Main {
    public static void main(String[] args) {
        loadTeachers.load();
        loadCursuri.load();

        MeniuService.Ecran1();
        MeniuService.Meniu();
    }
}