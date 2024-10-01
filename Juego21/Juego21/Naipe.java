
/**
 * Write a description of class Naipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Naipe
{
    //Un array llamado baraja con entradas de tipo "Carta"
    private Carta[] baraja;
    private String[] palos = {"Corazones", "Picas", "Diamantes", "Trebol"};
    private String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
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
        
        baraja = new Carta[52];
        int contador = 0;
        //Para recorrer cada entrada de la baraja completa
        for (String palo:palos){
            for(String valor:valores){
                System.out.println(palo);
                System.out.println(valor);
                Carta cartaEnUso = new Carta(palo,valor);
                baraja[contador] = cartaEnUso;
                System.out.println(baraja[contador]);
                contador += 1;
                System.out.println(contador);
            }
        }
    }
    
}
