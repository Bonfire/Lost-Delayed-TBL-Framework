package org.lostclient.utilities;

import org.lostclient.api.events.EntityInteractEvent;
import org.lostclient.api.interfaces.Locatable;
import org.lostclient.api.utilities.MethodProvider;
import org.lostclient.api.wrappers.actions.MenuAction;
import org.lostclient.api.wrappers.interactives.Entity;
import org.lostclient.api.wrappers.walking.Walking;

public class Interaction {
    public static boolean delayEntityInteract(Entity entity, String action, long sleepDelay) {
        MethodProvider.sleep(sleepDelay);
        return entity.interact(action);
    }

    public static void delayWalk(Locatable locatable, long sleepDelay) {
        MethodProvider.sleep(sleepDelay);
        Walking.walk(locatable.getTile());
    }
}
