//proyecto creado por Gaizka Medina Gordo
package Componentes;

import java.awt.Color;
import javax.swing.JMenuBar;

//clase barraMenu que extiende el JMenuBar donde se implementará el menú del 
//programa
public class barraMenu extends JMenuBar{
    
    //método constructor
    public barraMenu(){
        //implementación del menú dentro del JMenuBar
        menu Menu = new menu();
        //insertamos el menu dentro de barraMenu
        add(Menu);
        setVisible(true);
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
    }
}
