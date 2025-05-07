package Actividad2;
import Actividad1.ExceptionIsEmpty; // Importamos la excepción desde actividad1

// Esta es una interfaz genérica para una cola (queue)
// Declara las operaciones básicas de una cola
public interface Queue<E> {
    void enqueue(E x);                   // Inserta un elemento al final de la cola
    E dequeue() throws ExceptionIsEmpty; // Elimina y devuelve el frente de la cola
    E front() throws ExceptionIsEmpty;   // Devuelve el elemento del frente sin quitarlo
    E back() throws ExceptionIsEmpty;    // Devuelve el último elemento sin quitarlo
    boolean isEmpty();                   // Indica si la cola está vacía
}