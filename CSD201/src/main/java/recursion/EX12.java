package recursion;

// Bai nay su dung class BinaryTree dinh kem trong thu muc

public class EX12
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree(0);
        tree.add(tree.root, 1, 2);
        tree.add(tree.root.left, 3, 4);
        tree.add(tree.root.right, 5, 6);
        
        System.out.println("Tree depth = " + tree.maxDepth(tree.root));
    }
}