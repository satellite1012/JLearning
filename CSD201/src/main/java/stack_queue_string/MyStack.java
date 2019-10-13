package stack_queue_string;

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
    String info;
    Node next;
    Node(){}
    Node(String x)
    {
        this(x, null);
    }
    Node(String x, Node p)
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
    void push(String x)
    {
        Node p = new Node(x, top);
        if (isEmpty())
        {
            top = bot = p;
            return;
        }
        top = p;
    }
    String pop() throws EmptyStackException, StackReachEmptyException
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
    String top() throws EmptyStackException
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
            System.out.print("\"" + p.info + "\" ");
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
        
        stk.push("String 1");
        stk.push("String 2");
        stk.push("String 3");
        stk.push("String 4");

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
    }
}