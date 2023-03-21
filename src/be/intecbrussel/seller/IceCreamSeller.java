package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public interface IceCreamSeller extends Profitable{

    Cone orderCone(Cone.Flavor[] flavors);
    IceRocket orderIceRocket();
    Magnum orderMagnum(Magnum.MagnumType magnumType);

}
