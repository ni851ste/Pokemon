package de.knxamk;


import de.knxamk.aview.Gui;
import de.knxamk.aview.Tui;
import de.knxamk.controller.Controller;
import de.knxamk.model.Player;
import de.knxamk.model.stage.Stage;
import de.knxamk.util.factories.StageFactory;

public class Pokemon
{

    // TODO
    //  Logger, Tests with Mockito, mayB Exceptions

    public static void main(String[] args)
    {
        StageFactory stageFactory = new StageFactory();

        Stage[] testStages = stageFactory.createTestStages();


        // TODO START MAP HERE CONFIGURED
        Player player = new Player();
        Controller controller = new Controller(player, testStages, 1);
        Gui gui = new Gui(controller);
        Tui tui = new Tui(controller);

        controller.addListener(tui);
        controller.addListener(gui);

        gui.startGui();
        tui.startTui();

    }


}
