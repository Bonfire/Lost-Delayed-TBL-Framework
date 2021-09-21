package org.lostclient.behaviour.combat;

import org.lostclient.Main;
import org.lostclient.api.accessors.Players;
import org.lostclient.framework.Root;
import org.lostclient.utilities.Timing;

public class CombatBranch extends Root {

    @Override
    public boolean isValid() {
        return Timing.isValidTick() && !Players.localPlayer().isInCombat() && !Players.localPlayer().isMoving();
    }
}