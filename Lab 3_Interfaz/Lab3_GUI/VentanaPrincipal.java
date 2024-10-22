import javax.swing.*;
/**
 * VentanaPrincipal
 *
 * @author Alejandro Guerra Rodríguez
 * @version 22/10/2024
 */
public class VentanaPrincipal extends JFrame //Heredo la clase JFrame
/**
 * Mi clase VentanaPrincipal va a tener todos los métodos de la clase JFrame (de la biblioteca javax.swing)
 * junto con los métodos que yo le decida agregar.
 * 
 * Un Frame es una ventana "top-level" que tiene un títiulo y un borde
 * https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
 */
{
    //Método constructor
    public VentanaPrincipal(){
        /**
         * Parte 1:
         */

        //Establece el título del frame al string indicado:
        setTitle("Formulario de Usuario");
        //Define el ancho y alto:
        setSize(800, 600);
        //Comportamiento de salida: Cerrar al clickear el botón de salida
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Centro la ventana en la pantalla:
        setLocationRelativeTo(null);

        /**
         * Parte 2:
         */

        //Añado el menú:
        //menuBar es la barra vacía de un menú en el frame
        JMenuBar menuBar = new JMenuBar();
        //menuArchivo es una opción del menú llamada Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        //Estos ítems son opciones dipsonibles al seleccionar la opción Archivo
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        //Agrego las opciones a la opción Archivo
        menuArchivo.add(nuevoItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();     //Separador visual
        menuArchivo.add(salirItem);
        //Añado la opción archivo junto con todas sus opciones, a la barra del menú
        menuBar.add(menuArchivo);
        //Esto no termino de entender qué hace
        setJMenuBar(menuBar);

        //-------------------------------------------------------------------
        //Modificaciones personales para probar:
        JMenu menuVer = new JMenu("Ver");
        JMenuItem debuggerItem = new JMenuItem("Mostrar Depurador");
        JMenuItem terminalItem = new JMenuItem("Mostrar Terminal");
        JMenuItem buscarItem = new JMenuItem("Buscar Elemento");

        menuVer.add(debuggerItem);
        menuVer.addSeparator();
        menuVer.add(terminalItem);
        menuVer.addSeparator();
        menuVer.add(buscarItem);
        menuBar.add(menuVer);
        setJMenuBar(menuBar);
        //-------------------------------------------------------------------

        /**
         * Parte 3:
         */
        //'salirItem' es el item que creé anteriormente
        salirItem.addActionListener(e -> System.exit(0));
        




    }
    public static void main(String[] args){
        //Creo el objeto ventana
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}