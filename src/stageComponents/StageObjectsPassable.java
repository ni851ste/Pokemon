package stageComponents;

public interface StageObjectsPassable extends StageObjects
{

    public enum objects
    {free, highGrass}


    @Override
    public void action();
}
