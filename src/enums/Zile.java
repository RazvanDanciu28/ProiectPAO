package enums;

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
}


