package graph;

import java.util.LinkedList;

// import java.io.File;
// import java.util.Scanner;

class MyStack
{
    private LinkedList<Integer> t;
    public MyStack()
    {
        t = new LinkedList<Integer>();
    }
    public boolean isEmpty()
    {
        return t.isEmpty();
    }
    public void push(int x)
    {
        t.add(x);
    }
    public int pop()
    {
        return t.removeLast();
    }
}
class MyQueue
{
    private LinkedList<Integer> t;
    public MyQueue()
    {
        t = new LinkedList<Integer>();
    }
    public boolean isEmpty()
    {
        return t.isEmpty();
    }
    public void enqueue(int x)
    {
        t.add(x);
    }
    public int dequeue()
    {
        return (t.removeFirst());
    }
}

class Graph
{
    private int [][] a;
    private String [] label;
    private int n;

    public Graph()
    {
        setLabel("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    }
    public Graph(int [][] a)
    {
        this();
        setAMatrix(a, a.length);
    }

    public void setAMatrix(int [][] b, int m)
    {
        a = b.clone();
        this.n = m;
    }
    public void setLabel(String [] c)
    {
        label = c.clone();
    }
    
    public void visit(int i)
    {
        System.out.print(label[i] + " ");
    }
    void depth(boolean[] visited, int i) {
        visit(i);
        visited[i] = true;
        for (int j = 0; j < n; j++)
            if (!visited[j] && a[i][j] > 0)
                depth(visited, j);
    }

    void depth(int k) {
        boolean[] visited = new boolean[n];
        int i;
        for (i = 0; i < n; i++)
            visited[i] = false;
        System.out.println("\nDepth-first traverse from the vertex " + label[k] + ":");
        depth(visited, k);
        System.out.println();
    }

    void breadth(int k) {
        MyQueue q = new MyQueue();
        boolean[] enqueued = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++)
            enqueued[i] = false;
        q.enqueue(k);
        enqueued[k] = true;
        int r;
        System.out.println("\nBreadth-first traverse from the vertex " + label[k] + ":");
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++)
                if (!enqueued[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    enqueued[j] = true;
                }
        }
        System.out.println();
    }
    public void show()
    {
        String s;
        for (int[] i : a)
        {
            s = "";
            for (int j : i)
            {
                s += j + " ";
            }
            System.out.println(s);
        }
    }
}
class WGraph
{
    private int [][] a;
    private String [] label;
    private int n;

    static int INF = 99;

    public WGraph()
    {
        setLabel("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    }
    public WGraph(int [][] a)
    {
        this();
        setAMatrix(a, a.length);
    }

    public void setAMatrix(int [][] b, int m)
    {
        a = b.clone();
        this.n = m;
    }
    public void setLabel(String [] c)
    {
        label = c.clone();
    }
    
    public void visit(int i)
    {
        System.out.print(label[i] + " ");
    }
    void depth(boolean[] visited, int i) {
        visit(i);
        visited[i] = true;
        for (int j = 0; j < n; j++)
            if (!visited[j] && a[i][j] > 0)
                depth(visited, j);
    }

    void depth(int k) {
        boolean[] visited = new boolean[n];
        int i;
        for (i = 0; i < n; i++)
            visited[i] = false;
        System.out.println("\nDepth-first traverse from the vertex " + label[k] + ":");
        depth(visited, k);
        System.out.println();
    }

    void breadth(int k) {
        MyQueue q = new MyQueue();
        boolean[] enqueued = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++)
            enqueued[i] = false;
        q.enqueue(k);
        enqueued[k] = true;
        int r;
        System.out.println("\nBreadth-first traverse from the vertex " + label[k] + ":");
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++)
                if (!enqueued[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    enqueued[j] = true;
                }
        }
        System.out.println();
    }

    
    void displayStep(int step, boolean[] selected, int[] dist, int[] path, int p, int[] sele, int nSele,
            boolean[] stopDisplay) {
        int i;
        String S = "";
        for (i = 0; i < nSele; i++)
            S = S + label[sele[i]];
        System.out.printf("\n\n %2d:  %10s", step, S);
        for (i = 0; i < n; i++) {
            if (i == p)
                continue;
            if (dist[i] == INF)
                System.out.printf("  (%3s,%c)", "INF", label[path[i]]);
            else {
                if (stopDisplay[i])
                    System.out.printf("         ");
                else
                    System.out.printf("  (%3d,%c)", dist[i], label[path[i]]);
            }
            if (selected[i])
                stopDisplay[i] = true;
        }
    }

    // shortest path from vertex p to vertex q
    void dijkstra(boolean[] selected, int[] dist, int[] path, int p, int q, boolean[] stopDisplay)
    {
        int i, t, k, curr, step;// curr: current vertex, which is to be added to the S set
        // Khoi tao
        for (i = 0; i < n; i++) {
            selected[i] = false;
            stopDisplay[i] = false;
            dist[i] = a[p][i]; // At the first step distance is a direct distance
            path[i] = p; // and the vertex before vertex i is the vertex p
        }
        int[] sele = new int[50];
        int nSele = 0;
        selected[p] = true;
        sele[nSele++] = p;
        curr = p;// add the vertex p the the S set
        System.out.println("\n Dijkstra algorithm for shortest path from " + label[p] + " to  " + label[q] + ":");
        System.out.print("      The S set: ");
        for (i = 0; i < n; i++) {
            if (i == p)
                continue;
            System.out.printf("        %c", label[i]);
        }
        step = 0;
        displayStep(step, selected, dist, path, p, sele, nSele, stopDisplay);
        while (curr != q)// Thuc hien vong lap cho den khi gap nut q
        {
            t = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (i == p || selected[i])
                    continue;
                // Tim dinh gan nhat de dua vao S = tap da xet)
                if (dist[i] < t) {
                    t = dist[i];
                    k = i;
                }
            }

            if (t == INF) {
                System.out.println("\nKhong co duong di");
                return;
            }
            // Dua dinh k vao tap S da xet
            selected[k] = true;
            curr = k;
            sele[nSele++] = k;
            // Tinh lai khoang cach
            for (i = 0; i < n; i++) {
                if (i == p || selected[i])
                    continue;
                if (dist[i] > dist[k] + a[k][i]) {
                    dist[i] = dist[k] + a[k][i];
                    path[i] = k;
                }
            }
            step++;
            displayStep(step, selected, dist, path, p, sele, nSele, stopDisplay);
        }
    }

    public void show()
    {
        String s;
        for (int[] i : a)
        {
            s = "";
            for (int j : i)
            {
                s += j + " ";
            }
            System.out.println(s);
        }
    }
}

public class EXGraph
{
    
    public static void main(String[] args)
    {
        Graph graph = new Graph(newMatrix());
        graph.breadth(1);
        graph.depth(1);
    }
    public static int [][] newMatrix()
    {
        int [][] a;
        a = new int[][]
        {
            {0, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0}
        };
        return a;

        // try
        // {
        //     // File file = new File("matrix.txt");
        //     // Scanner in = new Scanner(file);

            
        //     // in.close();
        // }
        // catch(Exception e)
        // {
        //     System.out.println("File not found");
        // }
    }
    public static int [][] newWMatrix()
    {
        return null;
    }
}