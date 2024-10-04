
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    //La mano del jugador
    private Carta[] mano;
    //La carta en ese índice está vacía. La anterior a esa no está vacía.
    private int ultimaCarta;

    //El método constructor
    public Jugador()
    {
        //Lo creo de máximo 11 cartas ya que es el la cantidad necesaria para sumar 21 con el peor juego posible.
        this.mano = new Carta[11];
        this.ultimaCarta = 0;
    }
    
    //Setters y getters
    public Carta[] getMano(){
        return this.mano;
    }
    public void setMano(Carta[] mano){
        this.mano = mano;
    }
    
    //Pde una carta y la agrega a la mano del jugador
    public void pedirCarta(Carta carta){
        this.mano[ultimaCarta] = carta;
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
    public int obtenerPuntajeTotal(){
        int puntaje = 0;
        for (int i = 0; i < this.ultimaCarta; i++){
            Carta cartaEnAnalisis = this.mano[i];
            puntaje += cartaEnAnalisis.getPuntaje();
        }
        return puntaje;
    }
}
