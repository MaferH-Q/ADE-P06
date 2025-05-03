package Actividad1;

// Esta clase implementa una pila usando un arreglo genérico
// Al implementar Stack<E>, estamos obligados a escribir todos sus métodos
class StackArray<E> implements Stack<E> {
    private E[] array;   // Aquí guardaremos los elementos de la pila
    private int tope;    // Índice del último elemento (el que está en la cima)
    @SuppressWarnings("unchecked")// PONGO ESTO PARA ava no puede crear E[] directamente, así que usamos Object[] y lo convertimos 
    

    // Constructor que recibe el tamaño máximo de la pila
    public StackArray(int n){
        this.array = (E[]) new Object[n]; // Creamos el arreglo
        tope = -1; // Inicia vacío
    }

    // Agrega un elemento a la pila
    public void push(E x){
        if (isFull()) {
            System.out.println("La pila está llena. No se puede insertar.");
            return;
        }
        array[++tope] = x; // Aumentamos el tope y colocamos el elemento
    }

    // Elimina y devuelve el elemento en la cima de la pila
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía, no se puede hacer pop.");
        }
        return array[tope--]; // Devolvemos el tope y luego lo reducimos
    }

    // Devuelve el elemento en la cima sin eliminarlo
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía, no hay top.");
        }
        return array[tope];
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Verifica si la pila está llena (solo tiene sentido con arreglo)
    public boolean isFull() {
        return tope == array.length - 1;
    }

    // Devuelve el contenido de la pila de arriba hacia abajo
    public String toString(){
        if (isEmpty()) {
            return "Pila vacía";
        }

        StringBuilder sb = new StringBuilder("Contenido de la pila (top -> bottom):\n");
        for (int i = tope; i >= 0; i--) {
            sb.append("- ").append(array[i]).append("\n");
        }
        return sb.toString();
    }
}
