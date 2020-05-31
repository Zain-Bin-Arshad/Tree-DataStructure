 
/**
* This class represents a BTreeNode 
*/

public class BTreeNode
{
	static int t;  // order of tree
	int count; 
	AccountData key[]; 
	BTreeNode child[]; 
	boolean leaf;
	BTreeNode parent;  


	/**
   * This Constructor creates an BTreeNode
   * @param int t.
   * @param BTreeNode parent.
   * @return Nothing.
   */	
	public BTreeNode(int t, BTreeNode parent)
	{
		this.t = t; 
		this.parent = parent; 
		key = new AccountData[2*t - 1];  
		child = new BTreeNode[2*t];
		leaf = true; 
		count = 0; 
	}


	/**
   * To get key value at index position
   * @param int index.
   * @return AccountData key[index].
   */	
	public AccountData getValue(int index)
	{
		return key[index];
	}

	/**
   * Get given(index) child
   * @param int index.
   * @return BTreeeNode child[index].
   */
	public BTreeNode getChild(int index)
	{
		return child[index];
	}


}

