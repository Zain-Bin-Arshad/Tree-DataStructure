 
/**
* This is implementation of BTree 
*/

public class BTree
{
	int order, size = 0;
	BTreeNode root;  

	/**
   * This no argument Constructor !
   * @param Nothing.
   * @return Nothing.
   */	
	public BTree()
	{}
	
	/**
   * This no argument Constructor, which creats object of BTree of given order
   * @param int order.
   * @return Nothing.
   */	
	public BTree(int order)
	{
		this.order = order;
		root = new BTreeNode(order, null);
	}
	
	 /**
   * This inserts data of type AccountData
   * and calls methods like nonfullInsert()
   * @param AccountData  key.
   * @return Nothing.
   */
	public void insert(AccountData key)
	{
		BTreeNode node = this.root;
		// if full
		if(node.count == 2*order - 1){
			BTreeNode node2 = new BTreeNode(order,null);//new node
			this.root = node2;
			node2.leaf = false;
			node2.count = 0; 	
			node2.child[0] = node;
			//split root
			split(node2,0,node);
			nonfullInsert(node2, key);
		}
		else
			nonfullInsert(node,key);//if its not full just insert it
		size++;
	}
	

	 /**
   * This splits the node if it is full
   * @param BTreeNode firstNode.
   * @param BTreeNode secondNode.
   * @param int i.
   * @return Nothing.
   */
	public void split(BTreeNode firstNode, int i, BTreeNode secondNode)
	{
		// for spliting we need another new Node
		BTreeNode splitionNode = new BTreeNode(order, null);
		splitionNode.leaf = secondNode.leaf;
		// update size
		splitionNode.count = order - 1;

		// copy end of 2nd node to front of splitionNode
		for(int j = 0; j < order - 1; j++)
			splitionNode.key[j] = secondNode.key[j+order]; 

		// if not a leaf node
		if(!secondNode.leaf)
			for(int k = 0; k < order; k++)
				splitionNode.child[k] = secondNode.child[k+order]; 

		// update size
		secondNode.count = order - 1; 

		// rearranging chlid nodes
		for(int j = firstNode.count ; j> i ; j--)
			firstNode.child[j+1] = firstNode.child[j]; 
		
		// assign child firstNode
		firstNode.child[i+1] = splitionNode; 

		// for shifting keys
		for(int j = firstNode.count; j> i; j--)
			firstNode.key[j + 1] = firstNode.key[j]; 
		
		// assign value to root
		firstNode.key[i] = secondNode.key[order-1];
		// delet/ erase value
		secondNode.key[order-1 ] = null;

		// deleting old values
		for(int j = 0; j < order - 1; j++)
			secondNode.key[j + order] = null; //'delete' old values

		// count of firstnode's keysis increased
		firstNode.count ++; 
	}


	/**
   * Inserts when tree is not full
   * @param BTreeNode firstNode.
   * @param AccountData key
   * @return Nothing.
   */
	public void nonfullInsert(BTreeNode firstNode, AccountData key)
	{
		int i = firstNode.count; 
		if(firstNode.leaf){
			// find place to put key
			while(i >= 1 && key.compareTo(firstNode.key[i-1]) < 0){
				firstNode.key[i] = firstNode.key[i-1];
				i--;
			}

			// asign value
			firstNode.key[i] = key;
			// count of firstnode's keysis increased
			firstNode.count ++;
		}
		else{
			int j = 0;
			while(j < firstNode.count  && key.compareTo(firstNode.key[j]) > 0){			              		
				j++;
			}

			if(firstNode.child[j].count == order * 2 - 1){
				//call split on node firstNode's ith child
				split(firstNode,j,firstNode.child[j]);
				if(key.compareTo(firstNode.key[j]) > 0)
					j++;
			}
			//recursion
			nonfullInsert(firstNode.child[j],key);
		}
	}
	
	/**
   * Give Size of tree
   * @param Nothing
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
		int height = 0;
		for (BTreeNode node = root; !node.leaf; node = node.child[0])
			height++;
		return height;
	}
	
	/**
   * This give how % tree is balanced
   * @param nothing
   * @return double balance.
   */ 
   // not been able to build this logic
	public double getBalance()
	{
		return 0.0;
	}
}

