public class GestorDeRectangulos
{
    public Rectangulo encontrarRectanguloMayor(Rectangulo[] rectangulos){
        Rectangulo rectanguloMayor = rectangulos[0];
        for(Rectangulo rectangulo : rectangulos){
            rectanguloMayor = (rectangulo.calcularArea() > rectanguloMayor.calcularArea())? rectangulo: rectanguloMayor;
        }
        return rectanguloMayor;        
    }
}
