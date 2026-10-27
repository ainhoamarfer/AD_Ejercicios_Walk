import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Ejercicio 3 · Files.walk con maxDepth
 * Muestra el contenido de una carpeta (sin la propia carpeta), indicando si cada elemento es [carpeta] o [fichero],
 * sin bajar a las subcarpetas.
 *
 * Prueba: cambia el 1 por 2 y observa qué ocurre.
 */
public class Ej3 {

    static void main() throws IOException {
        Path raiz = Path.of("proyecto");

        try(DirectoryStream<Path> entradas = Files.newDirectoryStream(raiz)){
            for (Path entrada : entradas){

            }
        }
    }



}
