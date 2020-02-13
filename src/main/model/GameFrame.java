package main.model;

import main.model.stage.Stage;

import java.util.TreeMap;

public class GameFrame
{
    TreeMap<String, Stage> mapList;

    public GameFrame(TreeMap<String, Stage> list)
    {
        this.mapList = list;
    }


}
