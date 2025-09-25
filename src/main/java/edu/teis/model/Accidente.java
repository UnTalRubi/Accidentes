package edu.teis.model;


public record Accidente(String numExpediente, String fecha, String hora, String localizacion, int numero,
                        int codDistrito, String distrito, String tipoAccidente, String estadoMeteorologico,
                        String tipoVehiculo, String tipoPersona, String rangoEdad, String sexo, String codLesividad,
                        String lesividad, int coordenadaX, int coordenadaY, String positivaAlcohol,
                        String positivaDroga) {


    @Override
    public String toString() {
        return numExpediente() + " | " + fecha() + " | " + hora() + " | "
                + tipoAccidente() + " | " + tipoVehiculo() + " | " + tipoPersona() + " | "
                + rangoEdad() + " | " + sexo() + " | " + positivaAlcohol() + " | " + positivaDroga();
    }
}
