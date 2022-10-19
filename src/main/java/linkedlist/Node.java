package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private List<Node> children;
    public Node(String value, List<Node> children) {
        this.value = value;
        this.children = children;
    }
    public Node() {

    }
    public String getValue() {
        return this.value;
    }
    public List<Node> getChildren() {
        return this.children;
    }

    public String toString() {
        return this.value;
    }

    public static void main(String[] args) {
        Node b  = new Node("b", null);
        List<Node> nodeList = List.of(new Node("d", null), new Node("e", null), new Node("f", null));
        Node c = new Node("c", nodeList);

        Node root = new Node("a", List.of(b, c));

        System.out.println(toFlatList(root));
    }


    public static List<Node> toFlatList(Node root){
        List<Node> nodes = new ArrayList<>();
        toNode(root, nodes);
        return nodes;
    }


    public static void toNode(Node root, List<Node> nodes) {
        if (root.getChildren() != null) {
            root.getChildren().forEach(x -> Node.toNode(x, nodes));
        }
        nodes.add(root);
        System.out.println(root);
    }

}
