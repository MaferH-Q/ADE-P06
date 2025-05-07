package Ejercicio3;
import Actividad3.PriorityQueue;
import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;
import Actividad2.QueueLink;

// Esta clase implementa una cola de prioridad utilizando múltiples colas (una por cada prioridad)
public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {

    private Queue<E>[] arregloDeColas;  // Arreglo de colas (una por cada prioridad)
    private int nivelesPrioridad;       // Cantidad de prioridades

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int niveles) {
        this.nivelesPrioridad = niveles;
        this.arregloDeColas = new Queue[niveles]; // Creamos arreglo de colas

        for (int i = 0; i < niveles; i++) {
            arregloDeColas[i] = new QueueLink<>(); // Cada casilla contiene una cola vacía
        }
    }

    // Inserta un dato en la cola correspondiente a su prioridad
    public void enqueue(E x, Integer pr) {
        if (pr < 0 || pr >= nivelesPrioridad) {
            System.out.println("Prioridad inválida: " + pr);
            return;
        }
        arregloDeColas[pr].enqueue(x); // Enviamos el dato a la cola con esa prioridad
    }

    // Elimina y devuelve el primer dato con mayor prioridad (menor número)
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < nivelesPrioridad; i++) {
            if (!arregloDeColas[i].isEmpty()) {
                return arregloDeColas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    // Devuelve el primer dato de mayor prioridad sin eliminarlo
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < nivelesPrioridad; i++) {
            if (!arregloDeColas[i].isEmpty()) {
                return arregloDeColas[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    // Devuelve el último dato insertado de mayor prioridad sin eliminarlo
    public E back() throws ExceptionIsEmpty {
        for (int i = nivelesPrioridad - 1; i >= 0; i--) {
            if (!arregloDeColas[i].isEmpty()) {
                return arregloDeColas[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    // Verifica si todas las colas están vacías
    public boolean isEmpty() {
        for (int i = 0; i < nivelesPrioridad; i++) {
            if (!arregloDeColas[i].isEmpty()) return false;
        }
        return true;
    }

    // Muestra todas las colas, de menor a mayor prioridad
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenido de la cola de prioridad:\n");
        for (int i = 0; i < nivelesPrioridad; i++) {
            sb.append("Prioridad ").append(i).append(":\n")
              .append(arregloDeColas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
