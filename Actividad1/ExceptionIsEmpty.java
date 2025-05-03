package Actividad1;

// Esta clase define una excepción personalizada
// Se usará cuando se intente hacer pop() o top() en una pila vacía
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String mensaje) {
        super(mensaje); // Llama al constructor de la clase Exception con el mensaje
    }
}
