package org.lostclient.framework;

import org.lostclient.api.script.AbstractScript;

public class Root<T extends AbstractScript> extends Branch<T> {
    @Override
    public boolean isValid() {
        return true;
    }
}
