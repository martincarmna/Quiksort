import java.util.Arrays;

public class Quiksort {
     public static void main(String[] args) {
        String archivo = "numeros.txt";

        try {
            // 1. Leer números del archivo
            int[] numeros = leerNumeros(archivo);

            System.out.println("Datos cargados:");
            System.out.println(Arrays.toString(numeros));

            // 2. Ordenar usando QuickSort
            quickSort(numeros, 0, numeros.length - 1);

            System.out.println("Datos ordenados:");
            System.out.println(Arrays.toString(numeros));

            // 3. Guardarlos ordenados
            guardarNumeros("numeros_ordenados.txt", numeros);

            System.out.println("Se guardaron en: numeros_ordenados.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
