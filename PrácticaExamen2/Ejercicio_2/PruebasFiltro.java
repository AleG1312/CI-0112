package Ejercicio_2;

public class PruebasFiltro {
    public static void main(String[] args) {
        //Creo mi capa
        int[][] capa = {
                            {3,3,2,1,0},
                            {0,0,1,3,1},
                            {3,1,2,2,3},
                            {2,0,0,2,2},
                            {2,0,0,0,1}
                        };
        //Visualizo mi capa
        detalles(capa);
        //Aplico el filtro
        int[][] matrizSalida = maxPooling(capa, 3);
        //Visualizo mi matriz de salida
        detalles(matrizSalida);
    }
    public static int[][] maxPooling(int[][] capa, int filtroSize){
        //Defino las dimensioens de la matriz de salida:
        int filasSalida = capa.length - filtroSize + 1;
        int columnasSalida = capa[0].length - filtroSize + 1;
        //Defino mi matrizSalida ya con las dimensiones correctas
        int[][] matrizSalida = new int[filasSalida][columnasSalida];

        //Recorro mi matrizSalida. Cada elemento va a ser el filtro aplicado sobre la matriz capa
        // con la esquina superior del cuadrado en la misma entrada que la entrada de mi matrizSalida.
        for(int i = 0; i < matrizSalida.length; i++){
            for(int j = 0; j < matrizSalida[0].length; j++){
                /**
                 * Aplico el mapeo
                 */
                //1. Defino mi elemento mayor como la esquina superior izquierda de mi filtro:
                int mayor = capa[i][j];
                //2. Recorro la capa con mi filtro. Empezaré en la esquina superior izquierda
                for(int m = i; m < i + filtroSize; m++){
                    for(int n = j; n < j + filtroSize; n++){
                        //Comparo el número mayor:
                        if (capa[m][n] > mayor){
                            mayor = capa[m][n];
                        }//Fin de la comparación
                    }
                }//Fin del recorrido del filtro


                //3. Agrego el numero mayor del filtro a mi matriz de salida
                matrizSalida[i][j] = mayor;
            }
        }//Fin del recorrido de mi matriz Salida

        return matrizSalida;
    }
    
    public static void detalles(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(j == 0){
                    System.out.printf("(%d,", matriz[i][j]);
                }else if(j == matriz[0].length-1){
                    System.out.printf("%2d)", matriz[i][j]);
                }else{
                    System.out.printf("%2d,", matriz[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
