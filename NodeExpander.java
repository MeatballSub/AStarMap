import java.util.List;
import java.util.ArrayList;

public class NodeExpander
{
    public Node createRootNode(Object state)
    {
        return new Node(state);
    }

    public Node createNode(Object state, Node parent, Action action, double stepCost)
    {
        return new Node(state, parent, action, parent.getPathCost() + stepCost);
    }

    public List<Node> expand(Node node, Problem problem)
    {
        List<Node> successors = new ArrayList<Node>();

        ActionsFunction actionsFunction = problem.getActionsFunction();
        ResultFunction resultFunction = problem.getResultFunction();
        StepCostFunction stepCostFunction = problem.getStepCostFunction();

        for(Action action : actionsFunction.actions(node.getState()))
        {
            Object successorState = resultFunction.result(node.getState(), action);

            double stepCost = stepCostFunction.c(node.getState(), action, successorState);
            successors.add(createNode(successorState, node, action, stepCost));
        }

        return successors;
    }
}
