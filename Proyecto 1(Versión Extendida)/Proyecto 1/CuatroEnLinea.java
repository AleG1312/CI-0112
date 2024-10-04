
/**
 * Write a description of class CuatroEnLinea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuatroEnLinea
{
    // instance variables - replace the example below with your own
    private String[][] tablero;
    private String jugadorActual;
    

    /**
     * Método Constructor
     */
    public CuatroEnLinea(){
        this.tablero = new String[6][7];
        this.jugadorActual = "1"; 
    }
    
    public String[][] getTablero(){
        return this.tablero;
    }

    public void HacerMovimiento(int columna){
        for (int fila = this.tablero.length-1; fila >= 0; fila --){
            if(this.tablero[0][columna] != null){
                System.out.println("No se pudo hacer el movimiento correctamente");
                CambiarJugador();
                break;
            }
            if (this.tablero[fila][columna] == null){
                this.tablero[fila][columna] = this.jugadorActual;
                break;
            }            
        }
    }
    
    public void MostrarTablero(){
        String primeraFila;
        for (String[] fila : tablero){
            primeraFila = "|";
            for(String elemento : fila){
                if (elemento == null){
                    primeraFila += " ";
                }
                else{
                    primeraFila += elemento;
                }
                primeraFila += "|";
            }
            System.out.println(primeraFila); 
        }
    }
    
        public String EsGanador1(){
        String ganador = null;
        //Comienzo a medir el tiempo en nanosegundos posterior a haber ingresado los datos
        long startTime = System.nanoTime();
        
        //Revisión de filas:
        for (int i = 5; i >= 0; i--){
            //Voy a revisar del elemento inicial de la fila, hasta el elemento máximo de revisión de la misma fila
            for(int j = 0; j <= 3; j++){
                //Defino el ganador como el primer elemento que estoy revisando en la fila
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
 
                //Para el elemento en el que estoy, reviso los cuatro elementos posteriores incluyendo en el que estoy
                for(int elemento = j; elemento <= (j+3); elemento++){
                    //El valor de comparación es uno de los 3 elementos posteriores a mi valor inicial
                    String valorDeComparacion = this.tablero[i][elemento];
                    //Si es diferente, finalizo la comparación del primero intento de  en línea de la fila
                    if (valorDeComparacion != ganador){
                        ganador = null;
                        break;
                    }                    
                }
                
                //Si encontró un ganador en la fila, devuelvo el valor, sino paso al siguiente valor de comparación de la misma fila
                if (ganador != null){
                    //Mido el tiempo posterior a haber realizado los cálculos pero previo a desplegar todos los resultados
                    long endTime = System.nanoTime();
                    //Calculo la diferencia entre el tiempo de inicio y de final
                    long duration = endTime-startTime;
                    System.out.println("El método ganador #1 duró: " + duration + " nanosegundos");
                    return ganador;
                }
            }
        }
        return ganador;        
    }
    
    public String EsGanador2(){
        String ganador = null;
        
        //Comienzo a medir el tiempo en nanosegundos posterior a haber ingresado los datos
        long startTime = System.nanoTime();
        
        //Revisión de filas:
        for (int i = 5; i >= 0; i--){
            //Voy a revisar del elemento inicial de la fila, hasta el elemento máximo de revisión de la misma fila
            for(int j = 0; j <= 3; j++){
                //Defino el ganador como el primer elemento que estoy revisando en la fila
                ganador = this.tablero[i][j];
                //Solo hago la revisión si el elemento que estoy revisando no está vacío
                if(ganador != null){
                    //Para el elemento en el que estoy, reviso los cuatro elementos posteriores incluyendo en el que estoy
                    for(int elemento = j; elemento <= (j+3); elemento++){
                        //El valor de comparación es uno de los 3 elementos posteriores a mi valor inicial
                        String valorDeComparacion = this.tablero[i][elemento];
                        //Si es diferente, finalizo la comparación del primero intento de  en línea de la fila
                        if (valorDeComparacion != ganador){
                            ganador = null;
                            break;
                        }                    
                    }
                }
                
                //Si encontró un ganador en la fila, devuelvo el valor, sino paso al siguiente valor de comparación de la misma fila
                if (ganador != null){
                    //Mido el tiempo posterior a haber realizado los cálculos pero previo a desplegar todos los resultados
                    long endTime = System.nanoTime();
                    //Calculo la diferencia entre el tiempo de inicio y de final
                    long duration = endTime-startTime;
                    System.out.println("El método ganador #2 duró: " + duration + " nanosegundos");
                    return ganador;
                }
            }
        }
        return ganador;        
    }
    
    public String EsGanador3(){
        String ganador = null;
        
        //Comienzo a medir el tiempo en nanosegundos posterior a haber ingresado los datos
        long startTime = System.nanoTime();
        
        //Revisión de filas:
        for (int i = 5; i >= 0; i--){
            //Voy a revisar del elemento inicial de la fila, hasta el elemento máximo de revisión de la misma fila
            for(int j = 0; j <= 3; j++){
                String elementoDeColumnaAnterior;
                try{
                    elementoDeColumnaAnterior = tablero[i+1][j];
                }
                catch(Exception e){
                    elementoDeColumnaAnterior = "false";
                }
                
                //Solo entro a revisión si el elemento abajo de este no está vacío
                if(elementoDeColumnaAnterior != null){

                    //Defino el ganador como el primer elemento que estoy revisando en la fila
                    ganador = this.tablero[i][j];
                    
                    //Solo hago la revisión si el elemento que estoy revisando no está vacío
                    if(ganador != null){
                        //Para el elemento en el que estoy, reviso los cuatro elementos posteriores incluyendo en el que estoy
                        for(int elemento = j; elemento <= (j+3); elemento++){
                            //El valor de comparación es uno de los 3 elementos posteriores a mi valor inicial
                            String valorDeComparacion = this.tablero[i][elemento];
                            //Si es diferente, finalizo la comparación del primero intento de  en línea de la fila
                            if (valorDeComparacion != ganador){
                                ganador = null;
                                break;
                            }                    
                        }
                    }
                    
                    //Si encontró un ganador en la fila, devuelvo el valor, sino paso al siguiente valor de comparación de la misma fila
                    if (ganador != null){
                        //Mido el tiempo posterior a haber realizado los cálculos pero previo a desplegar todos los resultados
                        long endTime = System.nanoTime();
                        //Calculo la diferencia entre el tiempo de inicio y de final
                        long duration = endTime-startTime;
                        System.out.println("El método ganador #3 duró: " + duration + " nanosegundos");
                        return ganador;
                    }
                }
            }
        }
        return ganador;        
    }
    
    public void CambiarJugador(){
        if(this.jugadorActual == "1"){
            this.jugadorActual = "2";
        }
        else{
            this.jugadorActual = "1";
        }
    }
}
