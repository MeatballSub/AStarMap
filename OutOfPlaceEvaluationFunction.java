public class OutOfPlaceEvaluationFunction implements EvaluationFunction
{
    private String goalState;

    public OutOfPlaceEvaluationFunction(String goalState)
    {
        this.goalState = goalState;
    }

    public double f(Node n)
    {
        double rval = n.getPathCost();
        String currentState = (String)n.getState();

        for(int i = 0; i < goalState.length(); ++i)
        {
            if( (i >= currentState.length()) || (goalState.charAt(i) != currentState.charAt(i)) )
            {
                ++rval;
            }
        }

        return rval;
    }
}
