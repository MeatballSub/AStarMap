import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InputReader
{
    private ArrayList<String> cities;
    private ArrayList<ArrayList<Double>> distances;
    private ArrayList<ArrayList<Double>> speeds;
    private ArrayList<ArrayList<Double>> crowDistances;
    private ArrayList<ArrayList<Double>> crowTimes;

    public InputReader(String fileName)
    {
        Scanner input;
        File file = new File(fileName);
        try
        {
            input = new Scanner(file);
            if(input.hasNextInt())
            {
                int numCities = input.nextInt();
                input.nextLine();
                cities = new ArrayList<String>();
                for(int i = 0; i < numCities; ++i)
                {
                    if(input.hasNextLine())
                    {
                        cities.add(input.nextLine());
                    }
                    else
                    {
                        // give me good input
                    }
                }
                if(cities.size() == numCities)
                {
                    distances = new ArrayList<ArrayList<Double>>();
                    speeds = new ArrayList<ArrayList<Double>>();
                    crowDistances = new ArrayList<ArrayList<Double>>();
                    crowTimes = new ArrayList<ArrayList<Double>>();
                    readTable(input, numCities, distances);
                    readTable(input, numCities, speeds);
                    readTable(input, numCities, crowDistances);
                    calculateCrowTimesTable();
                }
                else
                {
                    // give me good input
                }
            }
            else
            {
                // give me correctly formatted input files
            }
        }
        catch(FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
    }

    public void readTable(Scanner input, int count, ArrayList<ArrayList<Double>> array)
    {
        for(int i = 0; i < count; ++i)
        {
            array.add(new ArrayList<Double>());
            for(int j = 0; j < count; ++j)
            {
                array.get(i).add(input.nextDouble());
            }
        }
    }

    public void calculateCrowTimesTable()
    {
        int numCities = cities.size();
        Double maxSpeed = speeds.get(0).get(0);

        for(int i = 0; i < numCities; ++i)
        {
            for(int j = 0; j < numCities; ++j)
            {
                if(speeds.get(i).get(j) > maxSpeed)
                {
                    maxSpeed = speeds.get(i).get(j);
                }
            }
        }

        for(int i = 0; i < numCities; ++i)
        {
            crowTimes.add(new ArrayList<Double>());
            for(int j = 0; j < numCities; ++j)
            {
                crowTimes.get(i).add(crowDistances.get(i).get(j) / maxSpeed * 60);
            }
        }
    }

    public ArrayList<String> getCities()
    {
        return cities;
    }

    public ArrayList<ArrayList<Double>> getDistances()
    {
        return distances;
    }

    public ArrayList<ArrayList<Double>> getSpeeds()
    {
        return speeds;
    }

    public ArrayList<ArrayList<Double>> getCrowDistances()
    {
        return crowDistances;
    }

    public ArrayList<ArrayList<Double>> getCrowTimes()
    {
        return crowTimes;
    }
}
