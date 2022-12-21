package service;

import db.DbVeiksmai;
import model.Knyga;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Meniu {

    private static final Scanner skait = new Scanner(System.in);

    public static void isvestiMeniu() {
        System.out.println("Pasirinkite vieną iš Meniu variantų:");
        System.out.println("Įveskite 1, jeigu norite pridėti knygą");
        System.out.println("Įveskite 2, jeigu norite istrinti knygą");
        System.out.println("Įveskite 3, jeigu norite redaguoti knygą");
        System.out.println("Įveskite 4 jeigu norite peržiūrėti visas knygas");
    }

    public static int nuskaitytiPasirinkima() {
        int pasirinkimas = skait.nextInt();
        skait.nextLine();
        return pasirinkimas;
    }

    public static void knygosIdejimas(Connection jungtis) throws SQLException {
        System.out.println("Pasirinkote pridėti naują knygą");
        System.out.println("Įveskite knygos pavadinimą");
        String pavadinimas = skait.nextLine();
        System.out.println("Įveskite knygos puslapių skaičių");
        int puslapiuSkaicius = skait.nextInt();
        skait.nextLine();
        System.out.println("Įveskite knygos leidėją");
        String leidejas = skait.nextLine();
        System.out.println("Įveskite knygos įvertinimą");
        double ivertinimas = skait.nextDouble();
        Knyga knyga = new Knyga(pavadinimas, puslapiuSkaicius, leidejas, ivertinimas);
        System.out.println(knyga);

        DbVeiksmai.idetiKnyga(jungtis, knyga);
    }

    public static void knygosIstrynimas(Connection jungtis) throws SQLException {
        System.out.println("pasirinkote knygos ištrynimą");
        System.out.println("Įveskite 1 jeigu norite ištrinti pagal ID arba 2 - jeigu pagal pavadinimą");
        int pasirinkimas = nuskaitytiPasirinkima();
        switch (pasirinkimas) {
            case 1:
                System.out.println("Įveskite knygos ID");
                int id = nuskaitytiPasirinkima();
                DbVeiksmai.istrintiKnygaPagalId(jungtis, id);
                break;
            case 2:
                System.out.println("Įveskite knygos pavadinimą");
                String pavadinimas = skait.nextLine();
                DbVeiksmai.istrintiKnygaPagalPavadinima(jungtis, pavadinimas);
                break;
            default:
                System.out.println("Blogas pasirinkimas. Programa sustos!");
        }
    }
    public static void knygosRedagavimas(Connection jungtis) throws SQLException {
        System.out.println("Pasirinkote redakuoti Knygą, įveskite knygos ID");
        int keiciamaId = skait.nextInt();
        skait.nextLine();
        System.out.println("Įveskite naują knygos pavadinimą");
        String pavadinimas = skait.nextLine();
        System.out.println("Įveskite naują puslapių skaičių");
        int puslapiuSkaicius = skait.nextInt();
        skait.nextLine();
        System.out.println("Įveskite naują knygos leidėją");
        String leidejas = skait.nextLine();
        System.out.println("Įveskite naujos knygos įvertinimą");
        double ivertinimas = skait.nextDouble();

        DbVeiksmai.redaguotiKnyga(jungtis, pavadinimas, puslapiuSkaicius, leidejas, ivertinimas, keiciamaId);
    }

    public static void knyguIsvedimas(Connection jungtis) throws SQLException {
        System.out.println("Pasirinkote knygų išvedimą");
        ArrayList<Knyga> visosKnygos = DbVeiksmai.grazintiVisasKnygas(jungtis);
        Utility.iSvestiArrayLIstKasEilute(visosKnygos);
    }

    public static void meniuVykdymas(Connection jungtis, int pasirinkimas) throws SQLException {
        switch (pasirinkimas) {
            case 1:
                knygosIdejimas(jungtis);
                break;
            case 2:
                knygosIstrynimas(jungtis);
                break;
            case 3:
                knygosRedagavimas (jungtis);
                break;
            case 4:
                knyguIsvedimas(jungtis);
                break;
            default:
                System.out.println("Įvedėte netinkamą pasirinkimą. Programa sustos!");

        }
    }

}
