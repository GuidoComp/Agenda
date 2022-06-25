package Agenda;

public class Test {
    public static void main(String[] args) {
        agregarPersona("45265986", "Martina", "Ramirez", "Donado", 356, "CABA");
        agregarPersona("46261526", "Juan", "Rodriguez", "Donado", 356, "CABA");
        agregarPersona("45265986", "Ramiro", "Perez", "Zapiola", 356, "CABA"); //mismo dni
        agregarPersona("12635926", "Ramiro", "Perez", "Zapiola", 4465, "CABA");
        agregarPersona("11526849", "Carlos", "Marquez", "Uruguay", 520, "CABA");
        cantidadPersonasYDomicilios();
        removerPersona("12635926"); //elimino a la persona que tiene un domicilio en Zapiola (que vive sola) (True)
        cantidadPersonasYDomicilios();
        removerPersona("12635926444"); //elimno persona inexistente (false)
        modificarDomicilio("2", "Zapiola", 4465, "CABA"); //persona inexistente (false)
        modificarDomicilio("46261526", "Donado", 356, "CABA"); //al mismo domicilio (false)
        modificarDomicilio("46261526", "Uruguay", 520, "CABA"); //Uno de los de Donado se muda con el de Uruguay
        cantidadPersonasYDomicilios();
        modificarDomicilio("45265986", "Freire", 3352, "CABA"); //El otro que vivía en Donado ahora vive en nueva direccion
        cantidadPersonasYDomicilios();
        modificarDomicilio("45265986", "Uruguay", 520, "CABA"); //todos se mudan a uruguay
        cantidadPersonasYDomicilios();
        listarPersonas();
        devolverUltimo();
        eliminarTodosElementosAMano();
    }

    public static Agenda agenda = new Agenda();

    public static void agregarPersona(String dni, String nombre, String apellido, String calle, int altura, String ciudad) {
        System.out.println("Probando agregar persona a la agenda: " + agenda.agregarPersona(dni, nombre, apellido, calle, altura, ciudad));
    }

    public static void removerPersona(String dni) {
        System.out.println("Probando remover a la persona " + dni + ": " + agenda.removerPersona(dni));
    }

    public static void cantidadPersonasYDomicilios() {
        System.out.println("Cantidad de personas: " + agenda.contarPersonas() + "\nCantidad de domicilios: " + agenda.contarDomicilios());
    }

    public static void modificarDomicilio(String dni, String calle, int altura, String ciudad) {
        System.out.println("Probando modificar domicilio de " + dni + ", a la calle " + calle + ": " + agenda.modificarDomicilio(dni, calle, altura, ciudad));
    }

    public static void listarPersonas() {
        System.out.println("Listado de personas de la agenda");
        agenda.listarPersonas();
    }

    public static void devolverUltimo() {
        System.out.println("Probando devolver última persona de la agenda:" +
                "\n" + agenda.devolverUltimo());
    }

    public static void eliminarTodosElementosAMano() {
        System.out.println("Probando eliminar todos los elementos de la agenda a mano:");
        agenda.eliminarTodosElementosAMano();
        if (agenda.estaVacia()) {
            System.out.println("Agenda vacía");
        } else {
            System.out.println("Error. La agenda no está vacía");
        }
    }
}
