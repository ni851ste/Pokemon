package model;

import model.stage.Stage;
import model.stage.stageComponents.StageObjects;

public class Player implements StageObjects
{
    public Stage currentMap = null;

    public Player(Stage m1)
    {
        this.currentMap = m1;
        this.currentMap.player = this;
    }

    public void changeMap(Stage m)
    {
        this.currentMap.player = null;
        this.currentMap = m;
    }

    @Override
    public void action()
    {
    }
}
