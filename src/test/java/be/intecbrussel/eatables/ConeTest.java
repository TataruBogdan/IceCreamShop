package be.intecbrussel.eatables;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    Cone cone;

    @Test
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
    void shouldReturnEqualsWhenConeHasTheSameFlavorsWithConeFlavours() {

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






}