public class MapTimeStepCostFunction implements StepCostFunction
{
    public MapTimeStepCostFunction()
    {
    }

    public double c(Object stateFrom, Action action, Object stateTo)
    {
        InputReader inputReader = new InputReader("Input.txt");

        String theState = (String) stateFrom;
        String theDest = (String) stateTo;

        int stateIndex = inputReader.getCities().indexOf(theState);
        int destIndex = inputReader.getCities().indexOf(theDest);
        
        double dist = inputReader.getDistances().get(stateIndex).get(destIndex);
        double speed = inputReader.getSpeeds().get(stateIndex).get(destIndex);
        double rval = (dist/speed) *60;
        
        return rval;
    }
}

