public class problem
{
    private state initialState;
    private state goalState;
    private ArrayList<action> actionList;
    private heuristic theHeuristic;

    public problem()
    {
    }

    public problem(state initialState, state goalState, ArrayList<action> actionList, heuristic theHeuristic)
    {
        setInitialState(initialState);
        setGoalState(goalState);
        setActions(actionList);
        setHeuristic(theHeuristic)
    }

    public void setInitialState(state s)
    {
        initialState = s;
    }

    public state getInitialState()
    {
        return initialState;
    }

    public void setGoalState(state s)
    {
        goalState = s;
    }

    public state getGoalState()
    {
        return goalState;
    }

    public boolean goal_test(state s)
    {
        return (s.equals(goalState));
    }

    public void setActions(ArrayList<action> aList)
    {
        actionList = aList;
    }

    public ArrayList<action> getActions()
    {
        return actionList;
    }

    public int getCost(state prev, state curr)
    {
        // fix with mapping
        return 1;
    }

    public void setHeuristic(heuristic h)
    {
        theHeuristic = h;
    }

    public int getHeuristicValue(state s)
    {
        return theHeuristic.getValue(s, goalState);
    }

    // Don't think we need this
    public ArrayList<state> getSuccessors(state s)
    {
        ArrayList<state> rval = new ArrayList<state>();
        for(action a : getActions())
        {
            rval.add(a.performAction(s));
        }
    }
}
