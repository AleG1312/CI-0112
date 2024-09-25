//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

/**
 * Write a description of class Main here.
 * 
 * @author Alejandro Guerra Rodriguez
 * @version 20-09-2024
 */
public class Main
{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            System.out.println("-------------------------------------------------");
            
            int[] vectorGeneral = {1,2,3,4};
            Vector vectorInstancia = new Vector(vectorGeneral);
            
            System.out.println("Elementos iniciales");
            vectorInstancia.MostrarElementos();
            
            vectorInstancia.RandomizarElementos();
            System.out.println("Elementos Randomizados");
            vectorInstancia.MostrarElementos();
            
            //vectorInstancia.OrdenamientoDeSeleccion();
            //System.out.println("Elementos Ordenados");
            //vectorInstancia.MostrarElementos();
            
            System.out.println("\nIngrese el elemento que desea buscar: ");
            int elementoABuscar = input.nextInt();
            vectorInstancia.BusquedaElemento(elementoABuscar);
            
            vectorInstancia.ParesImpares();
            
            vectorInstancia.RestaMaxima();
            
            vectorInstancia.Pequeños();
            
            
            System.out.println("Desea Continuar (1:Si, 2:No)");
            int eleccion = input.nextInt();
            if(eleccion == 2){
                continuar = false;
            }            
        }
    }
}