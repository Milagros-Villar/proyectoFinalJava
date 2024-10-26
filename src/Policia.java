public class Policia {

    //Atributos(caracteristicas)

    private String nombre;
    private String apellido;
    private int legajo;

    //Metodos(comportamiento)

    public Policia(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return "Policia: " + nombre + " " + apellido + ", Legajo: " + legajo;
    }
}
