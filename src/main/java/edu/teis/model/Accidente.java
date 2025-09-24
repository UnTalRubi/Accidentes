package edu.teis.model;


public class Accidente {
    private String numExpediente;
    private String fecha;
    private String hora;
    private String localizacion;
    private int numero;
    private int codDistrito;
    private String distrito;
    private String tipoAccidente;
    private String estadoMeteorologico;
    private String tipoVehiculo;
    private String tipoPersona;
    private String rangoEdad;
    private String sexo;
    private String codLesividad;
    private String lesividad;
    private int coordenadaX;
    private int coordenadaY;
    private String positivaAlcohol;
    private String positivaDroga;

    public Accidente(String numExpediente, String fecha, String hora, String localizacion,
                     int numero, int codDistrito, String distrito, String tipoAccidente,
                     String estadoMeteorologico, String tipoVehiculo, String tipoPersona,
                     String rangoEdad, String sexo, String codLesividad, String lesividad,
                     int coordenadaX, int coordenadaY, String positivaAlcohol, String positivaDroga) {
        this.numExpediente = numExpediente;
        this.fecha = fecha;
        this.hora = hora;
        this.localizacion = localizacion;
        this.numero = numero;
        this.codDistrito = codDistrito;
        this.distrito = distrito;
        this.tipoAccidente = tipoAccidente;
        this.estadoMeteorologico = estadoMeteorologico;
        this.tipoVehiculo = tipoVehiculo;
        this.tipoPersona = tipoPersona;
        this.rangoEdad = rangoEdad;
        this.sexo = sexo;
        this.codLesividad = codLesividad;
        this.lesividad = lesividad;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.positivaAlcohol = positivaAlcohol;
        this.positivaDroga = positivaDroga;
    }

    public String getNumExpediente() {return numExpediente;}

    public String getFecha() {return fecha;}

    public String getHora() {return hora;}

    public String getLocalizacion() {return localizacion;}

    public int getNumero() {return numero;}

    public int getCodDistrito() {return codDistrito;}

    public String getDistrito() {return distrito;}

    public String getTipoAccidente() {return tipoAccidente;}

    public String getEstadoMeteorologico() {return estadoMeteorologico;}

    public String getTipoVehiculo() {return tipoVehiculo;}

    public String getTipoPersona() {return tipoPersona;}

    public String getRangoEdad() {return rangoEdad;}

    public String getSexo() {return sexo;}

    public String getCodLesividad() {return codLesividad;}

    public String getLesividad() {return lesividad;}

    public int getCoordenadaX() {return coordenadaX;}

    public int getCoordenadaY() {return coordenadaY;}

    public String getPositivaAlcohol() {return positivaAlcohol;}

    public String getPositivaDroga() {return positivaDroga;}


    @Override
    public String toString() {
        return getNumExpediente() + " | " + getFecha() + " | " + getHora() + " | "
                + getLocalizacion() + " | " + getNumero() + " | " + getCodDistrito() + " | "
                + getDistrito() + " | " + getTipoAccidente() + " | " + getEstadoMeteorologico() + " | "
                + getTipoVehiculo() + " | " + getTipoPersona() + " | " +  getRangoEdad() + " | "
                + getSexo() + " | " + getCodLesividad() + " | " + getLesividad() + " | "
                + getCoordenadaX() + " | " + getCoordenadaY() + " | " + getPositivaAlcohol() + " | " + getPositivaDroga();
    }
}
