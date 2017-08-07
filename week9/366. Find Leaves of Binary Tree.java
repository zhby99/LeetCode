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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        while(!isLeaf(root)){
            res.add(new LinkedList<>(helper(root)));
        }
        res.add(new LinkedList<>(Arrays.asList(root.val)));
        return res;
    }
    private List<Integer> helper(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        if(isLeaf(root.left)){
            List<Integer> res = new LinkedList<>();
            res.add(root.left.val);
            root.left = null;
            if(isLeaf(root.right)){
                res.add(root.right.val);
                root.right = null;
                return res;
            } else{
                List<Integer> right = new LinkedList<>(helper(root.right));
                for(int num: right){
                    res.add(num);
                }
                return res;
            }
        } else{
            if(isLeaf(root.right)){
                List<Integer> res = new LinkedList<>(helper(root.left));
                res.add(root.right.val);
                root.right = null;
                return res;
            } else{
                List<Integer> res = new LinkedList<>(helper(root.left));
                List<Integer> right = new LinkedList<>(helper(root.right));
                for(int num: right){
                    res.add(num);
                }
                return res;
            }
        }
    }

    private boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
