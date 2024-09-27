//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;
//Ingreso la librería para poder generar números aleatorios
import java.util.Random;
//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;

/**
 * Write a description of class Main here.
 * 
 * @author Alejandro Guerra Rodriguez
 * @version 20-09-2024
 */
public class Main
{
    public static void main(String [] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        
        Vector vectorInstancia;
        vectorInstancia = CreacionVector();
        
        boolean continuar = true;
        while (continuar){
            System.out.println("Vector actual:");
            vectorInstancia.MostrarElementos();
            
            System.out.println("¿Qué desea realizar con el vector?");
            System.out.println("1. Randomizar elementos");
            System.out.println("2. Ordenar elementos");
            System.out.println("3. Buscar elementos");
            System.out.println("4. Pares/Impares en elementos");
            System.out.println("5. Resta Mayor-Menor");
            System.out.println("6. Visualizar el menor y el antemenor");
            System.out.println("7. Salir");
            System.out.println("--------------------------------");
            int eleccionUsuario = input.nextInt();
            switch (eleccionUsuario){
                case 1:
                    vectorInstancia.RandomizarElementos();
                    break;
                case 2:
                    vectorInstancia.OrdenamientoDeSeleccion();
                    break;
                case 3:
                    System.out.println("\nIngrese el elemento que desea buscar: ");
                    int elementoABuscar = input.nextInt();
                    vectorInstancia.BusquedaElemento(elementoABuscar);
                    break;
                case 4:
                    vectorInstancia.ParesImpares();
                    break;
                case 5:
                    vectorInstancia.RestaMaxima();
                    break;
                case 6:
                    vectorInstancia.Pequeños();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida.");
                    break;
                
            } 
            //Limpio el buffer
            input.nextLine();
            System.out.println("Presione 'enter' para continuar");
            input.nextLine();
            
            //Limpio la pantalla
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
    
    private static Vector CreacionVector(){
        Random randomNum = new Random();

        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingrese el tamaño de su vector");
        int length = input.nextInt();
        
        int[] vectorUsuario = new int[length];
        
        for (int i = 0; i < length; i++){
            vectorUsuario[i] = randomNum.nextInt(101);
        }
        
        Vector vectorInstancia = new Vector(vectorUsuario);
              
        return vectorInstancia;
    }
}