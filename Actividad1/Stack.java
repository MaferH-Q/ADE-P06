package Actividad1;

// Esta es una interfaz genérica para una pila (stack)
// Define qué operaciones básicas debe tener una pila
public interface Stack<E> {
    void push(E x);                    // Agrega un elemento al tope de la pila
    E pop() throws ExceptionIsEmpty;   // Elimina y devuelve el tope de la pila
    E top() throws ExceptionIsEmpty;   // Devuelve el tope sin eliminarlo
    boolean isEmpty();                // Indica si la pila está vacía
}