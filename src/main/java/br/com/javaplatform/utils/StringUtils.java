package br.com.javaplatform.utils;

import java.text.Normalizer;

public class StringUtils {
    public static String unaccented(String request) {
        return Normalizer
                .normalize(request, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
    public static String dayOfWeek(String request) {
        return Normalizer
                .normalize(request, Normalizer.Form.NFD)
                .replaceAll("[Sun]", "Domingo")
                .replaceAll("[Mon]", "Segunda-feira")
                .replaceAll("[Tue]", "Terça-feira")
                .replaceAll("[Wed]", "Quarta-feira")
                .replaceAll("[Thu]", "Quinta-feira")
                .replaceAll("[Fri]", "Sexta-feira")
                .replaceAll("[Sat]", "Sábado");
    }
}
