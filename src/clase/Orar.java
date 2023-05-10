package clase;

import java.util.Arrays;
import enums.Zile;

public class Orar {
    public class Day{
        boolean optZece = false;
        boolean zeceDoispe = false;
        boolean doispePaispe = false;
        boolean paispeSaispe = false;
        boolean saispeOptispe = false;
        boolean optispeDouazeci = false;
    }

    private Day luni;
    private Day marti;
    private Day miercuri;
    private Day joi;
    private Day vineri;
    private Day sambata;
    private Day duminica;

    public Orar(){
        for (Day day : Arrays.asList(luni, duminica)) {
            day.optZece = false;
            day.zeceDoispe = false;
            day.doispePaispe = false;
            day.paispeSaispe = false;
            day.saispeOptispe = false;
            day.optispeDouazeci = false;
        }
    }

    public String getStatus(boolean x){
        if (!x) return "Ocupat";
        else return "Liber";
    }

    public String getStatusOra(Zile zi, int ora){
        Day day_curent = switch (zi) {
            case Luni -> this.luni;
            case Marti -> this.marti;
            case Miercuri -> this.miercuri;
            case Joi -> this.joi;
            case Vineri -> this.vineri;
            case Sambata -> this.sambata;
            default -> this.duminica;
        };

        return switch (ora) {
            case 8 -> getStatus(day_curent.optZece);
            case 10 -> getStatus(day_curent.zeceDoispe);
            case 12 -> getStatus(day_curent.doispePaispe);
            case 14 -> getStatus(day_curent.paispeSaispe);
            case 16 -> getStatus(day_curent.saispeOptispe);
            default -> getStatus(day_curent.optispeDouazeci);
        };


        //mettoda 2 daca nu merge prima
//        if (zi.toLowerCase().equals("luni")){
//            if (ora == 8) return luni.optZece;
//            else if (ora == 10) return luni.zeceDoispe;
//            else if (ora == 12) return luni.doispePaispe;
//            else if (ora == 14) return luni.paispeSaispe;
//            else if (ora == 16) return luni.saispeOptispe;
//            else return luni.optispeDouazeci;
//        }
//        else if (zi.toLowerCase().equals("Marti")){
//            if (ora == 8) return luni.optZece;
//            else if (ora == 10) return luni.zeceDoispe;
//            else if (ora == 12) return luni.doispePaispe;
//            else if (ora == 14) return luni.paispeSaispe;
//            else if (ora == 16) return luni.saispeOptispe;
//            else return luni.optispeDouazeci;
//        }
    }

    public void changeStatusOra(Zile zi, int ora){
        Day day_curent = switch (zi) {
            case Luni -> this.luni;
            case Marti -> this.marti;
            case Miercuri -> this.miercuri;
            case Joi -> this.joi;
            case Vineri -> this.vineri;
            case Sambata -> this.sambata;
            default -> this.duminica;
        };

        switch (ora) {
            case 8 -> day_curent.optZece = !day_curent.optZece;
            case 10 -> day_curent.zeceDoispe = !day_curent.zeceDoispe;
            case 12 -> day_curent.doispePaispe = !day_curent.doispePaispe;
            case 14 -> day_curent.paispeSaispe = !day_curent.paispeSaispe;
            case 16 -> day_curent.saispeOptispe = !day_curent.saispeOptispe;
            default -> day_curent.optispeDouazeci = !day_curent.optispeDouazeci;
        };

    }


}
