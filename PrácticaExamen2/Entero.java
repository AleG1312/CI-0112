public class Entero {
    private int valor;
    public Entero(int valor){
        this.valor = valor;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }

    public static void main(String[] args) {
        Entero entero1 = new Entero(5);
        Entero entero2 = entero1;
        Entero entero3 = entero2;
        entero2.setValor(0);


        Entero[] enteros = {entero1, entero2, entero3};

        for(Entero entero:enteros){
            System.out.println(entero.getValor());
        }

    }
    
}
