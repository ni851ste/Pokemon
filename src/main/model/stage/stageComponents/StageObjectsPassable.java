package main.model.stage.stageComponents;

public interface StageObjectsPassable extends StageObjects
{

    @Override
    void action();


    enum objects
    {free, highGrass}
}
