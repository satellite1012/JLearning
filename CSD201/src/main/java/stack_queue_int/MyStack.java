package stack_queue_int;

import java.util.Scanner;

class EmptyStackException extends Exception
{
    private static final long serialVersionUID = 1L;    // IDE tu them vao
    EmptyStackException() {}
}
class StackReachEmptyException extends Exception
{
    private static final long serialVersionUID = 2L;
    StackReachEmptyException() {}
}

class Node
{
    int info;
    Node next;
    Node(){}
    Node(int x)
    {
        this(x, null);
    }
    Node(int x, Node p)
    {
        info = x;
        next = p;
    }
}

class Stack
{
    Node top, bot;
    Stack()
    {
        top = bot = null;
    }
    void clear()
    {
        top = bot = null;
    }
    boolean isEmpty()
    {
        return (top==null);
    }
    void push(int x)
    {
        Node p = new Node(x, top);
        if (isEmpty())
        {
            top = bot = p;
            return;
        }
        top = p;
    }
    int pop() throws EmptyStackException, StackReachEmptyException
    {
        if(isEmpty()) throw new EmptyStackException();
        Node p = top;
        if(top.equals(bot))
        {
            top = bot = null;
            throw new StackReachEmptyException();
        }
        else
        {
            top = top.next;
        }
        return p.info;
    }
    int top() throws EmptyStackException
    {
        if(isEmpty()) throw new EmptyStackException();
        return top.info;
    }
    void traverse()
    {
        if(isEmpty()) return;
        System.out.print("Stack from top to bottom:\n[ ");
        traverse(top);
        System.out.println("]");
    }
    private void traverse(Node p)
    {
        if(p!=null)
        {
            System.out.print(p.info + " ");
            traverse(p.next);
        }
    }
}

public class MyStack
{
    public static void main(String[] args)
    {
        // Demo for stack
        System.out.println("=== Integer stack demo ===");

        Stack stk = new Stack();
        
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        System.out.println("Top of stack is: " + stk.top.info);
        try
        {
            stk.pop();
        }
        catch(EmptyStackException|StackReachEmptyException e)
        {
            System.out.print("Stack is empty of reaching to empty.");
        }
        
        stk.traverse();

        // Use a stack to convert an integer number in decimal system to binary system and display on the screen.
        Scanner in = new Scanner(System.in);
        System.out.print("\n=== Convert decimal to binary using stack ===");
        System.out.print("\nEnter an integer: ");
        int n = in.nextInt(); in.close();

        Stack bin = new Stack();
        do
        {
            bin.push(n % 2);
            n /= 2;
        }while(n!=0);

        bin.traverse();
    }
}