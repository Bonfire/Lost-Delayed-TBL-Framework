package org.lostclient.framework;


import org.lostclient.api.script.AbstractScript;

public abstract class Leaf {
    public abstract boolean isValid();

    public abstract int onLoop();
}
