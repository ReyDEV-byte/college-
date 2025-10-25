/*
 * Ariela Ivón Corrales 1ro Info
 */
package dijkstracaminominimo;
import java.util.*;
/**
 *
 * @author Ariela
 */
public class DijkstraCaminoMinimo {
    private static final int INF = Integer.MAX_VALUE;
    private static Scanner scanner = new Scanner(System.in);
    
    // Implementación del algoritmo de Dijkstra
    public static CaminoResultado dijkstraConCamino(int[][] grafo, int origen, int destino) {
        int n = grafo.length;
        int[] distancias = new int[n];
        int[] predecesores = new int[n];
        boolean[] visitado = new boolean[n];
        
        Arrays.fill(distancias, INF);
        Arrays.fill(predecesores, -1);
        Arrays.fill(visitado, false);
        
        distancias[origen] = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && (u == -1 || distancias[j] < distancias[u])) {
                    u = j;
                }
            }
            
            if (distancias[u] == INF) break;
            if (u == destino) break;
            
            visitado[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != INF && distancias[u] != INF) {
                    int nuevaDistancia = distancias[u] + grafo[u][v];
                    if (nuevaDistancia < distancias[v]) {
                        distancias[v] = nuevaDistancia;
                        predecesores[v] = u;
                    }
                }
            }
        }
        
        return new CaminoResultado(distancias, predecesores);
    }
    
    // Clase para almacenar el resultado con distancias y predecesores
    static class CaminoResultado {
        int[] distancias;
        int[] predecesores;
        
        public CaminoResultado(int[] distancias, int[] predecesores) {
            this.distancias = distancias;
            this.predecesores = predecesores;
        }
    }
    
    // Reconstruir el camino desde el origen hasta el destino
    public static List<Integer> reconstruirCamino(int[] predecesores, int destino) {
        List<Integer> camino = new ArrayList<>();
        if (predecesores[destino] == -1) {
            return camino;
        }
        
        for (int v = destino; v != -1; v = predecesores[v]) {
            camino.add(v);
        }
        
        Collections.reverse(camino);
        return camino;
    }
    
    // Método para ingresar el grafo
    public static int[][] ingresarGrafo() {
        System.out.print("Ingrese la cantidad de nodos: ");
        int n = scanner.nextInt();
        
        System.out.print("Ingrese la cantidad de aristas: ");
        int m = scanner.nextInt();
        
        int[][] grafo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grafo[i], INF);
            grafo[i][i] = 0;
        }
        
        System.out.println("\nIngrese las aristas (origen destino peso):");
        System.out.println("Los nodos van desde 1 hasta " + n);
        
        for (int i = 0; i < m; i++) {
            System.out.print("Arista " + (i + 1) + ": ");
            int u = scanner.nextInt() - 1;  // Convertir a índice 0-based
            int v = scanner.nextInt() - 1;  // Convertir a índice 0-based
            int peso = scanner.nextInt();
            
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Error: Los nodos deben estar entre 1 y " + n);
                i--;
                continue;
            }
            
            grafo[u][v] = peso;
            grafo[v][u] = peso;
        }
        
        return grafo;
    }
    
    // Mostrar el grafo ingresado
    public static void mostrarGrafo(int[][] grafo) {
        System.out.println("\n--- GRAFO INGRESADO ---");
        int n = grafo.length;
        
        System.out.println("Aristas (formato: origen -> destino : peso):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && grafo[i][j] != INF) {
                    System.out.println("  " + (i + 1) + " -> " + (j + 1) + " : " + grafo[i][j]);
                }
            }
        }
    }
    
    // Método principal
    public static void main(String[] args) {
        System.out.println("=== ALGORITMO DE DIJKSTRA - CAMINO MÍNIMO ===");
        System.out.println("NOTA: Los nodos se numeran desde 1 hasta n\n");
        
        int[][] grafo = ingresarGrafo();
        mostrarGrafo(grafo);
        
        while (true) {
            System.out.println("\n--- CONSULTA DE CAMINO MÍNIMO ---");
            System.out.print("Ingrese nodo origen (0 para salir): ");
            int origen = scanner.nextInt();
            
            if (origen == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }
            
            System.out.print("Ingrese nodo destino: ");
            int destino = scanner.nextInt();
            
            int n = grafo.length;
            
            // Convertir a índices 0-based
            int origenIndex = origen - 1;
            int destinoIndex = destino - 1;
            
            if (origenIndex < 0 || origenIndex >= n || destinoIndex < 0 || destinoIndex >= n) {
                System.out.println("Error: Los nodos deben estar entre 1 y " + n);
                continue;
            }
            
            if (origen == destino) {
                System.out.println("El origen y destino son el mismo nodo. Distancia: 0");
                continue;
            }
            
            // Ejecutar Dijkstra
            CaminoResultado resultado = dijkstraConCamino(grafo, origenIndex, destinoIndex);
            List<Integer> camino = reconstruirCamino(resultado.predecesores, destinoIndex);
            
            // Mostrar resultados
            if (camino.isEmpty() || resultado.distancias[destinoIndex] == INF) {
                System.out.println("NO EXISTE CAMINO desde el nodo " + origen + " al nodo " + destino);
            } else {
                System.out.println("Distancia mínima: " + resultado.distancias[destinoIndex]);
                System.out.print("Camino: ");
                for (int i = 0; i < camino.size(); i++) {
                    if (i > 0) System.out.print(" -> ");
                    System.out.print(camino.get(i) + 1);  // Convertir a 1-based para mostrar
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}
