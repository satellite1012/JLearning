import java.util.Calendar;
import java.text.SimpleDateFormat;

class MyDateClass
{
    private String Pattern = "MM/dd/yy";
    private SimpleDateFormat _dFormat = new SimpleDateFormat();
    private Calendar c = Calendar.getInstance();

    public MyDateClass()
    {
        // Do nothing
    }
    public void setDate(int month, int date, int year)
    {
        c.set(year, month-1, date);
    }
    public String getDate()
    {
        _dFormat.applyPattern(Pattern);
        return _dFormat.format(c.getTime());
    }
    public String getDate(String pattern)
    {
        _dFormat.applyPattern(pattern);
        return _dFormat.format(c.getTime());
    }
}
class EX05
{
    public static void main(String [] args)
    {
        // instantiate object
        MyDateClass obj = new MyDateClass();
        //set date values
        obj.setDate(9,26,99);
        // display date
        System.out.println(obj.getDate());
        // display date
        System.out.println(obj.getDate("dd/MM/yy"));
        // display name
        System.out.println("Vo Van Hieu");
    } // end main
}