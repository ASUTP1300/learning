package linkedlist;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(6);
        ListNode listNode16 = new ListNode(7);
        ListNode listNode17 = new ListNode(8);


        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;
        listNode17.next = null;


        ListNode copy = listNode11.next;

        ListNode holder = listNode11;

        holder.next = null;

        System.out.println("L21" + holder);
        System.out.println("L11 " + copy);
        System.out.println("L20 " + copy);


        ListNode buff;
        ListNode buff2 = null;




        while (copy != null) {
            //buffer
            buff = copy.next;

            //buffer2
            buff2 = copy;

            buff2.next = holder;

            holder = buff2;

            copy = buff;
//            copy.next = holder;


        }

        System.out.println(holder);





    }


    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }

        }

        ListNode dum = new ListNode();
        ListNode prev = dum;

        while (!pq.isEmpty()) {
            prev.next = pq.poll();
            prev = prev.next;

            if (prev.next != null) {
                pq.add(prev.next);
            }
        }

        return dum.next;
    }


    static void iterateNode(ListNode listNode) {
        int i = 0;
        while (listNode != null) {
            System.out.println("Нода, номер узла " + i++ + " :"
                    + listNode.val);
            listNode = listNode.next;
        }
    }


    public static boolean hasCycle(ListNode node) {
        List<ListNode> lists = new ArrayList<>();
        ListNode current = node;

        while (current != null) {
            if (lists.contains(current)) {
                return true;
            }
            lists.add(current);
            current = current.next;
        }
        return false;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode current = res;
        int dec = 0;
        while (l1 != null && l2 != null) {
            current.next = new ListNode();
            int sum = l1.val + l2.val + dec;
            current.next.val = sum % 10;
            dec = sum / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            current.next = new ListNode();
            int sum = l1.val + dec;
            current.next.val = sum % 10;
            dec = sum / 10;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new ListNode();
            int sum = l2.val + dec;
            current.next.val = sum % 10;
            dec = sum / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (dec != 0) {
            current.next = new ListNode();
            int sum = +dec;
            current.next.val = sum % 10;
        }
        return res.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode current = res;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return res.next;
    }

    public int search(int[] nums, int target) {
        int indexR = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indexR = i;
            }
        }
        if (indexR == 0) {
            return -1;
        }
        return indexR;
    }


    public static ListNode reversList(ListNode head) {
            if(head == null || head.next == null)
                return head;
            ListNode newNode = reversList(head.next);
            head.next.next = head;
            head.next = null;

            LinkedList<Integer> list = new LinkedList<>();

            return newNode;


    }


}

