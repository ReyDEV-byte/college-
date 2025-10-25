public class Arista<T> {
    private final T origen;
    private final T destino;

    public Arista(T origen, T destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public T getOrigen() {
        return origen;
    }

    public T getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "(" + origen + " → " + destino + ")";
    }
}