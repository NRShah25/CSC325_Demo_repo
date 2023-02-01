
package list.csc229_hw5;
/**
 * This class is meant to utilize the behaviors
 * and properties of a binary search tree
 * @author nicholasshah
 */
public class PurchaseBinarySearchTree {
  /**
   * Constructor for a node, meant to hold purchase data
   */
    public class Node{
    Purchase data = new Purchase(); 
    Node left ;
    Node right;
    } 
  /**
   * method call to copy a node
   * @param n - existing node
   * @return - deep copy of an existing node
   */  
    public Node copyNode(Node n){
        return copyNode(n.data.makeCopy(),n.left,n.right);
    }
  /**
   * This method helps the node create a deep copy
   * @param name - existing purchase
   * @param left - left purchase
   * @param right - right purchase
   * @return - deep copy of a new node
   */  
    private Node copyNode(Purchase name,Node left,Node right){
        Node n1 = new Node();
        
        n1.data = name;
        n1.left = left;
        n1.right = right;
        if (n1.left != null){
            n1.left = copyNode(left);
        }
        if (n1.right != null){
            n1.right = copyNode(right);
        }
        return n1;
    } 
    public Node root;                                                           // variable of binary tree
    /**
     * public constructor of a binary tree
     */
    public PurchaseBinarySearchTree(){
        root = null;
    }
    /**
     * Copy constructor that creates a deep copy through use of
     * the copyNode method
     * @param other 
     */
   public PurchaseBinarySearchTree(PurchaseBinarySearchTree other){
        
        if (other.root != null){
           this.root = new Node();
           this.root = other.copyNode(other.root);
           this.root.left = (other.copyNode(other.root.left));
           this.root.right = (other.copyNode(other.root.right));
        }     
    }
    /**
     * logically sets the binary tree to empty
     */
    public void clear(){
        root = null;
    }
    /**
     * gets the length of how many nodes are in the tree
     * @return 
     */
    public int getLength(){
        return getLength(root);
    }
    /**
     * helper method that traverses the tree until it reaches the end nodes
     * @param tree
     * @return 
     */
    private int getLength(Node tree){
        if (tree == null){
            return 0;
        }
        else
        return getLength(tree.left) + getLength(tree.right) + 1;
    }
    /**
     * adds a node to the current tree
     * @param g 
     */
    public void add(Purchase g){
        root = add(root,g);
    }
    /**
     * helper method that will add a node to the tree in
     * a correct location depending on the value of the string name
     * @param tree - current tree
     * @param g - purchase to be added
     * @return 
     */
    private Node add(Node tree, Purchase g){
       if(tree == null){
           Node trees = new Node ();
           trees.data = g;
           trees.left = null;
           trees.right = null;
           return trees;
       }     
        if (g.getItemName().compareTo(tree.data.getItemName()) < 0){
            tree.left = add(tree.left,g);
        }
        else if (g.getItemName().compareTo(tree.data.getItemName()) > 0){
            tree.right = add(tree.right,g);
        }
        return tree;
    }
    /**
     * returns the items in tree as they were entered
     */
    public void preorder(){
        preorder(root);
    }
    /**
     * helper method that uses recursive calls to 
     * print out data in tree
     * @param tree 
     */
    private void preorder(Node tree){
        if (tree != null){
            System.out.println(tree.data.getItemName());
            preorder(tree.left);
            preorder(tree.right);
        }
    }
    /**
     * prints out data in order from binary tree
     */
    public void inorder(){
        inorder(root);
    }
    /**
     *  helper method that uses recursive calls to 
     * print out data in tree
     * @param tree 
     */
    private void inorder(Node tree){
        if (tree != null){
            inorder(tree.left);
            System.out.println(tree.data.getItemName());
            inorder(tree.right);
        }
    }
    /**
     * prints out data in tree from order of 
     * last entered to first entered
     */
    public void postorder(){
        postorder(root);
    }
    /**
     *  helper method that uses recursive calls to 
     * print out data in tree
     * @param tree 
     */
    private void postorder(Node tree){
        if (tree!= null){
            postorder(tree.left);
            postorder(tree.right);
            System.out.println(tree.data.getItemName());
        }
    }
    /**
     * returns a purchase keyed on the item name
     * @param itemName
     * @return 
     */ 
    public Purchase getPurchase(String itemName){
            
            return getPurchase(root,itemName);
    }
    /**
     * helper method that will traverse the tree until
     * the name matches the name being searched for
     * @param tree
     * @param itemName
     * @return 
     */
    private Purchase getPurchase(Node tree,String itemName){
        
        if (tree == null){
            return null;
        }
        
        else if (itemName.compareTo(tree.data.getItemName())< 0){
            return getPurchase(tree.left,itemName);
        }
        else if (itemName.compareTo(tree.data.getItemName())> 0){
            return getPurchase(tree.right,itemName);
        }
        else 
            return tree.data;    
    }
    /**
     * returns total cost of tree
     * @return 
     */
    public double totalCostUsingRecursion(){
        return totalCostUsingRecursion(root);
    }
    /**
     * helper method that traverses the tree, calling
     * the cost method from the purchase class to calculate a 
     * grand total cost
     * @param tree
     * @return 
     */
    private double totalCostUsingRecursion(Node tree){
        if (tree == null){
            return 0;
        }
        else
            return (tree.data.cost() + totalCostUsingRecursion(tree.right) + totalCostUsingRecursion(tree.left));         
    }
    /**
     * This method creates a copy of a tree through the
     * use of the copy constructor
     * @return 
     */
    public PurchaseBinarySearchTree makeCopy(){
        PurchaseBinarySearchTree p = new PurchaseBinarySearchTree(this);
        return p;   
    }
    /**
     * this method checks if two trees are identical to each other
     * based on purchase data and shape of tree
     * @param p
     * @return 
     */
    @Override
    public boolean equals(Object p){
      PurchaseBinarySearchTree p1 = (PurchaseBinarySearchTree)p;
       
      if (this.getLength() != p1.getLength())
             return false;
    
     boolean equal = ehelper(this.root,p1.root);
        return equal;
    }
    /**
     * helper method that checks if two purchases are identical
     * through the use of the purchase equals methods
     * and then traverses the tree in the same order
     * comparing every value
     * @param tree
     * @param other
     * @return 
     */
    private boolean ehelper(Node tree,Node other){
       boolean treeequal = true;
       boolean leftequal = true;
       boolean rightequal = true;
       
       if (tree.data != null && other.data != null){
           treeequal = tree.data.equals(other.data);            
       
        if (tree.left != null && other.left != null){
            leftequal = ehelper(tree.left,other.left);
        }
        else if (tree.left == null && other.left == null){
            leftequal = true;
        }
              if (tree.right != null && other.right != null){
            rightequal = ehelper(tree.right,other.right);
        }
              else if (tree.right == null && other.right == null){
            rightequal = true;
        }
         return (treeequal && leftequal && rightequal);
       } 
        return false;
    }   
}

