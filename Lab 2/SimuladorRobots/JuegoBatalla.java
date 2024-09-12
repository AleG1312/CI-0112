//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;

//Ingreso la librería para poder generar números aleatorios
import java.util.Random;

/**
 * La clase "JuegoBatalla" realiza la simulación de lucha entre robots.
 *
 * @author Alejandro Guerra Rodríguez
 * @version 12-09-2024
 */
public class JuegoBatalla
{   
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        int cantidadJugadores;

        System.out.println("Cuántos participantes robots desea crear (1-10)");
        cantidadJugadores = input.nextInt(); 
        
        //Para limpiar el buffer
        input.nextLine();
        
        //Para ingresar los datos de los participantes
        Robot[] jugadores = creacionJugadores(cantidadJugadores);                
        
        //Limpio la pantalla
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
        //Mostramos el estado inicial de los robots
        System.out.println("El estado inicial de los robots es:");
        VisualizarEstadoRobots(jugadores);
        System.out.println("\nListo para iniciar los enfrentamientos? (Presione cualquier tecla)");
        input.nextLine();
        
        //Caso #1: Solo se inicializa un robot 
        if (jugadores.length == 1){
            System.out.println("\n----------Fin del Juego----------"); 
            System.out.println("El robot ganador fue: " + jugadores[0].getNombre());             
        }
        
        //Caso #2: Se inicializan dos o más robots
        else if(jugadores.length > 1){
            //Array que me dice la cantidad de jugadores vivos restantes
            int[] jugadoresVivos = new int[2];
            
            //Array que me arroja la pareja [atacante,defensor]
            int[] participantesDeRonda = new int[2];
            
            //Contador para el número de ronda
            int numeroDeRonda = 0;   
        
            while (true){
                //Limpio la pantalla
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();            
                
                //Aumento el contador de la ronda
                numeroDeRonda += 1; 
                
                //Establezco los participantes (atacante, defensor) de la ronda
                participantesDeRonda = ParticipantesDeEnfrentamiento(jugadores); 
                
                //Realizo el enfrentamiento
                Enfrentamiento(participantesDeRonda, jugadores);             
                
                //Despliego los datos generales de la ronda
                System.out.println("\n----------Información de la Ronda #" + numeroDeRonda + "----------");   
                System.out.println("Atacante: " + participantesDeRonda[0]);
                System.out.println("Defensor: " + participantesDeRonda[1]);
                //Posterior al enfrentamiento, reviso la cantidad de jugadores vivos para comprobar si hay un ganador o si debemos continuar
                jugadoresVivos = Vivos(jugadores);            
                if (jugadoresVivos[0] == 1){
                    break;
                }            
                
                //Opcional: Visualizar el estado de los robots en cualquier momento de la simulación
                System.out.println("¿Desea visualizar el estado actual de los robots? (1:Sí / 2:No)");
                int visualizarEstadoActual = input.nextInt();
                if (visualizarEstadoActual == 1){
                    VisualizarEstadoRobots(jugadores); 
                    
                    //Implemento este control para continuar en el momento que el usuario haya terminado de revisar la información
                    System.out.println("\n¿Listo para continuar a la siguiente ronda? (Presione cualquier tecla)");
                    input.nextLine();  
                }           
                
                //Esto es para limpiar las entradas del buffer
                input.nextLine();   
            }
            
            //Ya en este momento, únicamente quedará un jugador vivo
            Robot ganador = jugadores[jugadoresVivos[1]];
            
            System.out.println("\n----------Fin del Juego----------"); 
            System.out.println("El robot ganador fue: " + ganador.getNombre());   
            System.out.println("¿Desea visualizar el estado final de los robots? (1:Sí / 2:No)");
            int decision = input.nextInt();
            if (decision == 1){
                VisualizarEstadoRobots(jugadores); 
            }  
        }         
        System.out.println("\nSimulación Finalizada."); 
    }
    
    
    //Método para solicitarle al usuario que ingrese los jugadores deseados
    private static Robot[] creacionJugadores(int cantidadJugadores){
        Scanner input = new Scanner(System.in);
        
        //Creo el array vacío de los jugadores
        Robot[] arregloRobots = new Robot[cantidadJugadores];
        
        for (int contador = 0; contador < arregloRobots.length; contador++){
            System.out.println("Ingrese el nombre del robot " + (contador+1));
            String nombreRobot = input.nextLine();            

            System.out.println("Ingrese la vida del robot " + (contador+1) + " (50-100)");
            int vidaRobot = input.nextInt();            
            
            System.out.println("Ingrese el ataque del robot " + (contador+1) + " (10-20)");
            int ataqueRobot = input.nextInt();             
            
            System.out.println("Ingrese la defensa del robot " + (contador+1) + " (0-10)");
            int defensaRobot = input.nextInt();  
            
            //Para limpiar el buffer
            input.nextLine();  
            
            Robot jugadorTemporal = new Robot(nombreRobot, vidaRobot, ataqueRobot, defensaRobot);
            arregloRobots[contador] = jugadorTemporal;
            }   
            
        return arregloRobots; 
    }  
    
    //Método para escoger dos robots aleatorios que se van a enfrentar
    private static int[] ParticipantesDeEnfrentamiento(Robot[] robots){
        Random random = new Random();
        int[] participantes = new int[2];
        
        //Genero de manera aleatoria el atacante. La única condición es que esté vivo
        int atacante;
        while (true){
            atacante = random.nextInt(robots.length - 0) + 0;
            if (robots[atacante].estaVivo() == true){
                    break;
                }
        }        
        participantes[0] = atacante;
        
        //Genero de manera aleatoria el defensor. Las condiciones es que no sea igual al atacante y que esté vivo
        int defensor;
        while (true){
            defensor = random.nextInt(robots.length - 0) + 0;            
            if (defensor != atacante){
                if (robots[defensor].estaVivo() == true){
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
    private static int[] Vivos (Robot[] arrayRobots){
        /**
         * Esta función me va a regresar un array de dos entradas.
         * Podemos tener los siguientes casos:
         * Caso 1: [n,0]. Hay n jugadores vivos.
         * Caso 2: [1,m]. Solo queda un jugador vivo y está en la posición m del array de robots.
         */

        int[] resultados = new int[2];
        int jugadoresVivos = 0;
        int posicionGanador = 0;
        int contador = 0;

        for (Robot robot: arrayRobots){            
            if (robot.estaVivo() == true){
                jugadoresVivos += 1;
                posicionGanador = contador;
            }
            contador += 1;
        }        
        
        if (jugadoresVivos > 1){
            contador = 0;
        }
        
        resultados[0] = jugadoresVivos;
        resultados[1] = posicionGanador;
        
        return resultados;
    }  

    
    //Despliega en forma de tabla ordenada los detalles del empleado
    private static void VisualizarEstadoRobots(Robot[] arrayRobots){
        //Imprimo el encabezado
        System.out.println("---------------------------------------------------------------");
        System.out.printf("|%-6s|%-20s|%-15s|%-10s|%-10s%n", "Robot", "Nombre", "Vida Actual", "Ataque", "Defensa");
        
        int contador = 0;

        //Imprimo las filas siguientes
        for (Robot robot: arrayRobots){
            System.out.printf("|%-6d|%-20s|%-15d|%-10d|%-10d%n", contador, robot.getNombre(), robot.getPuntosVida(), robot.getAtaque(), robot.getDefensa());
            contador += 1;
        }                        
    }    
}