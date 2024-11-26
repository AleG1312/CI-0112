public class Arbol {
    private NodoArbol nodoRaiz;

    public Arbol(){
        this.nodoRaiz = null;
    }
    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }

    public void insertar(int valor){
        if(this.nodoRaiz == null){
            this.nodoRaiz = new NodoArbol(valor);
        }else{
            this.nodoRaiz.insertar(valor);
        }
    }
}
