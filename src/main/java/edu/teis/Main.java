package edu.teis;

import edu.teis.model.Accidente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
                    .toList();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accidentes en los que están implicados alcohol o drogas.
        System.out.println();
        System.out.println("Accidentes en los que están implicados alcohol o drogas");
        List<Accidente>accidentesDrogas = accidentes.stream()
                .filter(accidente -> accidente.positivaAlcohol().equals("S") || accidente.positivaDroga().equals("1"))
                .toList();
        accidentesDrogas.forEach(System.out::println);

        System.out.println("Cantidad de accidentes con alcohol o drogas : " + accidentesDrogas.size());


        // Número de accidentes agrupados por sexos.
        System.out.println();
        System.out.println("Accidentes agrupados por sexos");
        long accidentesHombres = accidentes.stream()
                .filter(accidente -> accidente.sexo().equals("Hombre"))
                .count();
        long accidentesMujeres = accidentes.stream()
                .filter(accidente -> accidente.sexo().equals("Mujer"))
                .count();
        long accidentesSexoDesconocido = accidentes.stream()
                .filter(accidente -> accidente.sexo().equals("Desconocido"))
                .count();

        System.out.println("Hombres: " + accidentesHombres + "\tMujeres: " + accidentesMujeres + "\tDesconocido: " + accidentesSexoDesconocido);


        // Número de accidentes agrupados por meses.
        System.out.println();
        System.out.println("Accidentes agrupados por meses");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Map<Month, Long> accidentesPorMes = accidentes.stream()
                .collect(Collectors
                        .groupingBy(accidente -> LocalDate.parse(accidente.fecha(), formatter).getMonth()
                                ,() -> new TreeMap<Month, Long>(Comparator.naturalOrder())
                                ,Collectors.counting()));

        accidentesPorMes.forEach((mes, total) ->
                System.out.println(mes + ": " + total + " accidentes"));


        // Accidentes donde haya habido atropellos a personas.
        System.out.println();
        System.out.println("Accidentes donde haya habido atropellos a personas");
        List<Accidente>accidentesAtropellos = accidentes.stream()
                .filter(accidente -> accidente.tipoAccidente().equals("Atropello a persona"))
                .toList();
        accidentesAtropellos.forEach(System.out::println);

        System.out.println("Cantidad de accidentes con atropellos: " + accidentesAtropellos.size());
    }
}