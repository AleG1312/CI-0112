//Ingreso la librería para poder generar números aleatorios
import java.util.Random;
/**
 * "Naipe" me crea un array de objetos "Carta".
 * Además, me permite barajar y mostrar el naipe
 *
 * @author Alejandro Guerra Rodríguez
 * @version 05-10-2024
 */
public class Naipe
{
    //Un array llamado baraja con entradas de tipo "Carta"
    private Carta[] baraja;
    private String[] palos = {"Corazones", "Picas", "Diamantes", "Trebol"};
    private String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    //El índice que indica 'sí' contiene una carta
    private int ultimaCarta;
    
    //El método constructor
    public Naipe(){
        /**
         * Notar la manera de inicializar un array ya declarado dentro de un método. Utilizo "new + tipo[] + elementos dentro de los corchetes
         *      this.baraja = new int[]{1,2,3,4,5,6,7,8,9,10};
         * Al final no la utilicé, pero es bueno saberlo
         * 
         * 
         * Idea descartada:
         * String paloEnUso = palos[i/13];
         */
        
        this.baraja = new Carta[52];
        this.ultimaCarta = 51;
        int contador = 0;
        //Para recorrer cada entrada de la baraja completa
        for (String palo:palos){
            for(String valor:valores){
                Carta cartaEnUso = new Carta(valor,palo);
                this.baraja[contador] = cartaEnUso;
                contador += 1;
            }
        }
    }
    
    //Los setters y los getters
    public Carta[] getBaraja(){
        return this.baraja;
    }
    public void setBaraja(Carta[] baraja){
        this.baraja = baraja;        
    }
    public int getUltimaCarta(){
        return this.ultimaCarta;
    }
    public void setUltimaCarta(int ultimaCarta){
        this.ultimaCarta = ultimaCarta;        
    }
    
    //Baraja de manera aleatoria las cartas
    public void barajar(){
        Random randomNum = new Random();
        for (int i = 0; i <= 51; i++){
            //Guardo el valor de mi carta actual
            Carta cartaActual = baraja[i];
            //Posición random de otra carta que quiero intercambiara con mi carta actual
            int posicionDeIntercambio = randomNum.nextInt(52);
            //Reemplazo mi carta actual con la carta random
            baraja[i] = baraja[posicionDeIntercambio];
            //Reemplazo la carta random con mi carta actual
            baraja[posicionDeIntercambio] = cartaActual;
        }
    }
    
    //Me muestra la baraja completa
    public void mostrarBaraja(){
        int posicion = 1;
        for(Carta carta : baraja){
            System.out.println("Posición: " + posicion + ". " + carta.getValor() + "," + carta.getPalo());
            posicion += 1;
        }
    }
}