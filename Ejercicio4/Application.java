package Ejercicio4;
import Ejercicio1.StackLink;
import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;

public class Application {

    // Método que verifica si los símbolos están correctamente balanceados
    public static boolean symbolBalancing(String entrada) {
        Stack<Character> pila = new StackLink<>();

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            // Si es un símbolo de apertura, lo metemos a la pila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }

            // Si es un símbolo de cierre
            else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;

                try {
                    char cima = pila.pop();

                    // Verificamos que el par coincida
                    if ((c == ')' && cima != '(') ||
                        (c == ']' && cima != '[') ||
                        (c == '}' && cima != '{')) {
                        return false;
                    }
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
            }
        }

        return pila.isEmpty(); // Si al final no quedó nada, está balanceado
    }
}
