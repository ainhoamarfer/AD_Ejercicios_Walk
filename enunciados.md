# Ejercicios · Recorrido de árboles de directorios

Soluciones de referencia en esta misma carpeta (`Ejercicio1.java` … `Ejercicio5.java`).
Todos trabajan por defecto sobre la carpeta `proyecto/` que hay junto a este fichero (ejecútalos desde aquí). Los ejercicios 1 a 4 aceptan otra carpeta como argumento (`java Ejercicio1.java <carpeta>`); el 5 la pide por consola (Intro = `proyecto`).

## Ejercicio 1 · DirectoryStream
Muestra el nombre y el tamaño de todos los ficheros `.csv` de `proyecto/datos`, sin entrar en las subcarpetas. Al final, indica cuántos hay.

*Prueba:* apunta a `proyecto` en vez de `proyecto/datos`. ¿Aparecen los `.csv` de `datos`? ¿Por qué?

## Ejercicio 2 · Files.walk (informe por extensión)
Recorre un árbol completo y genera un informe con cuántos ficheros hay de cada extensión, por ejemplo `csv: 2`, `md: 2`, `txt: 1`… Los ficheros sin extensión se cuentan aparte.

*Pista:* `Files.walk` devuelve un `Stream<Path>`; filtra con `Files::isRegularFile` y agrupa con `Collectors.groupingBy(..., Collectors.counting())`. Un `TreeMap` deja el informe ordenado. Cierra el stream con `try-with-resources`.

## Ejercicio 3 · Files.walk con maxDepth
Muestra el contenido de una carpeta (sin la propia carpeta), indicando si cada elemento es `[carpeta]` o `[fichero]`, sin bajar a las subcarpetas.

*Prueba:* cambia el `1` por `2` y observa qué ocurre.

## Ejercicio 4 · walkFileTree
Borra una carpeta con todo su contenido (por defecto, una copia de `proyecto` llamada `copia`, que el propio programa crea antes con otro `walkFileTree`). Muestra por pantalla `ENTRA` al entrar en cada carpeta, `BORRA` en cada fichero y `SALE` al terminar una carpeta (que es cuando se borra, porque ya está vacía).


## Ejercicio 5 · Gestor de ficheros por consola
Programa interactivo que pide, uno a uno:

1. La **carpeta de origen**.
2. La **acción**: `listar`, `contar`, `copiar` o `borrar`.
3. El **patrón glob** que deben cumplir los ficheros (`*.txt`, `*.{jpg,png}`, `**/informe*`…).
4. Si la acción es `copiar`, la **carpeta de destino**; si es `borrar`, una **confirmación** (s/n).

Recorre todo el árbol y aplica la acción solo a los ficheros que cumplan el patrón. Al final muestra cuántos coincidían.

*Casos que debe resolver:*
- Acción desconocida o carpeta inexistente: avisar y terminar.
- `*.txt` casa con el nombre del fichero; `**.md` o `a/*.txt` casan con la ruta relativa a la raíz (`**/*.txt` no casa con los ficheros de la raíz).
- Con `copiar`, crear la carpeta de destino si no existe.

## Carpeta de prueba
`proyecto/` (junto a este fichero) es el árbol que se ve en la presentación:

```
proyecto/
├── datos/    ciudades.csv · notas.csv · informe.txt
├── docs/     guia.md · img/logo.png
├── README.md
└── pom.xml
```


