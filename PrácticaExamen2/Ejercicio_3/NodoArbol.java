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
    public NodoArbol getHijoDerecho() {
        return HijoDerecho;
    }

    //Insertar
    public void insertar(int valor){
        if (valor < this.valor){
            if(this.HijoIzquierdo == null){
                this.HijoIzquierdo = new NodoArbol(valor);
            }
            else{
                this.HijoIzquierdo.insertar(valor);
            }
        }
        else if(this.valor < valor){
            if(this.HijoDerecho == null){
                this.HijoDerecho = new NodoArbol(valor);
            }
            else{
                this.HijoDerecho.insertar(valor);
            }
        }else{
            System.out.println("El elemento '" + valor + "' ya se encuentra en el árbol.");
        }
    }
}
