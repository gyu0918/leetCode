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
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // 노드가 없는 경우도 하나의 경우의 수로 넣어줘야 조합 가능
        if (start > end) {
            result.add(null);
            return result;
        }

        // start ~ end 사이 값을 루트로 하나씩 선택
        for (int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftTrees = build(start, rootVal - 1);
            List<TreeNode> rightTrees = build(rootVal + 1, end);

            // 왼쪽 후보 x 오른쪽 후보 조합
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}