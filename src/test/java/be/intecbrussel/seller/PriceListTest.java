package be.intecbrussel.seller;

import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {

    PriceList priceList;

    @BeforeEach
    void setup() {
        priceList = new PriceList(1,2,2);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.00, 2.50})
    void getBallPrice(double ballPrice) {

        //given
        priceList.setBallPrice(ballPrice);
        //when
        double actualBallPrice = priceList.getBallPrice();

        //then
        assertEquals(ballPrice, actualBallPrice);

    }

    @ParameterizedTest
    @ValueSource(doubles = {1.00, 2.50})
    void setBallPrice(double ballPrice) {
        //given

        //when
        priceList.setBallPrice(ballPrice);
        //then
        assertEquals(ballPrice, priceList.getBallPrice());
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.00, 2.50})
    void getRocketPrice(double rocketPrice) {
        //given
        priceList.setRocketPrice(rocketPrice);
        //when
        double actualBallPrice = priceList.getRocketPrice();

        //then
        assertEquals(rocketPrice, actualBallPrice);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.00, 2.50})
    void setRocketPrice(double rocketPrice) {

        //given

        //when
        priceList.setRocketPrice(rocketPrice);

        //then
        assertEquals(rocketPrice, priceList.getRocketPrice());
    }

    //TODO - test for all other enums
    @ParameterizedTest
    @EnumSource(value = Magnum.MagnumType.class,
            names = {"MILKCHOCOLATE"})
    void getMagnumPrice(Magnum.MagnumType magnumType) {
        //given
        //when
        double magnumPriceMilk = priceList.getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE);
//        double magnumPriceWhite = priceList.getMagnumPrice(Magnum.MagnumType.WHITECHOCOLATE);
//        double magnumPriceBlack = priceList.getMagnumPrice(Magnum.MagnumType.BLACKCHOCOLATE);
//        double magnumPriceRTCS = priceList.getMagnumPrice(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
//        double magnumPriceAplin= priceList.getMagnumPrice(Magnum.MagnumType.APLINENUTS);

        double magnumPriceType = priceList.getMagnumPrice(magnumType);

        //then
        assertEquals(magnumPriceType, magnumPriceMilk );
//        assertEquals(magnumPriceType, magnumPriceWhite );
//        assertEquals(magnumPriceType, magnumPriceBlack );
//        assertEquals(magnumPriceType, magnumPriceRTCS );
//        assertEquals(magnumPriceType, magnumPriceAplin );
    }

    @Test
    void setMagnumStandardPrice() {
        //given

        //when
        priceList.setMagnumStandardPrice(5);

        //then
        assertEquals(5, priceList.getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE) / 0.25);
    }
}