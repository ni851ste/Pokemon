package de.knxamk.controller;

import de.knxamk.model.Player;
import de.knxamk.model.stage.Stage;
import de.knxamk.model.stage.stageComponents.StageContent;
import de.knxamk.util.TwoTouple;
import de.knxamk.util.observerPattern.Observable;

import java.util.Optional;


public class BackendController extends Observable
{
    public ControllerState controllerState;
    private Player player;
    private TwoTouple<Integer> playerPosition;

    private Stage[] stages;
    private Stage currentStage;

    private BackendController()
    {
        this.controllerState = ControllerState.MOVE;
    }

    private BackendController(Player p, Stage[] stages)
    {
        this();
        this.stages = stages;
        this.player = p;
    }

    public BackendController(Player p, Stage[] stages, Stage startStage)
    {
        this(p, stages);
        this.currentStage = startStage;
        this.playerPosition = new TwoTouple<>(startStage.width / 2, startStage.height / 2);
    }

    public BackendController(Player p, Stage[] stages, int startStageIndex)
    {
        this(p, stages, stages[startStageIndex]);
    }

    public BackendController(Stage startStage)
    {
        this.player = new Player();
        this.currentStage = startStage;
        this.playerPosition = new TwoTouple<>(startStage.width / 2, startStage.height / 2);
        this.controllerState = ControllerState.MOVE;
    }

    public boolean move(char direction)
    {
        if (!controllerState.equals(ControllerState.MOVE))
        {
            // TODO Log this and dont print this out
            System.out.println("state failure");
            return false;
        }
        int newWidth, newHeight;

        newWidth = playerPosition.get(0);
        newHeight = playerPosition.get(1);

        switch (direction)
        {
            case 'N':
                ++newHeight;
                break;
            case 'E':
                ++newWidth;
                break;
            case 'S':
                --newHeight;
                break;
            case 'W':
                --newWidth;
                break;
        }

        if (currentStage.isBlockPassable(newWidth, newHeight))
        {
            playerPosition.change(newWidth, newHeight);
            notifyObservers();
            return true;

        }

        return false;
    }

    public TwoTouple<Integer> getPosition()
    {
        return playerPosition;
    }

    /**
     * This method returns the player on the playerPosition and not the ground underneath.
     *
     * @return
     */
    public String getStageContentAsStringWithCoord(int w, int h)
    {
        if (playerPosition.get(0) == w && playerPosition.get(1) == h)
            return "player";

        Optional<StageContent> optContent = currentStage.getStageContentWithCoord(w, h);

        if (optContent.isEmpty())
            return "bounds";
        return optContent.get().toString();
    }
}
