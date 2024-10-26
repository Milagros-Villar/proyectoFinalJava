public class Corta extends Arma{

    //Atributos(caracteristicas)

    private boolean esAutomatica;

    //Metodos(comportamientos)

    public Corta(Policia policia, int cantMuniciones, double alcance, String marca, int calibre, String estado,
                 boolean esAutomatica){
        super(policia, cantMuniciones, alcance, marca, calibre, estado);
        this.esAutomatica= esAutomatica;
    }
    // verifica si el arma corta tiene efectividad a más de 200 metros
    public boolean efectividadMts() {
        return alcance > 200;
    }
    @Override
    public String toString() {
        return "ArmaCorta [policía=" + policia + ",marca=" + marca + ", calibre=" + calibre + ", estado=" + estado +
                ", esAutomatica=" + (esAutomatica ? "Sí" : "No") + "]";
    }

}
