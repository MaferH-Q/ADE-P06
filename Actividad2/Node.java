package Actividad2;

// Esta clase representa un nodo genérico para una lista enlazada
public class Node<E> {
    private E data;         // El dato que guarda
    private Node<E> next;   // El siguiente nodo

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

