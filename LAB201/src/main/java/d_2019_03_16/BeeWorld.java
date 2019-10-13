package d_2019_03_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Bee
{
    protected String name = "BEE";
    protected float health;
    protected boolean dead;
    protected float alive_level;

    static protected Random r = new Random();

    public Bee()
    {
        this(100, 0, "BEE");
    }
    public Bee(float health, float alive_level, String name)
    {
        this.name = name;
        this.health = health;
        this.alive_level = alive_level;
        this.dead = false;
    }
    public boolean isAlive()
    {
        return !dead;
    }
    public void Damage()
    {
        HealthDeduction(r.nextInt(100) + r.nextFloat());
    }
    public String getName()
    {
        return name;
    }
    public float getHealth()
    {
        return this.health;
    }
    public String getAlive()
    {
        return (dead ? "Dead" : "Alive");
    }

    protected void kill()
    {
        this.dead = true;
    }
    protected void checkStatus()
    {
        if(this.health < this.alive_level) kill();
    }
    protected void HealthDeduction(float damage)
    {
        if(this.health-damage > 0) this.health -= damage;
        checkStatus();
    }
}
class Worker extends Bee
{
    public Worker()
    {
        super(100, 70, "WORKER");
    }
}
class Queen extends Bee
{
    public Queen()
    {
        super(100, 20, "QUEEN");
    }

}
class Drone extends Bee
{
    public Drone()
    {
        super(100, 50, "DRONE");
    }

}

public class BeeWorld
{
    private static Scanner in = new Scanner(System.in);
    private static String err_msg_wronginp = "\t[Error] Wrong input, please try again!";
    private static List<Bee> beeList;
    public static void main(String[] args)
    {
        String main_select;
        boolean isContinue;
        do
        {
            System.out.println("====BEE====");
            System.out.println("1. Create new bee list.");
            System.out.println("2. Damage bee.");
            System.out.println("3. Exit");
            do
            {
                System.out.print("Choose an opinion: ");
                main_select = in.nextLine();
                isContinue = false;
                try
                {
                    switch(Integer.parseInt(main_select))
                    {
                        case 1:
                            createBeeList();
                            break;
                        case 2:
                            damageBeeList();
                            break;
                        case 3:
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

    private static void createBeeList()
    {
        Random rand = new Random();
        beeList = new ArrayList<Bee>();
        Bee tmpBee;
        for(int i=0; i<10; i++)
        {
            switch(rand.nextInt(3))
            {
                case 0:
                    tmpBee = new Worker();
                    beeList.add(tmpBee);
                    break;
                case 1:
                    tmpBee = new Queen();
                    beeList.add(tmpBee);
                    break;
                case 2:
                    tmpBee = new Drone();
                    beeList.add(tmpBee);
                    break;
                default:
                    System.out.println("Em luoi` code wa' tha^y` oi!");
            }
        }
        showHangChatxxx();
    }
    private static void damageBeeList()
    {
        for (Bee bee : beeList)
        {
            bee.Damage();
            System.out.printf("%s\t| %.2f\t| %s\n", bee.getName(), bee.getHealth(), bee.getAlive());
        }
    }
    private static void showHangChatxxx()
    {
        for (Bee bee : beeList)
        {
            System.out.printf("%s\t| %.2f\t| %s\n", bee.getName(), bee.getHealth(), bee.getAlive());
        }
    }
}