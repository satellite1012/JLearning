package assignment2ex1;

import java.io.BufferedWriter;

class TreeNode<T> {
    T data;
    TreeNode<T> root = null;
    TreeNode<T> left, right;

    TreeNode(T item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree<T extends Comparable<T>>{
    TreeNode<T> root;

    public BinaryTree() {
        root = null;
        // comparator = null;
    }

    public BinaryTree(T root_item) {
        this();
        insert(root_item);
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public TreeNode<T> search(T x) {
        if (isEmpty())
            return null;
        return search(root, x);
    }

    private TreeNode<T> search(TreeNode<T> tnode, T x) {
        if (tnode.data.compareTo(x) < 0)
            return search(tnode.right, x);
        else if (tnode.data.compareTo(x) > 0)
            return search(tnode.left, x);
        else if (tnode.data == x)
            return tnode;
        return null;
    }

    public void insert(T x) {
        if (isEmpty()) {
            root = new TreeNode<T>(x);
        } else {
            insert(root, x);
        }
    }

    private void insert(TreeNode<T> tnode, T x) {
        if (tnode.data.compareTo(x) <= 0) {
            if (tnode.right == null) {
                tnode.right = new TreeNode<T>(x);
                tnode.right.root = tnode;
            } else
                insert(tnode.right, x);
        } else if (tnode.data.compareTo(x) > 0) {
            if (tnode.left == null) {
                tnode.left = new TreeNode<T>(x);
                tnode.left.root = tnode;
            } else
                insert(tnode.left, x);
        }
    }

    public void breadth() {
        if (isEmpty()) {
            System.out.println(" >> Empty tree!");
        } else {
            System.out.println("=== Binary Search Tree Traverse ===");
            breadth(root);
            System.out.println("===================================");
        }
    }

    public void breadth(TreeNode<T> tnode) {
        System.out.println(tnode.data + " ");
        if (tnode.left != null)
            breadth(tnode.left);
        if (tnode.right != null)
            breadth(tnode.right);
    }

    public void preorder(TreeNode<T> tnode) {
        System.out.print(tnode.data + " ");
        if (tnode.left != null)
            breadth(tnode.left);
        if (tnode.right != null)
            breadth(tnode.right);
    }

    public void inorder() {
        if (isEmpty()) {
            System.out.println(" >> Empty tree!");
        } else {
            System.out.println("=== Binary Search Tree In-Order Traverse ===");
            inorder(root);
            System.out.println("===================================");
        }
    }

    public void inorder(TreeNode<T> tnode) {
        if (tnode.left != null)
            inorder(tnode.left);
        System.out.println(tnode.data + " ");
        if (tnode.right != null)
            inorder(tnode.right);
    }

    public void inorder_file(TreeNode<T> tnode, BufferedWriter br) {
        if (tnode.left != null)
            inorder(tnode.left);

        try {
            br.write(tnode.data.toString());
            br.newLine();
        } catch (Exception e) { }

        if (tnode.right != null)
            inorder(tnode.right);
    }

    public void postorder(TreeNode<T> tnode) {
        if (tnode.left != null)
            breadth(tnode.left);
        if (tnode.right != null)
            breadth(tnode.right);
        System.out.print(tnode.data + " ");
    }

    public int count() {
        return count(root);
    }

    private int count(TreeNode<T> tnode) {
        if (tnode == null)
            return 0;
        return 1 + count(tnode.left) + count(tnode.right);
    }

    public void delete(T x) {
        TreeNode<T> tnode = search(x);
        if (tnode == null)
            return;
        if (tnode.left == null && tnode.right == null) {
            if (tnode.root.left == tnode)
                tnode.root.left = null;
            else
                tnode.root.right = null;
        } else if (tnode.left != null && tnode.right == null) {
            if (tnode.root.left == tnode)
                tnode.root.left = tnode.left;
            else
                tnode.root.right = tnode.left;
        } else if (tnode.left == null && tnode.right != null) {
            if (tnode.root.left == tnode)
                tnode.root.left = tnode.right;
            else
                tnode.root.right = tnode.right;
        } else {
            TreeNode<T> snode = tnode.left;
            while (snode != null && (snode.left != null || snode.right != null)) {
                if (snode.right != null)
                    snode = snode.right;
                else if (snode.left != null)
                    snode = snode.left;
            }
            tnode.data = snode.data;
            if (snode.root.left == snode)
                snode.root.left = null;
            else
                snode.root.right = null;
        }
    }

    public TreeNode<T> min() {
        TreeNode<T> min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public TreeNode<T> max() {
        TreeNode<T> max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    // public int sum() {
    // if (isEmpty())
    // return 0;
    // return sum(root);
    // }

    // private int sum(TreeNode<T> tnode) {
    // if (tnode == null)
    // return 0;
    // return tnode.data + sum(tnode.left) + sum(tnode.right);
    // }

    // public int avg() {
    // return (int) (this.sum() / this.count());
    // }

    public int height() {
        return maxheight(root) - 1;
    }

    private int maxheight(TreeNode<T> tnode) {
        if (tnode == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxheight(tnode.left);
            int rDepth = maxheight(tnode.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode<T> tnode) {
        if (tnode == null)
            return 0;
        else
            return (size(tnode.left) + 1 + size(tnode.right));
    }
}