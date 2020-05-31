 
/**
* This class represents a AVLNode 
*/

public class AVLNode
{    
    AVLNode left, right;
    AccountData data;
    int height;
 
    /**
   * This Constructor creates an AVLNode
   * @param Account data.
   * @return Nothing.
   */	
    public AVLNode(AccountData data)
    {
        left = null;
        right = null;
        this.data = data;
        height = 0;
    }     
}
 