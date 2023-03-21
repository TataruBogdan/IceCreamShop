package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller{

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {

        Cone orderdCone = new Cone(flavors);

        //TODO -
        Cone preparedCone = prepareCone(flavors);

        for (int i = 0; i < flavors.length; i++) {
            double priceCone = priceList.getBallPrice();
            this.profit = priceCone  * 0.25;

        }

        return preparedCone;
    }

    // get the profit from the IceCream

    private Cone prepareCone(Cone.Flavor[] flavors) {

        Cone iceCone = new Cone(flavors);

        int currentStock = stock.getBalls();
        if (currentStock != 0){
            currentStock = currentStock - 1 ;
        } else {
            System.out.println("NO MORE CONE ICE CREAM");
            return null;
        }
        stock.setBalls(currentStock);
        // return a Cone obj with profit ???
        return iceCone;
    }

    @Override
    public IceRocket orderIceRocket() {

        IceRocket iceRocket = prepareRocket();

        int currentStock =  stock.getIceRockets();
        if (currentStock != 0) {
            currentStock = currentStock - 1;
        } else {
            System.out.println("NO MORE ROCKET ICE CREAM");
            return null;
        }
        stock.setIceRockets(currentStock);

        return iceRocket;
    }

    private IceRocket prepareRocket() {

        // return IceRocket - profit
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {

        Magnum preparedMagnum = prepareMagnum(magnumType);

        return  preparedMagnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) {

        int magniStock = stock.getMagni();
        if (magniStock != 0) {
            magniStock -= magniStock;
            stock.setMagni(magniStock);
        } else {
            System.out.println("NO MORE MAGNUM ICE CREAM");
            return null;
        }
        // return profit for magnum
        return new Magnum(magnumType);
    }

    public double getProfit() {
        return profit;
    }
}
