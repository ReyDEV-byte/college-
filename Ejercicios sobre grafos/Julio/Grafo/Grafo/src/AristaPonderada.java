public class AristaPonderada<T> extends Arista<T> {
    private final double peso;

    public AristaPonderada(T origen, T destino, double peso) {
        super(origen, destino);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "(" + getOrigen() + " → " + getDestino() + ", peso: " + peso + ")";
    }
}