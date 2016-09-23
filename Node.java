import java.util.List;
import java.util.ArrayList;

public class Node
{
    private Object state;
    private Node parent;
    private Action action;
    private double pathCost;

    public Node(Object state)
    {
        this.state = state;
        pathCost = 0.0;
    }

    public Node(Object state, Node parent, Action action, double pathCost)
    {
        this(state);
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    public Object getState()
    {
        return state;
    }

    public Node getParent()
    {
        return parent;
    }

    public double getPathCost()
    {
        return pathCost;
    }

    public Action getAction()
    {
        return action;
    }

    public boolean isRootNode()
    {
        return (null == parent);
    }

    public List<Node> getPathFromRoot()
    {
        List<Node> path = new ArrayList<Node>();
        Node current = this;
        while(null != current)
        {
            path.add(0, current);
            current = current.getParent();
        }
        return path;
    }
}
