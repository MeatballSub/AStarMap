import java.util.List;

public class Main
{
    public static void main(String [] args)
    {
        String goalState = "012345678";

        OutOfPlaceEvaluationFunction ef = new OutOfPlaceEvaluationFunction(goalState);
        EightPuzzleActionsFunction actionsFunction = new EightPuzzleActionsFunction();
        EightPuzzleResultFunction resultFunction = new EightPuzzleResultFunction();
        EightPuzzleGoalTest goalTest = new EightPuzzleGoalTest(goalState);

        Problem problem = new Problem("528417036", actionsFunction, resultFunction, goalTest);

        RecursiveBestFirstSearch rbfs = new RecursiveBestFirstSearch(ef);

        List<Action> result = rbfs.search(problem);

        for(Action a : result)
        {
            if(a instanceof EightPuzzleUpAction)
            {
                System.out.print("U-");
            }
            else if(a instanceof EightPuzzleDownAction)
            {
                System.out.print("D-");
            }
            else if(a instanceof EightPuzzleLeftAction)
            {
                System.out.print("L-");
            }
            else if(a instanceof EightPuzzleRightAction)
            {
                System.out.print("R-");
            }
        }
        System.out.println();
    }
}
