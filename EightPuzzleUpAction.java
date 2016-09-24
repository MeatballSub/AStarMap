public class EightPuzzleUpAction implements Action
{
    private boolean noOp;

    public EightPuzzleUpAction(String theState)
    {
        int zeroIndex = theState.indexOf('0');
        int checkIndex = zeroIndex - 3;
        noOp = (checkIndex < 0);
    }

    public boolean isNoOp()
    {
        return noOp;
    }
}
