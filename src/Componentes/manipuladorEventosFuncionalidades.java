//proyecto creado por Gaizka Medina Gordo
package Componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import practicafinal_2023.PRACTICAFINAL_2023;

//clase manipuladorEventosFuncionalidades que implementa el ActionListener 
//encargado de la manipulzación de los diferentes estados del programa en 
//función de los diferentes botones pulsados, tanto del JPanel panelBotones como
//del JMenu menuBotones
public class manipuladorEventosFuncionalidades implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //caso de nueva partida 
            case "NUEVA PARTIDA":
                //si nos encontramos en el estado de Nueva Partida o Final Partida, no
                //podremos cambiar de estado hasta finalizar esa partida. Por lo tanto,
                //se lo indicamos al usuario mediante un JOptionPane
                if (PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.NUEVA_PARTIDA
                        || PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.FIN_PARTIDA) {
                    JOptionPane.showMessageDialog(null,
                            "Debes terminar la partida actual antes de iniciar otra partida.");
                } else {
                    //en caso contrario actualizamos el estado
                    PRACTICAFINAL_2023.panelContenidos.estadoNuevaPartida();
                }
                break;
            //casos tanto de historial general como selectivo
            case "HISTORIAL GENERAL":
            case "HISTORIAL SELECTIVO":
                //si nos encontramos en el estado de Nueva Partida o Final Partida, no
                //podremos cambiar de estado hasta finalizar esa partida. Por lo tanto,
                //se lo indicamos al usuario mediante un JOptionPane
                if (PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.NUEVA_PARTIDA
                        || PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.FIN_PARTIDA) {
                    JOptionPane.showMessageDialog(null, "Debes terminar la partida actual antes de acceder al historial.");
                } else {
                    //verificamos el tipo de historial
                    if (e.getActionCommand().equals("HISTORIAL GENERAL")) {
                        //actualizamos el estado
                        PRACTICAFINAL_2023.panelContenidos.estadoHistorialGeneral();
                    } else {
                        //actualizamos el estado
                        PRACTICAFINAL_2023.panelContenidos.estadoHistorialSelectivo();
                    }
                }
                break;
            //caso de cambio de directorio de imágenes
            case "CAMBIAR DIRECTORIO DE IMÁGENES":
                //si nos encontramos en el estado de Nueva Partida o Final Partida, no
                //podremos cambiar de estado hasta finalizar esa partida. Por lo tanto,
                //se lo indicamos al usuario mediante un JOptionPane
                if (PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.NUEVA_PARTIDA
                        || PRACTICAFINAL_2023.panelContenidos.getEstado() == Estado.FIN_PARTIDA) {
                    JOptionPane.showMessageDialog(null,
                            "Debes terminar la partida actual antes de cambiar el directorio de imágenes.");
                } else {
                    //en caso contrario actualizamos el estado
                    PRACTICAFINAL_2023.panelContenidos.estadoCambiarDirectorio();
                }
                break;
            //caso salir 
            case "SALIR":
                //Finaliza la ejecucion del programa
                //este estado es el único que puede suceder independientemente del
                //estado en el que nos encontremos
                System.exit(0);
                break;
        }
    }
}
