package Ejercicio3;
import Actividad3.PriorityQueue;
import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Creamos una cola de prioridad con 4 niveles (0 = más prioritario)
        PriorityQueue<String, Integer> cola = new PriorityQueueLinked<>(4);

        // Insertamos elementos con prioridad
        cola.enqueue("Llamar al médico", 1);
        cola.enqueue("Hacer tarea", 3);
        cola.enqueue("Estudiar para examen", 1);
        cola.enqueue("Revisar correo", 2);
        cola.enqueue("Salir a caminar", 3);

        System.out.println(cola);

        try {
            System.out.println("Elemento con más prioridad: " + cola.front());
            System.out.println("Eliminando con dequeue: " + cola.dequeue());

            System.out.println("\nCola después del dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

