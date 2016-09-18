import java.lang.Math;

public class a_star
{
    private static final node failure = null;
    private static final int infinity = Integer.MAX_VALUE;

    public static solution RBFS(problem p, node n, int limit)
    {
        if(p.goal_test(n.getState()))
        {
            return new solution(n);
        }

        ArrayList<node> successors = new ArrayList<node>();
        for(action a : p.getActions(n.getState()))
        {
            successors.add(new node(p, n, a));
        }

        if(successors.isEmpty())
        {
            return new solution(failure, infinity);
        }

        for(node s : successors)
        {
            s.setF( Math.max(s.getG() + s.getH(), n.f) );
        }

        while(true)
        {
            node best = getBest(successors);
            if(best.getF() > limit)
            {
                return new solution(failure, best.f);
            }

            int alternative = getAlternative(successors);
            solution result = RBFS(p, best, min(limit, alternative));
            if(!result.isFailure())
            {
                return result;
            }
        }
    }

    private static node getBest(ArrayList<node> nodeList)
    {
        node rval = null;
        for(node n : nodeList)
        {
            if(null == rval)
            {
                rval = n;
            }
            else if(n.getF() < rval.getF())
            {
                rval = n;
            }
        }
        return rval;
    }

    private static int getAlternative(ArrayList<node> nodeList)
    {
        int rval = infinity;
        node best = null;
        node alt = null;
        
        for(node n : nodeList)
        {
            if(null == best)
            {
                best = n;
            }
            else if(null == alt)
            {
                if(n.getF() < best.getF())
                {
                    alt = best;
                    best = n;
                }
                else
                {
                    alt = n;
                }
            }
            else
            {
                if(n.getF() < alt.getF())
                {
                    alt = n;
                    if(alt.getF() < best.getF())
                    {
                        node temp = best;
                        best = alt;
                        alt = temp;
                    }
                }
            }
        }

        if(alt != null)
        {
            rval = alt.getF();
        }

        return rval;
    }
}
