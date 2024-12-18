import java.util.Scanner;
/**
 * main
 * 
 * @author Alejandro Guerra Rodríguez
 * @version 20-10-2024
 */
public class main
{   
    //Para crear una tabla
    private static Tabla crearTabla(){
        Scanner input = new Scanner(System.in);
        //Solicito los datos
        System.out.println("Ancho[Máx:" + Tabla.getAnchoEstandar() + "m]: ");
        double ancho = input.nextDouble();
        System.out.println("Largo[Máx:" + Tabla.getLargoEstandar() + "m]: ");
        double largo = input.nextDouble();
        //Creo la tabla
        Tabla tabla = new Tabla(ancho, largo);
        //Acomodo su orientación
        tabla.orientar();
        //La retorno
        return tabla;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Creo mi almacén vacío
        Almacen almacen = new Almacen();
        //Esta es mi condición de salida
        boolean continuar = true;
        while (continuar){
            mostrarMenu();
            //El usuario elige una de las opciones disponibles del menú
            int decision = input.nextInt();
            //Declaro variable a utilizar posteriormente
            int indice;
            switch (decision){
                case 1:
                    System.out.println("Estado actual del almacén: ");
                    almacen.mostrarAlmacen();
                    break;
                case 2:
                    System.out.println("Ingrese los datos de la tabla que desea cortar: ");
                    Tabla tablaCliente= crearTabla();
                    //Hago el corte solo si es válido (medidas menores a las máximas)
                    boolean corteValido = almacen.corteValido(tablaCliente);
                    if(corteValido){
                        System.out.println("\nEstado de Corte: Su petición es válida y está en proceso\n");
                        //La tabla madre es la tabla que agarro del almacén para realizar los cortes y entregarlas al usuario
                        int indiceTablaMadre = almacen.indiceTablaAUtilizar(tablaCliente);
                        System.out.println("El estado actual del almacén es: ");
                        almacen.mostrarAlmacen();
                        System.out.println("-----------------------------------------");
                        System.out.println("\nVamos a realizar el corte de la tabla #" + indiceTablaMadre + " del almacén.\n");
                        almacen.cortarTabla(indiceTablaMadre, tablaCliente);
                        System.out.println("Su tabla ha sido cortado exitosamente, la información es la siguiente:");
                        tablaCliente.detalles();
                    }
                    else{
                        System.out.println("Estado de Corte: Las dimensiones ingresadas superan la dimensiones máximas");
                    }
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;
            }
        }
    }
    //Muestra las opciones disponibles
    private static void mostrarMenu(){
        System.out.println("Ingrese la opción que desea ejecutar");
        System.out.println("1. Mostrar almacén");
        System.out.println("2. Cortar tabla");
        System.out.println("3. Salir");
    }
}