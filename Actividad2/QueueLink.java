package Actividad2;

import Actividad1.ExceptionIsEmpty; // Importamos la excepción desde actividad1

public class QueueLink<E> implements Queue<E> {
    private Node<E> first; // Primer nodo (frente de la cola)
    private Node<E> last;  // Último nodo (final de la cola)

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    // Inserta un nuevo elemento al final de la cola
    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (this.isEmpty()) {
            this.first = aux;
        } else {
            this.last.setNext(aux); // El último apunta al nuevo
        }
        this.last = aux; // El nuevo nodo siempre será el último
    }

    // Elimina y devuelve el primer elemento de la cola
    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía. No se puede hacer dequeue.");
        }
        E dato = this.first.getData();       // Guardamos el dato a retornar
        this.first = this.first.getNext();   // Avanzamos al siguiente
        if (this.first == null) {
            this.last = null; // Si ya no hay elementos, también limpiamos last
        }
        return dato;
    }

    // Devuelve el último elemento sin quitarlo
    public E back() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía. No hay back.");
        }
        return this.last.getData();
    }

    // Devuelve el primer elemento sin quitarlo
    public E front() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía. No hay front.");
        }
        return this.first.getData();
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return this.first == null;
    }

    // Muestra los elementos de la cola del frente al final
    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder("Contenido de la cola (front -> back):\n");
        Node<E> actual = this.first;
        while (actual != null) {
            sb.append("- ").append(actual.getData()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }
}