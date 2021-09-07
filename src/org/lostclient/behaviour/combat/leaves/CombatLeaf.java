package org.lostclient.behaviour.combat.leaves;

import org.lostclient.Main;
import org.lostclient.api.accessors.NPCs;
import org.lostclient.api.utilities.math.Calculations;
import org.lostclient.api.wrappers.interactives.NPC;
import org.lostclient.framework.Leaf;
import org.lostclient.utilities.Interaction;
import org.lostclient.utilities.Timing;

import java.util.List;

public class CombatLeaf extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int onLoop() {
        List<NPC> nearbyChickens = NPCs.all(npc -> npc != null && npc.getName().equals("Chicken") && npc.canReach() && !npc.isInCombat());
        NPC nearbyChicken = nearbyChickens.get(Calculations.random(nearbyChickens.size()));

        if (nearbyChicken != null && Interaction.delayEntityInteract(nearbyChicken, "Attack", Timing.getSleepDelay())) {
            return Timing.loopReturn();
        }

        return Timing.loopReturn();
    }
}
