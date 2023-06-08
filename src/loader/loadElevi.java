package loader;
import clase.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import database.database;

import javax.swing.plaf.nimbus.State;

public class loadElevi {
    public static Student elevCurent = new Student();
    public static HashMap<String, Student> elevi = new HashMap<>();
    public static void load() throws SQLException {
        Connection conn = database.getDatabaseConnection();
        Statement stmt = null;
        ResultSet rs = null;

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM studenti");

        while (rs.next()){
            String email = rs.getString("email");
            String parola = rs.getString("parola");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            int buget = rs.getInt("buget");
            int varsta = rs.getInt("varsta");
            String tel = rs.getString("nr_tel");

            elevi.put(email, new Student(nume, prenume, tel, email, parola, varsta, buget));

        }
    }

    public static void addElev(Student e){
        if (elevi.containsKey(e.getEmail()))
            System.out.println("Contul exista deja");
        else
            elevi.put(e.getEmail(), e);
    }
}
