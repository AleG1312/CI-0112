
/**
 * Write a description of class Tabla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tabla
{
    private static double anchoEstandar = 4.0;
    private static double largoEstandar = 6.0;
    private static double precioEstandar = 24000.0;
    
    private double ancho;
    private double largo;
    private double area;
    private double precio;

    public Tabla(double ancho, double largo)
    {
        this.ancho = ancho;
        this.largo = largo;
        this.area = ancho * largo;
        
        double areaEstandar = this.anchoEstandar*this.largoEstandar;
        this.precio = (this.area/areaEstandar)*precioEstandar;
    }
    public static double getAnchoEstandar() {
        return anchoEstandar;
    }
    public static void setAnchoEstandar(double nuevoAncho) {
        anchoEstandar = nuevoAncho;
    }
    public static double getLargoEstandar() {
        return largoEstandar;
    }
    public static void setLargoEstandar(double nuevoLargo) {
        largoEstandar = nuevoLargo;
    }
    public static double getPrecioEstandar() {
        return precioEstandar;
    }
    public static void setPrecioEstandar(double nuevoPrecio) {
        precioEstandar = nuevoPrecio;
    }
    public double getAncho() {
        return this.ancho;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public double getLargo() {
        return this.largo;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public double getArea() {
        return this.area;
    }
    public static double getAreaEstandar() {
        return anchoEstandar * largoEstandar;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void acomodarOrientacion(){
        double medidaTemporal;
        if(this.ancho > this.largo){
            medidaTemporal = this.ancho;
            this.ancho = this.largo;
            this.largo = medidaTemporal;
        }
    }
    public void invertirOrientacion(){
        double medidaTemporal = this.ancho;
        this.ancho = this.largo;
        this.largo = medidaTemporal;
    }
    public void mostrarDetalles(){
        System.out.println("\n--------Detalles de Tabla Estandar--------");
        System.out.println("Ancho: " + anchoEstandar + " | Largo: " + largoEstandar);
        System.out.println("Área: " + getAreaEstandar() + " | Precio: " + precioEstandar);
        
        System.out.println("\n--------Detalles de Tabla--------");
        System.out.println("Ancho: " + this.ancho + " | Largo: " + this.largo);
        System.out.println("Área: " + getArea() + " | Precio: " + this.precio);
    }
}