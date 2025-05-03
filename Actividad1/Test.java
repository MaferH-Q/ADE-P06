package Actividad1;

public class Test {
    public static void main(String[] args) {
        // Creamos una pila de Strings (tareas)
        Stack<String> pilaDeTareas = new StackArray<>(5);

        // Insertamos elementos usando push
        pilaDeTareas.push("Estudiar");
        pilaDeTareas.push("Lavar");
        pilaDeTareas.push("Dormir");

        // Imprimimos el contenido
        System.out.println(pilaDeTareas); // toString() se activa automáticamente

        try {
            // Vemos el elemento en la cima
            System.out.println("Elemento en el tope: " + pilaDeTareas.top());

            // Quitamos un elemento con pop
            System.out.println("Elemento eliminado con pop: " + pilaDeTareas.pop());

            // Imprimimos la pila después del pop
            System.out.println(pilaDeTareas);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Creamos una pila de números
        Stack<Integer> pilaNumeros = new StackArray<>(3);
        pilaNumeros.push(10);
        pilaNumeros.push(20);
        pilaNumeros.push(30);

        System.out.println("\nPila de números:");
        System.out.println(pilaNumeros);
    }
}