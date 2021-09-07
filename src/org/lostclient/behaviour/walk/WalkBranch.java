package org.lostclient.behaviour.walk;

import org.lostclient.Main;
import org.lostclient.api.wrappers.walking.Walking;
import org.lostclient.framework.Root;

public class WalkBranch extends Root<Main> {

    @Override
    public boolean isValid() {
        return Walking.shouldWalk(6);
    }
}