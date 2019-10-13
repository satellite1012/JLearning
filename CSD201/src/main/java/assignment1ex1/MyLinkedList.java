package assignment1ex1;

import java.util.Iterator;

class Node<T> {
    T info;
    Node<T> next;

    // Empty node
    Node() {
    }

    // Node has value but no linked
    Node(T x) {
        this(x, null);
    }

    // Node has value and linked to other node
    Node(T x, Node<T> p) {
        info = x;
        next = p;
    }
}

class LinkedList<T> implements Iterable<T> {
    Node<T> head, tail;

    public LinkedList() {
        head = tail = null;
    }

    boolean isEmpty() // Kiểm tra empty list
    {
        return (head == null);
    }

    void clear() // Xóa tất cả phần tử trong list
    {
        head = tail = null;
    }

    void addToHead(T x) // 1. Thêm phần tử vào đầu list
    {
        Node<T> p = new Node<T>(x, head);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        head = p;
    }

    void add(T x) // 2. Thêm một node vào cuối list
    {
        Node<T> p = new Node<T>(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    void addAfterNode(Node<T> p, T x) // 3. Thêm phần tử vào sau một node
    {
        if (contains(p.info)) {
            p.next = new Node<T>(x, p.next);
        }
    }

    void addAfterElement(T p, T x) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp == p) {
                addAfterNode(tmp, x);
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Do not have element!");
    }

    void removeFirst() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    void removeLast() {
        if (!isEmpty()) {
            Node<T> p = head;
            while ((p.next).next != null) {
                p = p.next;
            }
            tail = p;
            tail.next = null;
        }
    }

    void remove(T x) // 8. Xóa node đầu tiên bằng x
    {
        if (!isEmpty() && contains(x)) {
            if (head.info == x) {
                removeFirst();
            } else if (tail.info == x) {
                removeLast();
            } else {
                Node<T> p = head;
                while (!(p.next.info == x)) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
        }
    }

    void remove(Node<T> x) {
        if (!isEmpty() && contains(x)) {
            if (head == x) {
                removeFirst();
            } else if (tail == x) {
                removeLast();
            } else {
                Node<T> p = head;
                while (!(p.next == x)) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
        }
    }

    void removeAt(int position) {
        if (!isEmpty() && position < size()) {
            if (position == 0) {
                removeFirst();
            } else if (position == size() - 1) {
                removeLast();
            } else {
                Node<T> p = head;
                int count = 0;
                while (!(count + 1 == position)) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
        }
    }

    void printAll() {
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    boolean contains(T x) {
        Node<T> p = head;
        while (p != null) {
            if (p.info == x)
                return true;
            p = p.next;
        }
        return false;
    }

    boolean contains(Node<T> x) {
        Node<T> p = head;
        while (p != null) {
            if (p == x)
                return true;
            p = p.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node<T> ele = head;
        while (ele != null) {
            ele = ele.next;
            count++;
        }
        return count;
    }

    public T get(int i) {
        int count = 0;
        Node<T> ele = head;
        while (ele != null && count != i) {
            ele = ele.next;
            count++;
        }
        if (count == i)
            return ele.info;
        else
            return null;
    }

    // Code cai nay:
    void sort() {

    }

    void swap(Node<T> a, Node<T> b) {

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }
}