
/**
 * Write a description of class Bola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bola
{
    private int radio;
    private int X;
    private int Y;
    private int[] paredes;
    
    //Método constructor
    public Bola(int radio, int X, int Y){
        this.radio = radio;
        this.X = X;
        this.Y = Y;
        this.paredes = new int[] {-20,20};
    }
    //Setters y getters
    public int getRadio(){
        return this.radio;
    }
    public void setRadio(int radio){
        this.radio = radio;
    }
    public int getX(){
        return this.X;
    }
    public void setX(int X){
        this.X = X;
    }
    public int getY(){
        return this.Y;
    }
    public void setY(int Y){
        this.Y = Y;
    }
    public int[] getParedes(){
        return this.paredes;
    }
    public void setParedes(int[] paredes){
        this.paredes = paredes;
    }
    //Métodos adicionales
    public void avanzar(int deltaX, int deltaY){
        int limiteHorizontalDerecho = this.X + radio;
        int limiteHorizontalIzquierdo = this.X - radio;
        this.X = (this.paredes[0] <= (limiteHorizontalIzquierdo + deltaX) && (limiteHorizontalDerecho + deltaX) <= this.paredes[1])? this.X + deltaX : reflejarHorizontal(deltaX);
        this.Y += deltaY;
    }
    public int reflejarHorizontal(int deltaX){
        int limiteHorizontalDerecho = this.X + radio;
        int limiteHorizontalIzquierdo = this.X - radio;
        int distanciaPreviaReflexion;
        int distanciaRestante;
        int nuevoX = 0;
        //Si choco con el lado derecho de la pared
        if((limiteHorizontalDerecho + deltaX) > this.paredes[1]){
            distanciaPreviaReflexion = (this.paredes[1] - limiteHorizontalDerecho);
            distanciaRestante = (deltaX - distanciaPreviaReflexion);
            nuevoX = (this.paredes[1] - distanciaRestante - radio);
        }
        else{
            //Si choco con el lado izquierdo de la pared
            if((limiteHorizontalIzquierdo + deltaX) < this.paredes[0]){
                distanciaPreviaReflexion = (limiteHorizontalIzquierdo - this.paredes[0]);
                distanciaRestante = (-deltaX - distanciaPreviaReflexion);
                nuevoX = (this.paredes[0] + distanciaRestante + radio);
            }
        }
        return nuevoX;
    }
    public int reflejarVertical(int deltaY){
        return 3;
    }
    public void mostrarPosicion(){
        System.out.println("La posición de la pelota es: " + this.X + "," + this.Y);
        System.out.println("Los límites laterales son: (-20,20)");
    }
}
