import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[][] estudiantes;

    public static void main(String[] args) {
        System.out.println("RECORADATORIO. NO INGRESES TIPO DE DATOS NO VALIDOS.");
        System.out.println("Ejemplo: Si se pide ingresar un numero, no ingreses una letra.");
        pausaPrograma();
        limpiarPantalla();
        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int cantidadEstudiantes = scanner.nextInt();
        estudiantes = new String[cantidadEstudiantes][5];

        int opcion;
        do {
            System.out.println("\nGestion de Estudiantes");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Buscar Estudiante por Nombre");
            System.out.println("3. Buscar Estudiante por Edad");
            System.out.println("4. Buscar Estudiante por Materia");
            System.out.println("5. Mostrar Todos los Estudiantes");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opcion deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    pausaPrograma();
                    limpiarPantalla();
                    break;
                case 2:
                    buscarPorNombre();
                    pausaPrograma();
                    limpiarPantalla();
                    break;
                case 3:
                    buscarPorEdad();
                    pausaPrograma();
                    limpiarPantalla();
                    break;
                case 4:
                    buscarPorMateria();
                    pausaPrograma();
                    limpiarPantalla();
                    break;
                case 5:
                    mostrarEstudiantes();
                    pausaPrograma();
                    limpiarPantalla();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    pausaPrograma();
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, ingrese una opción valida.");
                    break;
            }

        } while (opcion != 6);
    }

    static void pausaPrograma() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static void agregarEstudiante() {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i][0] == null) { // Verifica si el espacio está vacío
                System.out.println("\nIngrese los datos del estudiante:");
                System.out.print("Apellido Paterno: ");
                estudiantes[i][0] = scanner.next();
                System.out.print("Apellido Materno: ");
                estudiantes[i][1] = scanner.next();
                System.out.print("Nombre: ");
                estudiantes[i][2] = scanner.next();
                System.out.print("Edad: ");
                estudiantes[i][3] = scanner.next();
                System.out.print("Cuantas materias desea registrar?: ");
                int cantidadMaterias = scanner.nextInt();
                StringBuilder materiaCalificacion = new StringBuilder();
                for (int j = 0; j < cantidadMaterias; j++) {
                    System.out.print("Nombre de la materia " + (j + 1) + ": ");
                    String materia = scanner.next();
                    System.out.print("Calificacion de " + materia + ": ");
                    String calificacion = scanner.next();
                    materiaCalificacion.append(materia).append(": ").append(calificacion).append(", ");
                }
                estudiantes[i][4] = materiaCalificacion.toString();

                System.out.println("Estudiante registrado exitosamente.");
                return; // Sale del método después de registrar un estudiante
            }
        }
        System.out.println("No hay espacio para más estudiantes.");
    }

    static void buscarPorNombre() {
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombreBuscar = scanner.next();
        boolean encontrado = false;
        System.out.println("Resultados de la búsqueda por nombre:");
        for (String[] estudiante : estudiantes) {
            if (estudiante[2] != null && estudiante[2].equalsIgnoreCase(nombreBuscar)) {
                mostrarInfoEstudiante(estudiante);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    static void buscarPorEdad() {
        System.out.print("Ingrese la edad del estudiante a buscar: ");
        String edadBuscar = scanner.next();
        boolean encontrado = false;
        System.out.println("Resultados de la búsqueda por edad:");
        for (String[] estudiante : estudiantes) {
            if (estudiante[3] != null && estudiante[3].equals(edadBuscar)) {
                mostrarInfoEstudiante(estudiante);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    static void buscarPorMateria() {
        System.out.print("Ingrese la materia del estudiante a buscar: ");
        String materiaBuscar = scanner.next();
        boolean encontrado = false;
        System.out.println("Resultados de la busqueda por materia:");
        for (String[] estudiante : estudiantes) {
            if (estudiante[4] != null && estudiante[4].toLowerCase().contains(materiaBuscar.toLowerCase())) {
                mostrarInfoEstudiante(estudiante);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    static void mostrarEstudiantes() {
        System.out.println("\nInformacion de todos los estudiantes:");
        for (String[] estudiante : estudiantes) {
            if (estudiante[0] != null) {
                mostrarInfoEstudiante(estudiante);
            }
        }
    }

    static void mostrarInfoEstudiante(String[] estudiante) {
        System.out.println("------------------------------");
        System.out.println("Apellido Paterno: " + estudiante[0]);
        System.out.println("Apellido Materno: " + estudiante[1]);
        System.out.println("Nombre: " + estudiante[2]);
        System.out.println("Edad: " + estudiante[3]);
        System.out.println("Materia y Calificación: " + estudiante[4]);
        System.out.println("------------------------------");
    }
}
