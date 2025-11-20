import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 // =====================
    // PERSISTENCIA
    // =====================

    public static int[] leerNumeros(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        List<Integer> lista = new ArrayList<>();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("\\s+");
            for (String p : partes) {
                if (!p.isEmpty()) lista.add(Integer.parseInt(p));
            }
        }
        br.close();

        // Convertimos la lista a arreglo
        int[] arr = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) arr[i] = lista.get(i);
        return arr;
    }

    public static void guardarNumeros(String archivo, int[] numeros) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (int n : numeros) {
            bw.write(n + " ");
        }

        bw.close();
    }
    // =====================
    // QUICKSORT
    // =====================

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    // Partición clásica de Lomuto
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivote último elemento
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }


















}
