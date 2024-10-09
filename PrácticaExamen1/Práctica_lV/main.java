public class main
{
    public static void main(String[] args){
        Rectangulo[] rectangulos = new Rectangulo[3]; 
        rectangulos[0] = new Rectangulo(5.0, 4.0); 
        rectangulos[1] = new Rectangulo(3.0, 6.0); 
        rectangulos[2] = new Rectangulo(2.0, 8.0); 
        GestorDeRectangulos gestor = new GestorDeRectangulos(); 
        Rectangulo rectanguloMayor = gestor.encontrarRectanguloMayor(rectangulos); 
        System.out.println("Rectángulo Mayor: " + rectanguloMayor.obtenerInfo());
    }
}
