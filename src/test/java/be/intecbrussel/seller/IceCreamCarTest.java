package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamCarTest {

    IceCreamCar iceCreamCar;
    Cone cone;
    Stock stock = new Stock();

    @BeforeEach
    void setup() {
        stock.setCones(0);
        stock.setBalls(0);
        stock.setMagni(0);
        stock.setIceRockets(0);
        cone = new Cone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.LEMON});
        iceCreamCar = new IceCreamCar(new PriceList(1, 2, 2.5),
                                      stock);
    }

    @ParameterizedTest
    @MethodSource("returnFlavours")
    void shouldReturnNullWhenCurrentStockIsEmpty(Cone.Flavor coneFlavour) {
        //fail("Must be implemented");

        // given

        // when
        Cone.Flavor[] flavors = {coneFlavour};
        // then
        assertNull(iceCreamCar.orderCone(flavors));

    }

    @ParameterizedTest
    @MethodSource("returnFlavoursList")
    //@Test
    void shouldReturnEqualsWhenConeFlavoursIsNotNull(List<Cone.Flavor> flavors) {

        // given

        // when
        stock.setCones(3);
        stock.setBalls(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        //Cone result = iceCreamCar.orderCone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});
        Cone result = iceCreamCar.orderCone(flavors.toArray(new Cone.Flavor[]{}));

        // then
        // assertNotNull(result);

        assertEquals(0.5, iceCreamCar.getProfit());

    }

    @ParameterizedTest
    @MethodSource("returnFlavoursList")
        //@Test
    void shouldReturnTrueWhenConeFlavoursIsNotNull(List<Cone.Flavor> flavors) {

        // given

        // when
        stock.setCones(3);
        stock.setBalls(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        //Cone result = iceCreamCar.orderCone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});
        Cone result = iceCreamCar.orderCone(flavors.toArray(new Cone.Flavor[]{}));

        // then
        assertNotNull(result);

        //assertEquals(0.5, iceCreamCar.getProfit());

    }

    //TODO - HOW TO TEST FOR NULL
    @Test
    void shouldReturnTrueWhenConeFlavoursIsNullOrderIceRocket() {
        //fail("Must be implemented");

        // given

        // when
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        // then
        assertNull(iceRocket);

    }


//    @ParameterizedTest
//    @MethodSource("returnFlavours")
//    void shouldReturnTrueWhenPrepareConeFlavoursIsNotNull() {
//        //fail("Must be implemented");
//
//        // given
//        Cone.Flavor[] coneFlavour = null;
//
//        // when
//        iceCreamCar.orderCone(coneFlavour);
//        // then
//        assertNull(iceCreamCar.orderCone(null));
//
//    }

    @ParameterizedTest
    @MethodSource("returnFlavours")
    void shouldReturnTrueWhenOrderMagnum(Cone.Flavor coneFlavour) {
        //fail("Must be implemented");

        //given

        //when
        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS);

        //then
        assertNull(magnum);


    }

    @Test
    void getProfit() {
        //fail("Must be implemented");

        //given
        stock.setIceRockets(1);


        //when
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        double profit = iceCreamCar.getProfit();
        //then
        assertEquals(0.4, profit);
    }

    static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }

    static Stream<Arguments> returnFlavoursList() {
        return Stream.of(Arguments.arguments(List.of(Cone.Flavor.BANANA, Cone.Flavor.LEMON)));
    }

}