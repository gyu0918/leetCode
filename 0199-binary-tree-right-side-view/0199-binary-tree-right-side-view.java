/**
 * Definition for a binary tree node.
 */

//  import java.util.*;
//  import java.io.*;


//  public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
 
import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                // 현재 레벨의 마지막 노드면 결과에 추가
                if (i == size - 1) {
                    result.add(cur.val);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return result;
    }

    // level order 배열 형태 입력을 트리로 만드는 함수
    // 예: 1 2 3 null 5 null 4
    public static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;

        while (!q.isEmpty() && index < arr.length) {
            TreeNode cur = q.poll();

            // left child
            if (index < arr.length && !arr[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[index]));
                q.offer(cur.left);
            }
            index++;

            // right child
            if (index < arr.length && !arr[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[index]));
                q.offer(cur.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 예시 입력:
        // 1 2 3 null 5 null 4
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            System.out.println("[]");
            return;
        }

        String[] arr = line.trim().split("\\s+");
        TreeNode root = buildTree(arr);

        List<Integer> answer = rightSideView(root);
        System.out.println(answer);
    }
}