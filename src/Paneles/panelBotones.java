//proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.manipuladorEventosFuncionalidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

//clase panelBotones que extiende el JPanel donde insertaremos los diferentes 
//botones del programa 
public class panelBotones extends JPanel {
    
    //método constructor
    public panelBotones() {
        setup();
        inicializacionComp();
    }

    //asignamos el GridLayout
    private void setup() {
        setLayout(new GridLayout(4, 1));
    }

    //inicialización de los componentes
    private void inicializacionComp() {

        //declaramos el componente JButton nuevaPartidaBoton
        JButton nuevaPartidaBoton = new JButton("NUEVA PARTIDA");
        //cambios en la visualización del componente
        nuevaPartidaBoton.setFont(new Font("arial", Font.BOLD, 10));
        nuevaPartidaBoton.setForeground(Color.WHITE);
        nuevaPartidaBoton.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        nuevaPartidaBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de panelBotones
        add(nuevaPartidaBoton);

        //declaramos el componente JButton clasificacionBoton
        JButton clasificacionBoton = new JButton("HISTORIAL GENERAL");
        //cambios en la visualización del componente
        clasificacionBoton.setFont(new Font("arial", Font.BOLD, 10));
        clasificacionBoton.setForeground(Color.WHITE);
        clasificacionBoton.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        clasificacionBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de panelBotones
        add(clasificacionBoton);

        //declaramos el componente JButton historialBoton
        JButton historialBoton = new JButton("HISTORIAL SELECTIVO");
        //cambios en la visualización del componente
        historialBoton.setFont(new Font("arial", Font.BOLD, 10));
        historialBoton.setForeground(Color.WHITE);
        historialBoton.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        historialBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de panelBotones
        add(historialBoton);

        //declaramos el componente JButton salirBoton
        JButton salirBoton = new JButton("SALIR");
        //cambios en la visualización del componente
        salirBoton.setFont(new Font("arial", Font.BOLD, 10));
        salirBoton.setForeground(Color.WHITE);
        salirBoton.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        salirBoton.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de panelBotones
        add(salirBoton);
    }
}
