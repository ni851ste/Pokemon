import aview.Gui;
import aview.Tui;
import controller.Controller;
import model.GameFrame;
import model.Player;
import ownUtil.IndexNotFittingException;
import zmaps.Stage;
import zmaps.Tree;

import java.util.TreeMap;

public class Pokemon
{
    static TreeMap<String, Stage> mapCollection;

    public static void main(String[] args)
    {
        try
        {
            Stage testStage1 = new Stage(5, 5);
            testStage1.mapData[1][1] = new Tree();

            Stage testStage2 = new Stage(10, 10);

            mapCollection = new TreeMap<>();
            mapCollection.put("testStage1", testStage1);
            mapCollection.put("testStage2", testStage2);

        } catch (IndexNotFittingException e)
        {
            System.out.println("Generating maps failed");
            System.exit(1);
        }

        GameFrame gF = new GameFrame(mapCollection);

        // TODO START MAP HERE CONFIGURED
        Player p1 = new Player(mapCollection.get("testStage1"));
        Controller c1 = new Controller(gF, p1, Controller.state.move);
        Gui g1 = new Gui(c1);
        Tui t1 = new Tui(c1);
        c1.attach(t1);
        c1.attach(g1);
        g1.GUI();
        t1.TUI();

    }


}
