package model;

import zmaps.Stage;
import zmaps.StageObjects;

public class Player implements StageObjects
{
    public Stage currentmap = null;

    public Player(Stage m1)
    {
        this.currentmap = m1;
        this.currentmap.player = this;
    }

    public void changeMap(Stage m)
    {
        this.currentmap.player = null;
        this.currentmap = m;
    }

    @Override
    public void action()
    {
    }
}
