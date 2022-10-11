import java.util.Stack;
 
public class BinaryTreeTraverse {
 
    public static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }
 
    // Recursive Solution
    public void inOrder(TreeNode root) {
        if(root !=  null) {
            inOrder(root.left);
            //Visit the node by Printing the node data  
            System.out.printf("%d ",root.data);
            inOrder(root.right);
        }
    }
 
    // Iterative solution
    public void inOrderIter(TreeNode root) {
 
        if(root == null)
            return;
 
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode=root;
 
        while(!s.empty() || currentNode!=null){
 
            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                TreeNode n=s.pop();
                System.out.printf("%d ",n.data);
                currentNode=n.right;
            }
        }
    }
    
    // Recursive Solution
    public void preorder(TreeNode root) {
        if(root !=  null) {
            //Visit the node-Printing the node data  
            System.out.printf("%d ",root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
 
    // Iterative solution
    public void preorderIter(TreeNode root) {
 
        if(root == null)
            return;
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        while(!stack.empty()){
 
            TreeNode n = stack.pop();
            System.out.printf("%d ",n.data);
 
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            } 
        } 
    }
       
    // Recursive Solution
    public void postOrder(TreeNode root) {
        if(root !=  null) {
            postOrder(root.left);
            postOrder(root.right);
            //Visit the node by Printing the node data  
            System.out.printf("%d ",root.data);
        }
    }
 
    // Iterative solution
    public void postorderIter( TreeNode root) {
        if( root == null ) return;
 
        Stack<TreeNode> s = new Stack<TreeNode>( );
        TreeNode current = root;
 
        while( true ) {
 
            if( current != null ) {
                if( current.right != null ) 
                    s.push( current.right );
                s.push( current );
                current = current.left;
                continue;
            }
 
            if( s.isEmpty( ) ) 
                return;
            current = s.pop( );
 
            if( current.right != null && ! s.isEmpty( ) && current.right == s.peek( ) ) {
                s.pop( );
                s.push( current );
                current = current.right;
            } else {
                System.out.print( current.data + " " );
                current = null;
            }
        }
    }
 
    public static void main(String[] args)
    {
        BinaryTreeTraverse bi=new BinaryTreeTraverse();
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("Using inOrder Recursive solution:");
 
        bi.inOrder(rootNode);
 
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");
 
        bi.inOrderIter(rootNode);
        
        System.out.println("\n\nUsing preOrder Recursive solution:");
 
        bi.preorder(rootNode);
 
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using Iterative solution:");
 
        bi.preorderIter(rootNode);
        
        System.out.println("\n\nUsing postOrder Recursive solution:");
 
        bi.postOrder(rootNode);
 
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Using postOrder Iterative solution:");
 
        bi.postorderIter(rootNode);
    }
 
    public static TreeNode createBinaryTree()
    {
 
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
 
        rootNode.left=node20;
        rootNode.right=node60;
 
        node20.left=node10;
        node20.right=node30;
 
        node60.left=node50;
        node60.right=node70;
 
        return rootNode;
    }
}
