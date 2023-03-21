package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.stream.Stream;

public class IceCreamSalon implements IceCreamSeller{

    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
        totalProfit = 0; // TODO
    }


    public double getProfit() {
        return totalProfit;
    }


    // -orderCone will create and return a new cone based on an array of flavors.
    // will also increase the total profit value based on the price list.(price * 0.25)
    @Override
    public Cone orderCone(Cone.Flavor[] flavors){

        Cone iceCone = new Cone(  flavors);

        long countOrderBalls = Stream.of(flavors)
                .filter(elem -> elem != null)
                .count();

        totalProfit += countOrderBalls * priceList.getBallPrice() * 0.25;

        return iceCone;

    }

    // orderIceRocket will create and return a new iceRocket.
    // will also increase the total profit value based on the price list.(price * 0.20)
    @Override
    public IceRocket orderIceRocket(){

        IceRocket iceRocket = new IceRocket();

        this.totalProfit += priceList.getRocketPrice() * 0.2;// TODO is correct ???

        return iceRocket;
    }

    // orderMagnum will create and return a new Magnum based on a MagnumType.
    // will also increase the total profit value based on the price list.(price * 0.01)
    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {

        Magnum magnum = new Magnum(magnumType);

        this.totalProfit += priceList.getMagnumPrice(magnumType) * 0.01; // TODO is correct ???

        return magnum;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
