import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Ejercicio 1 · DirectoryStream
 * Muestra el nombre y el tamaño de todos los ficheros .csv de proyecto/datos, sin entrar en las subcarpetas. Al final, indica cuántos hay.
 * <p>
 * Prueba: apunta a proyecto en vez de proyecto/datos. ¿Aparecen los .csv de datos? ¿Por qué?
 */
public class Ej1 {

    public static void main(String[] args) throws IOException {

        Path carpeta = Path.of("proyecto/datos");

        int numFicheros = 0;

        try (DirectoryStream<Path> entradas = Files.newDirectoryStream(carpeta, "*.csv")) {
            for (Path entrada : entradas) {
                if (!Files.isRegularFile(entrada)) continue; //asegura que sea un fichero y no otra cosa

                long tamano = Files.size(entrada);
                numFicheros++;

                System.out.println(entrada.getFileName() + " - " + tamano + " bytes");
            }
            System.out.println("Hay " + numFicheros + " ficheros");
        }
    }
}
