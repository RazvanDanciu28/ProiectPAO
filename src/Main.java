import loader.*;
import enums.*;
import clase.*;
import services.StudentService;

import java.lang.ref.Reference;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import services.MeniuService;


public class Main {
    public static void main(String[] args) {
        loadTeachers.load();
        loadCursuri.load();

        MeniuService.Ecran1();
        MeniuService.Meniu();
    }
}