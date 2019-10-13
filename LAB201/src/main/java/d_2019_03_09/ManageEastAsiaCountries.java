package d_2019_03_09;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Country
{
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country()
    {
        this("empty", "empty", 0);
    }
    public Country(String countryCode, String countryName, float totalArea)
    {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public void display()
    {
        System.out.println(this.countryCode + "\t" + this.countryName + "\t" + this.totalArea);
    }
    public static void display_header()
    {
        System.out.println("ID\tName\tTotal Area");
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public float getTotalArea() {
        return totalArea;
    }
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

}

class EastAsiaCountries extends Country
{
    private String countryTerrain;

    public EastAsiaCountries()
    {
        this("empty", "empty", 0, "empty");
    }
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain)
    {
        super(countryCode, countryCode, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display()
    {
        System.out.println(this.countryCode + "\t" + this.countryName + "\t" + this.totalArea + "\t\t" + this.countryTerrain);
    }
    public static void display_header()
    {
        System.out.println("ID\tName\tTotal Area\tTerrain");
    }
    public void display_only()
    {
        display_header();
        display();
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

}

public class ManageEastAsiaCountries
{
    private static Scanner in = new Scanner(System.in);
    private static String err_msg_wronginp = "     [Error] Wrong input, please try again!";
    // private static String err_msg_unkowerr = "     [Error] Unknow error has been occured!";

    private static LinkedList<EastAsiaCountries> countryList = new LinkedList<EastAsiaCountries>();
    // private static List<EastAsiaCountries> countryList = new ArrayList<EastAsiaCountries>();

    public static void main(String[] args)
    {
        String main_select;
        boolean isContinue;
        EastAsiaCountries tmpCountry;
        do
        {
            System.out.println("\t Menu");
            System.out.println("==============================");
            System.out.println("1. In put the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the infomation of country by user entered name");
            System.out.println("4. Display the infomation of countries sorted name in ascending order");
            System.out.println("5. Exit");
            System.out.println("==============================");
            do
            {
                System.out.print("Enter your choice: ");
                main_select = in.nextLine();
                isContinue = false;
                try
                {
                    switch(Integer.parseInt(main_select))
                    {
                        case 1:
                            tmpCountry = new EastAsiaCountries();

                            System.out.println("Enter code of country:");
                            tmpCountry.setCountryCode(in.nextLine());

                            System.out.println("Enter name of country:");
                            tmpCountry.setCountryName(in.nextLine());

                            System.out.println("Enter total Area:");
                            tmpCountry.setTotalArea((float)Enter_num("", "Please enter a number."));

                            System.out.println("Enter terrain of country:");
                            tmpCountry.setCountryTerrain(in.nextLine());

                            try
                            {
                                addCountryInfomation(tmpCountry);
                            }
                            catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try
                            {
                                getRecentEnteredInfomation().display_only();
                            }catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            try
                            {
                                System.out.println("Enter the name you want to search for:");
                                String countrySearch = in.nextLine();
                                EastAsiaCountries.display_header();
                                for (EastAsiaCountries country :  searchInfomationByName(countrySearch))
                                {
                                    country.display();
                                }
                            }catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:
                            try
                            {
                                displayAll();
                            }catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 5:
                            System.out.println("Exit program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(err_msg_wronginp);
                            isContinue = true;
                    }
                } catch(Exception e)
                {
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            }while(isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while(true);
    }

    static public void addCountryInfomation(EastAsiaCountries country) throws Exception
    {
        try
        {
            if(country.countryCode.isEmpty() || country.countryName.isEmpty()) throw new Exception("Some element is empty!");
            countryList.add(country);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    static public EastAsiaCountries getRecentEnteredInfomation() throws Exception
    {
        if(countryList.isEmpty()) throw new Exception("You've not entered any country!");
        else
            return countryList.getLast();
    }
    static public LinkedList<EastAsiaCountries> searchInfomationByName(String name) throws Exception
    {
        if(countryList.isEmpty()) throw new Exception("You've not entered any country!");
        LinkedList<EastAsiaCountries> countryFound = new LinkedList<EastAsiaCountries>();
        for (EastAsiaCountries country : countryList)
        {
            if(country.getCountryName().toUpperCase().contains(name.toUpperCase()))
            {
                countryFound.add(country);
            }
        }
        if(countryFound.isEmpty()) throw new Exception("Content not found!");
        return countryFound;
    }
    static public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception
    {
        try
        {
            countryList.sort(new Comparator<EastAsiaCountries>() {
                @Override
                public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                    return o1.getCountryName().compareTo(o2.getCountryName());
                }
            });
            return (EastAsiaCountries[])countryList.toArray();
        }catch(Exception e)
        {
            throw e;
        }
    }
    static public void displayAll()
    {
        EastAsiaCountries.display_header();
        for (EastAsiaCountries country : countryList)
        {
            country.display();
        }
    }
    private static double Enter_num(String str_show, String err_msg)        // this is checkin function
    {
        String entered;
        do
        {
            System.out.print(str_show);
            entered = in.nextLine();
            try
            {
                return Integer.parseInt(entered);
            }
            catch(NumberFormatException e)
            {
                System.out.println(err_msg);
            }
        }while(true);
    }
}