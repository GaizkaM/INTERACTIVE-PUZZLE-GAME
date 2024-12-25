//proyecto creado por Gaizka Medina Gordo
package Componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//método lecturaDatos utilizado para crear un componente JDialog con los atributos
//pasados por parámetro donde el usuario insertará los datos que le pidamos. El 
//contenido de lo escrito por el usuario será guardado en un array de variables
//String.
public class lecturaDatos extends JDialog {

    // Atributo array de componentes JTextField que representarán los valores
    // introducidos a través del contenedor JDialog
    private JTextField[] datos;
    // Atributo entero que representa el número de valores a introducir a través
    // del contenedor JDialog
    private int numeroValores = 0;

    // MÉTODO CONSTRUCTOR
    // El parámetro frame representa el contenedor JFrame desde el que se le ha
    // llevado a cabo la instanciación, y el parámetro campos representan los
    // literales de los conceptos demandados para introducir
    public lecturaDatos(JFrame frame, String[] campos) {
        super(frame, true);
        setTitle("INTRODUCCIÓN DATOS");
        //numeroValores representará el total de valores que el usuario debe de
        //pasar por teclado
        numeroValores = campos.length;
        //creación del contenedor panelContenidos donde insertaremos todos los
        //componentes
        Container panelContenidos = getContentPane();
        //le añadimos un GridLayout()
        panelContenidos.setLayout(new GridLayout(numeroValores + 1, 1));
        datos = new JTextField[numeroValores];
        JLabel[] conceptos = new JLabel[numeroValores];
        JPanel[] paneles = new JPanel[numeroValores];

        //bucle para crear los apartados de inserción de datos
        for (int i = 0; i < datos.length; i++) {
            // Instanciación de los diferentes arrays
            conceptos[i] = new JLabel(campos[i]);
            datos[i] = new JTextField(20);
            datos[i].setText("");
            paneles[i] = new JPanel();
            paneles[i].setLayout(new FlowLayout(FlowLayout.LEFT));

            // Aplicar fondo negro y letras blancas solo a los paneles de etiquetas
            paneles[i].setBackground(Color.WHITE);
            conceptos[i].setForeground(Color.BLACK);

            // Introducción en el contenedor JPanel indice-ésimo de la
            //componente JLabel indice-ésima y de la componente JTextField
            //indice-ésima
            paneles[i].add(conceptos[i]);
            paneles[i].add(datos[i]);

            // Introducción del contenedor JPanel indice-ésimo en el
            //panel de contenidos del contenedor JDialog
            panelContenidos.add(paneles[i]);
        }

        // Declaración componente JButton salirBoton
        JButton salirBoton = new JButton("CONFIRMAR");

        // Establecer el fondo negro y las letras blancas al botón
        salirBoton.setBackground(Color.BLACK);
        salirBoton.setForeground(Color.WHITE);

        // Introducción de la componente JButton salirBoton en el panel
        // de contenidos del contenedor JDialog
        panelContenidos.add(salirBoton);
        // Asignación e implementación del gestor de eventos asociado a la
        // componente JButton salirBoton
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pone a FALSE la visibilidad del contenedor JDialog
                setVisible(false);
            }
        });

        // Ajustar el tamaño del contenedor JDialog en función del número de valores a
        // introducir
        int dialogWidth = 300;
        int dialogHeight = (numeroValores + 1) * 70;
        setSize(dialogWidth, dialogHeight);

        // Centrar ventana contenedor JDialog en el centro de la ventana de la aplicación
        // desde donde se ha instanciado
        setLocationRelativeTo(frame);
        // Pone a TRUE la visibilidad del contenedor JDialog
        setVisible(true);
    }

    // Método que lleva a cabo la devolución de los datos introducidos a través
    //del contenedor JDialog
    public String[] getDatosTexto() {
        String[] datosIntroducidos = new String[numeroValores];
        for (int indice = 0; indice < datosIntroducidos.length; indice++) {
            // Asignamos a la componente indice del array datosIntroducidos el
            // String introducido en la componente JTextField del array datos

            datosIntroducidos[indice] = (datos[indice].getText());
            if (datos[indice].getText().equals("")) {
                return null;
            }
        }
        return datosIntroducidos;
    }
}
