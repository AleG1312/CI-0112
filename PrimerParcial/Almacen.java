
/**
 * Write a description of class Almacen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Almacen
{
    private Tabla[] tablasAlmacen;
    //En esta posición, no hay tabla. Sino en la anterior
    private int posicionUltimaTabla;
    public int getPosicionUltimaTabla(){
        return this.posicionUltimaTabla;
    }
    public void setPosicionUltimaTabla(int posicionUltimaTabla){
        this.posicionUltimaTabla = posicionUltimaTabla;
    }
    public Almacen(){
        this.tablasAlmacen = new Tabla[500];
        this.posicionUltimaTabla = 0;
    }
    public Tabla cortar(Tabla tablaCliente){
        return null;
    }
    public void ordenar(){
        //Primero acomodo la orientación de todas las tablas del almacén:
        for (Tabla tabla : this.tablasAlmacen){
            tabla.acomodarOrientacion();
        }
        //Defino mi tabla intermedia
        Tabla tablaTemporal;
        //Comienzo las comparaciones
        for (int i = 0; i < this.posicionUltimaTabla; i++){
            for (int j = (i+1); j < this.posicionUltimaTabla; j++){
                //Comparo los anchos:
                tablaTemporal = this.tablasAlmacen[i];
                if(this.tablasAlmacen[i].getAncho() > this.tablasAlmacen[j].getAncho()){
                    this.tablasAlmacen[i] = this.tablasAlmacen[j];
                    this.tablasAlmacen[i] = tablaTemporal;
                }
                //Si son del mismo ancho:
                else if(this.tablasAlmacen[i].getAncho() == this.tablasAlmacen[j].getAncho()){
                    //Comparo los largos:
                    if(this.tablasAlmacen[i].getLargo() > this.tablasAlmacen[j].getLargo()){
                        this.tablasAlmacen[i] = this.tablasAlmacen[j];
                        this.tablasAlmacen[i] = tablaTemporal;
                    }
                }
            }
        }
    }
    public void agregarTablaEstandar(){
        //Creo la tabla con medidas estándar
        Tabla tablaEstandar = new Tabla(Tabla.getAnchoEstandar(), Tabla.getLargoEstandar());
        //La agrego en la última tabla del almacén
        tablasAlmacen[this.posicionUltimaTabla] = tablaEstandar;
        //Aumento el contador
        this.posicionUltimaTabla += 1;
    }
}