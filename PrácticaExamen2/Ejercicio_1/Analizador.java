package Ejercicio_1;

public class Analizador {
    private int filaSecuencia;
    private int columnaSecuencia;
    private int largoSecuencia; //La cantidad de elementos que forman la secuencia

    // Constructor 
    public Analizador() {
        this.filaSecuencia = 0;
        this.columnaSecuencia = 0;
        this.largoSecuencia = 1;
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

    public void identificarHileraMasLarga(int[][] matriz, int filaSecuencia, int columnaSecuencia, int cantidadSecuencia) {
        /**
         * 1. Hacer un ciclo que recorra cada elemento de la matriz
         * 2. Hacer otro ciclo que para cada elemento, revise todos los elementos de su cuadro adyacente
         * 3. En el segundo ciclo, hacer métodos de comprobación para qué únicamente revise los elementos posibles
         */

        //Inicio del ciclo que recorre cada elemento de la matriz
        for(int i = filaSecuencia; i < matriz.length; i++){
            for(int j = columnaSecuencia; j < matriz[0].length; j++){

                System.out.println("\nEstoy analizando la entrada [" + i + "," + j + "]=" + matriz[i][j] + ", en busca de la secuencia más larga");

                
                String linea = "";
                //Inicio del ciclo que recorre el cuadro adyacente a mi elemento en análisis
                for(int m = i-1; m <= i+1; m++){
                    for(int n = j-1; n <= j+1; n++){



                        //Inicio de las comprobaciones de los elementos adyacentes válidos
                        if(0 <= m && m < matriz.length){
                            if(0 <= n && n < matriz[0].length){
                                if(i != m || j != n){   //Para ignorar el caso en el que estoy volviendo a analizar mi elemento de análisis original
                                    // System.out.print(matriz[m][n] + ",");
                                    linea +=matriz[m][n];
                                    linea += ", ";
                                    /**
                                     * Llegados a este bloque de código, estoy analizando todos los elementos adyacentes a mi elemento de análisis
                                     * de forma correcta sin incluir mi elemento de análisis inicial
                                     */
                                    
                                    if(matriz[m][n] == (matriz[i][j]+1)){
                                        System.out.println("He encontrado un elemento adyacente consecutivo: ");
                                        System.out.println("Elemento en análisis: [" + i + "," + j + "]=" + matriz[i][j]);
                                        System.out.println("Adyacente Consecutivo: [" + m + "," + n + "]=" + matriz[m][n] + "\n");


                                    }
                                }

                            }

                        }//Fin de las comprobaciones de los elementos adyacentes válidos



                    }   //Fin del ciclo que recorre el cuadro adyacente
                }
                System.out.println("Mis elementos adyacentes al elemento en análisis son: ");
                System.out.println(linea);



            }   //Fin del ciclo que recorre la matriz
        }
        
        
    }   //Fin del método 'identificarHileraMasLarga'
}
