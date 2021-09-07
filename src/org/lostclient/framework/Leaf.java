package org.lostclient.framework;


import org.lostclient.api.script.AbstractScript;

public abstract class Leaf<T extends AbstractScript> {
    public abstract boolean isValid();

    public abstract int onLoop();
}
