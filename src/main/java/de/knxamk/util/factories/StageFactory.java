package de.knxamk.util.factories;


import de.knxamk.model.stage.Stage;
import de.knxamk.model.stage.stageComponents.Tree;

public class StageFactory
{
    private Stage createSmallTestStage()
    {
        Stage testStage = new Stage(5, 5);

        // TODO Find a way to edit maps or hardcode then for creation
        //testStage.stageContent[1][1] = new Tree();

        return testStage;
    }

    private Stage createMediumTestStage()
    {
        return new Stage(10, 10);
    }

    public Stage[] createTestStages()
    {
        Stage[] testStages = new Stage[2];

        testStages[0] = createSmallTestStage();
        testStages[1] = createMediumTestStage();

        return testStages;
    }
}
