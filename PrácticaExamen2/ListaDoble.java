public class ListaDoble {
    private NodoDoble cabeza;

    public ListaDoble(int valor){
        this.cabeza = new NodoDoble(valor);
    }
    public void insertarFinal(int valor){
        if(this.cabeza == null){
            this.cabeza = new NodoDoble(valor);
        }else{  //Lo agrego a la cola
            insertarFinalRec(this.cabeza, valor);
        }
    }
    public void insertarFinalRec(NodoDoble nodo, int valor){
        if(nodo.getSiguiente() == null){
            nodo.setSiguiente(new NodoDoble(valor, nodo, null));
        } else{
            insertarFinalRec(nodo.getSiguiente(), valor);
        }
    }
    public void eliminar(int valor){
        if (this.cabeza == null){
            return;
        } else if(this.cabeza.getValor() == valor){
            this.cabeza = this.cabeza.getSiguiente();
        } else{
            eliminarRec(this.cabeza, valor);
        }
    }
    public void eliminarRec(NodoDoble nodo, int valor){
        if(nodo.getValor() == valor){
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        } else{
            eliminarRec(nodo.getSiguiente(), valor);
        }
    }

    public void imprimir(){
        if (this.cabeza == null){
            return;
        } else{
            imprimirRec(this.cabeza);
        }
    }
    public void imprimirRec(NodoDoble nodo){
        System.out.print(nodo.getValor() + ", ");
        if(nodo.getSiguiente() != null){
            imprimirRec(nodo.getSiguiente());
        }

    }

    public static void main(String[] args) {
        ListaDoble listaDoble = new ListaDoble(5);
        listaDoble.imprimir();
        listaDoble.insertarFinal(9);
        listaDoble.insertarFinal(4);
        listaDoble.insertarFinal(3);
        System.out.println();
        listaDoble.imprimir();
        listaDoble.eliminar(3);
        System.out.println();
        listaDoble.imprimir();
    }

}
