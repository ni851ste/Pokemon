package de.knxamk.model.stage.stageComponents;

public interface StageObjectPassable extends StageObject
{

    @Override
    void action();


    enum objects
    {free, highGrass}
}
