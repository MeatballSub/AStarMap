import java.util.List;

public class Main
{
    public static void main(String [] args)
    {
        String goalState = "Stormwind";

        MapTimeEvaluationFunction ef = new MapTimeEvaluationFunction(goalState);
        MapMoveActionsFunction actionsFunction = new MapMoveActionsFunction();
        MapResultFunction resultFunction = new MapResultFunction();
        MapGoalTest goalTest = new MapGoalTest(goalState);
        MapTimeStepCostFunction stepCostFunction = new MapTimeStepCostFunction();

        Problem problem = new Problem("Silvermoon", actionsFunction, resultFunction, goalTest, stepCostFunction);

        RecursiveBestFirstSearch rbfs = new RecursiveBestFirstSearch(ef);

        List<Action> result = rbfs.search(problem);

        System.out.print("Silvermoon");
        for(Action a : result)
        {
            System.out.print(" -> " + ((MapMoveAction)a).getDestination());
        }
        System.out.println();
    }
}
