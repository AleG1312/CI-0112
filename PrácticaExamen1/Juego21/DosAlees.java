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
public class DosAlees
{
    public static void main (String[] args) throws IOException, InterruptedException{  
        Scanner input = new Scanner(System.in);
        
        //Creo el naipe
        Naipe naipe = new Naipe();
        //Lo barajo aleatoriamente
        naipe.barajar();

        //Creo los Alees
        Jugador Ale = new Jugador();
        Jugador Fio = new Jugador();

        //Reparto dos cartas a la Fio y Ale
        for(int i = 0; i < 2; i++){
            Fio.pedirCarta(naipe);
            Ale.pedirCarta(naipe);
        }

        //Juega el Ale
        boolean continuar1 = true;
        int decision1;
        while(continuar1 && Ale.getUltimaCarta() < Ale.getMano().length){
            //Limpio la pantalla
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            System.out.println("La mano de Fio es :");
            Fio.mostrarMano();
            System.out.println("Desea pedir una carta (1:Sí, 2:No)");
            decision1 = input.nextInt();
            if (decision1 == 1){
                Fio.pedirCarta(naipe);
            }
            else{
                continuar1 = false;
            }
        }
        
        //Reviso si la Fio perdió
        if (Fio.puntajeTotal() > 21){
            Fio.setEstaVivo(false);
        }

        //Juega el Ale
        boolean continuar = true;
        int decision;
        while(continuar && Ale.getUltimaCarta() < Ale.getMano().length){
            //Limpio la pantalla
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            System.out.println("La mano de Ale es :");
            Ale.mostrarMano();
            System.out.println("Desea pedir una carta (1:Sí, 2:No)");
            decision = input.nextInt();
            if (decision == 1){
                Ale.pedirCarta(naipe);
            }
            else{
                continuar = false;
            }
        }
        //Reviso si el Ale perdió
        if (Ale.puntajeTotal() > 21){
            Ale.setEstaVivo(false);
        }
        
        //Defino el ganador
        String ganador = obtenerGanador(Fio,Ale);
        
        //Limpio la pantalla
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();              
        
        System.out.println("\nResultados:");
        System.out.println("Mano Fio:");
        Fio.mostrarMano();
        System.out.println(Fio.puntajeTotal());
        System.out.println("Mano Ale:");
        Ale.mostrarMano();
        System.out.println(Ale.puntajeTotal());
        System.out.println("\nGanador:");
        System.out.println(ganador);
    }
    //Método para poder escoger un ganador
    private static String obtenerGanador(Jugador Fio, Jugador Ale){
                         //Si ambos están muertos
        String ganador = (Fio.getEstaVivo() == false && Ale.getEstaVivo() == false)? "Ambos perdieron"
                         //Si solo uno está vivo
                         : (Fio.getEstaVivo() == true ^ Ale.getEstaVivo() == true)? (Fio.getEstaVivo() == true)? "Fio":"Ale"
                             //Si ambos están vivos
                             : (Fio.puntajeTotal() > Ale.puntajeTotal())? "Fio"
                             : (Fio.puntajeTotal() < Ale.puntajeTotal())? "Ale"
                             : "Hubo un empate";
            
        return ganador;
    }
}