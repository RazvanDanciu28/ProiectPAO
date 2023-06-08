package clase;

import java.util.*;
import java.time.*;
import enums.Zile;


public class Orar {
    private Map<LocalDate, Map<Integer, Boolean>> orar;

    public Orar(){
        orar = new HashMap<>();
        LocalDate data = LocalDate.now();
        for (int i = data.getDayOfYear(); i < 365; i++){
            Map<Integer, Boolean> zi = new HashMap<>();
            for (int ora = 8; ora <= 20; ora++)
                zi.put(ora, false); //initializam cu false, adica neocupat
            orar.put(data,zi);
            data = data.plusDays(1);
        }
    }

    ///getters
    public boolean getStatusOra(LocalDate data, int ora){
        return orar.get(data).get(ora);
    }
    public boolean getStatusOraRecurent(int ora, Zile zi){
        DayOfWeek zi_dow = Zile.toDOW(zi);
        LocalDate data = LocalDate.now();
        data = data.with(zi_dow);
        if (data.isBefore(LocalDate.now()))
            data = data.plusWeeks(1);
        for (int i = data.getDayOfYear(); i < 365; i++){
            if (getStatusOra(data, ora))
                return getStatusOra(data, ora);
            data = data.plusDays(1);
        }
        return false;
    }

    public String getDayOfWeek(LocalDate data){
        return data.getDayOfWeek().toString();
    }

    public Map<Integer, Boolean> getOreZi(LocalDate data){return orar.get(data);}

    ///setters
    public void setStatus(LocalDate data, int ora, boolean status){
        orar.get(data).put(ora, status);
    }
    public void setStatusRecurent(int ora, boolean status, Zile zi){
        DayOfWeek zi_dow = Zile.toDOW(zi);
        LocalDate data = LocalDate.now();
        data = data.with(zi_dow);
        if (data.isBefore(LocalDate.now())){
            data = data.plusWeeks(1);
        }
        for (int i = data.getDayOfYear(); i < 365; i=i+7){
            orar.get(data).put(ora, status);
            data = data.plusWeeks(1);
        }
    }
}
