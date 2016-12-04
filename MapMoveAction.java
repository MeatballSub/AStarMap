public class MapMoveAction implements Action
{
    private boolean noOp;
    private String destination;

    public MapMoveAction(String theState, String theDestination)
    {
        noOp = false;
        destination = theDestination;
        InputReader inputReader = new InputReader("Input.txt");
        int stateIndex = inputReader.getCities().indexOf(theState);
        int destIndex = inputReader.getCities().indexOf(theDestination);
        if(0 <= stateIndex && 0 <= destIndex)
        {
            if(inputReader.getDistances().get(stateIndex).get(destIndex) <= 0)
            {
                noOp = true;
            }
        }
        else
        {
            noOp = true;
        }
    }

    public boolean isNoOp()
    {
        return noOp;
    }

    public String getDestination()
    {
        return destination;
    }
}
