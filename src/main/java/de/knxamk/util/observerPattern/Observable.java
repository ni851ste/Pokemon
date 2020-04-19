package de.knxamk.util.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Observable
{
    transient List<Observer> subscribers = new ArrayList<>();

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
