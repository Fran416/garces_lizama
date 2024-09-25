import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    String[][] registro = new String[10][3];

    @Test
    void agregarPersona() {
        Registro.agregarPersona(registro, "Maria", "Solter@", 19);
        Registro.agregarPersona(registro, "Juan", "Solter@", 20);
        Registro.agregarPersona(registro, "Julia", "Casad@", 101);
        assertEquals("Maria", registro[0][0]);
        assertEquals("Solter@", registro[0][1]);
        assertEquals("19", registro[0][2]);
        assertEquals("Juan", registro[1][0]);
        assertEquals("Solter@", registro[1][1]);
        assertEquals("20", registro[1][2]);
        assertEquals("Julia", registro[2][0]);
        assertEquals("Casad@", registro[2][1]);
        assertEquals("101", registro[2][2]);
    }
}