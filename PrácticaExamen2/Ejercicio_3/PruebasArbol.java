package Ejercicio_3;

public class PruebasArbol {
    public static void main(String[] args) {
        /**
         * Funcionamiento general del árbol
         */
        //Creo mi árbol:
        Arbol arbol = new Arbol();
        //Inserto una raíz
        arbol.insertar(10);
        //Visualizo mi árbol
        arbol.imprimir();

        /**
        * Inserto varios nodos más
        */
        arbol.insertar(5);
        arbol.insertar(10);
        arbol.insertar(9);
        arbol.insertar(6);
        arbol.insertar(4);
        arbol.insertar(7);
        arbol.imprimir();

        arbol.eliminar(6);
        arbol.imprimir();
        System.out.println(arbol.getNodoRaiz().getHijoIzquierdo().getHijoDerecho().getValor());
        
        // /**
        //  * Compruebo información general
        //  */
        // System.out.println("\nArbol 1:");
        // System.out.println("Mi raiz es: " + arbol1.getNodoRaiz().getValor());
        // System.out.println("Mi árbol tiene: " + arbol1.getCantidadElementos() + " de elementos.");
        // arbol1.imprimir();

        
    }
}
