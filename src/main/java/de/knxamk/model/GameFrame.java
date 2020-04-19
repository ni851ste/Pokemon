package de.knxamk.model;

import de.knxamk.model.stage.Stage;

import java.util.TreeMap;

public class GameFrame
{
    TreeMap<String, Stage> mapList;

    public GameFrame(TreeMap<String, Stage> list)
    {
        this.mapList = list;
    }


}
