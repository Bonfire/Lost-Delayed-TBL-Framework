package org.lostclient.behaviour.tick;

import org.lostclient.Main;
import org.lostclient.framework.Root;
import org.lostclient.utilities.API;

public class TickBranch extends Root<Main> {
    @Override
    public boolean isValid() {
        return API.tickTimeout > 0;
    }
}
