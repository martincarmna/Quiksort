import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Quiksort {
// Método público para ordenar
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Implementación recursiva
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Elegimos un pivote aleatorio para reducir probabilidad de peor caso
            int pivotIndex = partitionRandomPivot(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);   // ordena izquierda
            quickSort(arr, pivotIndex + 1, high);  // ordena derecha
        }
    }

    // Partición con pivote aleatorio (usa esquema Lomuto)
    private static int partitionRandomPivot(int[] arr, int low, int high) {
        // Intercambia un elemento aleatorio con el último (convertimos el último en pivote)
        int randomIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        swap(arr, randomIndex, high);
        return lomutoPartition(arr, low, high);
    }

    // Esquema de partición de Lomuto: usa arr[high] como pivote
    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // i señalará el último índice de la parte "menor o igual que pivote"
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // coloca el pivote en su lugar correcto (i+1)
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // Prueba / ejemplo
    public static void main(String[] args) {
        int[] nums = {7, 2, 1, 6, 8, 5};
        System.out.println("Antes: " + Arrays.toString(nums));
        quickSort(nums);
        System.out.println("Después: " + Arrays.toString(nums));
    }
}
