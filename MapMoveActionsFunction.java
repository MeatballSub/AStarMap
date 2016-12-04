import java.util.Set;
import java.util.HashSet;

public class MapMoveActionsFunction implements ActionsFunction
{
    MapMoveActionsFunction()
    {
    }

    public Set<Action> actions(Object s)
    {
        HashSet<Action> theActions = new HashSet<Action>();
        String theState = (String) s;

        HashSet<Action> allActions = new HashSet<Action>();

        InputReader inputReader = new InputReader("Input.txt");

        for(String city: inputReader.getCities())
        {
            allActions.add(new MapMoveAction(theState, city));
        }

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
