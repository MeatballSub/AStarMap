public class EightPuzzleRightAction implements Action
{
    private boolean noOp;

    public EightPuzzleRightAction(String theState)
    {
        int zeroIndex = theState.indexOf('0');
        int checkIndex = zeroIndex + 1;
        noOp = (checkIndex > 8) || ((checkIndex % 3) == 0);
    }

    public boolean isNoOp()
    {
        return noOp;
    }
}
