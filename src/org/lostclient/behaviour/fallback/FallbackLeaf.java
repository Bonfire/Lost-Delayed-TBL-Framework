package org.lostclient.behaviour.fallback;

import org.lostclient.Main;
import org.lostclient.framework.Leaf;
import org.lostclient.utilities.Timing;

public class FallbackLeaf extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int onLoop() {
        return Timing.loopReturn();
    }
}
