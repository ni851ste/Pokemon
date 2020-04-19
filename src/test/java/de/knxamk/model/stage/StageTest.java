package de.knxamk.model.stage;

import de.knxamk.model.stage.stageComponents.Free;
import de.knxamk.model.stage.stageComponents.Tree;
import de.knxamk.util.exceptions.IndexNotFittingException;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StageTest
{
    @Test
    public void creatingAStageShouldCreateACorrectStage()
    {
        Stage testStage = new Stage(5,6);
        assertEquals(testStage.width, 5);
        assertEquals(testStage.height, 6);

        assertEquals(Tree.class, testStage.getStageContentWithCoord(0, 0).get().getClass());
    }

    @Test(expected = IndexNotFittingException.class)
    public void creatingATooSmallStageShouldBeReported()
    {
        new Stage(2,2);
    }

    @Test
    public void theEdgesOfStagesShouldBeNotPassable()
    {
        Stage testStage = new Stage(5,5);
        assertFalse(testStage.isBlockPassable(0,0));
    }

    @Test(expected = NoSuchElementException.class)
    public void outOfBoundsStageContentShouldBeEmpty()
    {
        Stage testStage = new Stage(5,5);
        testStage.getStageContentWithCoord(5, 5).get();
    }

    @Test
    public void gettingStageContentWithCoordsShouldReturnTheCorrectContent()
    {
        Stage testStage = new Stage(5,5);
        assertEquals(Free.class, testStage.getStageContentWithCoord(2, 2).get().getClass());
        assertEquals(Tree.class, testStage.getStageContentWithCoord(0, 0).get().getClass());

    }

}