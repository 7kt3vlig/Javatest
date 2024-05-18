package dev;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;



@ScriptManifest(name = "woodcutter", author = "peter", version = 1.0, info = "", logo = "")

public class main extends Script {

    private Area wcArea = new Area(3149, 3465, 3160, 3450);

    @Override
    public int onLoop() throws InterruptedException {


        if(!wcArea.contains(myPlayer())) {
            if(getWalking().webWalk(wcArea)){
                new ConditionalSleep(1000, 4000){
                    @Override
                    public boolean condition() throws InterruptedException {
                        return false;
                    }
                }.sleep();
            }else {
                RS2Object tree = getObjects().closest("Tree");
                if(tree != null){
                    if(myPlayer().isAnimating()){
                        tree.interact("Chop down");
                        getMouse().moveOutsideScreen();
                        sleep(random(1000, 3000));
                    }
                }
            }

        }


        return 602;
    }
}