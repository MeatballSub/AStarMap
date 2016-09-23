import java.util.List;
import java.util.ArrayList;

public class RecursiveBestFirstSearch
{
    private static final Double INFINITY = Double.MAX_VALUE;
    private final EvaluationFunction evaluationFunction;
    private final NodeExpander nodeExpander;

    public RecursiveBestFirstSearch(EvaluationFunction ef)
    {
        this(ef, new NodeExpander());
    }

    public RecursiveBestFirstSearch(EvaluationFunction ef, NodeExpander nodeExpander)
    {
        evaluationFunction = ef;
        this.nodeExpander = nodeExpander;
    }

    public List<Action> search(Problem p)
    {
        List<Action> actions = new ArrayList<Action>();
        Node n = nodeExpander.createRootNode(p.getInitialState());
        SearchResult sr = rbfs(p, n, evaluationFunction.f(n), INFINITY);
        if(sr.hasSolution())
        {
            Node s = sr.getSolutionNode();
            actions = getSequenceOfActions(s);
        }
        return actions;
    }

    public NodeExpander getNodeExpander()
    {
        return nodeExpander;
    }

    private SearchResult rbfs(Problem p, Node node, double node_f, double fLimit)
    {
        if(true == isGoalState(p, node))
        {
            return getResult(node, fLimit);
        }

        List<Node> successors = expandNode(node, p);

        if(true == successors.isEmpty())
        {
            return getResult(null, INFINITY);
        }

        int size = successors.size();
        double[] f = new double[size];

        for(int s = 0; s < size; ++s)
        {
            f[s] = Math.max(evaluationFunction.f(successors.get(s)), node_f);
        }

        while(true)
        {
            int bestIndex = getBestFValueIndex(f);
            if( f[bestIndex] > fLimit )
            {
                return getResult(null, f[bestIndex]);
            }

            int altIndex = getNextBestFValueIndex(f, bestIndex);

            SearchResult sr = rbfs(p, successors.get(bestIndex), f[bestIndex], Math.min(fLimit, f[altIndex]));
            f[bestIndex] = sr.getFCostLimit();

            if(true == sr.hasSolution())
            {
                return getResult(sr.getSolutionNode(), sr.getFCostLimit());
            }
        }
    }

    private int getBestFValueIndex(double [] f)
    {
        int lidx = 0;
        Double lowestSoFar = INFINITY;

        for(int i = 0; i < f.length; ++i)
        {
            if(f[i] < lowestSoFar)
            {
                lowestSoFar = f[i];
                lidx = i;
            }
        }

        return lidx;
    }

    private int getNextBestFValueIndex(double[] f, int bestIndex)
    {
        int lidx = bestIndex;
        Double lowestSoFar = INFINITY;

        for(int i = 0; i < f.length; ++i)
        {
            if( i != bestIndex && f[i] < lowestSoFar)
            {
                lowestSoFar = f[i];
                lidx = i;
            }
        }

        return lidx;
    }

    private List<Node> expandNode(Node node, Problem problem)
    {
        return nodeExpander.expand(node, problem);
    }

    private SearchResult getResult(Node solutionNode, double fCostLimit)
    {
        return new SearchResult(solutionNode, fCostLimit);
    }

    private static List<Action> getSequenceOfActions(Node node)
    {
        List<Node> nodes = node.getPathFromRoot();
        List<Action> actions = new ArrayList<Action>();
        if(nodes.size() == 1)
        {
            actions.add(null);
        }
        else
        {
            for(int i = 1; i < nodes.size(); ++i)
            {
                actions.add(nodes.get(i).getAction());
            }
        }
        return actions;
    }

    public static boolean isGoalState(Problem p, Node n)
    {
        return p.getGoalTest().isGoalState(n.getState());
    }

    static class SearchResult
    {
        private Node solNode;
        private final double fCostLimit;

        public SearchResult(Node solutionNode, double fCostLimit)
        {
            this.solNode = solutionNode;
            this.fCostLimit = fCostLimit;
        }

        public boolean hasSolution()
        {
            return (null != solNode);
        }

        public Node getSolutionNode()
        {
            return solNode;
        }

        public Double getFCostLimit()
        {
            return fCostLimit;
        }
    }
}
