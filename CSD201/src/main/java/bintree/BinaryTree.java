package bintree;

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

    public void breadth()
    {
        if(isEmpty())
        {
            System.out.println(" >> Empty tree!");
        } else
        {
            System.out.println("=== Binary Search Tree Traverse ===");
            breadth(root);
            System.out.println("===================================");
        }
    }
    public void breadth(TreeNode tnode)
    {
        System.out.print(tnode.data + " ");
        if(tnode.left != null) breadth(tnode.left);
        if(tnode.right != null) breadth(tnode.right);
    }

    public void preorder(TreeNode tnode)
    {
        System.out.print(tnode.data + " ");
        if(tnode.left != null) breadth(tnode.left);
        if(tnode.right != null) breadth(tnode.right);
    }
    public void inorder(TreeNode tnode)
    {
        if(tnode.left != null) breadth(tnode.left);
        System.out.print(tnode.data + " ");
        if(tnode.right != null) breadth(tnode.right);
    }
    public void postorder(TreeNode tnode)
    {
        if(tnode.left != null) breadth(tnode.left);
        if(tnode.right != null) breadth(tnode.right);
        System.out.print(tnode.data + " ");
    }

    public int count()
    {
        return count(root);
    }
    private int count(TreeNode tnode)
    {
        if(tnode==null) return 0;
        return 1 + count(tnode.left) + count(tnode.right);
    }

    public void dele(int x)
    {
        TreeNode tnode = search(x);
        if(tnode==null) return;
        if(tnode.left==null && tnode.right==null)
        {
            if(tnode.root.left == tnode) tnode.root.left = null;
            else tnode.root.right = null;
        }
        else if(tnode.left!=null && tnode.right==null)
        {
            if(tnode.root.left == tnode) tnode.root.left = tnode.left;
            else tnode.root.right = tnode.left;
        }
        else if(tnode.left==null && tnode.right!=null)
        {
            if(tnode.root.left == tnode) tnode.root.left = tnode.right;
            else tnode.root.right = tnode.right;
        }
        else
        {
            TreeNode snode = tnode.left;
            while(snode!=null && (snode.left!=null || snode.right!=null))
            {
                if(snode.right!=null) snode = snode.right; else
                if(snode.left!=null) snode = snode.left;
            }
            tnode.data = snode.data;
            if(snode.root.left == snode) snode.root.left = null;
            else snode.root.right = null;
        }
    }
    public TreeNode min()
    {
        TreeNode min = root;
        while(min.left!=null)
        {
            min = min.left;
        }
        return min;
    }
    public TreeNode max()
    {
        TreeNode max = root;
        while(max.right!=null)
        {
            max = max.right;
        }
        return max;
    }
    public int sum()
    {
        if(isEmpty()) return 0;
        return sum(root);
    }
    private int sum(TreeNode tnode)
    {
        if(tnode==null) return 0;
        return tnode.data + sum(tnode.left) + sum(tnode.right);
    }
    public int avg()
    {
        return (int)(this.sum()/this.count());
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