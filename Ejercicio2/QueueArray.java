package Ejercicio2;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue; // usamos la misma interfaz Queue de la Actividad 2

// Esta clase implementa una cola utilizando un arreglo (estructura estática)
public class QueueArray<E> implements Queue<E> {
    private E[] array;       // Arreglo que almacena los datos
    private int first;       // Índice del primer elemento
    private int last;        // Índice del último elemento insertado
    private int size;        // Cantidad de elementos actuales en la cola
    private int capacity;    // Capacidad máxima del arreglo

    @SuppressWarnings("unchecked")
    public QueueArray(int capacidad) {
        this.array = (E[]) new Object[capacidad];
        this.capacity = capacidad;
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    // Inserta un elemento al final de la cola
    public void enqueue(E x) {
        if (size == capacity) {
            System.out.println("La cola está llena. No se puede insertar.");
            return;
        }

        // Usamos aritmética modular para avanzar circularmente
        last = (last + 1) % capacity;
        array[last] = x;
        size++;
    }

    // Elimina y devuelve el primer elemento de la cola
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía (dequeue)");
        }

        E dato = array[first];
        first = (first + 1) % capacity;
        size--;
        return dato;
    }

    // Devuelve el primer elemento sin quitarlo
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía (front)");
        }
        return array[first];
    }

    // Devuelve el último elemento insertado sin quitarlo
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía (back)");
        }
        return array[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder("Contenido de la cola (front → back):\n");
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            sb.append("- ").append(array[index]).append("\n");
        }
        return sb.toString();
    }
}
