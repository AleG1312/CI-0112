/**
 * Write a description of class Almacen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Almacen
{
    private Tabla[] tablas;
    //En esta posición, no hay tabla. Sino en la anterior
    private int primeraPosicionVacia;
    public int getPrimeraPosicionVacia(){
        return this.primeraPosicionVacia;
    }
    public void setPrimeraPosicionVacia(int primeraPosicionVacia){
        this.primeraPosicionVacia = primeraPosicionVacia;
    }
    public Almacen(){
        this.tablas = new Tabla[500];
        this.primeraPosicionVacia = 0;
    }
    public Tabla cortar(Tabla tablaCliente){
        return null;
    }
    public void ordenar(){
        //Primero acomodo la orientación de todas las tablas del almacén:
        for (int i = 0; i < this.primeraPosicionVacia; i++){
            tablas[i].acomodarOrientacion();
        }
        //Defino mi tabla intermedia
        Tabla tablaTemporal;
        //Comienzo las comparaciones
        for (int i = 0; i < this.primeraPosicionVacia; i++){
            for (int j = (i+1); j < this.primeraPosicionVacia; j++){
                //Comparo los anchos:
                tablaTemporal = this.tablas[i];
                //System.out.println("Comparando: " + this.tablas[i].getAncho() + ",con: " + this.tablas[j].getAncho());
                if(this.tablas[i].getAncho() > this.tablas[j].getAncho()){
                    this.tablas[i] = this.tablas[j];
                    this.tablas[j] = tablaTemporal;
                }
                //Si son del mismo ancho:
                else if(this.tablas[i].getAncho() == this.tablas[j].getAncho()){
                    //Comparo los largos:
                    if(this.tablas[i].getLargo() > this.tablas[j].getLargo()){
                        this.tablas[i] = this.tablas[j];
                        this.tablas[j] = tablaTemporal;
                    }
                }
            }
        }
    }
    public void agregarTabla(Tabla tabla){
        //La agrego en la primera posicion vacía
        this.tablas[this.primeraPosicionVacia] = tabla;
        //Aumento el contador
        this.primeraPosicionVacia += 1;
    }
    public void agregarTablaEstandar(){
        //Creo la tabla con medidas estándar
        Tabla tablaEstandar = new Tabla(Tabla.getAnchoEstandar(), Tabla.getLargoEstandar());
        //La agrego en la primera posicion vacía
        this.tablas[this.primeraPosicionVacia] = tablaEstandar;
        //Aumento el contador
        this.primeraPosicionVacia += 1;
    }
    public void eliminarTabla(int indice){
        this.tablas[indice] = null;
        eliminarEspacioVacio(indice);
    }
    public void eliminarEspacioVacio(int indiceTablaEliminada){
        for (int i = (indiceTablaEliminada+1); i <= this.primeraPosicionVacia; i++){
            this.tablas[i-1] = this.tablas[i];   
        }        
        this.primeraPosicionVacia -= 1;
    }
    public void mostrarAlmacen(){
        for (int i = 0; i < this.primeraPosicionVacia; i++){
            if (this.tablas[i] != null){
                System.out.print("Posición: " + i);
                this.tablas[i].mostrarDetalles();
            }
        }
    }
}