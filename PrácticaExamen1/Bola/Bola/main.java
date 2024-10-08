import java.util.Scanner;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args){
        /**
        Scanner input = new Scanner(System.in);
        //Pido los datos de la bola
        System.out.println("Ingrese el radio de su bola: ");
        int radio = input.nextInt();
        System.out.println("Ingrese el X inicial de su bola: ");
        int X = input.nextInt();
        System.out.println("Ingrese el Y inicial de su bola: ");
        int Y = input.nextInt();
        //Instancio la bola con el método constructor
        Bola bola = new Bola(radio, X, Y);
        
        int deltaX;
        int deltaY;
        
        boolean continuar = true;
        int eleccion;
        while (continuar){
            System.out.println("Ingrese el desplazamiento horizontal (de -20 a +20): ");
            deltaX = input.nextInt();
            System.out.println("Ingrese el desplazamiento vertical: ");
            deltaY = input.nextInt();
            bola.avanzar(deltaX, deltaY);
            bola.mostrarPosicion();
            
            System.out.println("¿Desea parar? (1.Sí)");
            eleccion = input.nextInt();
            continuar = (eleccion == 1)? false : true;
        }
        **/
        int[] array1 = {1,2,3,2,1};
        boolean condicion = ejercicio2(array1);
        System.out.println(condicion);
        ejercicio3(array1);
        
    }
    private static boolean ejercicio2(int[] array){
        boolean seCumple = true;
        int maximoSuficienteDeComparacion = array.length/2;
        //Lo leo de izquierda a derecha
        for(int i = 0; i < maximoSuficienteDeComparacion; i++){
            //Agarro el elemento array[i]
            int elemento1 = array[i];
            //Agarro su espejo
            int elemento2 = array[array.length-1-i];
            //Los comparo
            if (elemento1 != elemento2){
                seCumple = false;
                break;
            }
        }
        return seCumple;
    }
    private static void ejercicio3(int[] array){
        int sumaPares = 0;
        int multiplicacionImpares = 1;
        for(int i = 0; i < array.length; i++){
            System.out.println("El residuo de dividir " + array[i] + "por 2, es: " + array[i]%2);
            if (array[i]%2 == 0){
                sumaPares += array[i];
            }
            else{
                multiplicacionImpares *= array[i];
            }
        }
        System.out.println("La suma de pares es: " + sumaPares);
        System.out.println("La multiplicación de impares es: " + multiplicacionImpares);
    }
}