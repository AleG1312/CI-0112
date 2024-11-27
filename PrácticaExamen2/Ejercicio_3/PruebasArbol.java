package Ejercicio_3;

public class PruebasArbol {
    public static void main(String[] args) {
        /**
         * Funcionamiento general del árbol
         */
        //Creo mi árbol:
        Arbol arbol1 = new Arbol();
        //Ingreso mi raíz
        arbol1.insertar(arbol1.getNodoRaiz(), 10);
        //Ingreso otros valores
        arbol1.insertar(arbol1.getNodoRaiz(), 5);
        arbol1.insertar(arbol1.getNodoRaiz(), 3);
        arbol1.insertar(arbol1.getNodoRaiz(), 8);
        arbol1.insertar(arbol1.getNodoRaiz(), 6);
        arbol1.insertar(arbol1.getNodoRaiz(), 17);
        arbol1.insertar(arbol1.getNodoRaiz(), 15);
        arbol1.insertar(arbol1.getNodoRaiz(), 16);
        arbol1.insertar(arbol1.getNodoRaiz(), 20);
        
        /**
         * Compruebo información general
         */
        System.out.println("\nArbol 1:");
        System.out.println("Mi raiz es: " + arbol1.getNodoRaiz().getValor());
        System.out.println("Mi árbol tiene: " + arbol1.getCantidadElementos() + " de elementos.");
        arbol1.imprimir();

        /**
         * Eliminar nodos de un árbol
         */

        // //Eliminamos nodo sin hijos
        // int valor = 3;
        // System.out.println("Estamos eliminando el valor: " + valor);
        // arbol1.eliminar(valor);
        // System.out.println("Comprobamos que el elemento '" + valor + "' ya no está: " +  arbol1.getNodoRaiz().getHijoIzquierdo().getHijoIzquierdo());
        // System.out.println("Arbol posterior a la eliminación: ");
        // arbol1.imprimir();

        // //Eliminamos nodo con hijo izquierdo
        // int valor = 6;
        // System.out.println("Estamos eliminando el valor: " + valor);
        // arbol1.eliminar(valor);
        // System.out.println("Comprobamos que el elemento '" + valor + "' ya no está: " +  arbol1.getNodoRaiz().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo());
        // System.out.println("Arbol posterior a la eliminación: ");
        // arbol1.imprimir();

        // //Eliminamos nodo con hijo derecho
        // int valor = 15;
        // System.out.println("Estamos eliminando el valor: " + valor);
        // arbol1.eliminar(valor);
        // System.out.println("Comprobamos que el elemento '" + valor + "' ya no está: " +  arbol1.getNodoRaiz().getHijoDerecho().getHijoIzquierdo().getHijoDerecho());
        // System.out.println("Arbol posterior a la eliminación: ");
        // arbol1.imprimir();

         //Eliminamos nodo con dos hijos
         int valor = 5;
         System.out.println("Estamos eliminando el valor: " + valor);
         arbol1.eliminar(valor);
         System.out.println("Comprobamos que el menor ya no está: " +  arbol1.getNodoRaiz().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo());
         System.out.println("Arbol posterior a la eliminación: ");
         arbol1.imprimir();
    }
}
