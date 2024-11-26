package Ejercicio_3;

public class PruebasArbol {
    public static void main(String[] args) {
        // /**
        //  * Funcionamiento general del árbol
        //  */
        // //Creo mi árbol:
        // Arbol arbol1 = new Arbol();
        // //Ingreso mi raíz
        // arbol1.insertar(10);
        // //Ingreso otros valores
        // arbol1.insertar(5);
        // arbol1.insertar(3);
        // arbol1.insertar(8);
        // arbol1.insertar(17);
        // arbol1.insertar(15);
        // arbol1.insertar(16);
        // arbol1.insertar(20);
        // //Compruebo la información
        // System.out.println("Mi raiz es: " + arbol1.getNodoRaiz().getValor());
        // System.out.println("Mi árbol tiene: " + arbol1.getCantidadElementos() + " de elementos.");
        // arbol1.iniciarPreorden();
        // //Ingreso elemento repetido
        // arbol1.insertar(5);
        // //Compruebo si un número está en el árbol o no:
        // System.out.println("¿El elemento '" + 5 + "' se encuentra en el árbol?: " + arbol1.seEncuentra(5));

        /**
         * Eliminar nodos de un árbol
         */
        Arbol arbol2 = new Arbol();
        arbol2.insertar(5);
        arbol2.insertar(4);
        System.out.println(arbol2.getNodoRaiz().getHijoIzquierdo().getValor());
        arbol2.eliminar(4);
        System.out.println(arbol2.getNodoRaiz().getHijoIzquierdo().getValor());

    }
}
