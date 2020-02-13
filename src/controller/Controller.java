package controller;

import model.GameFrame;
import model.Player;
import ownUtil.IndexNotFittingException;
import ownUtil.Observer;
import ownUtil.TwoTouple;
import stageComponents.Free;
import stageComponents.StageObjects;
import stageComponents.Tree;

import java.util.ArrayList;
import java.util.List;


public class Controller extends ownUtil.Subject
{
    //public enum objects {bounds, free, player, highgrass, tree}
    private ControllerState controllerState;
    private GameFrame gF;
    private Player currPlayer;
    private List<Observer> observers = new ArrayList<>();

    public Controller(GameFrame gF, Player p)
    {
        this.gF = gF;
        this.currPlayer = p;
        this.controllerState = ControllerState.MOVE;
    }

    public boolean move(char direction)
    {
        if (!controllerState.equals(ControllerState.MOVE))
        {
            System.out.println("state failure");
            return false;
        }
        int newWidth, newHeight;

        newWidth = currPlayer.currentMap.currentPos.get(0);
        newHeight = currPlayer.currentMap.currentPos.get(1);

        switch (direction)
        {
            case 'N':
                ++newHeight;
                break;
            case 'W':
                --newWidth;
                break;
            case 'S':
                --newHeight;
                break;
            case 'E':
                ++newWidth;
                break;
        }

        if (currPlayer.currentMap.isMapBlockFree(newWidth, newHeight))
        {
            try
            {
                currPlayer.currentMap.changePosition(newWidth, newHeight);
                notifyAllObservers();
                return true;
            } catch (IndexNotFittingException e)
            {
                return false;
            }
        }

        return false;
    }

    public TwoTouple<Integer> getPosition()
    {
        return currPlayer.currentMap.currentPos;
    }

    public String getObjectCurrMap(int w, int h)
    {
        StageObjects mO = currPlayer.currentMap.specMapObject(w, h);
        if (mO == null)
            return "bounds";
        if (mO instanceof Player)
            return "player";
        if (mO instanceof Free)
            return "free";
        if (mO instanceof Player)
            return "player";
        if (mO instanceof Tree)
            return "tree";
        System.exit(2);
        return null;
    }

    @Override
    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers()
    {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }
}
