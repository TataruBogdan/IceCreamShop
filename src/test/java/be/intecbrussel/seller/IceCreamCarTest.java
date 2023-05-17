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

    // Test for Cone
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
    void shouldReturnEqualsProfitWhenConeFlavoursIsNotNullAndIsStock(List<Cone.Flavor> flavors) {

        // given

        // when
        stock.setCones(3);
        stock.setBalls(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        //Cone result = iceCreamCar.orderCone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});
        Cone result = iceCreamCar.orderCone(flavors.toArray(new Cone.Flavor[]{}));

        // then
        assertNotNull(result);

        double profit = iceCreamCar.getProfit();
        profit = Math.round(profit * 100);
        profit = profit / 100.00;

        assertEquals(0.5, profit);

    }

    //Tests for IceRocket

    @Test
    void shouldReturnTrueWhenConeFlavoursIsNullOrderIceRocket() {
        //fail("Must be implemented");

        // given

        // when
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        // then
        assertNull(iceRocket);

    }

    //@ParameterizedTest
    //@MethodSource("returnFlavoursList")
    @Test
    void shouldReturnTrueWhenIceRocketFlavoursIsNotNullWithStock() {

        // given
        stock.setIceRockets(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        // when
        IceRocket result = iceCreamCar.orderIceRocket();

        // then
        assertNotNull(result);

        double profit = iceCreamCar.getProfit();
        profit = Math.round(profit * 100);
        profit = profit / 100.00;

        assertEquals(0.4,profit);

    }




    //Tests for Magnum

    @Test
    void shouldReturnNullWhenOrderMagnumStockEmpty() {
        //fail("Must be implemented");

        //given

        //when
        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS);

        //then
        assertNull(magnum);
    }



    //    @ParameterizedTest
//    @EnumSource(value = Magnum.MagnumType.class)
    @Test
    void shouldReturnEqualsProfitOrNotNullWhenMagnumOrderConeFlavoursIsNotNullAndIsStock() {

        // given

        // when
        stock.setMagni(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        // then
        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);

        assertNotNull(magnum);

        double profit = iceCreamCar.getProfit();
        profit = Math.round(profit * 100);
        profit = profit / 100.00;

        // actual profit is 0.01875
        assertEquals(0.02, profit);

    }

    //Test profit

    @Test
    void getProfit() {
        //fail("Must be implemented");

        //given
        stock.setIceRockets(1);

        //when
        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        assertNotNull(iceRocket);

        double profit = iceCreamCar.getProfit();
        profit = Math.round(profit * 100);
        profit = profit / 100.00;

        //then
        assertEquals(0.4, profit);
    }

    static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }

    static Stream<Arguments> returnFlavoursList() {
        return Stream.of(Arguments.arguments(List.of(Cone.Flavor.BANANA, Cone.Flavor.LEMON)));
    }

    @Test
    void shouldReturnEqualWhenToString(){

        //given
        IceCreamCar newIceCream = new IceCreamCar(new PriceList(1,2,3),
                                                  new Stock());


        //when
        String string = newIceCream.toString();
        //then
        assertEquals("IceCreamCar{priceList=PriceList{ballPrice=1.0, rocketPrice=2.0, magnumStandardPrice=3.0}, " +
                             "stock=Stock{iceRockets=0, cones=0, balls=0, magni=0}, profit=0.0}",
                     string);
    }

}