public class MapGoalTest implements GoalTest
{
    String theGoalState;

    MapGoalTest(String goalState)
    {
        theGoalState = goalState;
    }

    public boolean isGoalState(Object state)
    {
        boolean rval = false;

        String theState = (String) state;

        rval = theState.equals(theGoalState);

        return rval;
    }
}
