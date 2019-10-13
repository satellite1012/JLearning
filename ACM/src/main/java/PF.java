import java.util.Scanner;

public class PF
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            in.close();
        
            
        BinaryTree btree = new BinaryTree();
        in = new Scanner(str);
        while(in.hasNextInt())
        {
            btree.insert(in.nextInt());
        }
        System.out.println(btree.height()+1);
        in.close();
    }
}

class TreeNode 
{ 
    int data; 
    TreeNode root = null;
    TreeNode left, right;
    
    TreeNode(int item) 
    { 
        data = item; 
        left = right = null; 
    }
}

class BinaryTree
{
    TreeNode root;

    public BinaryTree()
    {
        root = null;
    }
    public BinaryTree(int root_item)
    {
        this();
        insert(root_item);
    }

    public boolean isEmpty()
    {
        return (root == null);
    }

    public void clear()
    {
        root = null;
    }

    public TreeNode search(int x)
    {
        if(isEmpty()) return null;
        return search(root, x);
    }
    private TreeNode search(TreeNode tnode, int x)
    {
        if(tnode.data < x) return search(tnode.right, x); else
        if(tnode.data > x) return search(tnode.left, x); else
        if(tnode.data == x) return tnode;
        return null;
    }
    public void insert(int x)
    {
        if(isEmpty())
        {
            root = new TreeNode(x);
        }else
        {
            insert(root, x);
        }
    }
    private void insert(TreeNode tnode, int x)
    {
        if(tnode.data <= x)
        {
            if(tnode.right==null)
            {
                tnode.right = new TreeNode(x);
                tnode.right.root = tnode;
            }
            else
                insert(tnode.right, x);
        } else
        if(tnode.data > x)
        {
            if(tnode.left==null)
            {
                tnode.left = new TreeNode(x);
                tnode.left.root = tnode;
            }
            else
                insert(tnode.left, x);
        }
    }
    public int height()
    {
        return maxheight(root)-1;
    }
    private int maxheight(TreeNode tnode)
    { 
        if (tnode == null) 
            return 0; 
        else 
        { 
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
}