public class EightPuzzleDownAction implements Action
{
    private boolean noOp;

    public EightPuzzleDownAction(String theState)
    {
        int zeroIndex = theState.indexOf('0');
        int checkIndex = zeroIndex + 3;
        noOp = (checkIndex > 8);
    }

    public boolean isNoOp()
    {
        return noOp;
    }
}
