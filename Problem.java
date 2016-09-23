public class Problem
{
    protected Object initialState;
    protected ActionsFunction actionsFunction;
    protected ResultFunction resultFunction;
    protected GoalTest goalTest;
    protected StepCostFunction stepCostFunction;

    public Problem(Object initialState, ActionsFunction actionsFunction, ResultFunction resultFunction, GoalTest goalTest)
    {
        this(initialState, actionsFunction, resultFunction, goalTest, new DefaultStepCostFunction());
    }

    public Problem(Object initialState, ActionsFunction actionsFunction, ResultFunction resultFunction, GoalTest goalTest, StepCostFunction stepCostFunction)
    {
        this.initialState = initialState;
        this.actionsFunction = actionsFunction;
        this.resultFunction = resultFunction;
        this.goalTest = goalTest;
        this.stepCostFunction = stepCostFunction;
    }

    public Object getInitialState()
    {
        return initialState;
    }

    public boolean isGoalState(Object state)
    {
        return goalTest.isGoalState(state);
    }

    public GoalTest getGoalTest()
    {
        return goalTest;
    }

    public ActionsFunction getActionsFunction()
    {
        return actionsFunction;
    }

    public ResultFunction getResultFunction()
    {
        return resultFunction;
    }

    public StepCostFunction getStepCostFunction()
    {
        return stepCostFunction;
    }

    protected Problem()
    {
    }
}
