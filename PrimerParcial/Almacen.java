/**
 * Almacen
 * 
 * @author Alejandro Guerra Rodríguez
 * @version 20-10-2024
 */
public class Almacen
{
    private Tabla[] tablas;
    //En esta posición, no hay tabla. Sino en la anterior
    private int primeraPosicionVacia;
    public Tabla[] getTablas(){
        return this.tablas;
    }
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
            tablas[i].orientar();
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
    public boolean corteValido(Tabla tablaCliente){
        boolean corteValido = true;
        if(tablaCliente.getAncho() > Tabla.getAnchoEstandar() || tablaCliente.getLargo() > Tabla.getLargoEstandar()){
            corteValido = false;
        }
        return corteValido;
    }
    public int indiceTablaAUtilizar(Tabla tablaCliente){
        int indiceTablaMadre = 0;
        for(int i = 0; i < this.primeraPosicionVacia; i++){
            if(this.tablas[i].getAncho() >= tablaCliente.getAncho() && this.tablas[i].getLargo() >= tablaCliente.getLargo()){
                indiceTablaMadre = i;
                return indiceTablaMadre;
            }
        }
        //En caso de que tengamos que agregar una tabla estandar
        agregarTablaEstandar();
        indiceTablaMadre = (this.primeraPosicionVacia-1);
        return indiceTablaMadre;
    }
    public void eliminarUltimaTabla(){
        this.tablas[this.primeraPosicionVacia-1] = null;
        this.primeraPosicionVacia -= 1;
    }
    public void cortarTabla(int indiceTablaMadre, Tabla tablaCliente){
        /**
         * El primer corte lo realizo paralelo al ancho:
         *      -La tabla restante tiene mismo ancho que la tabla madre, pero su nuevo largo es largoMadre-largoCliente
         * El segundo corte lo realizo paralelo al largo:
         *      -La tabla residuo tiene mismo largo que la tabla cliente, pero su nuevo ancho es anchoMadre-anchoCliente
         */
        
        Tabla tablaRestante = this.tablas[indiceTablaMadre];
        double largoRestante = tablaRestante.getLargo() - tablaCliente.getLargo();
        tablaRestante.setLargo(largoRestante);
        tablaRestante.recalcularArea();
        tablaRestante.recalcularPrecio();
        
        double anchoResiduo = tablaRestante.getAncho() - tablaCliente.getAncho();
        double largoResiduo = tablaCliente.getLargo();
        Tabla tablaResiduo = new Tabla(anchoResiduo, largoResiduo);

        if(tablaRestante.getAncho() != 0 && tablaRestante.getLargo() != 0){     //Si la tabla restante existe:
            tablaRestante.orientar();
            System.out.println("Hemos generado la siguiente tabla restante: ");
            tablaRestante.detalles();
            this.tablas[indiceTablaMadre] = tablaRestante;
        }
        else{       //Si no existe tabla restante:
            this.tablas[indiceTablaMadre] = this.tablas[primeraPosicionVacia-1];
            eliminarUltimaTabla();
        }
        if(tablaResiduo.getAncho() != 0 && tablaResiduo.getLargo() != 0){     //Si la tabla residuo existe:
            tablaResiduo.orientar();
            System.out.println("Hemos generado la siguiente tabla residuo: ");
            tablaResiduo.detalles();
            agregarTabla(tablaResiduo);
        }
        //Si no hay tabla residuo, no hago nada
        
        //Ordeno el almacén al finalizar todas las operaciones
        ordenar();
    }
    public void mostrarAlmacen(){
        if(this.primeraPosicionVacia == 0){
            System.out.println("\nAlmacén vacío\n");
        }
        else{
            for (int i = 0; i < this.primeraPosicionVacia; i++){
                if (this.tablas[i] != null){
                    System.out.print("Posición: " + i + "\n");
                    this.tablas[i].detalles();
                }
            }
        }
    }
}