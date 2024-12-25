//Proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.Partida;
import Ficheros.ficheroPartidasOut;
import Componentes.lecturaDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JFrame;

//clase panelPartida que extiende el JPanel encargado de mostrar los componentes
//relacionados con el estado NuevaPartida del programa
public class panelPartida extends JPanel {

    //instanciamos los diferentes atributos del programa
    private panelVisualizaciones panelVisualizaciones;
    private JPanel panelPartida;
    private JButton botonTerminarPartida = new JButton("ABANDONAR PARTIDA");
    private panelImagenes puzle;
    private static String rutaDirectorioImagenes = "imagenes/";
    private ImageIcon imagenPuzle;
    private int divHorizontales;
    private int divVerticales;
    public int puntos;
    public String nombre;
    public List<Partida> partidas;
    //declaración array de componentes String con los literales de los 
    //conceptos a introducir

    //método constructor con sus variables pasadas por parámetro
    public panelPartida(panelVisualizaciones panel, List<Partida> lista) {
        //asignamos a las variables de la clase los datos pasados por parámetro
        this.panelVisualizaciones = panel;
        this.partidas = lista;
        setup();
        inicializacionComp();
    }

    public void setup() {
        setLayout(new BorderLayout());
    }

    public void inicializacionComp() {
        //instanciamos un nuevo componente JFrame
        JFrame ventana = new JFrame();

        String[] datos = {"Introduce el nombre del jugador:",
            "Introduce el número de subdivisiones horizontal:",
            "Introduce el número de subdivisiones vertical: "};
        //lectura de los datos introducidos por el usuario a través del método
        //getDatosTexto() de la clase lecturaDatos
        datos = new lecturaDatos(ventana, datos).getDatosTexto();

        //comprobamos que los datos no sean nulos
        if (datos != null) {
            //inicialización de las variables pasadas por parámetro
            nombre = datos[0];
            divHorizontales = Integer.parseInt(datos[1]);
            divVerticales = Integer.parseInt(datos[2]);

            //método para seleccionar una imagen aleatoria del directorio
            seleccionarImagenAleatoria();
            //condición de que las subdivisiones sean mayores estrictas a 0
            if (divHorizontales > 0 && divVerticales > 0) {

                //inicialización del puzle con los datos recogidos y pasados por
                //parámetro a través de la clase panelImagenes
                puzle = new panelImagenes(this, divHorizontales, divVerticales,
                        imagenPuzle.getImage());

                //asignación de los puntos totales de la patida
                puntos = (divHorizontales * divVerticales);

                //diferentes excepciones sobre la introducción de datos
                botonTerminarPartida.setFont(new Font("arial", Font.BOLD, 13));
                botonTerminarPartida.setForeground(Color.WHITE);
                botonTerminarPartida.setBackground(Color.BLACK);

                //insertamos ambos componentes en el panel
                add(puzle, BorderLayout.CENTER);
                add(botonTerminarPartida, BorderLayout.SOUTH);

                //addActionListener del botón terminar partida
                botonTerminarPartida.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //si el usuario le da al botón partida, quiere decir que no ha 
                        //resuelto el puzle y su puntuación total será de 0 puntos
                        JOptionPane.showMessageDialog(null, "No has resuelto el puzzle. "
                                + "Puntos obtenidos: 0", "Partida Terminada", JOptionPane.INFORMATION_MESSAGE);
                        puntos = 0;
                        //saltamos al método finJuego
                        finJuego();
                    }
                });
            } else {
                entradaIncorrecta();
            }
        } else {
            entradaIncorrecta();
        }
    }

    //método finJuego que activa los métodos correspondientes a la finalización
    //de la partida actual
    public void finJuego() {
        //guardamos los datos del Jugador en el fichero resultados.dat
        //mediante el método guardarJugador
        guardarJugador(nombre, puntos);
        //cambiamos de estado en la clase panelVisualizaciones, ya que al
        //acabar la partida debemos mostrar la imagen resuelta
        panelVisualizaciones.estadoFinalPartida();
    }

    //método seleccionarImagenAleatoria que almacena en la variable imagenPuzle 
    //una de las imágenes del directorioImagenes en función de la variable
    //rutaDirectorioImagenes
    public void seleccionarImagenAleatoria() {
        try {
            File directorio = new File(rutaDirectorioImagenes);
            // Obtenemos una lista de archivos (File) en el directorio
            File[] archivos = directorio.listFiles();
            // Comprobamos que la lista de archivos no sea null ni esté vacía
            if (archivos != null && archivos.length > 0) {
                // Filtramos los archivos para obtener solo los archivos de imagen válidos.
                // En este caso, consideramos como archivos de imagen válidos aquellos
                // que tienen extensiones .jpg, .jpeg o .png
                List<File> archivosImagen = new ArrayList<>();
                for (File archivo : archivos) {
                    String nombreArchivo = archivo.getName().toLowerCase();
                    // Comprobamos que las imágenes terminen en .jpg, .jpeg o .png
                    if (nombreArchivo.endsWith(".jpg")
                            || nombreArchivo.endsWith(".jpeg")
                            || nombreArchivo.endsWith(".png")) {
                        // Si cumplen con el criterio, las insertamos en el ArrayList
                        archivosImagen.add(archivo);
                    }
                }

                // Comprobamos que no esté vacío
                if (!archivosImagen.isEmpty()) {
                    Random random = new Random();
                    // Con el método random, obtenemos un índice aleatorio de todos los posibles
                    int indiceAleatorio = random.nextInt(archivosImagen.size());
                    // Devolvemos la imagen con el índice aleatorio
                    File imagenSeleccionada = archivosImagen.get(indiceAleatorio);
                    // Guardamos esa imagen en la variable imagenPuzle con su directorio completo
                    imagenPuzle = new ImageIcon(imagenSeleccionada.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No se encontraron imágenes válidas en el directorio, por favor elige una ruta válida",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    errorFichero();
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se encontraron archivos en el directorio o el directorio no existe, por favor elige una ruta válida",
                        "Error", JOptionPane.ERROR_MESSAGE);
                errorFichero();
            }
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al seleccionar la imagen. Por favor, verifica la ruta del directorio",
                    "Error", JOptionPane.ERROR_MESSAGE);
            errorFichero();
        }
    }

    //método cambiarDirectorioImagenes para que el usuario pueda seleccionar
    //otro directorio 
    public static void cambiarDirectorioImagenes(String nuevaRuta) {
        rutaDirectorioImagenes = nuevaRuta;
    }

    //método obtenerRutaDirectorioImageens que devuelve la ruta del directorio
    //de imágenes actual
    public static String obtenerRutaDirectorioImagenes() {
        return rutaDirectorioImagenes;
    }

    //método getImagenPuzle que devuelve la imagen del puzle actual
    public ImageIcon getImagenPuzle() {
        return imagenPuzle;
    }

    //método guardarJugador que escribe dentro del fichero resultados.dat los
    //datos referentes a un Jugador
    public void guardarJugador(String nombre, int puntuacion) {

        //creamos la variable fechaCorrecta con el patrón correcto
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM:dd  HH:mm:ss ");

        LocalDateTime now = LocalDateTime.now();
        String fechaCorrecta = now.format(formatter);
        //creamos un objeto de la clase Partida con los datos de la partida actual
        Partida j = new Partida(nombre, fechaCorrecta, puntuacion);
        partidas.add(j);

        try {
            ficheroPartidasOut f = new ficheroPartidasOut();
            //escribimos en el fichero la lista de partidas mediante el método
            //escribirJugadores de la clase ficheroPartidasOut
            f.escribirPartidas(partidas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //método getLista que devuelve la lista actualizada de Partidas
    public List<Partida> getLista() {
        return partidas;
    }

    //método entradaIncorrecta que devuelve un mensaje por panel indicándonos
    //que ha habido un error en la inserción de datos
    private void entradaIncorrecta() {
        JOptionPane.showMessageDialog(panelPartida, //contenedor padre
                """
            No has introducido los datos correctamente,
            porfavor vulve a introducirlos""" //texto visualizado
        );
        //volvemos a la inicialización de la partidaF
        inicializacionComp();
    }

    //método errorFichero que se activará en caso de no encontrar imágenes en el
    //fichero válidas, el fichero esté vacío o simplemente no exista el fichero
    private void errorFichero() {
        panelVisualizaciones.estadoCambiarDirectorio();
        inicializacionComp();
    }
}