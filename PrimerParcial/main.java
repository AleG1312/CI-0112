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
        Scanner input = new Scanner(System.in);
        
        
        
        boolean continuar = true;
        while (continuar){
            //Creo una tabla:
            Tabla tablaCliente = crearTablaCliente();
            //Visualizo la información:
            
            tablaCliente.mostrarDetalles();
            System.out.println("\nSi desea salir digite 1");
            int decision = input.nextInt();
            continuar = (decision == 1)? false:true;
        }
        
    }
    
    private static Tabla crearTablaCliente(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el ancho: ");
        double ancho = input.nextDouble();
        System.out.println("Ingrese el largo: ");
        double largo = input.nextDouble();
        Tabla tablaCliente = new Tabla(ancho, largo);
        return tablaCliente;
    }
    private static void CambioMedidasStandar(double anchoEstandar, double largoEstandar){
        Tabla.setAnchoEstandar(anchoEstandar);
        Tabla.setLargoEstandar(largoEstandar);
    }
}
