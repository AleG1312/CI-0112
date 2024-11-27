public class NodoDoble {
    private int valor;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(int valor){
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
    public NodoDoble(int valor, NodoDoble anterior, NodoDoble siguiente){
        this.valor = valor;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    //Setters y getters
    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Setter para 'anterior'
public void setAnterior(NodoDoble anterior) {
    this.anterior = anterior;
}

// Getter para 'anterior'
public NodoDoble getAnterior() {
    return anterior;
}

// Setter para 'siguiente'
public void setSiguiente(NodoDoble siguiente) {
    this.siguiente = siguiente;
}

// Getter para 'siguiente'
public NodoDoble getSiguiente() {
    return siguiente;
}
}
