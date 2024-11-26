package Ejercicio_3;

public class Arbol {
    private NodoArbol nodoRaiz;
    private int cantidadElementos;

    public Arbol(){
        this.nodoRaiz = null;
        this.cantidadElementos = 0;
    }
    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }
    public int getCantidadElementos(){
        return this.cantidadElementos;
    }

    public void insertar(int valor){
        if(this.nodoRaiz == null){
            this.nodoRaiz = new NodoArbol(valor);
        }else{
            this.nodoRaiz.insertar(valor);
        }
        this.cantidadElementos += 1;
    }

    public boolean esVacio(){
        boolean vacio = false;
        if(this.nodoRaiz == null){
            vacio = true;
        }
        return vacio;
    }
    
    public boolean seEncuentra(int valor){
        boolean seEncuentra = false;
        if (this.nodoRaiz.getValor() == valor){
            return true;
        }else{
            seEncuentra = seEncuentraRecursivo(valor, this.nodoRaiz);
        }
        return seEncuentra;

    }
   
    public boolean seEncuentraRecursivo(int valor, NodoArbol nodo){
        boolean seEncuentra = false;
        if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
            if(nodo.getValor() == valor){
                return true;
            }else{
                seEncuentra = seEncuentraRecursivo(valor, nodo.getHijoIzquierdo());
                seEncuentra = seEncuentraRecursivo(valor, nodo.getHijoDerecho());
            }
        }
        return seEncuentra;
    }
    
    public void iniciarPreorden(){
        preordenRecursivo(this.nodoRaiz);
        System.out.print("} \n");
    }

    public void preordenRecursivo(NodoArbol nodo){
        if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
            if(nodo == this.nodoRaiz){
                System.out.print("{");
            }
            System.out.print(nodo.getValor() + ", ");
            preordenRecursivo(nodo.getHijoIzquierdo());
            preordenRecursivo(nodo.getHijoDerecho());
        }
    }


}
