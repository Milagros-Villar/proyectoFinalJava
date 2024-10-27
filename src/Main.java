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
        * */
        Scanner scanner = new Scanner(System.in);
        List<Policia> policias = new ArrayList<>();
        List<Corta> armasCortas = new ArrayList<>();
        List<Larga> armasLargas = new ArrayList<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("---..---..---..---..---..---..---..---..---..");
            System.out.println("\t--- Sistema de administracion de Armas ---");
            System.out.println("\t\t\t\tMENÚ PRINCIPAL ");
            System.out.println("1. Agregar Policia y su arma");
            System.out.println("2. Ver información de armas");
            System.out.println("3. Mostrar armas en condiciones para enfrentamiento");
            System.out.println("4. Salir");
            System.out.println("---..---..---..---..---..---..---..---..---..");
            System.out.print("Seleccione la opción numerica: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar arma y datos del policía
                    System.out.println("Ingrese el nombre del policía:");
                    String nombrePolicia = scanner.nextLine();
                    System.out.println("Ingrese el apellido del policía:");
                    String apellidoPolicia = scanner.nextLine();
                    System.out.println("Ingrese el legajo del policía:");
                    int legajoPolicia = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer
                    // Verificar si el legajo ya existe
                    boolean legajoExistente = false;
                    for (Policia p : policias) {
                        if (p.getLegajo() == legajoPolicia) {
                            legajoExistente = true;
                            break;
                        }
                    }
                    if (legajoExistente) {
                        System.out.println("Error: Este policía ya tiene un arma asignada.");
                        break; // Salir del caso si el legajo ya existe
                    }
                    Policia policia = new Policia(nombrePolicia, apellidoPolicia, legajoPolicia);
                    policias.add(policia);

                    System.out.println("Seleccione el numero de tipo de arma (1. Corta, 2. Larga):");
                    int tipoArma = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer
                    System.out.println("Ingrese la cantidad de municiones(numerico):");
                    int cantMuniciones = scanner.nextInt();
                    System.out.println("Ingrese el alcance en metros:");
                    double alcance = scanner.nextDouble();
                    scanner.nextLine(); // limpiar el buffer
                    System.out.println("Ingrese la marca del arma:");
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el calibre del arma:");
                    int calibre = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer
                    System.out.println("Ingrese el estado del arma (NUEVA, EN MANTENIMIENTO, EN USO):");
                    String estado = scanner.nextLine();

                    if (tipoArma == 1) {
                        System.out.println("¿Es automática? (true/false):");
                        boolean esAutomatica = scanner.nextBoolean();

                        Corta armaCorta = new Corta(policia, cantMuniciones, alcance, marca, calibre, estado, esAutomatica);
                        armasCortas.add(armaCorta);
                    } else if (tipoArma == 2) {
                        System.out.println("Ingrese la justificación de uso:");
                        String justifUso = scanner.nextLine();
                        System.out.println("Ingrese el nivel del arma (1 a 5):");
                        int nivelArma = scanner.nextInt();
                        System.out.println("¿Tiene sello del RENAR? (true/false):");
                        boolean tieneSello = scanner.nextBoolean();

                        Larga armaLarga = new Larga(policia, cantMuniciones, alcance, marca, calibre, estado, justifUso, nivelArma, tieneSello);
                        armasLargas.add(armaLarga);
                    }
                    break;

                case 2:
                    // Ver información de las armas cortas
                    System.out.println("\n--- INFORMACIÓN DE ARMAS CORTAS ---");
                    for (Corta corta : armasCortas) {
                        System.out.println(corta);
                        System.out.println("Puede disparar a más de 200m: " + corta.efectividadMts());
                    }
                    System.out.println("\n--- INFORMACIÓN DE ARMAS LARGAS ---");
                    for (Larga larga : armasLargas) {
                        System.out.println(larga);
                    }
                      // Comparar armas largas si hay más de una
                    if (armasLargas.size() > 1) {
                        // Determinar el nivel máximo entre las armas largas
                        int nivelMaximo = armasLargas.get(0).getNivelArma();
                        for (Larga larga : armasLargas) {
                            if (larga.getNivelArma() > nivelMaximo) {
                                nivelMaximo = larga.getNivelArma();
                            }
                        }

                        // Listar las armas de nivel máximo
                        List<Larga> armasNivelMaximo = new ArrayList<>();
                        List<Larga> armasNivelMenor = new ArrayList<>();

                        for (Larga larga : armasLargas) {
                            if (larga.getNivelArma() == nivelMaximo) {
                                armasNivelMaximo.add(larga);
                            } else {
                                armasNivelMenor.add(larga);
                            }
                        }

                        // Mostrar resultados
                        System.out.println("\n--- RESULTADO COMPARACIÓN DE ARMAS LARGAS ---");

                        if (armasNivelMaximo.size() > 1) {
                            System.out.println("Hay varias armas largas con el nivel máximo (" + nivelMaximo + "). Detalles:");
                            for (Larga larga : armasNivelMaximo) {
                                System.out.println(larga);
                            }
                        } else {
                            System.out.println("El arma larga de mayor nivel es:");
                            System.out.println(armasNivelMaximo.get(0));
                        }

                        if (!armasNivelMenor.isEmpty()) {
                            System.out.println("\nArmas largas de niveles menores:");
                            for (Larga larga : armasNivelMenor) {
                                System.out.println(larga);
                            }
                        }
                    }break;


                case 3:
                    // Mostrar armas en condiciones para enfrentamiento
                    System.out.println("\n--- ARMAS EN CONDICIONES PARA ENFRENTAMIENTO ---");
                    for (Corta corta : armasCortas) {
                        if (corta.enCondiciones()) {
                            System.out.println(corta + " está en condiciones para enfrentamiento.");
                        }
                    }

                    for (Larga larga : armasLargas) {
                        if (larga.enCondiciones()) {
                            System.out.println(larga + " está en condiciones para enfrentamiento.");
                        }
                    }
                    break;

                case 4:
                    // Salir del menú
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de administración de armas!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();




    }
}