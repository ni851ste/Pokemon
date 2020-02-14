package de.knxamk.util.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Observable
{
    List<Observer> subscribers = new ArrayList<Observer>();

    public void addListener(Observer s)
    {
        subscribers.add(s);
    }

    public void remove(Observer s)
    {
        throw new RuntimeException("Method Observer.remove not implemented");
    }

    public void notifyObservers()
    {
        subscribers.forEach(sub -> sub.update());
    }
}
