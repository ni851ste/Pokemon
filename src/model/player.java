package model;
import ownUtil.intTouple;
import zmaps.*;

public class player implements mapObject {
    public map currentmap = null;

    public player(map m1){
        this.currentmap = m1;
        this.currentmap.player = this;
    }

    public void changeMap (map m){
        this.currentmap.player = null;
        this.currentmap = m;
    }

    @Override
    public void action() { }
}
