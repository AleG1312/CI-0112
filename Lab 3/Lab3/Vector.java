//Ingreso la librería para poder generar números aleatorios
import java.util.Random;

/**
 * Write a description of class Main here.
 * 
 * @author Alejandro Guerra Rodriguez
 * @version 20-09-2024
 */
public class Vector
{
    //Atributo Vector (vector de enteros)
    private int[] vectorAtributo;    
    
    //Metodo para cambiar el vector completo de mi instancia
    public void SetVector(int [] vector){
        this.vectorAtributo = vector;        
    }
    
    public int[] GetVector(){
        return this.vectorAtributo;
    }
    
    //Metodo constructor. Recibe un vector de enteros para inicializar una instancia
    public Vector(int[] vector){
        this.vectorAtributo = vector;        
    }
    
    
    //Metodo para imprimir los valores del vector
    public void MostrarElementos(){
        String salida = "[";
        for (int i = 0; i < this.vectorAtributo.length; i++){
            salida += vectorAtributo[i];  
            if(i != this.vectorAtributo.length-1){
                salida += ",";
            }
        }
        salida += "]";
        System.out.println(salida);
    }   
    
    //Metodo para randomizar cada elemento del array
    public void RandomizarElementos(){
        /**
         * 1. Creo una instancia de la clase random llamada "randomNum"
         * 2. Utilizo el metodo de la clase random "Instancia.nextInt(bound)"para generar un numero aleatorio.
         * Note que el "bound" es el limite superior de los numeros randoms que quiero generar. Van a ir entre [0,bound[
         * 3. Al utilizar ese metodo ya se me genera un numero random. Entonces trabajo con ese numero para igualarlo a cada entrada del vector.
         */
        Random randomNum = new Random();

        for (int i = 0; i < this.vectorAtributo.length; i++){
            vectorAtributo[i] = randomNum.nextInt(101);
        }
    }
    
    //Metodo para ordenar en orden creciente cada elemento del array
    public void OrdenamientoDeSeleccion(){
        //Inicializo estas variables para poder utilizarlas posteriormente.
        //Los valores de inicio son irrelevantes
        int posicionMenor = 0;
        int valorMenor = this.vectorAtributo[0];
        
        //Comienzo los loops anidados
        for (int i = 0; i < this.vectorAtributo.length; i++){
            //Al inicio del primer loop, establezco el valor menor como el valor de la posicion en la que estoy
            valorMenor = this.vectorAtributo[i];
            //La posicion menor tambien debo resetearla
            posicionMenor = i;
            
            //Inicio el segundo loop a la derecha de mi posicion actual
            for(int j = i+1; j < this.vectorAtributo.length; j++){
                //Lo comparo con todos los numeros a la derecha de este
                if(vectorAtributo[j] < valorMenor){
                    posicionMenor = j;
                    valorMenor = vectorAtributo[j];
                }
            }
            this.vectorAtributo[posicionMenor] = this.vectorAtributo[i]; 
            this.vectorAtributo[i] = valorMenor; 
        }
    }
    
    /**
     * Ejercicio #1:
     * Escriba un m´etodo de b´usqueda secuencial en su clase Array que reciba como
     * par´ametro un n´umero, luego imprima el ´ındice de dicho n´umero en el array.
     */
    
    public void BusquedaElemento(int elemento){
        int indiceDeElemento = 0;
        boolean condicionDePresencia = false;
        for (int i = 0; i < this.vectorAtributo.length; i++){
            if (this.vectorAtributo[i] == elemento){
                indiceDeElemento = i;
                condicionDePresencia = true;
            }
        }
        if (condicionDePresencia == false){
            System.out.println("\nEl elemento no se encuentra en el array.");
        }
        else{
            System.out.println("\nEl elemento: " + elemento + ", se encuentra en el indice: " + indiceDeElemento);
        }
    }
    
    /**
     * Ejercicio #2:
     * Escriba un m´etodo en su clase Array que imprima la cantidad de valores pares e
     * impares que tiene.
     */
    public void ParesImpares(){
        int cantidadPares = 0;
        int cantidadImpares = 0;
        
        for (int i = 0; i < this.vectorAtributo.length; i++){
            if (this.vectorAtributo[i]%2 == 0){
                cantidadPares += 1;
            }
            else{
                cantidadImpares +=1;
            }
        }
        System.out.println("\nCantidad de pares: " + cantidadPares);
        System.out.println("Cantidad de impares: " + cantidadImpares);
    }
    
    /**
     * Ejercicio #3:
     * Escriba un m´etodo en su clase Array que imprima la resta entre el n´umero m´as
     * grande y el m´as peque˜no del array
     */
    public void RestaMaxima (){
        
        //this.OrdenamientoDeSeleccion();
        
        int menor = this.vectorAtributo[0];
        int mayor = this.vectorAtributo[0];
        for (int i = 0; i < this.vectorAtributo.length; i++){
            if (this.vectorAtributo[i] > mayor){
                mayor = this.vectorAtributo[i];
            }
            if (this.vectorAtributo[i] < menor){
                menor = this.vectorAtributo[i];
            }            
        }
        
        int diferencia = mayor - menor;
        System.out.println("\nLa diferencia entre el numero mayor y el menor es: " + diferencia);
    }
    
    
    /**
     * Ejercicio #4:
     * Escriba un m´etodo en su clase Array que encuentre el n´umero m´as peque˜no y el
     * segundo m´as peque˜no del array
     */
    
    public void Pequeños(){
        int menor;
        int segundoMenor;
        
        if (this.vectorAtributo.length == 1){
            menor = this.vectorAtributo[0];
            segundoMenor = this.vectorAtributo[0];
        }
        
        else{
            menor = this.vectorAtributo[0];
            segundoMenor = this.vectorAtributo[1];
            
            for (int i = 0; i < this.vectorAtributo.length; i++){
            if (this.vectorAtributo[i] < menor){
                segundoMenor = menor;
                menor = this.vectorAtributo[i];
            } 
            }
        }
        
        System.out.println("\nEl menor es: " + menor);
        System.out.println("El segundo menor es: " + segundoMenor);        
    }
}