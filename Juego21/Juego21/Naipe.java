
/**
 * Write a description of class Naipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Naipe
{
    private Carta[] baraja;
    private String[] palos = {"Corazones", "Picas", "Diamantes", "Trebol"};
    
    public Naipe(){
        /**
         * Notar la manera de inicializar un array ya declarado dentro de un método. Utilizo "new + tipo[] + elementos dentro de los corchetes
         *      this.baraja = new int[]{1,2,3,4,5,6,7,8,9,10};
         * Al final no la utilicé, pero es bueno saberlo
         */
        baraja = new Carta[52];
        for (int i = 0; i < baraja.length; i++){
            String paloEnUso = palos[i/13];
            String simboloEnUso = "A";
            int valorEnUso = 1;
            
            baraja[i] = new Carta (paloEnUso, simboloEnUso, valorEnUso);
            
        }
        
    }
    
}
