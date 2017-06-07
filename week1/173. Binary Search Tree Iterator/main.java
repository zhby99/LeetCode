/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    LinkedList<TreeNode> nodes;
    Iterator<TreeNode> itr;

    public BSTIterator(TreeNode root) {
        nodes = new LinkedList<TreeNode>();
        helper(root);
        itr = nodes.iterator();
    }

    private void helper(TreeNode middle){
        if(middle==null) return;
        if(middle.left == null){
            nodes.add(middle);
            helper(middle.right);
        }
        else{
            helper(middle.left);
            nodes.add(middle);
            helper(middle.right);
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return itr.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return itr.next().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
