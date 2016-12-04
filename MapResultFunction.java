public class MapResultFunction implements ResultFunction
{
    public MapResultFunction()
    {
    }

    public Object result(Object s, Action a)
    {
        return ((MapMoveAction)a).getDestination();
    }
}
