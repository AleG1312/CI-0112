package Ejercicio_1;

public class PruebasAnalizador {
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 9, 7}, // Primera fila
            {5, 2, 4}, // Segunda fila
            {0, 1, 2}  // Tercera fila
        };
        Analizador analizador1 = new Analizador();
        // System.out.println("Previo al análisis: ");
        // System.out.println("Fila Secuencia: " + analizador1.getFilaSecuencia());
        // System.out.println("Columna Secuencia: " + analizador1.getColumnaSecuencia());
        // System.out.println("Largo Secuencia: " + analizador1.getLargoSecuencia());
        analizador1.identificarHileraMasLarga(matriz, 0, 0, 1);
        // System.out.println("Posterior al análisis: ");
        // System.out.println("Fila Secuencia: " + analizador1.getFilaSecuencia());
        // System.out.println("Columna Secuencia: " + analizador1.getColumnaSecuencia());
        // System.out.println("Largo Secuencia: " + analizador1.getLargoSecuencia());
    }
    
}
