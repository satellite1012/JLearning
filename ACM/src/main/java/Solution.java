import java.util.*;

public class Solution {
    static String slurpStdin() {
        String input = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            input += scan.nextLine();
            if (scan.hasNextLine()) {
                input += "\n";
            } else {
                break;
            }
        }
        scan.close();
        return input;
    }

    static int va, vo, x, y, z;
    static double tTime; // total time

    public static void main(String[] args) {
        String input = slurpStdin();
        Scanner in = new Scanner(input);

        va = in.nextInt();
        vo = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int gold = 0;

        double sa = 0;

        if (vo < va) {
            System.out.println("0");
        } else {

            tTime = (double) z / va; // time = s*v // thoi gian an chay den dich
            sa += sRun(va, x);

            double pauseTime;

            do {
                sa += sRun(va, timeReach(sa, vo, va));      // an chay duoc truong luc boss duoi theo
                tTime -= timeReach(sa, vo, va);             // boss duoi kip
                gold += 1;                                  // rai vang

                pauseTime = y + tRun(vo, sa);               // thoi gian boss chay ve

                tTime -= pauseTime;                         // chay ve va chui do

                sa += sRun(va, pauseTime);                  // An chay di trong luc boss quay ve va lau vang
            } while (sa < z);

            if((sa-sRun(va, pauseTime))>=z) gold--;
            System.out.println(gold);
        }

        in.close();
    }

    // Tinh quang duong chay duoc trong thoi gian t
    static double sRun(int v, double t) {
        return (double) v * t;
    }

    static double tRun(int v, double s) {
        return s / (double) v;
    }

    static double timeReach(double khoangCach, int vo, int va) {
        return khoangCach / Math.abs(vo - va);
    }
}
