import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);

        InputReader inputReader = new InputReader("Input.txt");

        int tempNum = 0;
        for(String city : (inputReader.getCities()))
        {
            System.out.println(tempNum + ") " + city);
            tempNum++;
        }
        System.out.print("Choose a starting city: ");
        int startingCity = input.nextInt();

        System.out.print("Choose a destination city: ");
        int destinationCity = input.nextInt();

        System.out.println("0) Find path by distance.");
        System.out.println("1) Find path by time traveled.");
        int searchChoice = input.nextInt();

        String startState = inputReader.getCities().get(startingCity);
        String goalState = inputReader.getCities().get(destinationCity);

        EvaluationFunction ef;
        StepCostFunction stepCostFunction;

        if (searchChoice == 0)
        {
            ef = new MapDistanceEvaluationFunction(goalState);
            stepCostFunction = new MapDistanceStepCostFunction();
        }
        else if (searchChoice == 1)
        {
            ef = new MapTimeEvaluationFunction(goalState);
            stepCostFunction = new MapTimeStepCostFunction();
        }
        else
        {
            ef = new MapDistanceEvaluationFunction(goalState);
            stepCostFunction = new MapDistanceStepCostFunction();
        }

        MapMoveActionsFunction actionsFunction = new MapMoveActionsFunction();
        MapResultFunction resultFunction = new MapResultFunction();
        MapGoalTest goalTest = new MapGoalTest(goalState);

        Problem problem = new Problem(startState, actionsFunction, resultFunction, goalTest, stepCostFunction);

        RecursiveBestFirstSearch rbfs = new RecursiveBestFirstSearch(ef);

        List<Action> result = rbfs.search(problem);

        double totalTravel = 0;
        if (result.size() == 0)
        {
            System.out.println("No path from the start state to the goal state found.");
            System.out.println();
        }
        else
        {
            if (searchChoice == 0)
            {
                String prev = startState;
                System.out.print(startState);
                for(Action a : result)
                {
                    String current = ((MapMoveAction)a).getDestination();
                    int prevIndex = inputReader.getCities().indexOf(prev);
                    int currentIndex = inputReader.getCities().indexOf(current);

                    double distance = inputReader.getDistances().get(prevIndex).get(currentIndex);
                    totalTravel = totalTravel + distance;

                    System.out.printf(" --(%.2f)--> %s", distance, current);
                    prev = current;
                }
                System.out.println();
                System.out.printf("Total Distance Traveled: %.2f\n\n", totalTravel);
            }
            else if (searchChoice == 1)
            {
                String prev = startState;
                System.out.print(startState);
                for(Action a : result)
                {
                    String current = ((MapMoveAction)a).getDestination();
                    int prevIndex = inputReader.getCities().indexOf(prev);
                    int currentIndex = inputReader.getCities().indexOf(current);
                    double distanceTraveled = inputReader.getDistances().get(prevIndex).get(currentIndex);
                    double speedLimit = inputReader.getSpeeds().get(prevIndex).get(currentIndex);
                    double timeTraveled = (distanceTraveled/speedLimit) * 60;
                    totalTravel = totalTravel + timeTraveled;

                    System.out.printf(" --(%.2f)--> %s", timeTraveled, current);
                    prev = current;
                }
                System.out.println();
                System.out.printf("Total Travel Time: %.2f\n\n", totalTravel);
            }
        }
    }
}
