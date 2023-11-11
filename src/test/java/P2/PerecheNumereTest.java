package P2;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @org.junit.jupiter.api.Test
    void cmmmc() {
        PerecheNumere pereche = new PerecheNumere(2,3);
        assertEquals(6,pereche.cmmmc());
    }
}