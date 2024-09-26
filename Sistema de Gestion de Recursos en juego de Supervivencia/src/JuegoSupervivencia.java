import java.util.Random;
import java.util.Scanner;

// Clase principal para el juego
public class JuegoSupervivencia {
    public static void main(String[] args) {
        Comida comida = new Comida();
        Agua agua = new Agua();
        Materiales materiales = new Materiales();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int dias = 5;  // Número de días para simular el ciclo del juego

        for (int dia = 1; dia <= dias; dia++) {
            System.out.println("\n--- Día " + dia + " ---");

            // Mostrar recursos actuales
            comida.mostrarInfo();
            agua.mostrarInfo();
            materiales.mostrarInfo();

            // Menú de acciones
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Recolectar recursos");
            System.out.println("2. Usar recursos");
            System.out.println("3. Pasar al siguiente día");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Qué recurso quieres recolectar? (1.Comida, 2.Agua, 3.Materiales)");
                    int recursoRecolectar = scanner.nextInt();
                    switch (recursoRecolectar) {
                        case 1:
                            comida.agregarCantidad(10);
                            System.out.println("Recolectaste 10 unidades de comida.");
                            break;
                        case 2:
                            agua.agregarCantidad(10);
                            System.out.println("Recolectaste 10 unidades de agua.");
                            break;
                        case 3:
                            materiales.agregarCantidad(10);
                            System.out.println("Recolectaste 10 unidades de materiales.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("¿Qué recurso quieres usar? (1.Comida, 2.Agua, 3.Materiales)");
                    int recursoUsar = scanner.nextInt();
                    System.out.println("¿Cuánto deseas usar?");
                    int cantidadUsar = scanner.nextInt();
                    switch (recursoUsar) {
                        case 1:
                            comida.consumirCantidad(cantidadUsar);
                            System.out.println("Usaste " + cantidadUsar + " unidades de comida.");
                            break;
                        case 2:
                            agua.consumirCantidad(cantidadUsar);
                            System.out.println("Usaste " + cantidadUsar + " unidades de agua.");
                            break;
                        case 3:
                            materiales.consumirCantidad(cantidadUsar);
                            System.out.println("Usaste " + cantidadUsar + " unidades de materiales.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Pasas al siguiente día.");
                    break;
                default:
                    System.out.println("Opción inválida. Pasas al siguiente día.");
                    break;
            }

            // Evento aleatorio
            int eventoAleatorio = random.nextInt(100);  // Genera un número aleatorio entre 0 y 99
            if (eventoAleatorio < 20) {  // Un 20% de probabilidad de que ocurra un evento negativo
                System.out.println("¡Ocurre un evento inesperado!");
                if (eventoAleatorio < 10) {
                    // Escasez de agua
                    agua.consumirCantidad(20);
                    System.out.println("Una sequía reduce 20 unidades de agua.");
                } else {
                    // Tormenta destruye materiales
                    materiales.consumirCantidad(30);
                    System.out.println("Una tormenta destruye 30 unidades de materiales.");
                }
            } else {
                System.out.println("El día transcurre sin incidentes.");
            }
        }

        System.out.println("\n--- Fin del juego ---");
        comida.mostrarInfo();
        agua.mostrarInfo();
        materiales.mostrarInfo();
    }
}
