
public class NodoArbol{
    //Atributos
    private int valor;
    private NodoArbol NodoArbolIzquierdo;
    private NodoArbol NodoArbolDerecho;

    //Constructor
    public NodoArbol(int valor){
        this.valor = valor;
        this.NodoArbolIzquierdo = null;
        this.NodoArbolDerecho = null;
    }

    //Setters y getters
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NodoArbol getNodoArbolIzquierdo() {
        return NodoArbolIzquierdo;
    }
    public NodoArbol getNodoArbolDerecho() {
        return NodoArbolDerecho;
    }

    //Insertar
    public void insertar(int valor){
        if (valor < this.valor){
            if(this.NodoArbolIzquierdo == null){
                this.NodoArbolIzquierdo = new NodoArbol(valor);
            }
            else{
                this.NodoArbolIzquierdo.insertar(valor);
            }
        }
        else{
            if(this.NodoArbolDerecho == null){
                this.NodoArbolDerecho = new NodoArbol(valor);
            }
            else{
                this.NodoArbolDerecho.insertar(valor);
            }
        }
    }
}