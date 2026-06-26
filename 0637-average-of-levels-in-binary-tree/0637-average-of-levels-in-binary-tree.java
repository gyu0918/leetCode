import java.io.*;
import java.util.*;   // utill → util 오타 수정

// LeetCode 환경에서는 주석 처리된 TreeNode를 제공하므로
// 로컬 실행 시에만 아래 클래스가 필요
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // ── BFS 핵심 로직 ────────────────────────────────────────────────────
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 현재 레벨 노드 수 스냅샷 (핵심!)
            long sum = 0;                 // int 오버플로우 방지 → long

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add((double) sum / levelSize);
        }

        return result;
    }

    // ── 입력 파싱: "[3,9,20,null,null,15,7]" → TreeNode ─────────────────
    private static TreeNode buildTree(String line) {
        line = line.trim();
        line = line.substring(1, line.length() - 1).trim(); // 대괄호 제거

        if (line.isEmpty() || line.equals("null")) return null;

        String[] tokens = line.split(",");
        if (tokens[0].trim().equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0].trim()));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int idx = 1;
        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode cur = queue.poll();

            // 왼쪽 자식
            if (idx < tokens.length) {
                String val = tokens[idx++].trim();
                if (!val.equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(val));
                    queue.offer(cur.left);
                }
            }

            // 오른쪽 자식
            if (idx < tokens.length) {
                String val = tokens[idx++].trim();
                if (!val.equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(val));
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }

    // ── main ─────────────────────────────────────────────────────────────
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine(); // 예) [3,9,20,null,null,15,7]

        TreeNode root = buildTree(line);

        Solution sol = new Solution();
        List<Double> result = sol.averageOfLevels(root);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(result.get(i));
        }
        sb.append("]");

        System.out.println(sb);
    }
}