package main.util.observerPattern;

public interface Observer
{
    Subject subject = null;

    void update();
}