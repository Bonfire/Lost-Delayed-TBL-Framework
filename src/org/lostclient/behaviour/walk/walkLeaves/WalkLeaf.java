package org.lostclient.behaviour.walk.walkLeaves;

import org.lostclient.Main;
import org.lostclient.api.accessors.Players;
import org.lostclient.framework.Leaf;
import org.lostclient.utilities.API;
import org.lostclient.utilities.Interaction;

public class WalkLeaf extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int onLoop() {
        // Note here that walking is done in a while loop. Meaning if your path is long, this will only delay the first walking call
        Interaction.delayWalk(Players.localPlayer().getSurroundingArea(3).getRandomTile(), API.getSleepDelay());

        return API.loopReturn();
    }
}

