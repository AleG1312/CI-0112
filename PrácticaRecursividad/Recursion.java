public class Recursion {

    // Ejercicio 1: Suma de Dígitos
    public static int sumarDigitos(int numero) {
        if (numero == 0) {
            return 0;
        }
        return (numero % 10) + sumarDigitos(numero / 10);
    }

    // Ejercicio 2: Potencia de un Número
    public static int potencia(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * potencia(x, n - 1);
    }

    // Ejercicio 3: Invertir una Cadena
    public static String invertirCadena(String cadena) {
        if (cadena.isEmpty()) {
            return cadena;
        }
        return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
    }

    // Ejercicio 4: Máximo Común Divisor (MCD)
    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    // Ejercicio 5: Suma de los Elementos de un Array
    public static int sumarArray(int[] array, int indice) {
        if (indice == array.length) {
            return 0;
        }
        return array[indice] + sumarArray(array, indice + 1);
    }

    public static void main(String[] args) {
        // Pruebas para cada método

        // Ejercicio 1: Suma de Dígitos
        int numero = 1231231234;
        System.out.println("Suma de dígitos de " + numero + ": " + sumarDigitos(numero));

        System.out.println(123%10);

        // Ejercicio 2: Potencia de un Número
        int base = 2;
        int exponente = 3;
        System.out.println("Potencia de " + base + " elevado a " + exponente + ": " + potencia(base, exponente));

        // Ejercicio 3: Invertir una Cadena
        String cadena = "recursividad";
        System.out.println("Cadena invertida de \"" + cadena + "\": " + invertirCadena(cadena));

        // Ejercicio 4: Máximo Común Divisor (MCD)
        int a = 48;
        int b = 18;
        System.out.println("MCD de " + a + " y " + b + ": " + mcd(a, b));

        // Ejercicio 5: Suma de los Elementos de un Array
        int[] array = {1, 2, 3, 4};
        System.out.println("Suma de los elementos del array: " + sumarArray(array, 0));
    }
}