package org.lostclient.behaviour.timeout;

import org.lostclient.Main;
import org.lostclient.api.utilities.MethodProvider;
import org.lostclient.framework.Leaf;
import org.lostclient.utilities.Timing;

public class TimeoutLeaf extends Leaf<Main> {

    // If this leaf is called, that means that there is currently a tick timeout
    @Override
    public boolean isValid() {
        return Timing.tickTimeout > 0;
    }

    @Override
    public int onLoop() {
        // Decrement the tick timeout by one and wait for exactly one tick (600ms)
        Timing.tickTimeout--;
        MethodProvider.log(String.valueOf(Timing.tickTimeout));
        return 600;
    }
}
