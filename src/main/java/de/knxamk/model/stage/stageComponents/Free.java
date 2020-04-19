package de.knxamk.model.stage.stageComponents;

public class Free extends StageContentPassable
{

    String segmentName = "free";

    public void action()
    {
    }

    @Override
    public String toString()
    {
        return segmentName;
    }
}
