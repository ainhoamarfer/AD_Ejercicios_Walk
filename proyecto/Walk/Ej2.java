import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ejercicio 2 · Files.walk (informe por extensión)
 * Recorre un árbol completo y genera un informe con cuántos ficheros hay de cada extensión,
 * por ejemplo csv: 2, md: 2, txt: 1… Los ficheros sin extensión se cuentan aparte.
 *
 * Pista: Files.walk devuelve un Stream<Path>;
 * filtra con Files::isRegularFile y agrupa con Collectors.groupingBy(..., Collectors.counting()).
 * Un TreeMap deja el informe ordenado. Cierra el stream con try-with-resources.
 */
public class Ej2 {

    public static void main(String[] args) throws IOException {

        Path raiz = Path.of("proyecto");
        Map<String, Long> informe;

        try(Stream<Path> rutas = Files.walk(raiz)){
            informe = rutas.filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(path -> {
                                String fileName = String.valueOf(path.getFileName());
                                String[] array = fileName.split("\\.");
                                return array[array.length - 1].toLowerCase();

                            }, TreeMap::new,  Collectors.counting()));
        }

        long sinExtension = informe.getOrDefault("", 0L);
        informe.remove("");
        informe.forEach((ext, n) -> System.out.println((ext + ": " + n)));
        System.out.println("(sin extension): " + sinExtension);
    }
}
