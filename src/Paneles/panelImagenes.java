//proyecto creado por Gaizka Medina Gordo
package Paneles;

import Componentes.SubImagen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

//clase panelImagenes que extiende el JPanel encargado de mostrar el puzle de 
//la partida
public class panelImagenes extends JPanel {

    //atributos de la clase
    private int filas;
    private int columnas;
    private final SubImagen[][] piezas;
    private SubImagen[][] puzle;
    private SubImagen piezaSeleccionada;
    private final Image imagen;
    int[] indiceOrdenado = new int[filas * columnas];
    int[] indiceMezclado = new int[filas * columnas];
    private final panelPartida panelPartida;

    //método constructor con sus variables pasadas por parámetro
    public panelImagenes(panelPartida panel,int filas, int columnas, Image imagen) {
                        
        //asignamos a las variables de la clase los datos pasados por parámetro
        this.panelPartida = panel;
        this.filas = filas;
        this.columnas = columnas;
        this.piezas = new SubImagen[filas][columnas];
        this.piezaSeleccionada = null;
        this.imagen = imagen;
        this.indiceOrdenado = new int[filas * columnas];
        this.indiceMezclado = new int[filas * columnas];
        
        //creamos el layout en función de las filas y las columnas del puzle
        setLayout(new GridLayout(filas, columnas));
        //método crearPuzle que inicializa el puzle
        crearPuzle();
        //método mezclarPiezas que desordena el puzle
        mezclarPiezas();

        //addMouseListener encargado de gestionar los eventos del intercambio
        //de piezas por el ratón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    SubImagen pieza = (SubImagen) e.getSource();
                    //si no se ha seleccionado una pieza, no ocurre nada
                    if (piezaSeleccionada == null) {
                        piezaSeleccionada = pieza;
                    } else {
                        //si se han seleccionado 2 piezas, se produce el 
                        //intercambio entre ellas mediante el método
                        //intercambiarPiezas
                        intercambiarPiezas(piezaSeleccionada, pieza);
                        piezaSeleccionada = null;
                        repaint();
                    }
                }
            }
        });
    }

    //método crearPuzle que crea la matriz de objetos SubImagen
    private void crearPuzle() {
        //instanciamos el ancho y alto de cada pieza
        int anchoPieza = imagen.getWidth(null) / columnas;
        int altoPieza = imagen.getHeight(null) / filas;
        //instanciamos los puntos
        int puntos = filas * columnas;
        //recorrido de filas y columnas para instanciar cada una de las piezas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //calculamos el valor de x e y
                int x = j * anchoPieza;
                int y = i * altoPieza;
                //creamos la imagen de la SubImagen actual
                BufferedImage imagenPieza = new BufferedImage(anchoPieza, altoPieza, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = imagenPieza.createGraphics();
                //dibujamos la imagen
                g.drawImage(imagen, 0, 0, anchoPieza, altoPieza, x, y, x + anchoPieza,y + altoPieza, null);
                //intanciamos el icono de la imagen mediante imagenPieza
                ImageIcon icono = new ImageIcon(imagenPieza);  
                //guardamos la SubImagen en la matriz de piezas con sus parámetros
                piezas[i][j] = new SubImagen(i, j, icono);

                //addActionListener de la SubImagen actual
                piezas[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SubImagen pieza = (SubImagen) e.getSource();
                        //si no se ha seleccionado una pieza, no ocurre nada
                        if (piezaSeleccionada == null) {
                            piezaSeleccionada = pieza;
                        } else {
                            //si se han seleccionado 2 piezas, se produce el 
                            //intercambio entre ellas mediante el método
                            //intercambiarPiezas
                            intercambiarPiezas(piezaSeleccionada, pieza);
                            piezaSeleccionada = null;
                            //comprobamos si el puzle está ordenado
                            if (esOrdenado()) {
                                //si está ordenado, se lo indicamos al usuario
                                JOptionPane.showMessageDialog(null, "¡Felicidades! Has resuelto el puzzle."
                                        + "Puntos obtenidos: " + puntos, "Partida Terminada",
                                        JOptionPane.INFORMATION_MESSAGE);
                                //finalizamos la partida con el método finJuego
                                //de la clase partida
                                panelPartida.finJuego();
                            }
                            repaint();
                        }
                    }
                });
                //insertamos la pieza en la matriz
                add(piezas[i][j]);
            }
        }
        //asignamos a la pieza actual su indice (este indice servirá para comprobar
        //si el puzle está ordenado
        int k = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                piezas[i][j].setIndice(k);
                k++;
            }
        }

        //insertamos el indice en el array de indices Ordenado y mezclado
        for (int i = 0; i < filas * columnas; i++) {
            indiceOrdenado[i] = i;
            indiceMezclado[i] = i;
        }
    }

    //método mezclarPiezas que desordena el puzle aplicando un algoritmo
    public void mezclarPiezas() {
        // Algoritmo Fisher-Yates para mezclar
        puzle = new SubImagen[filas][columnas];
        int totalPiezas = filas * columnas;
        for (int i = totalPiezas - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int fila1 = i / columnas;
            int columna1 = i % columnas;
            int fila2 = j / columnas;
            int columna2 = j % columnas;
            //intercambiamos las 2 piezas
            intercambiarPiezas(piezas[fila1][columna1], piezas[fila2][columna2]);
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //copiamos la pieza indivudalmente
                puzle[i][j] = new SubImagen(i, j, (ImageIcon) piezas[i][j].getIcon());
            }
        }
    }

    //método intecambiarPiezas que intercambia de posición las 2 piezas pasadas
    //por parámetro
    private void intercambiarPiezas(SubImagen pieza1, SubImagen pieza2) {
        //alamcenamos las filas,columnas e indice de ambas piezas
        int fila1 = pieza1.getFila();
        int columna1 = pieza1.getColumna();
        int fila2 = pieza2.getFila();
        int columna2 = pieza2.getColumna();
        int indice1 = pieza1.getIndice();
        int indice2 = pieza2.getIndice();
        //almacenamos los iconos de ambas piezas
        Icon icono1 = piezas[fila1][columna1].getIcon();
        Icon icono2 = piezas[fila2][columna2].getIcon();

        //intercambiamos los iconos
        piezas[fila1][columna1].setIcon(icono2);
        piezas[fila2][columna2].setIcon(icono1);

        //intercambiamos los indices
        piezas[fila1][columna1].setIndice(indice2);
        piezas[fila2][columna2].setIndice(indice1);

        //intercambiamos los indices de las piezas en el array de indices
        //mezclado
        int aux = indiceMezclado[indice1];
        indiceMezclado[indice1] = indiceMezclado[indice2];
        indiceMezclado[indice2] = aux;

        //intercambiamo las filas y columnas de las piezas
        piezas[fila1][columna1].setFila(fila1);
        piezas[fila1][columna1].setColumna(columna1);
        piezas[fila2][columna2].setFila(fila2);
        piezas[fila2][columna2].setColumna(columna2);
    }

    //método esOrdenado que comprueba si el puzle está ordenado.Esto se 
    //comprueba verificando si el array de indices Ordenado es igual al
    //array de indices Mezclado
    public boolean esOrdenado() {
        //booleano ordenado que devolveremos
        boolean ordenado = true;
        for (int i = 0; i < indiceOrdenado.length; i++) {
            //si algún indice del array Ordenado no coincide con el indice del
            //arrat Mezclado, el booleano se pondrá a falso
            if (indiceOrdenado[i] != indiceMezclado[i]) {
                ordenado = false;
            }
        }
        //si completa todo el recorrido sin instanciarse a falso, querrá decir 
        //el puzle está ordenado
        return ordenado;
    }

}
