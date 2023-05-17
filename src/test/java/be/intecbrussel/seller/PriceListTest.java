package be.intecbrussel.seller;

import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PriceListTest {

    PriceList priceList;

    @BeforeEach
    void setup() {
        priceList = new PriceList(1,2,2);
    }

    // Test for PriceList
    @Test
    void shouldReturnNullWhenPriceListWithoutParameters() {
        //fail("Must be implemented");

        // given

        // when
        PriceList priceList1 = new PriceList() ;
        // then
        assertNull(null);

    }

    @ParameterizedTest   @ValueSource(doubles = {1.00, 2.50})
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
    //@EnumSource(value = Magnum.MagnumType.class, names = {"MILKCHOCOLATE"})
    //@ValueSource(doubles = {0.25, 0.5, 0.75, 1.25, 1.5})
    @MethodSource("argumentsStream")
    void shouldReturnEqualsWhenMagnumTypeMatchParameterType(Magnum.MagnumType magnumType,
            double expectedPrice) {
        //given

        //when
        double magnumPriceType = priceList.getMagnumPrice(magnumType);
//        double magnumPriceTypeWhite = priceList.getMagnumPrice(magnumType[1]);
//        double magnumPriceTypeBlack = priceList.getMagnumPrice(magnumType[2]);
//        double magnumPriceTypeRTCS = priceList.getMagnumPrice(magnumType[3]);
//        double magnumPriceTypeAlpine = priceList.getMagnumPrice(magnumType[4]);

        //then
        assertEquals(expectedPrice, magnumPriceType );
//        assertEquals(expectedPrice[1], magnumPriceTypeWhite );
//        assertEquals(expectedPrice[2], magnumPriceTypeBlack );
//        assertEquals(expectedPrice[3], magnumPriceTypeRTCS );
//        assertEquals(expectedPrice[4], magnumPriceTypeAlpine );
    }

//    static Stream<Arguments> argumentsStream() {
//        return Stream.of(
//                Arguments.arguments(Magnum.MagnumType.values(), new double[]{0.5, 1.0, 1.5, 3.0, 2.5}));
//    }

    static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.arguments(Magnum.MagnumType.APLINENUTS, 3.0),
                Arguments.arguments(Magnum.MagnumType.BLACKCHOCOLATE, 1.5),
                Arguments.arguments(Magnum.MagnumType.WHITECHOCOLATE, 1.0),
                Arguments.arguments(Magnum.MagnumType.MILKCHOCOLATE, 0.5),
                Arguments.arguments(Magnum.MagnumType.ROMANTICSTRAWBERRIES, 2.5));
    }


    @Test
    void setMagnumStandardPrice() {
        //given

        //when
        priceList.setMagnumStandardPrice(5);

        //then
        assertEquals(5, priceList.getMagnumPrice(Magnum.MagnumType.MILKCHOCOLATE) / 0.25);
    }

    @Test
    void shouldReturnEqualWhenToString(){

        //given

        //when
        String string = priceList.toString();
        //then
        assertEquals("PriceList{ballPrice=1.0, rocketPrice=2.0, magnumStandardPrice=2.0}",
                     string);
    }

}