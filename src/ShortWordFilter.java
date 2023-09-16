public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        String val = (String) x;
        return (val.length() > 5);
    }
}