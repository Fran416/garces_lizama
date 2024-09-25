import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class RegistroTest {

    String [][] registro = new String [50][3];

    @BeforeEach
    void setUp() {
        Registro.agregarPersona(registro, "Francisca", "Soltera", 19);
        Registro.agregarPersona(registro, "Francisco", "Soltero", 20);
        Registro.agregarPersona(registro, "Pablo", "Soltero", 17);
        Registro.agregarPersona(registro, "Macarena", "Soltera", 15);
    }

    @Test
    void testPersonasMayores() {
        assertEquals(2, Registro.personasMayoresEdad(registro));
    }

    @Test
    void testPersonasMenores() {
        assertEquals(2, Registro.personasMenoresEdad(registro));
    }
  
}