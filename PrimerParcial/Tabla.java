/**
 * Tabla
 * 
 * @author Alejandro Guerra Rodríguez
 * @version 20-10-2024
 */
public class Tabla
{
    private static double anchoEstandar = 4.0;
    private static double largoEstandar = 6.0;
    private static double areaEstandar = anchoEstandar*largoEstandar;
    private static double precioEstandar = 24000.0;
    
    private double ancho;
    private double largo;
    private double area;
    private double precio;
    
    //Método constructor
    public Tabla(double ancho, double largo)
    {
        this.ancho = ancho;
        this.largo = largo;
        this.area = this.ancho * this.largo;
        this.precio = (this.area/areaEstandar)*precioEstandar;
    }
    //Setters y getters
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
    public static double getAreaEstandar() {
        return areaEstandar;
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
    public void recalcularArea(){
        this.area = this.ancho * this.largo;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void recalcularPrecio(){
        this.precio = (this.area/areaEstandar)*precioEstandar;
    }
    //Orienta la tabla en caso de que el ancho sea mayor al largo
    public void orientar(){
        double medidaTemporal;
        if(this.ancho > this.largo){
            medidaTemporal = this.ancho;
            this.ancho = this.largo;
            this.largo = medidaTemporal;
        }
    }
    //Despliega la información de la tabla
    public void detalles(){
        System.out.println("--------Detalles de Tabla--------");
        System.out.println("Ancho: " + this.ancho + " | Largo: " + this.largo);
        System.out.println("Área: " + this.area + " | Precio: " + this.precio + "\n");
    }
}