/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//dfs로 접근해야됨
// class Solution {
//     public int maxDepth(TreeNode root) {
//         //엣지 처리
//         if (root == null) return 0;

//         int leftDepth = maxDepth(root.left);
//         int rightDepth = maxDepth(root.right);

//         return Math.max(leftDepth, rightDepth) + 1;
//     }
// }

// bfs로 접근하는 방법 
class Solution {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int depth = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
    