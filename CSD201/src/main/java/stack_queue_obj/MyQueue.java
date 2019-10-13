package stack_queue_obj;

class QueueNode
{
    Object info;
    QueueNode next;
    QueueNode(){}
    QueueNode(Object x)
    {
        this(x, null);
    }
    QueueNode(Object x, QueueNode p)
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
    void enqueue(Object x)
    {
        QueueNode p = new QueueNode(x, first);
        if(isEmpty())
        {
            first = last = p;
            return;
        }
        first = p;
    }
    Object dequeue() throws Exception
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
    Object first() throws Exception
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
            System.out.print("[" + p.info + "] ");
            traverse(p.next);
        }
    }
}
public class MyQueue
{
    public static void main(String[] args)
    {
        // Demo for queue
        System.out.println("=== Object queue demo ===");

        Queue que = new Queue();
        
        que.enqueue(new QueueNode('a'));
        que.enqueue(new QueueNode('b'));
        que.enqueue(new QueueNode('c'));
        que.enqueue(new QueueNode('d'));

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