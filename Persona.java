package Agenda;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;

    public Persona(String dni, String nombre, String apellido, String calle, int altura, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = new Domicilio(calle, altura, ciudad);
    }

    public Persona(String dni, String nombre, String apellido, Domicilio domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }

    protected String getDni() {
        return dni;
    }

    protected boolean mismoDomicilio(String calle, int altura, String ciudad) {
        return domicilio.mismoDomicilio(calle, altura, ciudad);
    }

    protected Domicilio getDomicilio() {
        return domicilio;
    }

    protected void cambiarDomicilio(Domicilio d) {
        this.setDomicilio(d);
    }

    private void setDomicilio(Domicilio d) {
        this.domicilio = d;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}
