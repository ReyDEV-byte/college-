import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GrafoNoDirigidoPonderadoLista<String> grafo = new GrafoNoDirigidoPonderadoLista<>();

        grafo.agregarAristaPonderada("O", "A", 2);
        grafo.agregarAristaPonderada("A", "C", 4);
        grafo.agregarAristaPonderada("A", "D", 6);
        grafo.agregarAristaPonderada("B", "A", 5);
        grafo.agregarAristaPonderada("B", "D", 7);
        grafo.agregarAristaPonderada("C", "D", 2);
        grafo.agregarAristaPonderada("C", "E", 5);
        grafo.agregarAristaPonderada("D", "E", 8);
        grafo.agregarAristaPonderada("D", "F", 6);
        grafo.imprimirGrafo();

        Map<String, Double> distancias = grafo.dijkstra("O");

        System.out.println("\nDistancia más corta de O a E:");
        System.out.println("O → E = " + distancias.get("E"));
        for (Map.Entry<String, Double> entry : distancias.entrySet()) {
            System.out.println("O → " + entry.getKey() + " = " + entry.getValue());
        }
    }
}