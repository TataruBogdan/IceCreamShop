package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.seller.IceCreamCar;
import be.intecbrussel.seller.PriceList;
import be.intecbrussel.seller.Stock;

import java.util.Scanner;

public class IceCreamApp2 {


    public static void main(String[] args) {


        PriceList priceList = new PriceList(1, 2, 4);

        Stock stock = new Stock();
        stock.setBalls(5);
        stock.setIceRockets(5);
        stock.setMagni(5);

        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();




        iceCreamCar.orderIceRocket();
        iceCreamCar.orderCone(new Cone.Flavor[]{});
    }
}
