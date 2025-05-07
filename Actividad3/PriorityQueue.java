package Actividad3;

// Interfaz genérica para una cola de prioridad
// E = tipo de dato, N = tipo de prioridad (Integer, Double, etc.)
public interface PriorityQueue<E, N> {
    void enqueue(E x, N pr);                 // Inserta un elemento con su prioridad
    E dequeue() throws Actividad1.ExceptionIsEmpty; // Elimina el más prioritario
    E front() throws Actividad1.ExceptionIsEmpty;   // Devuelve el primero sin quitarlo
    E back() throws Actividad1.ExceptionIsEmpty;    // Devuelve el último sin quitarlo
    boolean isEmpty();                       // Verifica si la cola está vacía
}
