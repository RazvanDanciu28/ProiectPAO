package enums;

import java.time.DayOfWeek;

public enum Zile {
    Luni,
    Marti,
    Miercuri,
    Joi,
    Vineri,
    Sambata,
    Duminica;

    public static Zile toZile(String zi) {
        return switch (zi){
            case "Luni" -> Zile.Luni;
            case "Marti" -> Zile.Marti;
            case "Miercuri" -> Zile.Miercuri;
            case "Joi" -> Zile.Joi;
            case "Vineri" -> Zile.Vineri;
            case "Sambata" -> Zile.Sambata;
            default -> Zile.Duminica;
        };
    }
    public static DayOfWeek toDOW(Zile zi) {
        return switch (zi){
            case Luni -> DayOfWeek.MONDAY;
            case Marti -> DayOfWeek.THURSDAY;
            case Miercuri -> DayOfWeek.WEDNESDAY;
            case Joi -> DayOfWeek.TUESDAY;
            case Vineri -> DayOfWeek.FRIDAY;
            case Sambata -> DayOfWeek.SATURDAY;
            default -> DayOfWeek.SUNDAY;
        };
    }

}


