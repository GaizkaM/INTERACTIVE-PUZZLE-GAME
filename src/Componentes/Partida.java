//proyecto creado por Gaizka Medina Gordo
package Componentes;

import java.io.Serializable;

//clase Partida que corresponderá a objetos Partida, generados cada vez que se 
//complete una partida del programa
public class Partida implements Serializable{
    
    //atributos final de la clase
    private final String nombre;
    private final String fecha;
    private final int puntuacion;
    
    //método constructor con las variables pasadas por parámetro
    public Partida(String nombreJugador, String fecha, int puntuacion) {
        //asignamos a las variables de la clase los datos pasados por parámetro
        this.nombre = nombreJugador;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }
    
    //métodos get de la clase
    public String getNombre() {
        return nombre;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    //método toString para crear las líneas que serán mostradas en el historial
    //de partidas
    public String toString(){
        return ("JUGADOR: "+nombre+"        - FECHA: "+fecha+"          "
                +"-PUNTOS: " +puntuacion+" puntos.");
    }
}