package de.knxamk;


import de.knxamk.aview.Gui;
import de.knxamk.aview.Tui;
import de.knxamk.controller.Controller;
import de.knxamk.model.GameFrame;
import de.knxamk.model.Player;
import de.knxamk.model.stage.Stage;
import de.knxamk.util.factories.StageFactory;

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
        Player player = new Player(testStages[0]);
        Controller controller = new Controller(gF, player);
        Gui gui = new Gui(controller);
        Tui tui = new Tui(controller);
        controller.listenTo(tui);
        controller.listenTo(gui);
        gui.GUI();
        tui.TUI();

    }


}
