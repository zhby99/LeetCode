/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null){
            queue.offer(root);
        } else{
            result.append("null,");
            return result.toString();
        }
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                result.append("null,");
            } else{
                result.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        nodes.addAll(Arrays.asList(data.split(",")));
        String val = nodes.remove();
        if(val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null){
                String left = nodes.remove();
                if(left.equals("null")){
                    queue.offer(null);
                } else{
                    current.left = new TreeNode(Integer.valueOf(left));
                    queue.offer(current.left);
                }
                String right = nodes.remove();
                if(right.equals("null")){
                    queue.offer(null);
                } else{
                    current.right = new TreeNode(Integer.valueOf(right));
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
