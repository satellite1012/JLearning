package stack_queue_string;

class QueueNode
{
    String info;
    QueueNode next;
    QueueNode(){}
    QueueNode(String x)
    {
        this(x, null);
    }
    QueueNode(String x, QueueNode p)
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
    void enqueue(String x)
    {
        QueueNode p = new QueueNode(x, first);
        if(isEmpty())
        {
            first = last = p;
            return;
        }
        first = p;
    }
    String dequeue() throws Exception
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
    String first() throws Exception
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
        
        que.enqueue("String 1");
        que.enqueue("String 2");
        que.enqueue("String 3");
        que.enqueue("String 4");

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