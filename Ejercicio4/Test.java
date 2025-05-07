package Ejercicio4;
public class Test {
    public static void main(String[] args) {
        String[] entradas = {
            "()()()[(())]()",
            "(((())))[]",
            "([[]][)(",
            "([{])}",
            "[",
            "[[]][[]]{{{{}}}}"
        };

        for (String entrada : entradas) {
            boolean resultado = Application.symbolBalancing(entrada);
            System.out.println("Entrada: " + entrada + " -> ¿Balanceado?: " + resultado);
        }
    }
}

