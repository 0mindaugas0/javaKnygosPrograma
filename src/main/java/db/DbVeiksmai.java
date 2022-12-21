package db;

import model.Knyga;

import java.sql.*;
import java.util.ArrayList;

public class DbVeiksmai {
    public final static String DB_PAVADINIMAS = "jdbc:mysql://localhost:3306/Uzduotis?useUnicode=true&characterEncoding=UTF-8";
    public final static String DB_USER = "root";
    public final static String DB_PASSWORD = "M2n0pup4";

   public static final String KNYGOS_IDEJIMAS = "INSERT INTO Knyga (pavadinimas, puslapiu_skaicius, leidejas, ivertinimas) VALUES (?, ?, ?, ?)";
   public static final String KNYGOS_ISTRYNIMAS_ID = "DELETE FROM Knyga WHERE id = ?";
   public static final String KNYGOS_ISTRYNIMAS_PAVADINIMA = "DELETE FROM Knyga WHERE pavadinimas = ?";

   public static final String KNYGOS_REDAGAVIMAS = "UPDATE Knyga SET pavadinimas = ?, puslapiu_skaicius = ?, leidejas = ?, ivertinimas = ? WHERE id = ?";
   public static final String VISU_KYGU_ISVEDIMAS = "SELECT * FROM Knyga";

    public static Connection prisijungtiPrieDuombazes() throws SQLException {
        Connection jungtis = DriverManager.getConnection(DB_PAVADINIMAS, DB_USER, DB_PASSWORD);
        return jungtis;
    }

   public static boolean idetiKnyga(Connection jungtis, Knyga knyga) throws SQLException {
       PreparedStatement paruostukas = jungtis.prepareStatement(KNYGOS_IDEJIMAS);

       paruostukas.setString(1, knyga.getPavadinimas());
       paruostukas.setInt(2, knyga.getPuslapiu_skaicius());
       paruostukas.setString(3, knyga.getLeidejas());
       paruostukas.setDouble(4, knyga.getIvertinimas());


       boolean ats = paruostukas.execute();
       paruostukas.close();
       return ats;
   }

   public static int istrintiKnygaPagalId(Connection jungtis, int id) throws SQLException {
        PreparedStatement paruostukas = jungtis.prepareStatement(KNYGOS_ISTRYNIMAS_ID);

        paruostukas.setInt(1, id);
        int ats = paruostukas.executeUpdate();
        paruostukas.close();
        return ats;

   }

   public static int redaguotiKnyga(Connection jungtis, String pavadinimas, int puslapiuSkaicius, String leidejas, double ivertinimas, int keiciamaId) throws SQLException {
        PreparedStatement paruostukas = jungtis.prepareStatement(KNYGOS_REDAGAVIMAS);

        paruostukas.setString(1, pavadinimas);
        paruostukas.setInt(2, puslapiuSkaicius);
        paruostukas.setString(3, leidejas);
        paruostukas.setDouble(4, ivertinimas);
        paruostukas.setInt(5, keiciamaId);

        int ats = paruostukas.executeUpdate();
        paruostukas.close();
        return ats;

   }


   public static int istrintiKnygaPagalPavadinima(Connection jungtis, String pavadinimas) throws SQLException {
        PreparedStatement paruostukas = jungtis.prepareStatement(KNYGOS_ISTRYNIMAS_PAVADINIMA);

        paruostukas.setString(1, pavadinimas);
        int ats = paruostukas.executeUpdate();
        paruostukas.close();
        return  ats;
   }

   public static ArrayList<Knyga> grazintiVisasKnygas(Connection jungtis) throws SQLException {
       ArrayList<Knyga> knygos = new ArrayList<>();
        PreparedStatement paruostukas = jungtis.prepareStatement(VISU_KYGU_ISVEDIMAS);
        ResultSet rezultatas = paruostukas.executeQuery();

        while (rezultatas.next()) {
            int id = rezultatas.getInt("id");
            String pavadinimas = rezultatas.getString("pavadinimas");
            int puslapiuSkaicius = rezultatas.getInt("puslapiu_skaicius");
            String leidejas = rezultatas.getString("leidejas");
            double ivertinimas = rezultatas.getDouble("ivertinimas");

            Knyga knyga = new Knyga(id, pavadinimas, puslapiuSkaicius, leidejas, ivertinimas);
            knygos.add(knyga);
        }
        return knygos;
   }



}
