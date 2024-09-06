
/**
 * Write a description of class Robot here.
 *
 * @author Alejandro Guerra Rodríguez
 * @version 12-09-2024
 */
public class Robot
{
    //Defino los atributos
    private String nombre;      //El nombre del robot
    private int puntosVida;     //Cantidad de vida que tiene (entre 50 y 100)
    private int ataque;         //Cantidad de daño que causa (entre 10 y 20)
    private int defensa;        //Cantidad de defensa del robot(entre 0 y 10)
    
    //Defino los setters y los getters
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void setPuntosVida(int puntosVida){
        this.puntosVida = puntosVida;
    }
    public int getPuntosVida(){
        return this.puntosVida ;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public int getAtaque(){
        return this.ataque ;
    }
    
    public void SetDefensa(int defensa){
        this.defensa = defensa;
    }
    public int getDefensa(){
        return this.defensa;
    }    
    
    
    //Creo el método constructor
    public Robot (String nombre, int puntosVida, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = 0;       //La inicializo como cero pero la voy a cambiar posteriormente
    }

    
    //Método para realizar el ataque
    public void atacar(Robot robot1, Robot robot2){
        int nuevaVida = robot2.getPuntosVida() - robot1.getAtaque();
        robot2.setPuntosVida(nuevaVida);
    }
    
    //Método para ver si el robot sigue vivo o no
    public boolean estaVivo(Robot robot){
        if (robot.getPuntosVida() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
