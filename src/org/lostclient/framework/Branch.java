package org.lostclient.framework;

import org.lostclient.api.script.AbstractScript;
import org.lostclient.utilities.API;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Branch<T extends AbstractScript> extends Leaf<T> {

    public final List<Leaf<T>> children;

    public Branch() {
        this.children = new LinkedList<>();
    }


    public Branch<T> addLeafs(Leaf<T>... leaves) {
        Collections.addAll(this.children, leaves);
        return this;
    }


    @Override
    public int onLoop() {
        return children.stream()
                .filter(c -> Objects.nonNull(c) && c.isValid())
                .findAny()
                .map(tLeaf -> {
                    API.currentBranch = this.getClass().getSimpleName();
                    API.currentLeaf = tLeaf.getClass().getSimpleName();
                    return tLeaf.onLoop();
                }).orElse(600);
    }
}
