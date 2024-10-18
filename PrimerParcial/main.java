import java.util.Scanner;
/**
 * main
 * 
 * @author Alejandro Guerra Rodríguez
 * @version 20-10-2024
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
            double aE = tablaCliente.getAreaEstandar();
            System.out.println("El área estándar es de: " + aE);
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