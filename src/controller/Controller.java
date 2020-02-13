package controller;

import model.GameFrame;
import model.Player;
import ownUtil.IndexNotFittingException;
import ownUtil.Observer;
import ownUtil.TwoTouple;
import zmaps.Free;
import zmaps.StageObjects;
import zmaps.Tree;

import java.util.ArrayList;
import java.util.List;


public class Controller extends ownUtil.Subject
{
    public enum state
    {move, menu, talk, fight}

    //public enum objects {bounds, free, player, highgrass, tree}
    private state s;
    private GameFrame gF;
    private Player currPlayer;
    private List<Observer> observers = new ArrayList<>();

    public Controller(GameFrame gF, Player p, state s)
    {
        this.gF = gF;
        this.currPlayer = p;
        this.s = s;
    }

    public boolean move(char direction)
    {
        if (!s.equals(state.move))
        {
            System.out.println("state failure");
            return false;
        }
        int newWidth, newHeight;

        newWidth = currPlayer.currentmap.currentPos.get(0);
        newHeight = currPlayer.currentmap.currentPos.get(1);

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

        if (currPlayer.currentmap.isMapBlockFree(newWidth, newHeight))
        {
            try
            {
                currPlayer.currentmap.changePosition(newWidth, newHeight);
                notifyAllObservers();
                return true;
            } catch (IndexNotFittingException e)
            {
                return false;
            }
        }

        return false;
    }

    public TwoTouple getPosition()
    {
        return currPlayer.currentmap.currentPos;
    }

    public String getObjectCurrMap(int w, int h)
    {
        StageObjects mO = currPlayer.currentmap.specMapObject(w, h);
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
