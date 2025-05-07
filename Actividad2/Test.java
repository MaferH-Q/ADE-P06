package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        Queue<String> cola = new QueueLink<>();

        // Insertamos elementos
        cola.enqueue("Arequipa");
        cola.enqueue("Cusco");
        cola.enqueue("Puno");

        // Imprimimos
        System.out.println(cola);

        try {
            System.out.println("Front: " + cola.front()); // Arequipa
            System.out.println("Back: " + cola.back());   // Puno

            System.out.println("Eliminando con dequeue: " + cola.dequeue()); // Arequipa
            System.out.println("Cola después del dequeue:");
            System.out.println(cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
