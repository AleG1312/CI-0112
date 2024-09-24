/**
 * Write a description of class Main here.
 * 
 * @author Alejandro Guerra Rodriguez
 * @version 20-09-2024
 */
public class Main
{
    public static void main(String [] args){
        int[] vectorGeneral = {2,3,7,8};
        Vector vectorInstancia = new Vector(vectorGeneral);
        
        System.out.println("Elementos iniciales");
        vectorInstancia.MostrarElementos();
        
        vectorInstancia.RandomizarElementos();
        System.out.println("Elementos Randomizados");
        vectorInstancia.MostrarElementos();
        
        vectorInstancia.OrdenamientoDeSeleccion();
        System.out.println("Elementos Ordenados");
        vectorInstancia.MostrarElementos();
    }
}
