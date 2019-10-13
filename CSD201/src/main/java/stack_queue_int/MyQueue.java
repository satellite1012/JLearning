package stack_queue_int;

import java.util.Scanner;

class QueueNode {
    int info;
    QueueNode next;

    QueueNode() {
    }

    QueueNode(int x) {
        this(x, null);
    }

    QueueNode(int x, QueueNode p) {
        info = x;
        next = p;
    }
}

class Queue {
    QueueNode first, last;

    Queue() {
        first = last = null;
    }

    void clear() {
        first = last = null;
    }

    boolean isEmpty() {
        return (last == null);
    }

    void enqueue(int x) {
        QueueNode p = new QueueNode(x, first);
        if (isEmpty()) {
            first = last = p;
            return;
        }
        first = p;
    }

    int dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();
        QueueNode p = first;
        if (first.equals(last)) {
            clear();
        }
        first = first.next;
        return p.info;
    }

    int first() throws Exception {
        if (isEmpty())
            throw new Exception();
        return first.info;
    }

    void traverse() {
        if (isEmpty())
            return;
        System.out.print("Queue from first to last:\n[ ");
        traverse(first);
        System.out.println("]");
    }

    private void traverse(QueueNode p) {
        if (p != null) {
            System.out.print(p.info + " ");
            traverse(p.next);
        }
    }
}

public class MyQueue {
    public static void main(String[] args) {
        // Demo for queue
        System.out.println("=== Integer queue demo ===");

        Queue que = new Queue();

        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);

        System.out.println("Last of queue is: " + que.last.info);
        try {
            que.dequeue();
        } catch (Exception e) {
            System.out.print("Queue is empty!");
        }

        que.traverse();

        // Use a stack to convert an integer number in decimal system to binary system
        // and display on the screen.
        Scanner in = new Scanner(System.in);
        System.out.print("\n=== Convert decimal (<1) to binary using queue ===");
        System.out.print("\nEnter an integer: ");
        float n = in.nextFloat();
        in.close();

        if (n < 1) {
            Queue bin = new Queue();
            do {
                n *= 2;
                bin.enqueue((int) n);
                n -= (int) n;
            } while (n != 0);

            bin.traverse();
        } else {
            System.out.print("Wrong input");
        }
    }
}