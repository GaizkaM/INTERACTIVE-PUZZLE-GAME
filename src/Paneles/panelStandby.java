//proyecto creado por Gaizka Medina Gordo
package Paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//panelStandBy donde se inserta la imagen con el logo de la UIB para el panel
//inicial del programa
public class panelStandby extends JPanel {

    private Image img;

    public panelStandby() {
        setup();
        inicializacionComp();
    }

    public void setup() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
        img = new ImageIcon("UIB.jpg").getImage();
    }

    public void inicializacionComp() {
        setLayout(new BorderLayout()); 
        JLabel imagenUIB = new JLabel();
        ImageIcon imgIcon = new ImageIcon(img);
        //insertamos la imagen en el JLabel
        imagenUIB.setIcon(imgIcon);
        //insertamos el JLabel en el panel
        add(imagenUIB, BorderLayout.CENTER);
    }
}