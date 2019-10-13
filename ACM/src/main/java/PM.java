import java.util.LinkedList;
import java.util.Scanner;

class Element
{
    private int number;
    private int count;

    public Element(int n) {
        number = n;
        setCount(1);
    }
    public int getNumber() {
        return number;
    }
    public int getCount() {
        return count;
    }
    public void increaseCount()
    {
        setCount(++count);
    }
    public void setCount(int count) {
        this.count = count;
    }
}
public class PM
{
    static LinkedList<Element> listElements = new LinkedList<Element>(); 
    public static void main(String[] args)
    {
        int n;
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        in.close();
        Scanner is = new Scanner(inp);
        // 3 1 2 2 1 3 5 3 3 2
        
        while(is.hasNextInt())
        {
            n = is.nextInt();
            add(n);
        }

        for (Element ele : listElements)
        {
            System.out.println(ele.getNumber() + " " + ele.getCount());    
        }
        
        is.close();
    }
    static void add(int n)
    {
        Element ele = search(n);
        if(ele!=null)
        {
            ele.increaseCount();
        }
        else
        {
            ele = new Element(n);
            listElements.add(ele);
        }
    }
    static Element search(int n)
    {
        for (Element ele : listElements)
        {
            if(ele.getNumber() == n) return ele;
        }
        return null;
    }
}