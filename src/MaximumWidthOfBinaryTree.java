import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        int[] root = {1, 3, -101, 5, 3};
        TreeNode treeRoot = createTree(root);
        printTree(treeRoot);
        int ans = widthOfBinaryTree(treeRoot);
        System.out.println(ans);
    }

    public static TreeNode createTree(int[] num) {
        TreeNode[] nodes = new TreeNode[num.length];
        for (int i = 0; i < num.length; i++) {
            if (num[i] == -101) {
                nodes[i] = null;
                continue;
            }
            nodes[i] = new TreeNode(num[i]);
        }
        TreeNode root = nodes[0];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) continue;
            nodes[i].left = (i + 1) * 2 - 1 < nodes.length ? nodes[(i + 1) * 2 - 1] : null;
            nodes[i].right = (i + 1) * 2 < nodes.length ? nodes[(i + 1) * 2] : null;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print(root.val + " ");
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
                System.out.print(tmp.left.val + " ");
            } else {
                System.out.print("N ");
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                System.out.print(tmp.right.val + " ");
            } else {
                System.out.print("N ");
            }
        }
        System.out.println();
    }

    public static int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> distanceToRootOfLevel = new HashMap<>();
        dfs(0, root, 0, distanceToRootOfLevel);
        System.out.println(distanceToRootOfLevel);
        int maxWidth = 1;
        for (ArrayList<Integer> tmp : distanceToRootOfLevel.values()) {
            if (tmp.size() < 2)
                continue;
            tmp.sort(Comparator.naturalOrder());
            int width = tmp.get(tmp.size() - 1) - tmp.get(0);
            if (tmp.get(tmp.size() - 1) * tmp.get(0) > 0)
                width += 1;
            if (maxWidth < width)
                maxWidth = width;
        }
        return maxWidth;
    }

    public static void dfs(int dis, TreeNode node, int level, HashMap<Integer, ArrayList<Integer>> map) {
        if (node == null) return;
        if (!map.containsKey(level + 1)) {
            map.put(level + 1, new ArrayList<>());
        }
        if (node.left != null) {
            int tmpDis = dis < 0 ? dis * 2 : dis * 2 - 1;
            map.get(level + 1).add(tmpDis);
            dfs(tmpDis, node.left, level + 1, map);
        }
        if (node.right != null) {
            int tmpDis = dis <= 0 ? dis * 2 + 1 : dis * 2;
            map.get(level + 1).add(tmpDis);
            dfs(tmpDis, node.right, level + 1, map);
        }
    }
}
