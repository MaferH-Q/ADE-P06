package Ejercicio2;
import Actividad2.Queue;
import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Creamos una cola de tipo String
        Queue<String> cola = new QueueArray<>(4); // capacidad fija

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        System.out.println(cola); // Imprimir contenido

        try {
            System.out.println("Front: " + cola.front()); // A
            System.out.println("Back: " + cola.back());   // C

            System.out.println("Eliminando con dequeue: " + cola.dequeue()); // A
            System.out.println("Nueva cola:");
            System.out.println(cola);

            cola.enqueue("D");
            cola.enqueue("E"); // Intento de insertar extra
            System.out.println("Cola final:");
            System.out.println(cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Otra prueba con números
        Queue<Integer> colaNumeros = new QueueArray<>(3);
        colaNumeros.enqueue(10);
        colaNumeros.enqueue(20);
        colaNumeros.enqueue(30);

        System.out.println("\nCola de números:");
        System.out.println(colaNumeros);
    }
}
