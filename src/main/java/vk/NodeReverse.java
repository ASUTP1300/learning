package vk;

public class NodeReverse {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNode(node2);
        node2.setNode(node3);
        node3.setNode(node4);
        node4.setNode(node5);

        printNode(node1);
        System.out.println();
        System.out.println();


        printNode(reverseNode(node1));

        System.out.println();
        System.out.println();

        printNode(node1);



    }


    static Node reverseNode(Node node) {
        Node curr = node;
        Node next = null;
        Node prev = null;

        while(curr != null) {
            next = curr.next;//2,3,4
            curr.next = prev;//null,1,2
            prev = curr;//1,2
            curr = next;//2,3
        }
        return prev;
    }
    static void printNode(Node node){
        Node node1 = node;
        while (node1 != null) {
            node1.toString();
            node1 = node1.next;
        }
    }
}


class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }

    void setNode(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        System.out.println("Node value: " + value);
        return null;
    }
}
