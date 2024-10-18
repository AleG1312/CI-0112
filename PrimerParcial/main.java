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
        //Creo mi almacén vacío
        Almacen almacen = new Almacen();
        boolean continuar = true;
        while (continuar){
            System.out.println("Para salir, ingrese una tabla vacía (0,0)");
            //Creo una tabla:
            Tabla tablaCliente = crearTablaCliente();
            //Condición de salida
            if (tablaCliente.getAncho() == 0 || tablaCliente.getLargo() == 0){
                continuar = false;
            }
            else{
                //La agrego al almacén
                almacen.agregarTabla(tablaCliente);
                //Visualizo la información:
                almacen.mostrarAlmacen();
                System.out.println("Desea ordenar el almacén?(1:Sí)");
                int decision = input.nextInt();
                if (decision == 1){
                    almacen.ordenar();
                    almacen.mostrarAlmacen();
                }
            }
        }
        System.out.println("Ingrese la posición de la tabla que desea eliminar: [0," + (almacen.getPrimeraPosicionVacia()-1) + "]");
        int posicion = input.nextInt();
        almacen.eliminarTabla(posicion);
        almacen.mostrarAlmacen();
    }
    private static Tabla crearTablaCliente(){
        Scanner input = new Scanner(System.in);
        //Solicito los datos
        System.out.println("Ingrese las dimensiones de la tabla que desea: ");
        System.out.println("Ancho: ");
        double ancho = input.nextDouble();
        System.out.println("Largo: ");
        double largo = input.nextDouble();
        //Creo la tabla
        Tabla tablaCliente = new Tabla(ancho, largo);
        //La retorno
        return tablaCliente;
    }
    /**
    private static void CambioMedidasStandar(double anchoEstandar, double largoEstandar){
        Tabla.setAnchoEstandar(anchoEstandar);
        Tabla.setLargoEstandar(largoEstandar);
    }
    **/
}