package tree;

import java.util.List;

public class TreeNode {
    int val;
    List<TreeNode> nodeList;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setNode(List<TreeNode> nodeList){
        this.nodeList = nodeList;
    }

}
