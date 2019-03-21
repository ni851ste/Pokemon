package controller;
import model.*;
import ownUtil.*;
import zmaps.*;

import java.util.ArrayList;
import java.util.List;


public class controller extends ownUtil.Subject {
    public enum state {move, menu,  talk, fight}
    //public enum objects {bounds, free, player, highgrass, tree}
    private state s;
    private gameFrame gF;
    private player currPlayer;
    private List<Observer> observers = new ArrayList<>();

    public controller (gameFrame gF, player p, state s){
         this.gF = gF;
         this.currPlayer = p;
         this.s = s;
    }

    public boolean move (char direction){
        if (!s.equals(state.move)){
            System.out.println("state failure");
            return false;
        }
        int newWidth, newHeight;

        newWidth = currPlayer.currentmap.currentPos.get(0);
        newHeight = currPlayer.currentmap.currentPos.get(1);
        switch (direction){
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
        if (currPlayer.currentmap.isMapBlockFree(newWidth, newHeight)) {
            try {
                currPlayer.currentmap.changePosition(newWidth, newHeight);
                notifyAllObservers();
                return true;
            } catch (IndexNotFittingException e) {
                return false;
            }
        }
        return false;
    }

    public intTouple getPosition(){
        return currPlayer.currentmap.currentPos;
    }

    public String getObjectCurrMap(int w, int h) {
        mapObject mO = currPlayer.currentmap.specMapObject(w, h);
        if (mO == null)
            return "bounds";
        if (mO instanceof player)
            return "player";
        if (mO instanceof free)
            return "free";
        if (mO instanceof player)
            return "player";
        if (mO instanceof tree)
            return "tree";
        System.exit(2);
        return null;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
