package stack_queue_char;

class QueueNode
{
    char info;
    QueueNode next;
    QueueNode(){}
    QueueNode(char x)
    {
        this(x, null);
    }
    QueueNode(char x, QueueNode p)
    {
        info = x;
        next = p;
    }
}
class Queue
{
    QueueNode first, last;
    Queue()
    {
        first = last = null;
    }
    void clear()
    {
        first = last = null;
    }
    boolean isEmpty()
    {
        return (last==null);
    }
    void enqueue(char x)
    {
        QueueNode p = new QueueNode(x, first);
        if(isEmpty())
        {
            first = last = p;
            return;
        }
        first = p;
    }
    char dequeue() throws Exception
    {
        if (isEmpty()) throw new Exception();
        QueueNode p = first;
        if (first.equals(last))
        {
            clear();
        }
        first = first.next;
        return p.info;
    }
    char first() throws Exception
    {
        if (isEmpty()) throw new Exception();
        return first.info;
    }
    void traverse()
    {
        if(isEmpty()) return;
        System.out.print("Queue from first to last:\n[ ");
        traverse(first);
        System.out.println("]");
    }
    private void traverse(QueueNode p)
    {
        if(p!=null)
        {
            System.out.print("\"" + p.info + "\" ");
            traverse(p.next);
        }
    }
}
public class MyQueue
{
    public static void main(String[] args)
    {
        // Demo for queue
        System.out.println("=== Integer queue demo ===");

        Queue que = new Queue();
        
        que.enqueue('a');
        que.enqueue('b');
        que.enqueue('c');
        que.enqueue('d');

        System.out.println("Last of queue is: " + que.last.info);
        try
        {
            que.dequeue();
        }
        catch(Exception e)
        {
            System.out.print("Queue is empty!");
        }
        
        que.traverse();
    }
}