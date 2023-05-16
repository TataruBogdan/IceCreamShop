package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamSalonTest {

    IceCreamSalon iceCreamSalon;
    PriceList priceList;
    @BeforeEach
    void setup() {
        priceList = new PriceList(0,0,0);
        iceCreamSalon = new IceCreamSalon(priceList);
    }

    @Test
    void shouldReturnEqualsWhenProfit() {
        //fail("Must be implemented");
        //given
        PriceList priceListProfit = new PriceList(1,2,4);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);

        //when
        Magnum magnum = iceCreamSalonProfit.orderMagnum(Magnum.MagnumType.APLINENUTS);
        double profit = iceCreamSalonProfit.getProfit();
        //then
        assertEquals(0.06, profit);
    }

    @ParameterizedTest
    @MethodSource("returnFlavours")
    void shouldReturnNullNoStockOrderCone(Cone.Flavor coneFlavour) {
        //fail("Must be implemented");

        // given
        Cone.Flavor[] flavors = {coneFlavour};

        //when
        Cone cone = iceCreamSalon.orderCone(flavors);
        //then
        assertNotNull(cone, "ice cream cone : ");


    }

    @Test
    void orderIceRocket() {
        fail("Must be implemented");
    }

    @Test
    void orderMagnum() {
        fail("Must be implemented");
    }

    static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(
                Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }

    @Test
    void getProfit() {
        //fail("Must be implemented");

        //given
        PriceList priceListProfit = new PriceList(1,2, 4);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        IceRocket iceRocket = iceCreamSalonProfit.orderIceRocket();

        //when

        //then
        assertEquals(0.4, iceCreamSalonProfit.getProfit());
    }
}