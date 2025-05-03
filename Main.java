import clase4.SGE.Estudiante;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[10];
        int cantidad = 0;
        int opcion = 0;

        System.out.println("\n--- Sistema de Gestión de Estudiantes ---");

        while (opcion != 4) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear estudiante");
            System.out.println("2. Mostrar todos");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Salir");
            System.out.print("Elegí una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer

            if (opcion == 1) {
                if (cantidad < estudiantes.length) {
                    try {
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Legajo (STU-YYYY-XXXX): ");
                        String legajo = scanner.nextLine();

                        estudiantes[cantidad] = new Estudiante(nombre, edad, legajo);
                        cantidad++;
                        System.out.println("Estudiante creado correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("No se pueden agregar más estudiantes.");
                }

            } else if (opcion == 2) {
                if (cantidad == 0) {
                    System.out.println("No hay estudiantes cargados.");
                } else {
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("\nEstudiante #" + (i + 1));
                        estudiantes[i].mostrar();
                    }
                }

            } else if (opcion == 3) {
                if (cantidad == 0) {
                    System.out.println("No hay estudiantes para actualizar.");
                } else {
                    System.out.print("Número de estudiante (1 a " + cantidad + "): ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indice >= 0 && indice < cantidad) {
                        try {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();

                            System.out.print("Nueva edad: ");
                            int nuevaEdad = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Nuevo legajo (STU-YYYY-XXXX): ");
                            String nuevoLegajo = scanner.nextLine();

                            estudiantes[indice].actualizar(nuevoNombre, nuevaEdad, nuevoLegajo);
                            System.out.println("Estudiante actualizado correctamente.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
