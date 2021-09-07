package org.lostclient.behaviour.combat.leaves;

import org.lostclient.Main;
import org.lostclient.api.accessors.NPCs;
import org.lostclient.api.events.EntityInteractEvent;
import org.lostclient.api.utilities.MethodProvider;
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
        // Grab a nearby chicken
        NPC nearbyChicken = NPCs.closest(npc -> npc != null && npc.getName().equals("Chicken") && npc.canReach() && !npc.isInCombat());

        // If the chicken exists, let's perform a delayed entity interaction (in this case, an attack)
        // Notice that we call Timing.getSleepDelay() to randomly fetch a sleep delay for this interaction
        // This sleep is taken prior to taking the action
        if (nearbyChicken != null && Interaction.delayEntityInteract(nearbyChicken, "Attack", Timing.getSleepDelay())) {
            return Timing.loopReturn();
        }

        return Timing.loopReturn();
    }
}
