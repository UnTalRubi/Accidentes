package edu.teis.utils;

public class Utils {

    public static int parseIntSafe(String valor) {
        try {
            return Integer.parseInt(valor.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
