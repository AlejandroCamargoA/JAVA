import java.time.*;
import java.util.ArrayList;

import java.util.List;

public class PrincipalFloreriaBD {
    private static List<List<String>> data = new ArrayList<List<String>>();
    public static void main(String[] args) {
        LocalDateTime dtm = LocalDateTime.now();

        conector c = new conector();

        new CFlor("Amapola","Dulce Fuerte","Roja",20,75, dtm,"Inactivo");
    }
}