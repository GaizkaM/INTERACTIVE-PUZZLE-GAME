//Proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.Partida;
import Componentes.lecturaDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

//panelVisualizaciones dondre trataremos los cambios de JPanel en función de los
//diferentes estados del programa
public class panelVisualizaciones extends JPanel{

    private panelContenidos p;
    //instanciamos los diferentes paneles
    private JPanel panelActual;
    private panelPartida panelpartida;
    private panelHistorial panelhistorial;
    private ImageIcon imagenPartida = null;
    //lista de objetos Partida para ir almacenando las diferentes partidas a 
    //medida que se vayan jugando
    private final List<Partida> listaJugadores = new ArrayList<>();
    
    //método constructor donde se le asigna el JPanel panelContenidos padre
    public panelVisualizaciones(panelContenidos panel)throws Exception {
        p = panel;
        setup();
        estadoInicial();
    }

    //inicizalización de panelVisualizaciones
    public void setup() {
        String nombreArchivo = "resultados.dat";
        //borramos los datos que habia dentro del fichero para que solo se 
        //almacenen los datos de las partidas jugadas en el programa actual
        try (FileOutputStream fos = new FileOutputStream(nombreArchivo)) {
            // No se escribe ningún dato en el archivo para vaciarlo
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        setSize(800, 600);
        setBackground(Color.BLACK);
    }

    //estadoIncial de panelVisualizaciones
    public void estadoInicial() {
        //borramos todos los paneles en caso de venir de otro estado anterior
        removeAll();
        //asignamos a panelActual en panelStandBy
        panelActual = new panelStandby();
        //lo insertamos en panelVisualizaciones
        add(panelActual, BorderLayout.CENTER);
        revalidate();
        repaint();
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.INICIAL);
    }
    
    //estadoNuevaPartida de panelVisualizaciones
    public void estadoNuevaPartida() {
        //borramos el panel anterior
        removeAll();
        //asignamos a panelPartida un nuevo panelPartida
        panelpartida = new panelPartida(this, listaJugadores);
        //asignamos a panelActual el nuevo panelPartida
        panelActual = panelpartida;
        //extraemos la imagen de la partida actual para utilizarla posteriormente
        imagenPartida = panelpartida.getImagenPuzle();
        //insertamos el panelActual en panelVisualizaciones
        add(panelActual, BorderLayout.CENTER);
        revalidate();
        repaint();
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.NUEVA_PARTIDA);
    }
    
    //estadoFinalPartida de panelVisualizaciones
    public void estadoFinalPartida() {
        //borramos el panel anterior
        removeAll();
        //asignamos al panelActual un nuevo panelImagenSolucion con la imagenPartida
        //del panelpartida
        panelActual = new panelImagenSolucion(this, imagenPartida);
        //insertamos el panelActual en panelVisualizaciones
        add(panelActual, BorderLayout.CENTER);
        revalidate();
        repaint();
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.FIN_PARTIDA); 
    }

    //estadoHistorialGeneral de panelVisualizaciones
    public void estadoHistorialGeneral() {
        //borramos el panel anterior
        removeAll();
        //asignamos a panelhistorial un nuevo panelHistorial
        panelhistorial = new panelHistorial(this, listaJugadores);
        //asignamos a panelActual el panelhistorial
        panelActual = panelhistorial;
        //insertamos el panelActual en panelVisualizaciones
        add(panelActual, BorderLayout.CENTER);
        revalidate();
        repaint();
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.HISTORIAL_GENERAL); 
    }
    
    //estadoHistorialSelectivo de panelVisualizaciones
    public void estadoHistorialSelectivo() {
        //borramos el panel anterior
        removeAll();
        //inicializamos el mensaje que será mostrado al usuario
        String[] dato = {"Introduce el nombre del jugador:"};
        //instanciamos un nuevo JFrame
        JFrame ventana = new JFrame();
        //mediante el método lecturaDatos, creamos un nuevo panel JDialog para
        //pedirle al usuario un dato específico. En este caso, se le pedirá
        //al usuario un nombre para el método historialSelectivo
        dato = new lecturaDatos(ventana, dato).getDatosTexto();
        //asignamos a panelhistorial un nuevo panelHistorial
        panelhistorial = new panelHistorial(this, listaJugadores);
        //llamamos al método mostrarHistorialSelectivo con el dato escrito por el
        //usuario pasado por parámetro
        panelhistorial.mostrarHistorialSelectivo(dato[0]);
        //asignamos a panelActual el panelhistorial
        panelActual = panelhistorial;
        //insertamos el panelActual en panelVisualizaciones
        add(panelActual, BorderLayout.CENTER);
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.HISTORIAL_SELECTIVO);
    }

    //estadoCambiarDirectorio de panelVisualizaciones
    public void estadoCambiarDirectorio() {
        //instanciamos un nuevo componente JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        //lo asignamos a solo directorios
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //instanciamos el entero seleccion que será el valor devuelto por la
        //opción seleccionada del usuario
        int seleccion = fileChooser.showOpenDialog(null);
        //comprobación de que el directorio elegido por el usuario es válido
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = fileChooser.getSelectedFile();
            //creamos la variable nuevaRuta que será la ruta del nuevo directorio
            String nuevaRuta = directorioSeleccionado.getAbsolutePath();
            //cambiamos el directorio de la selección de imágenes a través del
            //método cambiarDirectorioImagenes de la clase panelpartida
            panelpartida.cambiarDirectorioImagenes(nuevaRuta);
        }
        //actualizamos el estado de panelContenidos
        p.setEstado(Componentes.Estado.HISTORIAL_SELECTIVO);
    }
}