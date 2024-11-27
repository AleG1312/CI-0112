package Ejercicio_1;

public class Analizador {
    private int filaSecuencia;
    private int columnaSecuencia;
    private int largoSecuencia; //La cantidad de elementos que forman la secuencia

    // Constructor 
    public Analizador() {
        this.filaSecuencia = -1;
        this.columnaSecuencia = -1;
        this.largoSecuencia = 0;
    }

    // Setters y getters
    public int getFilaSecuencia() {
        return filaSecuencia;
    }
    public void setFilaSecuencia(int filaSecuencia) {
        this.filaSecuencia = filaSecuencia;
    }
    public int getColumnaSecuencia() {
        return columnaSecuencia;
    }
    public void setColumnaSecuencia(int columnaSecuencia) {
        this.columnaSecuencia = columnaSecuencia;
    }
    public int getLargoSecuencia() {
        return largoSecuencia;
    }
    public void setLargoSecuencia(int largoSecuencia) {
        this.largoSecuencia = largoSecuencia;
    }

    public void identificarHileraMasLarga(int[][] matriz) {
        //Inicio del ciclo que recorre cada elemento de la matriz
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                buscarSecuencia(matriz, i, j, i, j, matriz[i][j]-1, 0);
                
            }  
        }   //Fin del ciclo que recorre la matriz

        System.out.println("\nSecuencia más larga inicia en fila: " + this.filaSecuencia + 
                            ", columna: " + this.columnaSecuencia + 
                            ", longitud: " + this.largoSecuencia);
    }   //Fin del método 'identificarHileraMasLarga'

    public void buscarSecuencia(int[][] matriz, int filaInicial, int columnaInicial, int fila, int columna, int anterior, int longitud){
        //Caso Base: Va a detener la recursividad hasta que la entrada se salga del rango o el siguiente número no sea consecutivo
        if(fila < 0 || columna < 0 || matriz.length <= fila || matriz[0].length <= columna || matriz[fila][columna] != (anterior+1)){
            //System.out.println("Estoy en el caso base");
            if(longitud > this.largoSecuencia){
                this.largoSecuencia = longitud;
                this.filaSecuencia = filaInicial;
                this.columnaSecuencia = columnaInicial;
            }
            return;
        }
        int valorActual = matriz[fila][columna];
        //Caso Recursivo: Estamos dentro del rango permitido y el número es consecutivo:
        //1. Reviso la fila anterior
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila - 1, columna - 1, valorActual, longitud + 1);
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila - 1, columna    , valorActual, longitud + 1);
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila - 1, columna + 1, valorActual, longitud + 1);
        //2. Reviso la fila actual
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila,     columna - 1, valorActual, longitud + 1);
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila,     columna + 1, valorActual, longitud + 1);
        //3. Reviso la fila posterior
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila + 1, columna - 1, valorActual, longitud + 1);
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila + 1, columna,     valorActual, longitud + 1);
        buscarSecuencia(matriz, filaInicial, columnaInicial, fila + 1, columna + 1, valorActual, longitud + 1);
    }
    
    public static void main(String[] args) {
        //Creo mi matriz
        int[][] matriz = {
            {0, 1, 2}, // Primera fila
            {5, 0, 1}, // Segunda fila
            {4, 3, 2}  // Tercera fila
        };
        //Creo mi objeto analizador
        Analizador analizador1 = new Analizador();
        analizador1.identificarHileraMasLarga(matriz);
    }
}
