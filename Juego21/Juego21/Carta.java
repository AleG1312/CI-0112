
/**
 * Write a description of class Carta here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Carta
{
    private String palo;
    private String valor;
    
    //Método constructor
    public Carta(String valor, String palo){
        this.palo = palo;
        this.valor = valor;
    }
    
    //Setters y getters
    public String getPalo(){
        return this.palo;
    }
    public void setPalo(String palo){
        this.palo = palo;
    }
    public String getValor(){
        return this.valor;
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    
    //Me da el puntaje (número entero) de la carta
    public int getPuntaje(){
        switch (this.valor){
            case "A":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 5;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 10;
            case "Q":
                return 10;
            case "k":
                return 10;
            default:
                return 0;
        }
    }
}