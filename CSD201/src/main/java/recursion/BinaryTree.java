package recursion;

// Class viet rieng cho de code bai 12 va 13

class TreeNode 
{ 
    int data; 
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

    BinaryTree()
    {
        this(0);
    }
    BinaryTree(int item)
    {
        root = new TreeNode(item);
    }

    public void add(TreeNode node_root, int item_left, int item_right)
    {
        node_root.left = new TreeNode(item_left);;
        node_root.right = new TreeNode(item_right);;
    }

    int maxDepth(TreeNode tnode)  
    { 
        if (tnode == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(tnode.left); 
            int rDepth = maxDepth(tnode.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    } 

    public int size() 
    { 
        return size(root); 
    }
    private int size(TreeNode tnode) 
    { 
        if (tnode == null) 
            return 0; 
        else
            return(size(tnode.left) + 1 + size(tnode.right)); 
    } 
}