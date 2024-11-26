public class SimulacroExamen2 {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3}, // Primera fila
            {4, 5, 6}, // Segunda fila
            {7, 8, 9}  // Tercera fila
        };
        identificarHileraMasLarga(matriz);
    }

    public static void identificarHileraMasLarga(int[][] matriz ) {
        /**
         * 1. Hacer un ciclo que recorra cada elemento de la matriz
         * 2. Hacer otro ciclo que para cada elemento, revise todos los elementos de su cuadro adyacente
         * 3. En el segundo ciclo, hacer métodos de comprobación para qué únicamente revise los elementos posibles
         */

        //Inicio del ciclo que recorre la matriz
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){

                int elementoInicial = matriz[i][j];
                System.out.println("Mi elemento en análisis es: " + elementoInicial);



                //Inicio del ciclo que recorre el cuadro adyacente
                for(int m = i-1; m <= i+1; m++){
                    for(int n = j-1; n <= j+1; n++){



                        //Comprobaciones para únicamente considerer los elementos válidos
                        if(0 <= m && m < matriz.length){
                            if(0 <= n && n < matriz[0].length){
                                if(i != m || j != n){
                                    /**
                                     * Llegados a este bloque de código, estoy analizando todos los elementos adyacentes a mi elemento de análisis
                                     * de forma correcta.
                                     */
                                    
                                    if(matriz[m][n] == (matriz[i][j]+1)){
                                        System.out.println(matriz[m][n]);
                                        System.out.println(true);
                                    }
                                }

                            }

                        }



                    }   //Fin del ciclo que recorre el cuadro adyacente
                }



            }   //Fin del ciclo que recorre la matriz
        }
        
        
    }   //Fin del método 'identificarHileraMasLarga'
}
