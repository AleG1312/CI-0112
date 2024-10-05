//Ingreso la librería para poder solicitarle datos al usuario
import java.util.Scanner;

//Ingreso la librería para poder limpiar la pantalla en plena ejecución
import java.io.IOException;
/**
 * "main" une las funciones de las otras clases y me permite jugar al 21
 *
 * @author Alejandro Guerra Rodríguez
 * @version 05-10-2024
 */
public class main
{
    public static void main (String[] args) throws IOException, InterruptedException{  
        Scanner input = new Scanner(System.in);
        
        //Creo el naipe
        Naipe naipe = new Naipe();
        //Lo barajo aleatoriamente
        naipe.barajar();

        //Creo los jugadores
        Jugador jugador = new Jugador();
        Jugador casa = new Jugador();

        //Reparto dos cartas a la casa y jugador
        for(int i = 0; i < 2; i++){
            casa.pedirCarta(naipe);
            jugador.pedirCarta(naipe);
        }

        //En caso de que la casa tenga un puntaje menor a 16
        while(casa.puntajeTotal() <= 16){
            casa.pedirCarta(naipe);
        }
        //Reviso si la casa perdió
        if (casa.puntajeTotal() > 21){
            casa.setEstaVivo(false);
        }

        //Juega el jugador
        boolean continuar = true;
        int decision;
        while(continuar && jugador.getUltimaCarta() < jugador.getMano().length){
            //Limpio la pantalla
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            System.out.println("Su mano es :");
            jugador.mostrarMano();
            System.out.println("Desea pedir una carta (1:Sí, 2:No)");
            decision = input.nextInt();
            if (decision == 1){
                jugador.pedirCarta(naipe);
            }
            else{
                continuar = false;
            }
        }
        //Reviso si el jugador perdió
        if (jugador.puntajeTotal() > 21){
            jugador.setEstaVivo(false);
        }
        
        //Defino el ganador
        String ganador = obtenerGanador(casa,jugador);
        
        //Limpio la pantalla
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();              
        
        System.out.println("\nResultados:");
        System.out.println("Mano casa:");
        casa.mostrarMano();
        System.out.println(casa.puntajeTotal());
        System.out.println("Mano Jugador:");
        jugador.mostrarMano();
        System.out.println(jugador.puntajeTotal());
        System.out.println("\nGanador:");
        System.out.println(ganador);
    }
    //Método para poder escoger un ganador
    private static String obtenerGanador(Jugador casa, Jugador jugador){
                         //Si ambos están muertos
        String ganador = (casa.getEstaVivo() == false && jugador.getEstaVivo() == false)? "Ambos perdieron"
                         //Si solo uno está vivo
                         : (casa.getEstaVivo() == true ^ jugador.getEstaVivo() == true)? (casa.getEstaVivo() == true)? "Casa":"Jugador"
                             //Si ambos están vivos
                             : (casa.puntajeTotal() > jugador.puntajeTotal())? "Casa"
                             : (casa.puntajeTotal() < jugador.puntajeTotal())? "Jugador"
                             : "Hubo un empate";
            
        return ganador;
    }
}