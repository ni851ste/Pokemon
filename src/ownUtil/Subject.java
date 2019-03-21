package ownUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    List<Observer> observers;

    public abstract void attach(Observer observer);

    public abstract void notifyAllObservers();
}