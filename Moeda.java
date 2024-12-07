public record Moeda(String codigo, String moeda) {
    public String toString() {
        return codigo + " (" + moeda+")";
    }
}
