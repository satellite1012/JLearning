package assignment1ex7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter equation has blacket () {} []: ");
        Scanner in = new Scanner(System.in);

        boolean check = checkBracket(in.nextLine().toCharArray());

        System.out.println(check ? "correct" : "incorrect");

        in.close();

    }

    public static boolean checkBracket(char[] str) {
        Stack stk = new Stack();
        try {
            for (char c : str) {
                if (c == '[' || c == '{' || c == '(')
                    stk.push(c);
                else {
                    if ((stk.top() == '[' && c == ']') || (stk.top() == '(' && c == ')')
                            || (stk.top() == '{' && c == '}')) {
                        stk.pop();
                    } else
                        return false;
                }
            }
        } catch (EmptyStackException | StackReachEmptyException e) {
            //
        }
        return true;
    }
}