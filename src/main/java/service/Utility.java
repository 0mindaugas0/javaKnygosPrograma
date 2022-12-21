package service;

import model.Knyga;

import java.util.ArrayList;

public class Utility {
    public static <T> void iSvestiArrayLIstKasEilute(ArrayList<T> sarasas) {
        for (T t : sarasas) {
            System.out.println(t);
        }
    }
}
