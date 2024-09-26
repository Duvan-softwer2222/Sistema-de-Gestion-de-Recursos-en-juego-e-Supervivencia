import java.util.Random;
import java.util.Scanner;

// Clase base Recurso
public abstract class Recurso {
    protected String nombre;
    protected int cantidad;

    public Recurso(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void consumirCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente " + nombre);
        }
    }

    public abstract void mostrarInfo();
}

// Clase Comida
class Comida extends Recurso {
    public static final int CANTIDAD_INICIAL = 50; // Constante

    public Comida() {
        super("Comida", CANTIDAD_INICIAL);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Recurso: " + nombre + " - Cantidad: " + cantidad);
    }
}

// Clase Agua
class Agua extends Recurso {
    public static final int CANTIDAD_INICIAL = 100; // Constante

    public Agua() {
        super("Agua", CANTIDAD_INICIAL);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Recurso: " + nombre + " - Cantidad: " + cantidad);
    }
}

// Clase Materiales
class Materiales extends Recurso {
    public static final int CANTIDAD_INICIAL = 200; // Constante

    public Materiales() {
        super("Materiales", CANTIDAD_INICIAL);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Recurso: " + nombre + " - Cantidad: " + cantidad);
    }
}

