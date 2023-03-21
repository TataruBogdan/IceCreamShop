package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable{

    private Flavor[] balls;

    // default value Vanilla
    public Cone() {
        this(new Flavor[Flavor.VANILLA.ordinal()]);
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }


    // all different types of balls,
    @Override
    public void eat() {
        System.out.println("You are eating " +
                                   Arrays.toString(this.balls));

    }

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE

    }

    @Override
    public String toString() {
        return "Cone{" +
                "balls=" + Arrays.toString(balls) +
                '}';
    }
}
