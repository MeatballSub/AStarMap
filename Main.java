public class Main
{
    public static void main(String [] args)
    {
        OutOfPlaceEvaluationFunction ef = new OutOfPlaceEvaluationFunction("01234567");

        Problem problem = new Problem("76543210", actionsFunction, resultFunction, goalTest);

        RecursiveBestFirstSearch rbfs = new RecursiveBestFirstSearch(ef);

        List<Action> result = rbfs.search(problem);
    }
}
