package de.knxamk.controller;

import de.knxamk.model.Player;
import de.knxamk.model.stage.Stage;
import de.knxamk.util.TwoTouple;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackendControllerTest
{
    @Test
    public void creatingAControllerShouldCreateACorrectController()
    {
        Stage testStage = new Stage(5,5);
        Stage[] testStages = new Stage[1];
        testStages[0] = testStage;

        Player p = new Player();

        BackendController controller1 = new BackendController(p, testStages, testStage);
        BackendController controller2 = new BackendController(p, testStages, 0);

        assertEquals(controller1.controllerState, ControllerState.MOVE);

        assertEquals(controller1.getPosition().get(0), controller2.getPosition().get(0));
        assertEquals(controller1.getPosition().get(1), controller2.getPosition().get(1));

    }

    @Test
    public void aSuccesfulMoveShouldMoveThePlayer()
    {
        Stage testStage = new Stage(5,5);
        Stage[] testStages = new Stage[1];
        testStages[0] = testStage;

        BackendController testController = new BackendController(new Player(), testStages, 0);
        Integer previousHeightCoord = testController.getPosition().get(1);

        assertTrue(testController.move('N'));
        TwoTouple<Integer> laterPosition = testController.getPosition();

        assertNotEquals(previousHeightCoord, laterPosition.get(1));

    }

    @Test
    public void aNotValidMoveShouldReturnFalse()
    {
        Stage testStage = new Stage(3, 3);
        Stage[] testStages = new Stage[1];
        testStages[0] = testStage;

        BackendController testController = new BackendController(new Player(), testStages, 0);
        assertFalse(testController.move('N'));
    }

    @Test
    public void gettingAStageContentsShouldReturnTheRightOnes()
    {
        Stage testStage = new Stage(4, 4);
        Stage[] testStages = new Stage[1];
        testStages[0] = testStage;

        BackendController testController = new BackendController(new Player(), testStages, 0);

        assertEquals("player", testController.getStageContentAsStringWithCoord(2, 2));
        assertEquals("bounds", testController.getStageContentAsStringWithCoord(-1, -1));
        assertEquals("free", testController.getStageContentAsStringWithCoord(1, 1));
        assertEquals("tree", testController.getStageContentAsStringWithCoord(0, 0));
    }
}