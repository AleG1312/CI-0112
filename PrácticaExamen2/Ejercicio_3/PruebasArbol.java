package Ejercicio_3;

public class PruebasArbol {
    public static void main(String[] args) {
        //Creo mi árbol:
        Arbol arbol1 = new Arbol();
        //Ingreso mi raíz
        arbol1.insertar(7);
        //Ingreso otros valores
        arbol1.insertar(4);
        arbol1.insertar(5);
        arbol1.insertar(8);
        //Compruebo la información
        System.out.println("Mi raiz es: " + arbol1.getNodoRaiz().getValor());
        System.out.println("Mi árbol tiene: " + arbol1.getCantidadElementos() + " de elementos.");
        arbol1.iniciarPreorden();
        //Ingreso elemento repetido
        arbol1.insertar(5);
        arbol1.insertar(6);
        arbol1.iniciarPreorden();
        //Compruebo si un número está en el árbol o no:
        System.out.println(arbol1.seEncuentra(5));
    }
}
