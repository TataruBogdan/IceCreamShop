package be.intecbrussel.eatables;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    Cone cone;

    @BeforeEach
    void setup() {
        cone= new Cone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});
    }

    // can test what types of flavour the ice cream contains?
    @ParameterizedTest
    @MethodSource("returnFlavours")
    void shouldReturnEqualsWhenConeHasTheSameFlavorsWithConeFlavours(Cone.Flavor coneFlavours) {

        //given

        //when
        Cone.Flavor[] flavors = {coneFlavours};

        Cone cone = new Cone(flavors);

        //then
        assertEquals(Arrays.hashCode(flavors), cone.hashCode());

    }

    @Test
    void shouldReturnEqualsWhenConeFlavours() {

        //given

        //when
        Cone.Flavor[] flavors = {Cone.Flavor.VANILLA};

        Cone cone = new Cone();

        //then
        assertEquals(Arrays.hashCode(flavors), cone.hashCode());

    }


    static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(
                Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }




    @Test
    void shouldTestVoidEatWhyIDontKnow(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.VANILLA});
        System.setOut(tps);
        cone.eat();
        System.setOut(original);
        tps.flush();
        assertEquals("You are eating Cone with: [VANILLA]", baos.toString());
    }

    @Test
    void shouldReturnEqualWhenToString(){

        //given

        //when
        String string = cone.toString();
        //then
        assertEquals("Cone{balls=[BANANA, LEMON]}", string);
    }

    @Test
    void shouldReturnEqualWhenEquals(){

        //given
        Cone cone1 = new Cone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});

        //when
        int hashedCode = cone.hashCode();
        //then
        assertTrue(cone1.equals(cone) && cone.equals(cone1));
        assertEquals(hashedCode, cone1.hashCode());
    }



}