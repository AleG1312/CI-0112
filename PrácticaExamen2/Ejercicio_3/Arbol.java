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

    public void insertar(NodoArbol nodo, int valor){
        if(this.nodoRaiz == null){
            this.nodoRaiz = new NodoArbol(valor);
            this.cantidadElementos += 1;
        }else{
            if(valor < nodo.getValor()){
                if(nodo.getHijoIzquierdo() == null){
                    nodo.setHijoIzquierdo(new NodoArbol(valor));
                    this.cantidadElementos += 1;
                }else{
                    insertar(nodo.getHijoIzquierdo(), valor);
                }
            } else if(nodo.getValor() < valor){
                if(nodo.getHijoDerecho() == null){
                    nodo.setHijoDerecho(new NodoArbol(valor));
                    this.cantidadElementos += 1;
                }else{
                    insertar(nodo.getHijoDerecho(), valor);
                }
            } else {    
                //El valor ya se encuentra en el árbol
                return;
            }
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
        }else{  //Caso Rec
            seEncuentra = seEncuentraRec(valor, this.nodoRaiz, seEncuentra);
        }//Finliza la recursión: 
        return seEncuentra;
    }
   
    public boolean seEncuentraRec(int valor, NodoArbol nodo, boolean seEncuentra){
        if(!seEncuentra){
            if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
                if(nodo.getValor() == valor){
                    return !seEncuentra;
                }else{
                    seEncuentra = seEncuentraRec(valor, nodo.getHijoIzquierdo(), seEncuentra);
                    seEncuentra = seEncuentraRec(valor, nodo.getHijoDerecho(), seEncuentra);
                }
            }
        }
        return seEncuentra;
    }

    public void imprimir(){
        imprimirRec(this.nodoRaiz);
        System.out.print("} \n\n");
    }

    public void imprimirRec(NodoArbol nodo){
        if(nodo != null){   //Solo se hace el recorrido si el nodo no es nulo  
            if(nodo == this.nodoRaiz){
                System.out.print("{" + nodo.getValor());
            }
            else{
                System.out.print(", " + nodo.getValor());
            }
            imprimirRec(nodo.getHijoIzquierdo());
            imprimirRec(nodo.getHijoDerecho());
        }
    }

    public void eliminar(int valor){
        this.nodoRaiz = eliminarRec(this.nodoRaiz, valor);
    }
    
    public NodoArbol eliminarRec(NodoArbol nodo, int valor){
        if (nodo != null){
            //Caso Base: Encontró el valor a ser eliminado
            if(valor == nodo.getValor()){   
                //Eliminamos una hoja:
                if(nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null){ 
                    return null;
                }
                //Eliminamos un nodo con un único hijo
                else if(nodo.getHijoIzquierdo() == null ^ nodo.getHijoDerecho() == null){   
                    if(nodo.getHijoIzquierdo() == null){//Solo tiene hijo derecho
                        return nodo.getHijoDerecho();
                    }else{  //Solo tiene hijo izquierdo
                        return nodo.getHijoIzquierdo();
                    }
                } else{ //Eliminamos un nodo con dos hijos
                    NodoArbol sucesor = nodoMinimo(nodo.getHijoDerecho());
                    nodo.setValor(sucesor.getValor());
                    nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), sucesor.getValor()));
                    return nodo;
                }
            }
            if(valor < nodo.getValor()){
                nodo.setHijoIzquierdo(eliminarRec(nodo.getHijoIzquierdo(), valor));
            } else{
                nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), valor));
            }
        }
        return nodo;
    }
    
    public NodoArbol nodoMinimo (NodoArbol nodo){
        while(nodo.getHijoIzquierdo() != null){ //Caso Rec
            return nodoMinimo(nodo.getHijoIzquierdo());
        }
        return nodo;
    } 


    public void interseccion(NodoArbol nodoArbol1, Arbol arbol2, Arbol arbolInterseccion){
        if(nodoArbol1 == null){ //Caso base: El nodo es nulo
        } else{ //Caso recursivo: 
            if(arbol2.seEncuentra(nodoArbol1.getValor())){
                arbolInterseccion.insertar(arbolInterseccion.getNodoRaiz(), nodoArbol1.getValor());
            }
            interseccion(nodoArbol1.getHijoIzquierdo(), arbol2, arbolInterseccion);
            interseccion(nodoArbol1.getHijoDerecho(), arbol2, arbolInterseccion);
        }
    }
    public void union(NodoArbol nodoArbol1, Arbol arbolUnion){
        if(nodoArbol1 == null){ //Caso base: El nodo es nulo
        } else{ //Caso recursivo: 
            arbolUnion.insertar(arbolUnion.getNodoRaiz(), nodoArbol1.getValor());
            union(nodoArbol1.getHijoIzquierdo(), arbolUnion);
            union(nodoArbol1.getHijoDerecho(), arbolUnion);
        }
    }
}  