public class EjerciciosRecursivos {
    public static int sumarDigitos(int numero){
        if (numero == 0){
            return 0;
        } else{
            int ultimoDigito = numero % 10;
            int resto = numero / 10;
            return ultimoDigito + sumarDigitos(resto);
        }
    }
    public static int potencia(int numero, int potencia){
        if(potencia == 0){
            return 1;
        }else if(potencia == 1){
            return numero;
        } else{
            return numero * potencia(numero, potencia-1);
        }
    }
    public static String invertirCadena(String cadena){
        if(cadena.length() == 0 || cadena.length() == 1){
            return cadena;
        }else{
            int ultimaPosicion = (cadena.length() - 1);
            String ultimoElemento = cadena.substring(ultimaPosicion);
            // System.out.println("La última letra es: " + ultimoElemento);
            String resto = cadena.substring(0,ultimaPosicion);
            // System.out.println("El resto es: " + resto);
            return ultimoElemento + invertirCadena(resto);
        }
    }
    public static int mcd(int a, int b){
        if(a==1 || b == 1){
            return 1;
        }
        else if(a == b){
            return a;
        }
        else if(a > b){
            return mcd(a-1,b);
        }
        else{
            return mcd(a,b-1);
        }
    }
    public static int sumarArray(int[] array, int indice){
        if(indice >= array.length){
            return 0;
        }else{
            return array[indice] + sumarArray(array, indice+1);
        }
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
