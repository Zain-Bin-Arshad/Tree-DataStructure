 import java.io.*;

/**
* This class is represents node of Binary Seacrh Tree 
*/
public class BSTNode implements Serializable
{
	AccountData key;
	BSTNode left, right;

	/**
   * This Constructor creates an BSTNode
   * @param Account data.
   * @return Nothing.
   */	
	public BSTNode(AccountData item)
	{
		key = item;
		left = right = null;
	}
	
	/**
   * This prints the Key stored in repective node of BST on the standard output
   * @param nothing
   * @return String node's data.
   */	
	public String toString()
	{
		return this.key.toString();
	}
}