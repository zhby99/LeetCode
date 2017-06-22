/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    public int sumHelper(TreeNode n, int prev){
	    if (n == null) {
	        return 0;
	    }
	    if (n.right == null && n.left == null) {
	        return 10 * prev + n.val;
	    }
	    return sumHelper(n.left, 10 * prev + n.val) + sumHelper(n.right, 10 * prev + n.val);
    }
}
