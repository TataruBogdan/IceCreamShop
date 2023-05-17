package be.intecbrussel.eatables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {

    Magnum magnum;

    @BeforeEach
    void setup() {
        magnum = new Magnum();
    }

    @Test
    void shouldReturnEqualsWhenMagnum() {

        //given

        //when

        Magnum magnum = new Magnum();

        //then
        assertNotNull(magnum);

    }


    @ParameterizedTest
    @EnumSource(value = Magnum.MagnumType.class, names = {"MILKCHOCOLATE"})
    void shouldReturnEqualsWhenMagnumHasTheSameType(Magnum.MagnumType magnumType) {

        //given
        Magnum magnum = new Magnum(magnumType);
        //when


        //then
        assertEquals(magnumType, magnum.getType());

    }




    @Test
    void shouldTestVoidEatWhyIDontKnow(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        Magnum magnum = new Magnum();
        System.setOut(tps);
        magnum.eat();
        System.setOut(original);
        tps.flush();
        assertEquals("You are eating Magnum: MagnumType MILKCHOCOLATE", baos.toString());
    }

    @ParameterizedTest
    @EnumSource(value = Magnum.MagnumType.class, names = {"MILKCHOCOLATE"})
    void getType(Magnum.MagnumType magnumType) {
        //given
        Magnum magnum = new Magnum(magnumType);
        // when
        Magnum.MagnumType type = magnum.getType();
        //then
        assertEquals(magnum.getType(), type);

    }

    @Test
    void shouldReturnEqualWhenToString(){

        //given

        //when
        String string = magnum.toString();
        //then
        assertEquals("Magnum{type=MagnumType MILKCHOCOLATE}",
                     string);
    }
}