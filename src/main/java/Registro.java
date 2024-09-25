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
                6)Salir.
                """);
        System.out.print("Elija una opcion: ");
    }

    public static void ejecutarMenu(String [][] registro) {
        int opcion = 0;
        while(opcion != 6) {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, registro);
        }
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
                //agregarPersona(registro,nombre, estadocivil, edad);
                break;
            case 2:
                //personasMayoresEdad();
                break;
            case 3:
                //personasMenoresEdad();
                break;
            case 4:
                //personasTerceraEdad();
                break;
            case 5:
                //personasSegunEstadoCivil();
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
            return registro;
        } else {
            System.out.println("No hay cupo.");
            return registro;
        }
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

    public static int stringAInt(String numeroString){
        int numeroEntero;
        try{
            numeroEntero = Integer.parseInt(numeroString);
        } catch (NumberFormatException e) {
            numeroEntero = -1;
        }
        return numeroEntero;
    }

    public static int personasMayoresEdad(String[][] registro) {
        int personasMayores = 0;
        for (int i = 0; i < registro.length; i++) {
            if (stringAInt(registro[i][2]) > 17 ) {
                personasMayores++;
            }
        }
        return personasMayores;
    }

    public static int personasMenoresEdad(String[][] registro) {
        int personasMenores = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                i = registro.length-1;
            }else if (stringAInt(registro[i][2]) < 18 ) {
                personasMenores++;
            }
        }
        return personasMenores;
    }
}

