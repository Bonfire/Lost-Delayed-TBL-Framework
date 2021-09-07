package org.lostclient.utilities;

import org.lostclient.api.events.EntityInteractEvent;
import org.lostclient.api.events.InteractionEvent;
import org.lostclient.api.interfaces.Locatable;
import org.lostclient.api.utilities.MethodProvider;
import org.lostclient.api.wrappers.actions.MenuAction;
import org.lostclient.api.wrappers.interactives.Entity;
import org.lostclient.api.wrappers.walking.Walking;

public class Interaction {
    public static void delayEntityInteract(Entity entity, String action, long sleepDelay) {
        MethodProvider.sleep(sleepDelay);
        new EntityInteractEvent(entity, new MenuAction().setAction(action)).execute();
    }

    public static void delayWalk(Locatable locatable, long sleepDelay) {
        MethodProvider.sleep(sleepDelay);
        Walking.walk(locatable.getTile());
    }
}
