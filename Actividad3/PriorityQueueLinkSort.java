package Actividad3;

import Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna para almacenar dato y prioridad juntos
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return data + " (Prioridad: " + priority + ")";
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    // Inserta el elemento ordenado por prioridad (menor número = mayor prioridad)
    public void enqueue(E x, N pr) {
        EntryNode nuevo = new EntryNode(x, pr);
        Node<EntryNode> nuevoNodo = new Node<>(nuevo);

        if (isEmpty()) {
            first = last = nuevoNodo;
            return;
        }

        // Si el nuevo tiene mayor prioridad que el primero
        if (pr.compareTo(first.getData().priority) < 0) {
            nuevoNodo.setNext(first);
            first = nuevoNodo;
            return;
        }

        // Recorrer para insertar en el lugar correcto
        Node<EntryNode> actual = first;
        while (actual.getNext() != null && pr.compareTo(actual.getNext().getData().priority) >= 0) {
            actual = actual.getNext();
        }

        nuevoNodo.setNext(actual.getNext());
        actual.setNext(nuevoNodo);

        // Actualizar last si fue insertado al final
        if (nuevoNodo.getNext() == null) {
            last = nuevoNodo;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        E dato = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return dato;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La cola está vacía");
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder("Cola de prioridad (menor número = más prioridad):\n");
        Node<EntryNode> actual = first;
        while (actual != null) {
            sb.append("- ").append(actual.getData()).append("\n");
            actual = actual.getNext();
        }
        return sb.toString();
    }
}