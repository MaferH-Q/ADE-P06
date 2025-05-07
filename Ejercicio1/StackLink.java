package Ejercicio1;


import Actividad1.ExceptionIsEmpty;  // Importamos la excepción
import Actividad1.Stack;             // Importamos la interfaz Stack
import Actividad2.Node;              // Reutilizamos la clase Node del laboratorio anterior

// Esta clase implementa una pila usando una lista enlazada
public class StackLink<E> implements Stack<E> {
    private Node<E> top; // Apunta al nodo de arriba (último insertado)

    public StackLink() {
        this.top = null; // Al inicio, la pila está vacía
    }

    // Agrega un elemento al tope de la pila
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);   // Creamos un nuevo nodo
        nuevo.setNext(top);              // Apuntamos el nuevo nodo al que era el tope anterior
        top = nuevo;                     // El nuevo nodo ahora es el tope
    }

    // Elimina y devuelve el tope
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía (pop)");
        }
        E dato = top.getData();          // Guardamos el dato
        top = top.getNext();             // El tope ahora es el siguiente nodo
        return dato;
    }

    // Devuelve el tope sin eliminarlo
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía (top)");
        }
        return top.getData();
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Muestra el contenido de la pila de arriba hacia abajo
    public String toString() {
        if (isEmpty()) return "Pila vacía";

        StringBuilder sb = new StringBuilder("Contenido de la pila (top → bottom):\n");
        Node<E> actual = top;
        while (actual != null) {
            sb.append("- ").append(actual.getData()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }
}
