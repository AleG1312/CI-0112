public class Rectangulo
{
    private double ancho;
    private double alto;
    public Rectangulo(double ancho, double alto){
        this.ancho = ancho;
        this.alto = alto;
    }
    public double getAncho(){
        return this.ancho;
    }
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    public double getAlto(){
        return this.alto;
    }
    public void setAlto(double alto){
        this.alto = alto;
    }
    public double calcularArea(){
        double area = this.alto * this.ancho;
        return area;
    }
    public String obtenerInfo(){
        String cadena = "Ancho: " + this.ancho + ". Alto: " + this.alto + ". Área: " + calcularArea();
        return cadena;
    }
}
