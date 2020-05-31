 import java.io.*;
/**
* This is implementation of Binary Search Tree
*/

public class BST implements Serializable
{
	BSTNode root;
	int size = 0;
	/**
   * This no argument Constructor, which creates an object of BST
   * @param Nothing.
   * @return Nothing.
   */
    public BST()
    {
        root = null;
    }
 
	/**
   * This calls the recurssive method insert()
   * It increases the size of BST by 1
   * @param AccountData data .
   * @return Nothing.
   */
    void insert(AccountData key)
    {
        root = insertKey(root, key);
		size++;
    }
 
    /**
   * This Inserts AccountData into the tree
   * @param key AccountData
   * @param BSTNode node
   * @return BSTNode node.
   */
    BSTNode insertKey(BSTNode root, AccountData key)
    {
        // base case
        if (root == null){
            root = new BSTNode(key);
            return root;
        }

        // else, recur down the tree 
        if (key.compareTo(root.key) < 0)
            root.left = insertKey(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = insertKey(root.right, key);
 
        // else return the "unchanged" node pointer
        return root;
    }
	
	
    /**
   * This just calls recursive deleteKey()
   * decreases size by 1
   * @param key String
   * @return BSTNode node.
   */
    public BSTNode delete(String key)
    {
        root = deleteKey(root, key);
		size--;
		return root;
    }
 
   /**
   * This deletes the node that have data equals to given key
   * @param key String
   * @param root BSTNode
   * @return BSTNode node.
   */
    BSTNode deleteKey(BSTNode root, String key)
    {
        // Base Case
        if (root == null)  
			return root;
 
        // else recur down the tree 
        if (key.compareTo(root.key.ticker) < 0)
            root.left = deleteKey(root.left, key);
        else if (key.compareTo(root.key.ticker) > 0)
            root.right = deleteKey(root.right, key);
 
        // if key is same as root, then this  node is to delete
        else
        {
            // node with 1 or no Child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // 2 childrn then get succser
            root.key = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteKey(root.right, root.key.ticker);
        }
        return root;
    }
	
	 /**
   * This gives the successor of given node
   * @param root BSTNode
   * @return BSTNode node.
   */
    AccountData minValue(BSTNode root)
    {
        AccountData minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	
	 /**
   * This tells the size of tree
   * @param nothing
   * @return int size.
   */ 
	public int getSize()
	{
		return size;
	}
	
	/**
   * Just calls height()
   * @param nothing
   * @return int height.
   */ 
	public int getHeight()
	{
		return height(root);
	}
	
	/**
   * calculates the height of the tree
   * @param BSTNode root
   * @return int height.
   */ 
	public int height(BSTNode root) 
	{
		//base case OR when tree is empty
		if (root == null) 
			return -1;

		int Lheight = height(root.left);
		int Rheight = height(root.right);
	
		// return largest hieght
		return (Lheight > Rheight) ?  Lheight+1 : Rheight+1;
    }

	/**
   * just calls searchHelper()
   * @param String key
   * @return boolean key found or not
   */ 
	public boolean search(String key)
	{
		return searchHelper(key, root);
	}
	
	/**
   * Search tree for a given key
   * @param String key
   * @param BSTNode current
   * @return boolean key found or not
   */ 
	public boolean searchHelper(String key, BSTNode current)
	{
		// base case
		if(current == null)
			return false;
		if(key.compareTo(current.key.ticker) == 0 ){
			System.out.printf("\nKey Found ! \n" + current.key);
			return true;
		}
		boolean left = searchHelper(key, current.left);
		boolean right = searchHelper(key,current.right);
		return left || right;
	}
	
	/**
   * just calls balance()
   * @param nothing.
   * @return float balance
   */ 
	public float getBalance()
	{
		return balance(root);
	}	
	
	/**
   * calculates the balance of the tree
   * @param BSTNode root
   * @return float balance
   */ 
	public float balance(BSTNode root)  
    { 
		float leftNodesP = ((float)countNodes(root.left) / getSize()) * 100 ;
		float rightNodesP = 100 - leftNodesP;
		return 100 - Math.abs(leftNodesP - rightNodesP);
    } 
	
	
	/**
   * This counts the number of all nodes below a given node
   * @param BSTNode node
   * @return int count.
   */ 
	private int countNodes(BSTNode node)
	{
		if (node == null)
			return 0;
		else{
			int count = 1;
			count += countNodes(node.left);
			count += countNodes(node.right);
			return count;
		}
	}
}