public class Larga extends Arma implements Comparable<Larga>  {
    //Atributos(caracteristicas)
    private String justifUso;
    private int nivelArma; // del 1 al 5
    private boolean tieneSello;
    private Policia policia;

    //Metodo(comportamiento)

    public Larga(Policia policia, int cantMuniciones, double alcance, String marca, int calibre, String estado,
                     String justifUso, int nivelArma, boolean tieneSello) {
        super(policia, cantMuniciones, alcance, marca, calibre, estado);
        this.justifUso = justifUso;
        this.nivelArma = nivelArma;
        this.tieneSello = tieneSello;
        this.policia = policia;
    }

    @Override
    public int compareTo(Larga otra) {
        return Integer.compare(this.nivelArma, otra.nivelArma);
    }   @Override
    public String toString() {
        return "ArmaLarga [policía=" + policia + ", marca=" + marca + ", calibre=" + calibre + ", estado=" + estado +
                ", nivelArma=" + nivelArma + ", tieneSello=" + (tieneSello ? "Sí" : "No") +
                ", justifUso=" + justifUso + "]";
    }
}
