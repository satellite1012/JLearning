package practicalexam;

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

    Queue(int numVertices) {
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

    int dequeue() {
        if (isEmpty())
            return -1;
        QueueNode p = first;
        if (first.equals(last)) {
            clear();
        }
        first = first.next;
        return p.info;
    }

    int first() {
        if (isEmpty())
            return -1;
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