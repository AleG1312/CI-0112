/**
 * La clase "Robot" contiene ciertos atributos y métodos necesarios para realizar la simulación de lucha entre robots
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
    
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    public int getDefensa(){
        return this.defensa;
    }    
    
    
    //Creo el método constructor
    public Robot (String nombre, int puntosVida, int ataque, int defensa){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;
    }    

    
    //Método para realizar el ataque. Recibe (atacante, defensor)
    public static void atacar(Robot robot1, Robot robot2){
        /**
         * Se considera la defensa como un tipo de escudo. Lo que hace es que reduce un 10% el valor del ataque.
         * Después de cada ataque, la defensa se desgasta en un punto.
         */
        
        int ataque = robot1.getAtaque();
        
        if (robot2.getDefensa() > 0){
            //Disminuyo el ataque un 10%
            ataque *= 0.9;
            //Establezco el nuevo valor de la defensa
            int nuevaDefensa = robot2.getDefensa() - 1;
            robot2.setDefensa(nuevaDefensa);
        }
        
        int nuevaVida = robot2.getPuntosVida() - ataque;
        
        //Este condicional es para evitar robots con vida negativa
        if (nuevaVida < 0){
            nuevaVida = 0;
        }
        
        robot2.setPuntosVida(nuevaVida);
    }
    
    
    //Método para ver si el robot sigue vivo o no
    public boolean estaVivo(){
        if (this.puntosVida > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
