public abstract class Arma {

    //Atributos(caracteristicas)

    protected Policia policia;
    protected int cantMuniciones;
    protected double alcance;
    protected String marca;
    protected int calibre;
    protected String estado; // "NUEVA", "EN MANTENIMIENTO", "EN USO"

    //Metodos(comportamiento)

    public Arma(Policia policia, int cantMuniciones, double alcance, String marca, int calibre, String estado) {
        this.policia = policia;
        this.cantMuniciones = cantMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }
    //Método para verificar si el arma está en condiciones para el uso

    public boolean enCondiciones() {
        return "EN USO".equalsIgnoreCase(estado) && calibre >= 9;
    }
    @Override
    public abstract String toString();


}
