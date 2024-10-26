//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * Nombre: Juan, Apellido: Perez, Legajo: 101,(arma corta)Cantidad de Municiones: 15, Alcance: 300 metros, Marca: Glock, Calibre: 9, Estado: EN USO, Es Automática: Sí
        * Nombre: Matias, Apellido: Gomez, Legajo: 202,(arma larga)Cantidad de Municiones: 12, Alcance: 150 metros, Marca: Beretta, Calibre: 7, Estado: EN MANTENIMIENTO, Es Automática: No
        *Nombre: Carlos, Apellido: López, Legajo: 303,(arma larga)Cantidad de Municiones: 25, Alcance: 800 metros, Marca: Winchester, Calibre: 10, Estado: EN USO, Justificación de Uso: Caza, Nivel del Arma: 2, Tiene Sello RENAR: No
        *
        * */
        Scanner scanner = new Scanner(System.in);
        List<Policia> policias = new ArrayList<>();
        List<Arma> armas = new ArrayList<>();

        // Ingresar policías
        System.out.println("Ingrese la cantidad de policías:");
        int numPolicias = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numPolicias; i++) {
            System.out.println("Ingrese nombre del policía " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese apellido del policía " + (i + 1) + ":");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese legajo del policía " + (i + 1) + ":");
            int legajo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            Policia policia = new Policia(nombre, apellido, legajo);
            policias.add(policia);
        }

        // Crear armas para los policías ingresados
        for (Policia policia : policias) {
            System.out.println("Creando arma para el policía: " + policia);
            System.out.println("Ingrese tipo de arma (1 para corta, 2 para larga):");
            int tipoArma = scanner.nextInt();

            System.out.println("Ingrese la cantidad de municiones:");
            int cantMuniciones = scanner.nextInt();

            System.out.println("Ingrese el alcance (en metros):");
            double alcance = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese la marca del arma:");
            String marca = scanner.nextLine();

            System.out.println("Ingrese el calibre del arma:");
            int calibre = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese el estado del arma (NUEVA, EN MANTENIMIENTO, EN USO):");
            String estado = scanner.nextLine();

            if (tipoArma == 1) { // Arma corta
                System.out.println("¿Es automática? (true/false):");
                boolean esAutomatica = scanner.nextBoolean();

                Corta corta = new Corta(policia, cantMuniciones, alcance, marca, calibre, estado, esAutomatica);
                armas.add(corta);
            } else if (tipoArma == 2) { // Arma larga
                System.out.println("Ingrese justificación de uso:");
                String justifUso = scanner.nextLine();

                System.out.println("Ingrese el nivel del arma (1 a 5):");
                int nivelArma = scanner.nextInt();

                System.out.println("¿Tiene sello del RENAR? (true/false):");
                boolean tieneSello = scanner.nextBoolean();

                Larga larga = new Larga(policia, cantMuniciones, alcance, marca, calibre, estado, justifUso, nivelArma, tieneSello);
                armas.add(larga);
            }
        }

        // Mostrar si cada arma está en condiciones para enfrentamiento
        for (Arma arma : armas) {
            System.out.println(arma + " está en condiciones para enfrentamiento: " + (arma.enCondiciones() ? "Sí" : "No"));

            // Específico para armas cortas
            if (arma instanceof Corta) {
                Corta corta = (Corta) arma;
                System.out.println(corta + " puede disparar a más de 200m: " + (corta.efectividadMts() ? "Sí" : "No"));
            }
        }

        // Comparar armas largas (solo si hay más de una)
        List<Larga> armasLargas = new ArrayList<>();
        for (Arma arma : armas) {
            if (arma instanceof Larga) {
                armasLargas.add((Larga) arma);
            }
        }

        if (armasLargas.size() > 1) {//verifica si hay mas de un arma larga en la lista
            for (int i = 0; i < armasLargas.size() - 1; i++) {
                Larga arma1 = armasLargas.get(i);
                Larga arma2 = armasLargas.get(i + 1);
                int comparacion = arma1.compareTo(arma2);
                if (comparacion > 0) {
                    System.out.println(arma1 + " es de mayor nivel que " + arma2);
                } else if (comparacion < 0) {
                    System.out.println(arma2 + " es de mayor nivel que " + arma1);
                } else {
                    System.out.println("Ambas armas largas tienen el mismo nivel.");
                }
            }
        }

        scanner.close();



    }
}