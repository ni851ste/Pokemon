package de.knxamk.util.observerPattern;

import java.util.List;

public abstract class Subject
{

    List<Observer> observers;

    public abstract void attach(Observer observer);

    public abstract void notifyAllObservers();
}