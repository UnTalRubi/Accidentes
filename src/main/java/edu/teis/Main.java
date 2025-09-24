package edu.teis;

import edu.teis.model.Accidente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.teis.utils.Utils.parseIntSafe;

public class Main {
    public static void main(String[] args) {
        List<Accidente> accidentes = new ArrayList<>();

        try (Stream<String> lineas = Files.lines(Paths.get("res/2025_Accidentalidad.csv"))) {
            accidentes = lineas
                    .skip(1)
                    .map(linea -> {
                        String[] campos = linea.split(";", -1);
                        String numExpediente = campos[0];
                        String fecha = campos[1];
                        String hora = campos[2];
                        String localizacion = campos[3];
                        int numero = parseIntSafe(campos[4]);
                        int codDistrito = parseIntSafe(campos[5]);
                        String distrito = campos[6];
                        String tipoAccidente = campos[7];
                        String estadoMeteorologico = campos[8];
                        String tipoVehiculo = campos[9];
                        String tipoPersona = campos[10];
                        String rangoEdad = campos[11];
                        String sexo = campos[12];
                        String codLesividad = campos[13];
                        String lesividad = campos[14];
                        int coordenadaX = parseIntSafe(campos[15]);
                        int coordenadaY = parseIntSafe(campos[16]);
                        String positivaAlcohol = campos[17];
                        String positivaDroga = campos[18];

                        return new Accidente(numExpediente, fecha, hora, localizacion,
                                numero, codDistrito, distrito, tipoAccidente,
                                estadoMeteorologico, tipoVehiculo, tipoPersona,
                                rangoEdad, sexo, codLesividad, lesividad,
                                coordenadaX, coordenadaY, positivaAlcohol, positivaDroga);
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔎 Imprimir los 100 primeros accidentes
        accidentes.stream().limit(100).forEach(System.out::println);
    }
}