//Proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.Estado;
import Componentes.barraMenu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

//panelContenidos donde insertaremos todos los componentes del programa
public class panelContenidos extends JPanel {

    //componentes final del programa
    private panelVisualizaciones panelVisualizaciones;
    private barraMenu barraMenu;
    private panelBotones panelBotones;
    private final JSplitPane separador1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    private final JSplitPane separador2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private final JSplitPane separador3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    //variable de instancia para almacenar el estado actual
    private Estado estadoActual;

    public panelContenidos() {
        try {
            setup();

            //a cada componente lo inicializamos como una nueva clase
            this.panelVisualizaciones = new panelVisualizaciones(this);
            this.barraMenu = new barraMenu();
            this.panelBotones = new panelBotones();
            //inicializamos los componentes
            inicializacionComp();
            //inicializamos el estado actual al estado INICIAL
            estadoActual = Estado.INICIAL;
        } catch (Exception e) {
            // Manejar la excepción aquí o mostrar un mensaje de error adecuado
            e.getMessage();
        }
    }

    public void setup() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(850, 600));
    }

    //inicialización de los componentes dentro de los separadores
    public void inicializacionComp() {
        separador1.setTopComponent(barraMenu);
        separador1.setDividerLocation(100);
        separador1.setEnabled(false);
        add(separador1, BorderLayout.NORTH);

        separador2.setLeftComponent(panelBotones);
        separador2.setRightComponent(panelVisualizaciones);
        separador2.setDividerLocation(150);
        separador2.setEnabled(false);
        separador2.setResizeWeight(0.0); // Establecer peso de redimensionamiento
        add(separador2, BorderLayout.CENTER);

        add(separador3, BorderLayout.SOUTH);
    }

    //estadoNuevaPartida del panelContenidos
    public void estadoNuevaPartida() {
        //cambiamos el estado de panelVisualizaciones
        panelVisualizaciones.estadoNuevaPartida();
        //lo volvemos a insertar dentro del separador
        separador2.setRightComponent(panelVisualizaciones);
        //actualizamos el estado actual
        estadoActual = Estado.NUEVA_PARTIDA;
    }

    //estadoHistorialGeneral del panelContenidos
    public void estadoHistorialGeneral() {
        //cambiamos el estado de panelVisualizaciones
        panelVisualizaciones.estadoHistorialGeneral();
        //lo volvemos a insertar dentro del separador
        separador2.setRightComponent(panelVisualizaciones);
        //actualizamos el estado actual
        estadoActual = Estado.HISTORIAL_GENERAL;
    }

    //estadoHistorialSelectivo del panelContenidos
    public void estadoHistorialSelectivo() {
        //cambiamos el estado de panelVisualizaciones
        panelVisualizaciones.estadoHistorialSelectivo();
        //lo volvemos a insertar dentro del separador
        separador2.setRightComponent(panelVisualizaciones);
        //actualizamos el estado actual
        estadoActual = Estado.HISTORIAL_SELECTIVO;
    }

    //estadoCambiarDirectorio del panelContenidos
    public void estadoCambiarDirectorio() {
        //cambiamos el estado de panelVisualizaciones
        panelVisualizaciones.estadoCambiarDirectorio();
        //lo volvemos a insertar dentro del separador
        separador2.setRightComponent(panelVisualizaciones);
        //actualizamos el estado actual
        estadoActual = Estado.CAMBIAR_DIRECTORIO;
    }

    //métodos get y set del estadoActual para tratar los diferentes casos
    //que podemos encontrarnos
    public Estado getEstado() {
        return estadoActual;
    }

    public void setEstado(Estado s) {
        estadoActual = s;
    }

}
