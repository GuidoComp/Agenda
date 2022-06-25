package Agenda;

public class Domicilio {
    private String calle;
    private int altura;
    private String ciudad;

    public Domicilio(String calle, int altura, String ciudad) {
        this.calle = calle;
        this.altura = altura;
        this.ciudad = ciudad;
    }

    protected boolean mismoDomicilio(String calle, int altura, String ciudad) {
        return this.calle.equalsIgnoreCase(calle) && this.altura == altura && this.ciudad.equalsIgnoreCase(ciudad);
    }

    protected boolean mismoDomicilio(Domicilio d) {
        return this == d;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", altura=" + altura +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
