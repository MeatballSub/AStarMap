public class EightPuzzleLeftAction implements Action
{
    private boolean noOp;

    public EightPuzzleLeftAction(String theState)
    {
        int zeroIndex = theState.indexOf('0');
        int checkIndex = zeroIndex - 1;
        noOp = (checkIndex < 0) || ((checkIndex % 3) == 2);
    }

    public boolean isNoOp()
    {
        return noOp;
    }
}
