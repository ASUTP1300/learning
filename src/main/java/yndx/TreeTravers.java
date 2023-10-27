package yndx;

import java.util.ArrayList;
import java.util.List;

public class TreeTravers {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(5);

        TreeNode n12 = new TreeNode(2);
        TreeNode n11 = new TreeNode(1);

        TreeNode n22 = new TreeNode(99);
        TreeNode n21 = new TreeNode(1777);

        n3.left = n12;
        n12.left = n11;

        n3.right = n22;
        n22.right = n21;

        List<List<TreeNode>> list = new ArrayList<>();

        DFM(n3, 0, list);

        System.out.println(list);

    }


    //      5
    //    /  \
    //   2   99
    // /      \
    // 1      1777
    static void DFM(TreeNode node, int depth, List<List<TreeNode>> results) {
        if (node == null) {
            return;
        }

        if (depth >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(depth).add(node);
        depth++;
        DFM(node.left, depth, results);
        DFM(node.right, depth, results);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}

