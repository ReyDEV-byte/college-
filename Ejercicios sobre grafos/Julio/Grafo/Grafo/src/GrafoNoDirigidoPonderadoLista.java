import java.util.*;

public class GrafoNoDirigidoPonderadoLista<T> {
    private final Set<T> nodos;
    private final Map<T, LinkedList<AristaPonderada<T>>> listaAdyacencia;

    public GrafoNoDirigidoPonderadoLista() {
        this.nodos = new HashSet<>();
        this.listaAdyacencia = new HashMap<>();
    }

    public void agregarNodo(T nodo) {
        if (!nodos.contains(nodo)) {
            nodos.add(nodo);
            listaAdyacencia.put(nodo, new LinkedList<>());
        }
    }

    public void agregarAristaPonderada(T origen, T destino, double peso) {
        if (!validarRango(origen) || !validarRango(destino))
            return;

        agregarNodo(origen);
        agregarNodo(destino);
        listaAdyacencia.get(origen).add(new AristaPonderada<>(origen, destino, peso));
        listaAdyacencia.get(destino).add(new AristaPonderada<>(destino, origen, peso));
    }

    // BFS modificado
    public void bfs(T inicio) {
        if (!validarNodo(inicio))
            return;

        Map<T, Boolean> visitado = new HashMap<>();
        Queue<T> cola = new LinkedList<>();

        for (T nodo : nodos)
            visitado.put(nodo, false);

        visitado.put(inicio, true);
        cola.offer(inicio);

        System.out.println("\nRecorrido BFS:");
        while (!cola.isEmpty()) {
            T actual = cola.poll();
            System.out.print(actual + ": [");

            // Ordenar vecinos por destino
            LinkedList<AristaPonderada<T>> vecinos = new LinkedList<>(listaAdyacencia.get(actual));
            vecinos.sort(Comparator.comparing(a -> a.getDestino().toString()));

            List<String> destinos = new ArrayList<>();
            for (AristaPonderada<T> arista : vecinos) {
                destinos.add(arista.getDestino() + "(" + arista.getPeso() + ")");
            }
            System.out.print(String.join(", ", destinos) + "]\n");

            for (AristaPonderada<T> arista : vecinos) {
                T vecino = arista.getDestino();
                if (!visitado.get(vecino)) {
                    visitado.put(vecino, true);
                    cola.offer(vecino);
                }
            }
        }
    }

    // Validaciones similares
    private boolean validarRango(T nodo) {
        if (nodo instanceof Integer) {
            int valor = (Integer) nodo;
            if (valor < 0 || valor > 4) {
                System.out.println("Error: El nodo " + nodo + " debe estar en el rango [0,4]");
                return false;
            }
        }
        return true;
    }

    private boolean validarNodo(T nodo) {
        if (!nodos.contains(nodo)) {
            System.out.println("Error: El nodo " + nodo + " no existe en el grafo");
            return false;
        }
        return true;
    }

    public void imprimirGrafo() {
        System.out.println("\nLista de adyacencia del grafo no dirigido ponderado:");
        List<T> nodosOrdenados = new ArrayList<>(nodos);
        if (!nodosOrdenados.isEmpty() && nodosOrdenados.get(0) instanceof Comparable) {
            Collections.sort(nodosOrdenados, (a, b) -> ((Comparable<T>) a).compareTo(b));
        }

        for (T nodo : nodosOrdenados) {
            System.out.print(nodo + ": [");
            List<String> aristas = new ArrayList<>();
            for (AristaPonderada<T> arista : listaAdyacencia.get(nodo)) {
                aristas.add(arista.getDestino() + "(" + arista.getPeso() + ")");
            }
            System.out.print(String.join(", ", aristas) + "]\n");
        }
    }

    // Mantener el método dijkstra original
    public Map<T, Double> dijkstra(T inicio) {
        Map<T, Double> distancias = new HashMap<>();
        PriorityQueue<NodoDistancia<T>> cola = new PriorityQueue<>(
                Comparator.comparingDouble(nd -> nd.distancia));

        for (T nodo : nodos)
            distancias.put(nodo, Double.POSITIVE_INFINITY);
        distancias.put(inicio, 0.0);
        cola.offer(new NodoDistancia<>(inicio, 0.0));

        while (!cola.isEmpty()) {
            NodoDistancia<T> actual = cola.poll();

            if (actual.distancia > distancias.get(actual.nodo))
                continue;

            for (AristaPonderada<T> arista : listaAdyacencia.get(actual.nodo)) {
                T vecino = arista.getDestino();
                double nuevaDist = actual.distancia + (Double) arista.getPeso();

                if (nuevaDist < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDist);
                    cola.offer(new NodoDistancia<>(vecino, nuevaDist));
                }
            }
        }
        return distancias;
    }

    private static class NodoDistancia<T> {
        T nodo;
        double distancia;

        public NodoDistancia(T nodo, double distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }
    }

    public AristaPonderada<T> buscarArista(T nodo1, T nodo2) {
        if (!nodos.contains(nodo1) || !nodos.contains(nodo2)) {
            return null;
        }
        for (AristaPonderada<T> arista : listaAdyacencia.get(nodo1)) {
            if (arista.getDestino().equals(nodo2)) {
                return arista;
            }
        }
        return null;
    }

    public boolean eliminarArista(T nodo1, T nodo2) {
        if (!nodos.contains(nodo1) || !nodos.contains(nodo2)) {
            return false; // No se pueden eliminar nodos que no existen
        }
        // Busca y elimina en ambas direcciones (grafo no dirigido)
        boolean eliminado1 = eliminarAristaUnidireccional(nodo1, nodo2);
        boolean eliminado2 = eliminarAristaUnidireccional(nodo2, nodo1);
        return eliminado1 || eliminado2; // Devuelve true si al menos una arista existía
    }

    // Método auxiliar para eliminar una arista en una sola dirección
    private boolean eliminarAristaUnidireccional(T origen, T destino) {
        LinkedList<AristaPonderada<T>> aristas = listaAdyacencia.get(origen);
        for (AristaPonderada<T> arista : aristas) {
            if (arista.getDestino().equals(destino)) {
                return aristas.remove(arista);
            }
        }
        return false;
    }
}