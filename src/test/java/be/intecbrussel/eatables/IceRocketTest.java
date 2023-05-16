package be.intecbrussel.eatables;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IceRocketTest {

    @Test
    void shouldReturnEqualsWhenConeFlavours() {

        //given

        //when

        IceRocket iceRocket = new IceRocket();

        //then
        assertNotNull(iceRocket);

    }

    @Test
    void shouldTestVoidEatWhyIDontKnow(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        IceRocket iceRocket = new IceRocket();
        System.setOut(tps);
        iceRocket.eat();
        System.setOut(original);
        tps.flush();
        assertEquals("You are eating IceRocket", baos.toString());
    }
}