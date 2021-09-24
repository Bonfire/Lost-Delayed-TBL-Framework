package org.lostclient;

import org.lostclient.api.listeners.Painter;
import org.lostclient.api.script.AbstractScript;
import org.lostclient.api.script.ScriptManifest;
import org.lostclient.behaviour.combat.CombatBranch;
import org.lostclient.behaviour.combat.leaves.CombatLeaf;
import org.lostclient.behaviour.fallback.FallbackLeaf;
import org.lostclient.behaviour.timeout.TimeoutLeaf;
import org.lostclient.framework.Tree;
import org.lostclient.utilities.API;
import org.lostclient.utilities.Timing;
import org.lostclient.api.utilities.paint.CustomPaint;
import org.lostclient.api.utilities.paint.PaintInfo;

import java.awt.*;

@ScriptManifest(author = "Bonfire", name = "LostDelayedTBL", version = 1.00)
public class Main extends AbstractScript implements Painter, PaintInfo {

    // Instantiate the tree to hold our branches and leaves
    private final Tree tree = new Tree();

    // Instantiate the paint object. This can be customized to your liking.
    private final CustomPaint CUSTOM_PAINT = new CustomPaint(this,
            CustomPaint.PaintLocations.BOTTOM_LEFT_PLAY_SCREEN, new Color[]{new Color(255, 251, 255)},
            "Trebuchet MS",
            new Color[]{new Color(50, 50, 50, 175)},
            new Color[]{new Color(28, 28, 29)},
            1, false, 5, 3, 0);
    private final RenderingHints aa = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Our onStart that supports arguments
    @Override
    public void onStart(String... args) {
        instantiateTree();
    }

    // Our onStart for when no arguments have been passed to the script
    @Override
    public void onStart() {
        instantiateTree();
    }

    @Override
    public void onExit() {
        Timing.tickTimeout = 0;
        Timing.sleepLength = 0;
    }

    // Add all of the branches and leaves to the tree
    private void instantiateTree() {
        tree.addBranches(
                new TimeoutLeaf(),
                // Place your own branches and leaves below this

                new CombatBranch().addLeafs(new CombatLeaf()),

                // Place your own branches and leaves above this
                new FallbackLeaf()
        );
    }

    // Infinite loop. Returns the current leaf and executes it
    @Override
    public int onLoop() {
        return this.tree.onLoop();
    }

    // Our paint info
    // Add new lines to the paint here
    @Override
    public String[] getPaintInfo() {
        return new String[]{
                AbstractScript.getScriptName() + " V" + AbstractScript.getScriptVersion(),
                "Current Branch: " + API.currentBranch,
                "Current Leaf: " + API.currentLeaf,
                "Tick Timeout: " + Timing.tickTimeout,
                "Sleep Delay: " + Timing.sleepLength + "ms"
        };
    }

    // onPaint (you probably don't need to touch this)
    @Override
    public void onPaint(Graphics2D graphics2D) {
        graphics2D.setRenderingHints(aa);
        CUSTOM_PAINT.paint(graphics2D);
    }
}
