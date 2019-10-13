import java.util.LinkedList;
import java.util.Scanner;

class Player
{
    private String name;
    private int count = 0;

    public Player(String n) {
        name = n;
        setPoint(0);
    }
    public String getName() {
        return name;
    }
    public int getPoint() {
        return count;
    }
    public void increasePoint(int k)
    {
        setPoint(count + k);
    }
    public void setPoint(int count) {
        this.count = count;
    }
}
public class PP
{
    static LinkedList<Player> listPlayers = new LinkedList<Player>(); 
    static Player winner=null;
    public static void main(String[] args)
    {
        String tmpName, tmp;
        int tmpPoint;
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for(int i = 0; i<n; i++)
        {
            tmp = in.nextLine();
            tmpName = tmp.split("\\s", 0)[0];
            tmpPoint = Integer.parseInt(tmp.split("\\s", 0)[1]);
            add(tmpName, tmpPoint);
        }
        System.out.print(winner.getName());
        in.close();
    }

    static void add(String n, int point)
    {
        Player ele = search(n);
        if(ele!=null)
        {
            ele.increasePoint(point);
        }
        else
        {
            ele = new Player(n);
            ele.increasePoint(point);
            listPlayers.add(ele);
            if(winner==null)
            {
                winner = ele;
            }
        }
        if(ele.getPoint()>winner.getPoint()) winner = ele;
    }
    static Player search(String n)
    {
        if(listPlayers.isEmpty()) return null;
        for (Player ele : listPlayers)
        {
            if(ele.getName().equals(n)) return ele;
        }
        return null;
    }
}