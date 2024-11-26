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
            insertarRecursivo(valor, this.nodoRaiz);
        }
        this.cantidadElementos += 1;
    }
    
    public void insertarRecursivo(int valor, NodoArbol nodoComparacion){
        if (valor < nodoComparacion.getValor()){
            if(nodoComparacion.getHijoIzquierdo() == null){
                nodoComparacion.setHijoIzquierdo(new NodoArbol(valor));
            }
            else{
                insertarRecursivo(valor, nodoComparacion.getHijoIzquierdo());
            }
        }
        else if(nodoComparacion.getValor() < valor){
            if(nodoComparacion.getHijoDerecho() == null){
                nodoComparacion.setHijoDerecho(new NodoArbol(valor));
            }
            else{
                insertarRecursivo(valor, nodoComparacion.getHijoDerecho());
            }
        }else{
            System.out.println("El elemento '" + valor + "' ya se encuentra en el árbol.");
        }
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

        if (this.nodoRaiz.getValor() == valor){ //Caso base
            seEncuentra = true;
        }else{  //Caso recursivo
            seEncuentra = seEncuentraRecursivo(valor, this.nodoRaiz, seEncuentra);
        }//Finliza la recursión: 
        return seEncuentra;
    }
   
    public boolean seEncuentraRecursivo(int valor, NodoArbol nodo, boolean seEncuentra){
        if(!seEncuentra){
            if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
                if(nodo.getValor() == valor){
                    return !seEncuentra;
                }else{
                    seEncuentra = seEncuentraRecursivo(valor, nodo.getHijoIzquierdo(), seEncuentra);
                    seEncuentra = seEncuentraRecursivo(valor, nodo.getHijoDerecho(), seEncuentra);
                }
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

    public void eliminar(int valor){
        if(esVacio()){
            System.out.println("No se puede eliminar ya que la lista se encuentra vacía.");
        } else if(!seEncuentra(valor)){
            System.out.println("No se puede eliminar ya que '" + valor + "' no se encuentra en la lista.");
        } else { //En el caso de que sí esté el elemento a eliminar
            NodoArbol nodoAEliminar = identificarNodoAEliminar(this.nodoRaiz, valor);
            System.out.println("Hemos identificado el nodo a eliminar. Este tiene un valor de: " + nodoAEliminar.getValor());
            //
            if(nodoAEliminar.getHijoIzquierdo() == null && nodoAEliminar.getHijoDerecho() == null){ //Eliminamos una hoja
                nodoAEliminar = null;
            }
        }

    }
    
    public NodoArbol identificarNodoAEliminar(NodoArbol nodo, int valor){
        NodoArbol nodoAEliminar;
        if(valor == nodo.getValor()){   //Caso Base
            nodoAEliminar = nodo;
        }
        else{   //Caso Recursivo
            if(valor < nodo.getValor()) {    //Casos recursivos
                nodoAEliminar = identificarNodoAEliminar(nodo.getHijoIzquierdo(), valor);
            }else{
                nodoAEliminar = identificarNodoAEliminar(nodo.getHijoDerecho(), valor);
            }
        }
        return nodoAEliminar;
    }
}  
