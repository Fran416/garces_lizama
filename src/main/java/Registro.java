import java.util.InputMismatchException;
import java.util.Scanner;




public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        int a = -1;



            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    int edad;




                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Estadocivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            edad = Integer.parseInt(new Scanner(System.in).nextLine());
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = String.valueOf(edad);
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(a == 2) {
                int mayoresDeEdad = 0;




                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                }




                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);




                for (int i = 0; i < queSera; i++) {
                    if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(a == 4) {
                int mmmm = 0;




                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                        mmmm++;
                    } else if(Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
            } else if(a == 5) {
                int c = 0;
                int d = 0;
                for(String[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        c++;
                    } else if(persona[1].equals("soltero/a")) {
                        d++;
                    }
                }




                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
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

    public static String obtenerString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}