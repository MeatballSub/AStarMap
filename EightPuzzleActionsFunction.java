import java.util.Set;
import java.util.HashSet;

public class EightPuzzleActionsFunction implements ActionsFunction
{
    EightPuzzleActionsFunction()
    {
    }

    public Set<Action> actions(Object s)
    {
        HashSet<Action> theActions = new HashSet<Action>();
        String theState = (String) s;

        HashSet<Action> allActions = new HashSet<Action>();

        allActions.add(new EightPuzzleUpAction(theState));
        allActions.add(new EightPuzzleDownAction(theState));
        allActions.add(new EightPuzzleLeftAction(theState));
        allActions.add(new EightPuzzleRightAction(theState));

        for(Action a : allActions)
        {
            if(!a.isNoOp())
            {
                theActions.add(a);
            }
        }

        return theActions;
    }
}
