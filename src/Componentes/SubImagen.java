//proyecto creado por Gaizka Medina Gordo
package Componentes;

import javax.swing.*;

//clase SubImagen que extiende el JButton que corresponderá a una SubImagen del puzle
//del programa
public class SubImagen extends JButton {

    //atributos de la clase
    private int fila;
    private int columna;
    private int indice;
    private ImageIcon imagen;

    //método constructor con las variables pasadas por parámetro
    public SubImagen(int fila, int columna, ImageIcon imagen) {
        //asignamos a las variables de la clase los datos pasados por parámetro
        this.fila = fila;
        this.columna = columna;
        this.imagen = imagen;
        setIcon(imagen); 
    }

    //métodos get y set de las variables
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
}
