public class MapDistanceStepCostFunction implements StepCostFunction
{
    public MapDistanceStepCostFunction()
    {
    }

    public double c(Object stateFrom, Action action, Object stateTo)
    {
        InputReader inputReader = new InputReader("Input.txt");

        String theState = (String) stateFrom;
        String theDest = (String) stateTo;

        int stateIndex = inputReader.getCities().indexOf(theState);
        int destIndex = inputReader.getCities().indexOf(theDest);

        return inputReader.getDistances().get(stateIndex).get(destIndex);
    }
}
