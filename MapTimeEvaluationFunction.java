public class MapTimeEvaluationFunction implements EvaluationFunction
{
    private String goalState;

    public MapTimeEvaluationFunction(String theGoalState)
    {
        goalState = theGoalState;
    }

    public double f(Node n)
    {
        double rval = n.getPathCost();
        String currentState = (String)n.getState();

        InputReader inputReader = new InputReader("Input.txt");

        int currentIndex = inputReader.getCities().indexOf(currentState);
        int goalIndex = inputReader.getCities().indexOf(goalState);

        rval += inputReader.getCrowTimes().get(currentIndex).get(goalIndex);

        return rval;

    }
}
