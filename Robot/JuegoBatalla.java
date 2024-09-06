import java.util.Scanner;
/**
 * Write a description of class JuegoBatalla here.
 *
 * @author Alejandro Guerra Rodríguez
 * @version 12-09-2024
 */
public class JuegoBatalla
{   
    public static void main(){
        //Scanner input = new Scanner(System.in);
        
        //Creo el array vacíos de los jugadores
        Robot[] arregloRobots = new Robot[10];
        
        //Este ciclo es para ingresar los robots participantes
        creacionJugadores(arregloRobots);
    }
    
    
    //Método para solicitarle al usuario que ingrese los jugadores deseados
    private static Robot[] creacionJugadores(Robot[] robots){
        Scanner input = new Scanner(System.in);
        Robot[] jugadoresFinales = new Robot[robots.length];
        
        System.out.println("Cuántos robots desea crear");
        int cantidadJugadores = input.nextInt();
        
        for (int contador = 1; contador <= cantidadJugadores; contador++){
            System.out.println("Ingrese el nombre del robot " + contador);
            String nombreRobot = input.nextLine();
            
            /**
            System.out.println("Ingrese la vida del robot " + contador);
            int vidaRobot = input.nextInt();
            
            
            System.out.println("Ingrese el ataque del robot " + contador);
            int ataqueRobot = input.nextInt();           
  
            
            Robot jugadorTemporal = new Robot(nombreRobot, vidaRobot, ataqueRobot);
            robots[contador] = jugadorTemporal;
            **/
            }    
        return jugadoresFinales; 
    }   
}
