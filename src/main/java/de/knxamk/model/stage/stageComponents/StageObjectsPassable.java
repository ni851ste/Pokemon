package de.knxamk.model.stage.stageComponents;

public interface StageObjectsPassable extends StageObjects
{

    @Override
    void action();


    enum objects
    {free, highGrass}
}
