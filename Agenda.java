package Agenda;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Persona> personas;

    public Agenda() {
        this.personas = new ArrayList<>();
    }

    protected boolean agregarPersona(String dni, String nombre, String apellido, String calle, int altura, String ciudad) {
        Persona p = this.buscarPersona(dni);
        Domicilio d = null;
        boolean agregada = false;

        if (p == null) {
            agregada = true;
            d = this.buscarDomicilioExistente(calle, altura, ciudad);
            if (d == null) {
                personas.add(new Persona(dni, nombre, apellido, calle, altura, ciudad));
            } else {
                personas.add(new Persona(dni, nombre, apellido, d));
            }
        }
        return agregada;
    }

    private Persona buscarPersona(String dni) {
        Persona personaBuscada = null;
        int index = 0;

        while (index < personas.size() && personaBuscada == null) {
            if (personas.get(index).getDni().equals(dni)) {
                personaBuscada = personas.get(index);
            } else {
                index++;
            }
        }
        return personaBuscada;
    }

    private Domicilio buscarDomicilioExistente(String calle, int altura, String ciudad) {
        Domicilio d = null;
        int index = 0;

        while (index < personas.size() && d == null) {
            if (personas.get(index).mismoDomicilio(calle, altura, ciudad)) {
                d = personas.get(index).getDomicilio();
            } else {
                index++;
            }
        }
        return d;
    }

    protected boolean modificarDomicilio(String dni, String calle, int altura, String ciudad) {
        boolean modificado = false;
        Persona p = this.buscarPersona(dni);
        Domicilio d = null;

        if (p != null) {
            if (!p.mismoDomicilio(calle, altura, ciudad)) {
                modificado = true;
                d = this.buscarDomicilioExistente(calle, altura, ciudad);
                if (d == null) {
                    p.cambiarDomicilio(new Domicilio(calle, altura, ciudad));
                } else {
                    p.cambiarDomicilio(d);
                }
            }
        }
        return modificado;
    }

    protected boolean removerPersona(String dni) {
        boolean removida = false;
        Persona p = null;

        p = this.buscarPersona(dni);

        if (p != null) {
            personas.remove(p);
            removida = true;
        }
        return removida;
    }

    protected boolean estaVacia() {
        return personas.isEmpty();
    }

    protected void eliminarTodosElementosAMano() {
        while (!personas.isEmpty()) {
            personas.remove(0);
        }
    }

    protected Persona devolverUltimo() {
        Persona p = null;

        if (!this.estaVacia()) {
            p = personas.get(personas.size() - 1);
        }
        return p;
    }

    protected void listarPersonas() {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    protected int contarPersonas() {
        return personas.size();
    }

    protected int contarDomicilios() {
        int cant = 0;
        ArrayList<Domicilio> domicilios = new ArrayList<>();

        for (Persona p : personas) {
            if (!this.domicilioExistente(p.getDomicilio(), domicilios)) {
                domicilios.add(p.getDomicilio());
                cant++;
            }
        }
        return cant;
    }

    private boolean domicilioExistente(Domicilio d, ArrayList<Domicilio> lista) {
        boolean existe = false;
        int index = 0;

        while (index < lista.size() && !existe) {
            if (lista.get(index).mismoDomicilio(d)) {
                existe = true;
            } else {
                index++;
            }
        }
        return existe;
    }


    @Override
    public String toString() {
        return "Agenda{" +
                "personas=" + personas +
                '}';
    }
}
