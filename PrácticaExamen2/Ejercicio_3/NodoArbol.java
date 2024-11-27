package Ejercicio_3;

public class NodoArbol{
    //Atributos
    private int valor;
    private NodoArbol HijoIzquierdo;
    private NodoArbol HijoDerecho;

    //Constructor
    public NodoArbol(int valor){
        this.valor = valor;
        this.HijoIzquierdo = null;
        this.HijoDerecho = null;
    }
    //Setters y getters
    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoArbol getHijoIzquierdo() {
        return HijoIzquierdo;
    }
    public void setHijoIzquierdo(NodoArbol nodo){
        this.HijoIzquierdo = nodo;
    }
    public NodoArbol getHijoDerecho() {
        return HijoDerecho;
    }
    public void setHijoDerecho(NodoArbol nodo){
        this.HijoDerecho = nodo;
    }
}
