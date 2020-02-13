package main;

import main.aview.Gui;
import main.controller.Controller;
import main.model.GameFrame;
import main.model.Player;
import main.model.stage.Stage;
import main.util.factories.StageFactory;

import java.util.TreeMap;

public class Pokemon
{
    static TreeMap<String, Stage> mapCollection;

    public static void main(String[] args)
    {
        StageFactory stageFactory = new StageFactory();

        Stage[] testStages = stageFactory.createTestStages();

        GameFrame gF = new GameFrame(mapCollection);

        // TODO START MAP HERE CONFIGURED
        Player p1 = new Player(testStages[0]);
        Controller c1 = new Controller(gF, p1);
        Gui g1 = new Gui(c1);
        //Tui t1 = new Tui(c1);
        //c1.attach(t1);
        c1.attach(g1);
        g1.GUI();
        //t1.TUI();

    }


}
