//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;

//Ingreso la librería para poder generar números aleatorios
import java.util.Random;

/**
 * Write a description of class JuegoBatalla here.
 *
 * @author Alejandro Guerra Rodríguez
 * @version 12-09-2024
 */
public class JuegoBatalla
{   
    public static void main() throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        int cantidadJugadores;

        System.out.println("Cuántos participantes robots desea crear (2-10)");
        cantidadJugadores = input.nextInt();       
    
        
        //Para ingresar los datos de los participantes
        Robot[] jugadores = creacionJugadores(cantidadJugadores);
        
        int[] jugadoresVivos = new int[2];
        int[] participantesDeRonda = new int[2];
        int numeroDeRonda = 0;
        //iniciamos las rondas de enfrentamientos
        do{
            numeroDeRonda += 1;
            System.out.println("Vamos por la ronda: " + numeroDeRonda);
            jugadoresVivos = RevisionJugadoresVivos(jugadores);
            participantesDeRonda= ParticipantesDeEnfrentamiento(jugadores);
            System.out.println("Atacante: " + participantesDeRonda[0]);
            System.out.println("Defensor: " + participantesDeRonda[1]);
            Enfrentamiento(participantesDeRonda, jugadores);            
            VisualizarEstadoRobots(jugadores);
        }while(jugadoresVivos[0] != 1);
        VisualizarEstadoRobots(jugadores);
        System.out.println("Ya solo queda un jugador en pie");
        
    }
    
    
    //Método para solicitarle al usuario que ingrese los jugadores deseados
    private static Robot[] creacionJugadores(int cantidadJugadores){
        Scanner input = new Scanner(System.in);
        
        //Creo el array vacío de los jugadores
        Robot[] arregloRobots = new Robot[cantidadJugadores];
        
        for (int contador = 0; contador < arregloRobots.length; contador++){
            input.nextLine();
            System.out.println("Ingrese el nombre del robot " + (contador+1));
            String nombreRobot = input.nextLine();
            

            System.out.println("Ingrese la vida del robot " + (contador+1) + " (50-100)");
            int vidaRobot = input.nextInt();
            
            
            System.out.println("Ingrese el ataque del robot " + (contador+1) + " (10-20)");
            int ataqueRobot = input.nextInt(); 
            
            
            System.out.println("Ingrese la defensa del robot " + (contador+1) + " (0-10)");
            int defensaRobot = input.nextInt();      
  
            
            Robot jugadorTemporal = new Robot(nombreRobot, vidaRobot, ataqueRobot, defensaRobot);
            arregloRobots[contador] = jugadorTemporal;
            }    
        return arregloRobots; 
    }  
    
    
    //Método para escoger dos robots aleatorios que se van a enfrentar
    private static int[] ParticipantesDeEnfrentamiento(Robot[] robots){
        Random random = new Random();
        int[] participantes = new int[2];
        
        //Genero de manera aleatoria el atacante. La única condición es que su vida sea mayor a cero.
        int atacante;
        while (true){
            atacante = random.nextInt(robots.length - 0) + 0;
            if (robots[atacante].getPuntosVida() != 0){
                    break;
                }
        }        
        participantes[0] = atacante;
        
        //Genero de manera aleatoria el defensor. Las condiciones es que no sea igual al atacante y su vida sea mayor a cero.
        int defensor;
        while (true){
            defensor = random.nextInt(robots.length - 0) + 0;            
            if (defensor != atacante){
                if (robots[defensor].getPuntosVida() != 0){
                    break;
                }
            }
        }        
        participantes[1] = defensor;
        
        return participantes;  
    }    
    
    //Método para realizar el enfrentamiento entre los robots elegidos
    private static Robot[] Enfrentamiento(int[] participantes, Robot[] robots){
        int atacante = participantes[0];
        int defensor = participantes[1];
        
        //Se realiza el ataque
        Robot.atacar(robots[atacante] , robots[defensor]);
        return robots;
    }
    
    //Este método es para comprobar los jugadores restantes
    private static int[] RevisionJugadoresVivos (Robot[] robots){
        /**
         * Esta función me va a regresar un array de dos entradas.
         * Primera entrada: Jugadores Vivos
         * Segunda entrada: Posición del ganador
         * Si la primera entrada es diferente de 1, la segunda entrada se hace cero automáticamente, ya que todavía faltan rondas por ocurrir.
         * Si la primera entrada es 1, la segunda entrada indica la posición del robot ganador.
         */
        int[] resultados = new int[2];
        int jugadoresVivos = 0;
        int posicionGanador = 0;

        for (int contador = 0; contador < robots.length; contador++){
            if (robots[contador].getPuntosVida() == 0){
                jugadoresVivos += 1;
                posicionGanador = contador;
            }
        }
        
        if (jugadoresVivos != 1){
            posicionGanador = 0;
        }
        
        resultados[0] = jugadoresVivos;
        resultados[1] = posicionGanador;
        
        return resultados;
    }
    
    private static void VisualizarEstadoRobots(Robot[] robots){
        for (int contador = 0; contador < robots.length; contador ++){
            System.out.println("\n----------Robot " + contador + "----------");
            System.out.println("Vida: " + robots[contador].getPuntosVida());
            System.out.println("Ataque: " + robots[contador].getAtaque());
            System.out.println("Defensa: " + robots[contador].getDefensa());
        }
    }
}
