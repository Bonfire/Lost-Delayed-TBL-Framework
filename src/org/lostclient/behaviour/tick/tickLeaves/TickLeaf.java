package org.lostclient.behaviour.tick.tickLeaves;

import org.lostclient.Main;
import org.lostclient.framework.Leaf;
import org.lostclient.utilities.API;

public class TickLeaf extends Leaf<Main> {

    // If this leaf is called, that means that there is currently a tick timeout
    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int onLoop() {
        // Decrement the tick timeout by one and wait for exactly one tick (600ms)
        API.tickTimeout--;
        return 600;
    }
}
