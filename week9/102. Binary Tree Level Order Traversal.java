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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 0);
        int last = -1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int level = map.get(cur);
            if(level > last){
                last = level;
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(cur.val);
            if(cur.left != null){
                map.put(cur.left, level + 1);
                queue.offer(cur.left);
            }
            if(cur.right != null){
                map.put(cur.right, level + 1);
                queue.offer(cur.right);
            }
        }
        return res;
    }
}
