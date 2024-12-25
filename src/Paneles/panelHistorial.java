//proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.Partida;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//clase panelPartida que extiende el JPanel encargado de mostrar los componentes
//relacionados con el estado NuevaPartida del programa
public class panelHistorial extends JPanel {

    //atributos de la clase
    private final JTextArea areaVisualizacionResultados;
    private final List<Partida> partidas;
    private final panelVisualizaciones p;

    //método constructor con sus variables pasadas por parámetro
    public panelHistorial(panelVisualizaciones panel,List<Partida> lista) {

        setLayout(new CardLayout());
        areaVisualizacionResultados = new JTextArea(10, 20);
        areaVisualizacionResultados.setEditable(false);
        //asignamos a las variables de la clase los datos pasados por parámetro
        p = panel;
        partidas = lista;    
        mostrarHistorialPartidas();
        //insertamos el JTextArea en el panelHistorial
        add(areaVisualizacionResultados);

    }
    
    //método mostrarHistorialPartidas que muestra el JTextArea con los datos
    //de las partidas
    private void mostrarHistorialPartidas() {
        //Reiniciamos el texto del JTextArea
        areaVisualizacionResultados.setText("");
        //Encabezado del historial
        String encabezado = "HISTORIAL\n\n";
        // Espacios para centrar el texto
        String espacios = "                                                        ";

        // Aplicar formato al encabezado
        String encabezadoFormateado = espacios + encabezado;
        Font fontEncabezado = new Font(areaVisualizacionResultados.getFont().getName(), Font.BOLD, 24);
        areaVisualizacionResultados.setFont(fontEncabezado);
        areaVisualizacionResultados.append(encabezadoFormateado);

        //comprobación de si la lista de Partiads contiene partidas
        if (!partidas.isEmpty()) {
            //recorrido de toda la lista
            for (Partida partida : partidas) {
                //inserción de la partida mediante el método append de JTextArea
                //y el método toString del objeto Partida
                areaVisualizacionResultados.append(partida.toString() + "\n");
            }
        }else{
           // El archivo está vacío
            JOptionPane.showMessageDialog(this, "El fichero está vacío, primero"
                    + " debes de jugar almenos 1 partida."); 
        }
    }

    //método mostrarHistorialSelectivo que muestra el historial de partidas de
    //solo los objetos Partrida los cuales contengan el mismo nombre que la variable
    //variable pasada por parámetro
    public void mostrarHistorialSelectivo(String nombre) {
        //Reiniciamos el texto del JTextArea
        areaVisualizacionResultados.setText("");
        //Encabezado del historial
        String encabezado = "HISTORIAL\n\n";
        // Espacios para centrar el texto
        String espacios = "                                                        ";

        // Aplicar formato al encabezado
        String encabezadoFormateado = espacios + encabezado;
        Font fontEncabezado = new Font(areaVisualizacionResultados.getFont().getName(), Font.BOLD, 24);
        areaVisualizacionResultados.setFont(fontEncabezado);
        areaVisualizacionResultados.append(encabezadoFormateado);

        //variable booleana que nos indica si se ha encontrado almenos una 
        //partida donde el nombre del jugador coincida con el nombre pasado
        //por parámetro
        boolean jugadorEncontrado = false;

        //recorrido de la lista de partidas
        for (Partida partida : partidas) {
            //comprobación de si coincide mediante el método equals
            if (partida.getNombre().equals(nombre)) {
                //inserción de la partida mediante el método append de JTextArea
                //y el método toString del objeto Partida
                areaVisualizacionResultados.append(partida.toString() + "\n");
                //variable booleana a true
                jugadorEncontrado = true;
            }
        }
        //Si no se han encontrado partidas con el mismo nombre de jugador, se 
        //muestra por pantalla el mensaje indicándolo
        if (!jugadorEncontrado) {
            JOptionPane.showMessageDialog(this, "Ningún jugador coincide con el nombre solicitado.");
        }
    }
}
