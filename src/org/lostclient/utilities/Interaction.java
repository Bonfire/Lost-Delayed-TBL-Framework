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
        return new EntityInteractEvent(entity, action).executed();
    }
}
