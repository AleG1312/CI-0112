

import javax.swing.*;

import java.awt.*;


// Mi Panel es el componente en el que dibujaré mi árbol
class panelArbol extends JPanel {
    private Arbol arbol;


    public panelArbol(Arbol arbol) {
        this.arbol = arbol;
        setPreferredSize(new Dimension(800, 800)); // Tamaño inicial de mi panel
    }

    @Override
    protected void paintComponent(Graphics g) { //Método que dibujará mi árbol
        super.paintComponent(g);    //Para eliminar el contenido del panel y dibujarlo de cero, sin que se superpongan dibujos anteriores.
        if (arbol.getNodoRaiz() != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();
            int altoNodoRaiz = 40;
            dibujarNodo(g, arbol.getNodoRaiz(), anchoPanel/2, altoNodoRaiz, anchoPanel/4);
        }
    }

    //Método que dibuja mis nodos
    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int xOffset) {   //El XOffset me dice la distancia de separación entre nodos
        if (nodo != null) { //Solo dibuja un nodo si no es nulo

            // Primero dibujo las líneas que unen los hijos que existan para que se dibujen por debajo del círculo y texto
            if (nodo.getHijoIzquierdo() != null) {
                g.drawLine(x, y, x - xOffset, y + 50);
            }
            if (nodo.getHijoDerecho() != null) {
                g.drawLine(x, y, x + xOffset, y + 50);
            }

            // Variables necesarias para ubicar el círculo y la estrella
            int radio = 40;
            int xCentro = x - (radio/2);
            int yCentro = y - (radio/2);

            if (nodo == arbol.getNodoRaiz()){   //Dibujaré el nodo de una manera
                dibujarRaiz(g, nodo, 3*radio/4);

                // g.setColor(Color.YELLOW);    //El color del círculo relleno
                // g.fillOval(xCentro, yCentro, radio, radio);   // Dibuo el círculo relleno
                // g.setColor(Color.BLACK);    //El color del borde del círculo
                // g.drawOval(xCentro, yCentro, radio, radio);   //Dibuo el borde
            } else{ //Dibujaré los hijos de otra manera
                if(nodo.getValor() % 2 == 0){
                    //Dibujo el nodo relleno y su borde
                    g.setColor(Color.GREEN);    //El color del círculo relleno
                    g.fillOval(xCentro, yCentro, radio, radio);   // Dibuo el círculo relleno
                    g.setColor(Color.BLACK);    //El color del borde del círculo
                    g.drawOval(xCentro, yCentro, radio, radio);   //Dibuo el borde
                }else{
                    //Dibujo el nodo relleno y su borde
                    g.setColor(Color.BLUE);    //El color del círculo relleno
                    g.fillOval(xCentro, yCentro, radio, radio);   // Dibuo el círculo relleno
                    g.setColor(Color.BLACK);    //El color del borde del círculo
                    g.drawOval(xCentro, yCentro, radio, radio);   //Dibuo el borde
                }
            }

            // Dibujo el valor del nodo
            String valor = nodo.toString();     //Obtengo el valor a dibujar

            Font fuenteTexto= new Font("Times New Roman", Font.BOLD, 30);   //Defino la fuente que quiero
            g.setFont(fuenteTexto); //Establezco mi fuente en el graphics

            //Proceso para obtener mi ancho y alto específicos para poder centrar el texto en el círculo
            FontMetrics fm = g.getFontMetrics();    
            int textoAncho = fm.stringWidth(valor);
            int textoAlto = fm.getAscent();
            //Dibujo mi texto centrado
            g.drawString(valor, x - textoAncho / 2, y + textoAlto / 4);


            // Ahora sí, dibujo los hijos que existan
            if (nodo.getHijoIzquierdo() != null) {
                dibujarNodo(g, nodo.getHijoIzquierdo(), x - xOffset, y + 50, xOffset / 2);
            }
            if (nodo.getHijoDerecho() != null) {
                dibujarNodo(g, nodo.getHijoDerecho(), x + xOffset, y + 50, xOffset / 2);
            }
        }
    }

    
    private void dibujarRaiz(Graphics g, NodoArbol nodo, int radio) {

        int verticesEstrella = 10;
        int radioExterno = (int) Math.round (2*radio); // El radio del círculo que conecta los picos externos de la estrella
        double anguloInicial = -Math.PI/2;
        //Defino mis puntos de la estrella
        int[] xPuntos = obtenerPuntosXEstrella(getWidth()/2, radio, radioExterno, anguloInicial, verticesEstrella);
        int[] yPuntos = obtenerPuntosYEstrella(35, radio, radioExterno, anguloInicial, verticesEstrella);

        //Dibujo la estrella rellena de amarillo
        g.setColor(Color.YELLOW);   
        g.fillPolygon(xPuntos, yPuntos, verticesEstrella);
        //Dibujo el borde de la estrella:
        g.setColor(Color.BLACK);    
        g.drawPolygon(xPuntos, yPuntos, verticesEstrella); 
            
    }
    
    public int[] obtenerPuntosXEstrella(int xCentro, int radio, int radioExterno, double anguloInicial, int vertices){
        int[] xPuntos = new int[vertices]; 

        //Defino los puntos de mi estrella:

        double anguloIncremento = 2 * Math.PI / vertices;
        for (int i = 0; i < vertices; i++) {
            double anguloVertice = anguloInicial + i*anguloIncremento;
            if(i%2 == 0){   //Estoy en un vértice externo
                xPuntos[i] = (int) Math.round(xCentro + radioExterno * Math.cos(anguloVertice));
            } else{ //Estoy en un vértice interno
                xPuntos[i] = (int) Math.round(xCentro + radio * Math.cos(anguloVertice));
            }
        }
        return xPuntos;
    }

    public int[] obtenerPuntosYEstrella(int yCentro, int radio, int radioExterno, double anguloInicial, int vertices){
        int[] yPuntos = new int[vertices]; 

        double anguloIncremento = 2 * Math.PI / vertices;

        for (int i = 0; i < vertices; i++) {
            double anguloVertice = anguloInicial + i*anguloIncremento;
            if(i%2 == 0){   //Estoy en un vértice externo
                yPuntos[i] = (int) Math.round(yCentro + radioExterno * Math.sin(anguloVertice));
            } else{ //Estoy en un vértice interno
                yPuntos[i] = (int) Math.round(yCentro + radio * Math.sin(anguloVertice));
            }
        }
        return yPuntos;
    }

    // public static void main(String[] args) {
    //     // Crear un árbol binario
    //     Arbol arbol = new Arbol();
    //     arbol.insertar(10);
    //     arbol.insertar(1);
    //     arbol.insertar(20);
    //     arbol.insertar(2);
    //     arbol.insertar(3);
    //     arbol.insertar(19);
    //     arbol.insertar(18);

    //     // Crear el panel de dibujo
    //     panelArbol panelArbol = new panelArbol(arbol);

    //     // Crear el JFrame y agregar el panel dentro de un JScrollPane
    //     JFrame frame = new JFrame("Árbol Binario");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(800, 600);
    //     frame.add(new JScrollPane(panelArbol));
    //     frame.setVisible(true);
    // }
}