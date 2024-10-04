//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;
/**
 * Write a description of class Pruebas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pruebas
{
    public static void main(String[] args) throws IOException, InterruptedException{
        
        Scanner input = new Scanner(System.in);
        CuatroEnLinea nuevoJuego = new CuatroEnLinea();
        
        String[][] tablero = nuevoJuego.getTablero();
        
        boolean continuar = true;
        while (continuar){
            /*
            System.out.println("(Presione '7' para salir)");
            int eleccion = input.nextInt();
            
            if (eleccion == 7){
                continuar = false;
            }
            */
            
            nuevoJuego.MostrarTablero();
            
            System.out.println("Ingrese la columna para hacer su movimiento");
            int columna = input.nextInt();
            
            //Limpio la pantalla
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            nuevoJuego.HacerMovimiento(columna);
            String ganador = nuevoJuego.EsGanador1();
            String ganador2 = nuevoJuego.EsGanador2();
            String ganador3 = nuevoJuego.EsGanador3();
            nuevoJuego.CambiarJugador();   
            if (ganador3 != null){
                continuar = false;
                nuevoJuego.MostrarTablero();
                System.out.println("El ganador es: " + ganador);
            }
                    
        }
    }
}
