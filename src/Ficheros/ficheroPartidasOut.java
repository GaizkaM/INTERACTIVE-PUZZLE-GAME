//proyecto creado por Gaizka Medina Gordo
package Ficheros;

import Componentes.Partida;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

//clase ficheroPartidasOut encargado de insertar dentro del dichero correspondiente
//las diferentes clases Partida
public class ficheroPartidasOut {
    //atributo de la clase
    private final ObjectOutputStream oos;

    //método constructor
    public ficheroPartidasOut() throws FileNotFoundException, IOException {
        //instanciamos el ObjectOutputStream
        oos = new ObjectOutputStream(new FileOutputStream("resultados.dat"));
    }

    //método escribirPartidas encargado de escribir todos el array de objetos Jugadores
    //dentro del fichero
    public void escribirPartidas(List<Partida> partidas) throws IOException {

        //bucle for-each que recorre toda la lista de objetos Partida
        for (Partida p : partidas) {
            //escribimos dentro del fichero mediante el método writeObject
            oos.writeObject(p);
        }
    }
}
