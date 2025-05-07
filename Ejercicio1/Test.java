package Ejercicio1;

import Actividad1.Stack;
import Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Creamos una pila de String usando StackLink
        Stack<String> pila = new StackLink<>();

        // Insertamos datos usando el metodo push 
        pila.push("Uno");
        pila.push("Dos");
        pila.push("Tres");

        // Mostramos pila
        System.out.println(pila);

        try {
            System.out.println("Elemento en el tope: " + pila.top());
            System.out.println("Eliminando con pop: " + pila.pop());
            System.out.println("Nueva pila:");
            System.out.println(pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Creamos pila de Integer para mostrar uso con otro tipo
        Stack<Integer> numeros = new StackLink<>();
        numeros.push(100);
        numeros.push(200);
        numeros.push(300);

        System.out.println("\nPila de numeros:");
        System.out.println(numeros);
    }
}

