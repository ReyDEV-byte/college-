/*
 * Ariela Ivón Corrales 1ro Info
 */
package buscarsator;
import java.util.Scanner;
/**
 *
 * @author Ariela
 */
public class BuscarSator {

    // Direcciones: (dx, dy)
    static int[][] direcciones = {
        {0, 1},   // derecha
        {0, -1},  // izquierda
        {1, 0},   // abajo
        {-1, 0},  // arriba
        {1, 1},   // diagonal abajo-derecha
        {1, -1},  // diagonal abajo-izquierda
        {-1, 1},  // diagonal arriba-derecha
        {-1, -1}  // diagonal arriba-izquierda
    };

    static String[] nombresDirecciones = {
        "derecha", "izquierda", "abajo", "arriba",
        "diagonal abajo-derecha", "diagonal abajo-izquierda",
        "diagonal arriba-derecha", "diagonal arriba-izquierda"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int cols = sc.nextInt();
        sc.nextLine();

        char[][] matriz = new char[filas][cols];

        System.out.println("Introduce cada fila como una cadena de letras (sin espacios):");
        for (int i = 0; i < filas; i++) {
            String linea = sc.nextLine().trim().toUpperCase();
            if (linea.length() != cols) {
                System.out.println("Error: la fila " + (i + 1) + " debe tener exactamente " + cols + " caracteres.");
                return;
            }
            matriz[i] = linea.toCharArray();
        }

        buscarPalabra(matriz, "SATOR");

        sc.close();
    }

    public static void buscarPalabra(char[][] matriz, String palabra) {
        int filas = matriz.length;
        int cols = matriz[0].length;
        int len = palabra.length();
        boolean encontrada = false;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                for (int d = 0; d < direcciones.length; d++) {
                    int dx = direcciones[d][0];
                    int dy = direcciones[d][1];

                    // Verificar límites
                    int finFila = i + (len - 1) * dx;
                    int finCol = j + (len - 1) * dy;

                    if (finFila < 0 || finFila >= filas || finCol < 0 || finCol >= cols) {
                        continue;
                    }

                    // Comparar letra por letra
                    boolean coincide = true;
                    for (int k = 0; k < len; k++) {
                        if (matriz[i + k * dx][j + k * dy] != palabra.charAt(k)) {
                            coincide = false;
                            break;
                        }
                    }

                    if (coincide) {
                        System.out.println("✅ Palabra '" + palabra + "' encontrada en posición (" + i + ", " + j + ") dirección: " + nombresDirecciones[d]);
                        encontrada = true;
                    }
                }
            }
        }

        if (!encontrada) {
            System.out.println("❌ La palabra '" + palabra + "' no se encontró en la matriz.");
        }
    }
}
