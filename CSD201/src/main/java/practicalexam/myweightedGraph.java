package practicalexam;

// import java.util.Arrays;

public class myweightedGraph extends myListGraph {
    protected double weight[][];

    myweightedGraph() {
        this(1);
    }

    myweightedGraph(int capacity) {
        super(capacity);
        weight = new double[capacity][capacity];
    }

    @Override
    public void addVertex(String newVertex) {
        if (getIndex(newVertex) != -1) {
            System.out.print("addVertex: ");
            System.out.print(newVertex);
            System.out.println(" failed -- vertex already exists.");
            return;
        }

        // if array of vertices is full, we need to expand it and
        // also expand Edges
        if (names.length == numVertices) {
            names = resize(names, 2 * numVertices + 1);
            Edges = resize(Edges, 2 * numVertices + 1);
            weight = resize(weight, 2 * numVertices + 1);
        }

        names[numVertices++] = newVertex;
    }

    // Ham resize cho mangr 2 chieu Weight
    protected double[][] resize(double[][] array, int newSize) {
        double[][] temp = new double[newSize][newSize];

        int smallerSize = newSize;
        if (array.length < smallerSize)
            smallerSize = array.length;

        for (int i = 0; i < smallerSize; i++) {
            for (int j = 0; j < smallerSize; j++) {
                temp[i][j] = array[i][j];
            }

        }
        return temp;
    }

    @Override
    public void addEdge(String u, String v) {
        addEdge(u, v, 1.0);
    }

    public void addEdge(String u, String v, double w) {
        int i = getIndex(u);
        if (i == -1) {
            System.out.print("addEdge failed: ");
            System.out.print(u);
            System.out.println(" does not exist.");
            return;
        }

        int j = getIndex(v);
        if (j == -1) {
            System.out.print("addEdge failed: ");
            System.out.print(v);
            System.out.println(" does not exist.");
            return;
        }

        Edges[i].insertFirst(names[j]);
        Edges[j].insertFirst(names[i]);

        weight[i][j] = w;
        weight[j][i] = w;

        numEdges++;
    }

    public void setWeight(double w[][]) {
        weight = (double[][]) w;
    }

    public Double getweight(String u, String v) {
        int i = getIndex(u);
        int j = getIndex(v);

        return getweight(i, j);
    }

    public Double getweight(int i, int j) {
        return weight[i][j];
    }

    public String[] getSortedEdges(int v) {
        String[] ret = Edges[v].copyIntoArray();

        for (int i = 0; i < ret.length-1; i++) {
            int k = i;  // k is index of min
            for (int j = i + 1; j < ret.length; j++) {
                if(getweight(v, k)>getweight(v, j)) k = j;
            }
            String tmp = ret[i]; ret[i] = ret[k]; ret[k] = tmp;
        }
        return ret;
    }

    public int[] MST() {
        int[] tree = new int[numVertices];
            for(int i = 0; i<numVertices; i++) tree[i] = -1;
        boolean visit[] = new boolean[numVertices];
            for(int i = 0; i<numVertices; i++) visit[i] = false;

        int v = 0, t = 0;
        String [] vtx = getSortedEdges(v);

        do
        {
            for(int i = 0; i < numVertices; i++)
            {
                if(!visit[getIndex(vtx[i])])
                {
                    visit[getIndex(vtx[i])] = true;
                    tree[t] = i;
                    break;
                }
            }
            t++;
        }while(t<numVertices);

        return tree;

        // Bước 1: Sắp xếp các cạnh của đồ thị theo thứ tự trọng số tăng dần.
        // Bước 2: Khởi tạo T:= Ø
        // Bước 3: Lần lượt lấy từng cạnh thuộc danh sách đã sắp xếp. Nếu T+{e} không
        // chứa chu trình thì gán T:=T+{e}.
        // Bước 4: Nếu T đủ n-1 phần tử thì dừng, ngược lại làm tiếp bước 3.
    }

    // Phương thức này trả về tổng trọng lượng của một cây bao trùm tối thiểu.
    public double costMST() {
        return 0;
    }
}