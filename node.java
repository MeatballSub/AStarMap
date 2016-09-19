public class node
{
    int f;           // total path cost = g + h
    int g;           // path cost to get to this node
    state theState;
    node parent;
    action theAction;
    
    public node(problem p, node n, action a)
    {
        theAction = a;
        parent = n;
        theState = a.performAction(n.getState());
        if(parent == null)
        {
            g = 0;
        }
        else
        {
            g = parent.getG() + p.getCost(n.getState(), theState);
        }
        f = g + getH();
    }

    public state getState()
    {
        return theState;
    }

    public void setF(int value)
    {
        f = value;
    }

    public int getG()
    {
        return g;
    }

    public int getH()
    {
        return p.getHeuristicValue(theState);
    }

    public int getF()
    {
        return f;
    }
}
