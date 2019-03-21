import ownUtil.IndexNotFittingException;
import java.util.TreeMap;
import aview.*;
import controller.*;
import model.*;
import zmaps.*;

public class init {
    static TreeMap<String,map> mapList;

    public static void main(String[] args){
        try {
            map map1 = new map(5, 5);
            map1.mapData[1][1] = new tree();

            map map2 = new map(10, 10);

            mapList = new TreeMap<>();
            mapList.put("map1", map1);
            mapList.put("map2", map2);

        } catch (IndexNotFittingException e){
            System.out.println("Generating maps failed");
            System.exit(1);
        }

        gameFrame gF = new gameFrame(mapList);

        //TODO START MAP HERE CONFIGURED
        player p1 = new player (mapList.get("map2"));
        controller c1 = new controller (gF, p1, controller.state.move);
        GUI g1 = new GUI (c1);
        TUI t1 = new TUI (c1);
        c1.attach(t1);
        c1.attach(g1);
        g1.GUI();
        t1.TUI();

    }




}
