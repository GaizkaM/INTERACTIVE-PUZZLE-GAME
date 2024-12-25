//Proyecto creado por Gaizka Medina Gordo
package practicafinal_2023;

import Paneles.panelContenidos;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class PRACTICAFINAL_2023 extends JFrame {

    // panel que contiene las interficies
    public static final panelContenidos panelContenidos = new panelContenidos();

    //método main
    public static void main(String[] args) {
        new PRACTICAFINAL_2023().setVisible(true);
    }
    
    //método constructor que inicializa el JFrame del programa
    public PRACTICAFINAL_2023() {
        setTitle("PRACTICA FINAL - PROGRAMACION II - 2022-2023 - UIB"); 
        setSize(1200, 750);
        setResizable(false);
        setLayout(new BorderLayout()); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //asignación a panelContenidos del panel de contenidos del JFrame
        setContentPane(panelContenidos); 
    }
}
