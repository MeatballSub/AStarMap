public class EightPuzzleResultFunction implements ResultFunction
{
    public EightPuzzleResultFunction()
    {
    }

    public Object result(Object s, Action a)
    {
        String theState = (String) s;
        String rval = null;

        int zeroIndex = theState.indexOf('0');

        if( a instanceof EightPuzzleUpAction )
        {
            rval = swap(theState, zeroIndex, zeroIndex - 3);
        }
        else if(a instanceof EightPuzzleDownAction)
        {
            rval = swap(theState, zeroIndex, zeroIndex + 3);
        }
        else if(a instanceof EightPuzzleLeftAction)
        {
            rval = swap(theState, zeroIndex, zeroIndex - 1);
        }
        else if(a instanceof EightPuzzleRightAction)
        {
            rval = swap(theState, zeroIndex, zeroIndex + 1);
        }

        return rval;
    }

    private String swap(String str, int first, int second)
    {
        char firstChar = str.charAt(first);
        char secondChar = str.charAt(second);

        char [] rval = str.toCharArray();
        rval[first] = secondChar;
        rval[second] = firstChar;

        return (new String(rval));
    }
}
