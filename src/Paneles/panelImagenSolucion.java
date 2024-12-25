//proyecto creado por Gaizka Medina Gordo
package Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//clase panelImagenSolucion que extiende el JPanel de la solución de la partida
//del programa
public class panelImagenSolucion extends JPanel {
    
    //atributos final de la clase
    private final panelVisualizaciones panelVisualizaciones;
    private final ImageIcon imagenPuzle;

    //método constructor con sus variables pasadas por parámetro
    public panelImagenSolucion(panelVisualizaciones panelVisualizaciones, ImageIcon imagenPartida) {
        //asignamos a las variables de la clase los datos pasados por parámetro
        this.panelVisualizaciones = panelVisualizaciones;
        imagenPuzle = imagenPartida;
        setup();
        inicializacionComp();
    }

    public void setup() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
    }

    public void inicializacionComp() {
        //intanciamos la variable imagen a partir del icono pasado por parámetro
        Image imagen = imagenPuzle.getImage();
        //intanciamos el componente JLabel con la imagen
        JLabel imagenSolucion = new JLabel(new ImageIcon(imagen));
        //cambiamos el tamaño del JLabel
        setPreferredSize(new Dimension(new ImageIcon(imagen).getIconWidth(), 
                         new ImageIcon(imagen).getIconHeight()));
        //agregamos el JLabel al contenedor usando BorderLayout
        add(imagenSolucion, BorderLayout.CENTER);
        //instanciamos el componente JButton 
        JButton botonContinuar = new JButton("Continuar");
        //agregamos el botón al contenedeor usando BorderLayout
        botonContinuar.setFont(new Font("arial", Font.BOLD, 13));
        botonContinuar.setForeground(Color.WHITE);
        botonContinuar.setBackground(Color.BLACK);
        add(botonContinuar, BorderLayout.SOUTH);

        //addActionListener sobre el boton continuar
        botonContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //una vez pulsamos el botón continuar, volvemos al estado inicial
                panelVisualizaciones.estadoInicial();
            }
        });
    }
}
