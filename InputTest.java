import java.util.ArrayList;

public class InputTest
{
    public static void main(String [] args)
    {
        String fileName = args[0];
        System.out.println(fileName);
        InputReader inputReader = new InputReader(fileName);

        printCities(inputReader.getCities());
        printDists(inputReader.getCities(), inputReader.getDistances());
        printSpeeds(inputReader.getCities(), inputReader.getSpeeds());
        printCrowDists(inputReader.getCities(), inputReader.getCrowDistances());
        printCrowTimes(inputReader.getCities(), inputReader.getCrowTimes());
    }

    public static void printCities(ArrayList<String> cities)
    {
        for(String city : cities)
        {
            System.out.println(city);
        }
    }

    public static void printDists(ArrayList<String> cities, ArrayList<ArrayList<Double>> distances)
    {
        formattedPrint(cities, distances);
    }

    public static void printSpeeds(ArrayList<String> cities, ArrayList<ArrayList<Double>> speeds)
    {
        formattedPrint(cities, speeds);
    }

    public static void printCrowDists(ArrayList<String> cities, ArrayList<ArrayList<Double>> distances)
    {
        formattedPrint(cities, distances);
    }

    public static void printCrowTimes(ArrayList<String> cities, ArrayList<ArrayList<Double>> times)
    {
        formattedPrint(cities, times);
    }

    public static void formattedPrint(ArrayList<String> cities, ArrayList<ArrayList<Double>> values)
    {
        System.out.printf("%15s", "");
        for(String city : cities)
        {
            System.out.printf("%15s", city);
        }
        System.out.println();

        int i = 0;
        for(String city : cities)
        {
            System.out.printf("%15s", city);
            for(Double value : values.get(i))
            {
                System.out.printf("%15f", value);
            }
            System.out.println();
            ++i;
        }
        System.out.println();
    }
}
