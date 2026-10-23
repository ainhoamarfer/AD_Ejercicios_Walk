import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Ejercicio 1 · DirectoryStream
 * Muestra el nombre y el tamaño de todos los ficheros .csv de proyecto/datos, sin entrar en las subcarpetas. Al final, indica cuántos hay.
 * <p>
 * Prueba: apunta a proyecto en vez de proyecto/datos. ¿Aparecen los .csv de datos? ¿Por qué?
 */
public class Ej1 {

    public static void main(String[] args) throws IOException {

        Path carpeta = Path.of("proyecto/datos");


        try (DirectoryStream<Path> entradas = Files.newDirectoryStream(carpeta)) {
            for (Path entrada : entradas) {
                System.out.println(entrada.getFileName());
            }
        }
    }
}
