import java.util.InputMismatchException;
import java.util.Scanner;




public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        ejecutarMenu(registro);
    }

    public static void mostrarMenu(){
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6) Salir.
                """);
        System.out.print("Elija una opcion: ");
    }

    public static void ejecutarMenu(String [][] registro) {
        int opcion = 0;
        while(opcion != 6) {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, registro);}
    }

    public static int leerOpcion() {
        int opcion=0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }


    public static String leerCadena(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        String cadena = scanner.nextLine();
        return cadena;
    }

    public static void ejecutarOpcion(int opcion, String[][] registro) {
        switch (opcion) {
            case 1:
                //agregarPersona(registro);
                break;
            case 2:
                //personasMayoresEdad();
                break;
            case 3:
                //personasMenoresEdad();
                break;
            case 4:
                int cantidaPersonasTerceraEdad = personasTerceraEdad(registro);
                System.out.println("En su registro hay "+ cantidaPersonasTerceraEdad+" personas de la tercera edad" );
                break;
            case 5:
                String estadoCivil = leerCadena("Ingrese el estado Civil de desea contar (Solter@ - Casad@).");
                if (estadoCivil == "Solte@" || estadoCivil == "Casad@") {
                    int cantidadPersonas = personasSegunEstadoCivil(registro, estadoCivil);
                } else {
                    System.out.println("Error: El estado civil no se encuentra entre las opciones existentes");
                }
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }


    public static String[][] agregarPersona(String[][] registro, String nombre, String estadocivil, int edad) {
        if (hayCupo(registro)) {
            int filaVacia = obtenerUltimoEspacio(registro);
            registro[filaVacia][0] = nombre;
            registro[filaVacia][1] = estadocivil;
            registro[filaVacia][2] = String.valueOf(edad);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
        return registro;
    }

    public static int obtenerUltimoEspacio(String [][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return i;
            }
        }
        return registro.length;
    }

    public static boolean hayCupo(String [][] registro) {
        return registro.length - obtenerUltimoEspacio(registro) > 0;
    }

    public static int personasTerceraEdad(String[][] registro){
        int contador = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                i = registro.length - 1;
            } else if (stringAInt(registro[i][2]) >= 60) {
                contador++;
            }
        }
        return contador;
    }

    public static int personasSegunEstadoCivil(String[][] registro, String estadoCivil) {
        int contador = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                i = registro.length - 1;
            } else if (registro[i][1] == estadoCivil) {
                contador++;
            }
        }
        return contador;
    }

    public static int stringAInt(String numeroString){
        int numeroEntero;
        try{
            numeroEntero = Integer.parseInt(numeroString);
        } catch (NumberFormatException e) {
            numeroEntero = -1;
        }
        return numeroEntero;
    }
}