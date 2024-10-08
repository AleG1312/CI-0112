
/**
 * "Jugador" crea un jugador con una mano de máximo 11 cartas. 
 * Puedo pedir cartas, mostrar mi mano y ver mi puntaje total.
 *
 * @author Alejandro Guerra Rodríguez
 * @version 05-10-2024
 */
public class Jugador
{
    //La mano del jugador
    private Carta[] mano;
    //La carta en ese índice está vacía. La anterior a esa no está vacía.
    private int ultimaCarta;
    //Condición para saber si el jugador está vivo o no
    private boolean estaVivo;

    //El método constructor
    public Jugador()
    {
        //Lo creo de máximo 11 cartas ya que es el la cantidad necesaria para sumar 21 con el peor juego posible.
        this.mano = new Carta[11];
        this.ultimaCarta = 0;
        this.estaVivo = true;
    }
    
    //Setters y getters
    public Carta[] getMano(){
        return this.mano;
    }
    public void setMano(Carta[] mano){
        this.mano = mano;
    }
    public int getUltimaCarta(){
        return this.ultimaCarta;
    }
    public void setUltimaCarta(int ultimaCarta){
        this.ultimaCarta = ultimaCarta;
    }
    public boolean getEstaVivo(){
        return this.estaVivo;
    }
    public void setEstaVivo(boolean estaVivo){
        this.estaVivo = estaVivo;
    }
    
    //Pde una carta y la agrega a la mano del jugador
    public void pedirCarta(Naipe naipe){
        //Obtengo el índice de la última carta de la baraja completa
        int indiceUltimaCarta = naipe.getUltimaCarta();
        //Obtengo la baraja completa
        Carta[] baraja = naipe.getBaraja();
        //Entrego la carta al final de la mano del jugador, la última carta del mazo
        this.mano[this.ultimaCarta] = baraja[indiceUltimaCarta];
        //Reduzco el contador de la última carta de la baraja completa. Ese índice sí tiene una carta
        naipe.setUltimaCarta(indiceUltimaCarta-1);
        //Aumento el contador de la última carta de la mano del jugador. Ese índice tiene una carta vacía
        this.ultimaCarta += 1;
        
    }
    
    //Muestra la mano del jugador
    public void mostrarMano(){
        int posicion = 1;
        for(Carta carta : this.mano){
            if (carta != null){
                System.out.println("Posición: " + posicion + ". " + carta.getValor() + "," + carta.getPalo());
                posicion += 1;
            }
        }
    }
    
    //Obtiene el puntaje total de la mano actual del jugador
    public int puntajeTotal(){
        int puntaje = 0;
        for(Carta carta:this.mano){
            if (carta != null){
                puntaje += carta.getPuntaje();
            }
        }
        return puntaje;
    }
}
