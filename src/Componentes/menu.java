//proyecto creado por Gaizka Medina Gordo
package Componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

//clase menu que extiende el JMenu donde insertaremos los diferentes componentes 
//JMenuItem que representarán las diferentes opciones del menú desplegable
public class menu extends JMenu {
    
    //método constructor
    public menu() {
        //inicialización
        super("MENÚ");
        setFont(new Font("arial", Font.BOLD, 13));
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        
        //declaración JMenuItem nuevaPartidaMenu
        JMenuItem nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
        //cambios en la visualización del componente
        nuevaPartidaMenu.setFont(new Font("arial", Font.BOLD, 13));
        nuevaPartidaMenu.setForeground(Color.WHITE);
        nuevaPartidaMenu.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        nuevaPartidaMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de menu
        add(nuevaPartidaMenu);
        
        //declaración JMenuItem clasificacionMenu
        JMenuItem clasificacionMenu = new JMenuItem("HISTORIAL GENERAL");
        //cambios en la visualización del componente
        clasificacionMenu.setFont(new Font("arial", Font.BOLD, 13));
        clasificacionMenu.setForeground(Color.WHITE);
        clasificacionMenu.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        clasificacionMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de menu
        add(clasificacionMenu);
        
        //declaración JMenuItem historialMenu
        JMenuItem historialMenu = new JMenuItem("HISTORIAL SELECTIVO");
        //cambios en la visualización del componente
        historialMenu.setFont(new Font("arial", Font.BOLD, 13));
        historialMenu.setForeground(Color.WHITE);
        historialMenu.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        historialMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de menu
        add(historialMenu);
        
        //declaración JMenuItem cambiardirectorioMenu
        JMenuItem cambiardirectorioMenu = new JMenuItem("CAMBIAR DIRECTORIO DE IMÁGENES");
        //cambios en la visualización del componente
        cambiardirectorioMenu.setFont(new Font("arial", Font.BOLD, 13));
        cambiardirectorioMenu.setForeground(Color.WHITE);
        cambiardirectorioMenu.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        cambiardirectorioMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de menu
        add(cambiardirectorioMenu);
        
        //declaración JMenuItem salirMenu
        JMenuItem salirMenu = new JMenuItem("SALIR");
        //cambios en la visualización del componente
        salirMenu.setFont(new Font("arial", Font.BOLD, 13));
        salirMenu.setForeground(Color.WHITE);
        salirMenu.setBackground(Color.BLACK);
        //implementamos el addActionListener manipuladorEventosFuncionalidades
        salirMenu.addActionListener(new manipuladorEventosFuncionalidades());
        //lo añadimos dentro de menu
        add(salirMenu);
    }
}

