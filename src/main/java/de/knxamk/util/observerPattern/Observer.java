package de.knxamk.util.observerPattern;

public interface Observer
{
    Subject subject = null;

    void update();
}