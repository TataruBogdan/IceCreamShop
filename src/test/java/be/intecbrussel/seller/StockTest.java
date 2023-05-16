package be.intecbrussel.seller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    Stock stock;

    @BeforeEach
    void setup(){
        stock = new Stock();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setIceRocketsTest(int iceRocketsPrice) {

        //given

        //when
        stock.setIceRockets(iceRocketsPrice);
        //then
        assertEquals(iceRocketsPrice, stock.getIceRockets());
    }

    @Test
    void getIceRocketTest() {

        //given

        //when
        stock.setIceRockets(2);

        //then
        assertEquals(2, stock.getIceRockets());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setConesTest(int conesPrice) {

        //give

        //when
        stock.setCones(conesPrice);
        //then
        assertEquals(conesPrice, stock.getCones());

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setBallsTest(int ballsPrice) {

        //give

        //when
        stock.setBalls(ballsPrice);
        //then
        assertEquals(ballsPrice, stock.getBalls());
    }

    @Test
    void getBallsTest() {

        //given

        //when
        stock.setBalls(2);

        //then
        assertEquals(2, stock.getBalls());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setMagniTest(int magniPrice) {

        //give

        //when
        stock.setIceRockets(magniPrice);
        //then
        assertEquals(magniPrice, stock.getIceRockets());
    }

    @Test
    void getMagniTest() {

        //given

        //when
        stock.setMagni(2);

        //then
        assertEquals(2, stock.getMagni());
    }
}