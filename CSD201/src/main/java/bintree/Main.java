package bintree;

public class Main
{
    public static void main(String[] args)
    {
        BinaryTree btree = new BinaryTree();
            // 4,3,12,11,5,7,1
            btree.insert(4);
            btree.insert(3);
            btree.insert(12);
            btree.insert(11);
            btree.insert(5);
            btree.insert(7);
            btree.insert(1);

        btree.breadth();
        System.out.println(">> Count: " + btree.count());
        System.out.print("Preorder: "); btree.preorder(btree.root); System.out.println("");
        System.out.print("Inorder: "); btree.inorder(btree.root); System.out.println("");
        System.out.print("Postorder: ");btree.postorder(btree.root); System.out.println("");

        btree.dele(12);
        System.out.println("\n=== Preorder After Delete Node ===");
        btree.preorder(btree.root); System.out.println();

        System.out.println(">> Min value: " + btree.min().data);
        System.out.println(">> Max value: " + btree.max().data);
        System.out.println(">> SUM of tree: " + btree.sum());
        System.out.println(">> AVG of tree: " + btree.avg());
        System.out.println(">> Height of tree: " + btree.height());
    }
}