package de.knxamk.model.stage;

import de.knxamk.model.stage.stageComponents.Free;
import de.knxamk.model.stage.stageComponents.StageContent;
import de.knxamk.model.stage.stageComponents.StageContentNotPassable;
import de.knxamk.model.stage.stageComponents.Tree;
import de.knxamk.util.TwoTouple;
import de.knxamk.util.exceptions.IndexNotFittingException;

import java.util.Optional;

public class Stage
{
    public final int width, height;
    private final StageContent[][] stageContent;


    /**
     * Contructor for map
     * 0: width INTEGER > 2
     * 1: height INTEGER > 2
     * throws IndexNotFittingException
     */
    public Stage(int width, int height) throws IndexNotFittingException
    {

        if (width < 3 | height < 3)
        {
            throw new IndexNotFittingException(String.format("Stage with width %d and height %d could not be created!", width, height));
        }

        this.width = width;
        this.height = height;
        this.stageContent = new StageContent[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if (i == 0 | i == width - 1 | j == 0 | j == height - 1)
                {
                    stageContent[i][j] = new Tree();
                }
                else
                {
                    stageContent[i][j] = new Free();
                }
            }
        }
    }
/*
    public TwoTouple<Integer> changePosition(int widthPos, int heightPos) throws IndexNotFittingException
    {
        if (!isMapBlockInBounds(widthPos, heightPos))
        {
            // TODO What does it do?
            throw new IndexNotFittingException("WHAT THE FUCK DOES THIS DO?????");
        }
        this.currentPos.change(widthPos, heightPos);
    }

 */


    /**
     * returns true if block on map is free
     * else returns false
     */
    public boolean isBlockPassable(int w, int h)
    {
        return !(stageContent[w][h] instanceof StageContentNotPassable);
    }

    /**
     * checks if position is in bounds of map
     * returns true if it is
     * False if not
     */
    public boolean isMapBlockInBounds(int w, int h)
    {
        return !(w < 0 | w >= width |
                h < 0 | h >= height);
    }

    public Optional<StageContent> getStageContentWithCoord(int w, int h)
    {
        if (!this.isMapBlockInBounds(w, h))
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(stageContent[w][h]);
        }
    }

}
