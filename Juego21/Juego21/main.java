
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main (String[] args){  
        //Creo el naipe
        Naipe naipe = new Naipe();
        
        //Creo los jugadores
        Jugador jugador = new Jugador();
        Jugador casa = new Jugador();
        
        //Lo barajo aleatoriamente
        naipe.barajar();
        int contador = 0;
        while (contador <= 7){
            jugador.mostrarMano();
            Carta cartaAEntregar = naipe.entregarCarta();
            jugador.pedirCarta(cartaAEntregar);
            System.out.println("La última carta del naipe es: " + naipe.getUltimaCarta());
            contador += 1;
        }
    }
}
