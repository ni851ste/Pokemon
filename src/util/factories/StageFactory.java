package util.factories;

import model.stage.Stage;
import model.stage.stageComponents.Tree;

public class StageFactory
{
    private Stage createSmallTestStage()
    {
        Stage testStage = new Stage(5, 5);
        testStage.mapData[1][1] = new Tree();

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
