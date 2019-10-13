package hashing;

import java.util.Random;
import java.util.Scanner;

class Node {
    char info;
    Node next;

    Node() {
    }

    Node(char x) {
        this.info = x;
        next = null;
    }

    Node(char x, Node p) {
        this.info = x;
        this.next = p;
    }
}

class LinkedList {
    Node head, tail;

    LinkedList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void add(char x) {
        if (isEmpty())
            head = tail = new Node(x, null);
        else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    void traverse() {
        if (isEmpty()) {
            System.out.println("");
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.print(" " + (char) p.info);
            p = p.next;
        }
        System.out.println();
    }

    Node search(char x) {
        Node p = head;
        while (p != null) {
            if (p.info == x)
                return (p);
            p = p.next;
        }
        return (null);
    }

    void dele(char x) {
        if (isEmpty()) {
            System.out.println("\n The list is empty");
            return;
        }
        if (head.info == x) {
            head = head.next;
            if (head == null)
                tail = null;
            return;
        }
        Node f, p;
        f = null;
        p = head;
        while (p != null && p.info != x) {
            f = p;
            p = p.next;
        }
        if (p != null) {
            f.next = p.next;
        } else
            System.out.println(x + " is not found in the list, no deletion");
    }
}

class HashTable {
    LinkedList[] table;
    int size;

    HashTable() {
        this(26);
    }

    HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];

        for(int i = 0; i<size; i++)
        {
            table[i] = new LinkedList();
        }
    }

    boolean isEmpty() {
        boolean empty = true;
        for (LinkedList e : table) {
            if (!e.isEmpty()) {
                empty = false;
                break;
            }
        }
        return (empty);
    }

    void clear() {
        for (LinkedList e : table) {
            e.head = e.tail = null;
        }
    }


    void add(char c) {
        int i;
        if (c >= 'A' && c <= 'Z') {
            i = c - 'A';
        } else if (c >= 'a' && c <= 'z') {
            i = c - 'a';
        } else {
            System.out.println("Cannot add this character: " + c + " - " + (int)c);
            return;
        }
        table[i % size].add(c);
    }

    void traverse() {
        if (isEmpty()) {
            System.out.println("\n The Hash table is empty");
            return;
        }
        System.out.println("=== Hash Table ===");
        for (int i = 0; i < size; i++) {
            System.out.print("  [" + i + "]\t");
            table[i].traverse();
        }
        System.out.println();
    }

    Node search(char x) {
        int i = x % size;
        return (table[i].search(x));
    }

    void dele(char x) {
        int i = x % size;
        table[i].dele(x);
    }

    void addArray(char[] b) {
        int i, n;
        n = b.length;
        for (i = 0; i < n; i++)
            add(b[i]);
    }

    void addRandom() {
        int i, n;
        char x;
        Scanner s = new Scanner(System.in);
        System.out.print(" Enter n = ");
        n = s.nextInt();
        Random r = new Random();
        clear();
        for (i = 0; i < n; i++) {
            x = (char) (r.nextInt(size + 65)); // Choose value from 0 to 99
            add(x);
        }
        s.close();
    }
}

public class Main {
    static Scanner in = new Scanner(System.in);
    static HashTable hTable = new HashTable(26);

    public static void main(String[] args) {
        System.out.println("Enter string to hash: ");
        String str = in.nextLine();

        for (char c : str.toCharArray()) {
            hTable.add(c);
        }

        hTable.traverse();

        in.close();
    }
}