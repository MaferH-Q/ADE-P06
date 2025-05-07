package Ejercicio1;
import Actividad1.ExceptionIsEmpty;  // Importamos la excepcion -> para lanzar errores si la pila esta vacia
import Actividad1.Stack;             // Importamos la interfaz Stack -> para implementar la interfaz con los métodos push, pop, entre otros 
import Actividad2.Node;              // Reutilizamos la clase Node del laboratorio anterior -> para crear la lista enlazada que guarda los datos

// Esta clase  generica que implementa una pila usando una lista enlazada
public class StackLink<E> implements Stack<E> {
    // Atributo clave 
    private Node<E> top; // Apunta al nodo de arriba (ultimo insertado)
    public StackLink() {
        this.top = null; // Al inicio -> la pila esta vacia
    }

    // Agrega al tope 
    // Inserta el nodo al inicio de la lista, como debe hacer una pila 
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);   // Creamos un nuevo nodo
        nuevo.setNext(top);              // Apuntamos el nuevo nodo al que era el tope anterior
        top = nuevo;                     // El nuevo nodo ahora es el tope
    }

    // Elimina y devuelve el tope
    // Elimina el primer nodo de la lista, como una pila LIFO
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila esta vacia (pop)");
        }
        E dato = top.getData();          // Guardamos el dato
        top = top.getNext();             // El tope ahora es el siguiente nodo
        return dato;
    }

    // Devuelve el tope sin eliminarlo
    // Solo devuelve el dato del nodo (top), sin modificar la estructura 
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía (top)");
        }
        return top.getData();
    }

    // Verifica si la pila esta vacia
    public boolean isEmpty() {
        return top == null;
    }

    // Muestra el contenido de la pila de arriba hacia abajo
    public String toString() {
        if (isEmpty()) return "Pila vacia";

        StringBuilder sb = new StringBuilder("Contenido de la pila (top -> bottom):\n");
        Node<E> actual = top;
        while (actual != null) {
            sb.append("- ").append(actual.getData()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }
}
