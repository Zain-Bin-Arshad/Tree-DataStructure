 

/**
* This is implementation of AVLTrees 
*/

public class AVLTree
 {
    AVLNode root;    
	int size =0;	
    
 /**
   * This no argument Constructor, which creates an object of AVLTree
   * @param Nothing.
   * @return Nothing.
   */	
    public AVLTree()
    {
        root = null;
    }

  /**
   * This calls the recurssive method insert()
   * It increases the size of AVLTree by 1
   * @param AccountData data .
   * @return Nothing.
   */
    public void insert(AccountData data)
    {
        root = insert(data, root);
		size++;
    }
	
	/**
   * This Inserts AccountData into the tree,
   * maintains tree balance by calling helper functions i.e. double_with_right()
   * @param key AccountData
   * @param AVLNode node
   * @return AVLNode node.
   */
    public AVLNode insert(AccountData key, AVLNode node)
    {
        if (node == null)
            node = new AVLNode(key);
         else 
			// key is less than node's key
			if (key.compareTo(node.data) < 0){
				node.left = insert( key, node.left );
				// if tree becomes unbalanaced 
				if(height( node.left) -height(node.right) == 2 )
					if( key.compareTo(node.left.data) < 0)
						node = rotate_with_left(node);
					else
						node = double_with_left(node);
			}
			else 
				// key is greater than node's key
				if( key.compareTo(node.data) > 0 ){

					node.right = insert( key, node.right );
					// if tree becomes unbalanced
					if( height(node.right)- height( node.left) ==2 )
						if( key.compareTo(node.right.data) > 0)
							node = rotate_with_right( node );
						else
							node = double_with_right(node);
				}
				// dupliacte ... do nothing
				else
				   ; 
		// updating hiehtof the node
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }
	
    /**
   * This find out the height of the tree
   * @param AVLNode node
   * @return int height.
   */
    public int height(AVLNode node )
    {
        return node == null ? -1 : node.height;
    }
	
   /**
   * This rotates input node with its left node
   * @param AVLNode node
   * @return AVLNode node.
   */   
    public AVLNode rotate_with_left(AVLNode node2)
    {
        AVLNode node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;
        node2.height = Math.max( height( node2.left ), height( node2.right ) ) + 1;
        node1.height = Math.max( height( node1.left ), node2.height ) + 1;
        return node1;
     }
 
   /**
   * This rotates input node with its right node
   * @param AVLNode node
   * @return AVLNode node.
   */ 
	private AVLNode rotate_with_right(AVLNode node1)
    {
        AVLNode node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        node1.height = Math.max(height(node1.left), height(node1.right))+1;
        node2.height = Math.max(height(node2.right), node1.height ) +1;
        return node2;
    }
	
	 /**
   * This rotates input node with its right node then left node
   * @param AVLNode node
   * @return AVLNode node.
   */  
    public AVLNode double_with_left(AVLNode node3)
    {
        node3.left = rotate_with_right( node3.left );
        return rotate_with_left( node3 );
    }
	
	 /**
   * This rotates input node with its left node then right node
   * @param AVLNode node
   * @return AVLNode node.
   */  
    public AVLNode double_with_right(AVLNode node1)
    {
        node1.right = rotate_with_left( node1.right );
        return rotate_with_right( node1 );
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
   * This tells the height of tree
   * @param nothing
   * @return int height.
   */ 
	public int getHeight()
	{
		return root.height;
	}
	
	/**
   * This calls balance()
   * @param nothing
   * @return float balance.
   */ 
	public float getBalance()
	{
		return balance(root);
	}	
	
	/**
   * This tells how much % tree is balanced
   * @param AVLNode root
   * @return float balance.
   */ 
	public float balance(AVLNode root)  
    { 
		float leftNodesP = ((float)countNode(root.left) / getSize()) * 100 ;
		float rightNodesP = 100 - leftNodesP;
		return 100 - Math.abs(leftNodesP - rightNodesP);
    } 
	
	/**
   * This counts the number of all nodes below a given node
   * @param AVLNode node
   * @return int count.
   */ 
	private int countNode(AVLNode node)
	{
		if (node == null)
			return 0;
		else{
			int count = 1;
			count += countNode(node.left);
			count += countNode(node.right);
			return count;
		}
	}	
	
 }
