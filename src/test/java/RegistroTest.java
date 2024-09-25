import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    String[][] registro = new String[10][3];

    @BeforeEach
    void setUp() {
        Registro.agregarPersona(registro, "Maria", "Solter@", 19);
        Registro.agregarPersona(registro, "Juanin", "Solter@", 70);
        Registro.agregarPersona(registro, "Julia", "Casad@", 101);
    }

    @Test
    void agregarPersona() {
        Registro.agregarPersona(registro, "Maria", "Solter@", 19);
        Registro.agregarPersona(registro, "Juan", "Solter@", 20);
        Registro.agregarPersona(registro, "Julia", "Casad@", 101);
        assertEquals("Maria", registro[3][0]);
        assertEquals("Solter@", registro[3][1]);
        assertEquals("19", registro[3][2]);
        assertEquals("Juan", registro[4][0]);
        assertEquals("Solter@", registro[4][1]);
        assertEquals("20", registro[4][2]);
        assertEquals("Julia", registro[5][0]);
        assertEquals("Casad@", registro[5][1]);
        assertEquals("101", registro[5][2]);
    }

    @Test
    void personaTerceraEdad() {
        assertEquals(2, Registro.personasTerceraEdad(registro));
    }

    @Test
    void personaSegunEstadoCivil() {
        assertEquals(2, Registro.personasSegunEstadoCivil(registro, "Solter@"));
        assertEquals(1, Registro.personasSegunEstadoCivil(registro, "Casad@"));
    }
}