package Actividad3;
import Actividad1.ExceptionIsEmpty;
public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinkSort<>();

        // Insertamos elementos con prioridad
        colaPrioridad.enqueue("Terminar informe", 2);
        colaPrioridad.enqueue("Estudiar para examen", 1);
        colaPrioridad.enqueue("Hacer compras", 4);
        colaPrioridad.enqueue("Descansar", 5);

        System.out.println(colaPrioridad);

        try {
            System.out.println("Elemento con más prioridad: " + colaPrioridad.front());
            System.out.println("Último elemento en cola: " + colaPrioridad.back());

            System.out.println("Eliminando elemento con dequeue: " + colaPrioridad.dequeue());
            System.out.println("\nCola después de quitar el primero:");
            System.out.println(colaPrioridad);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}