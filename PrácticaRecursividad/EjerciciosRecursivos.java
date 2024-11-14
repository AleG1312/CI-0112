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
        //Debo probar hasta la raíz de un número para comprobar si tiene divisores o si es  primo.
        return 0;
    }
    public static int sumarArray(int[] array, int indice){
        if(indice >= array.length){
            return 0;
        }else{
            return array[indice] + sumarArray(array, indice+1);
        }
    }
    public static void main(String[] args) {
        System.out.println(sumarDigitos(12345));
        System.out.println(potencia(5,0));
        System.out.println(potencia(4,1));
        System.out.println(potencia(3,4));
        System.out.println(invertirCadena("hola"));
        System.out.println(sumarArray(new int[]{1,2,3,4}, 0));
    }
}
