package de.knxamk.util.observerPattern;

import java.util.List;

public abstract class Subject
{

    List<Observer> observers;

    public abstract void listenTo(Observer observer);

    public void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }
}