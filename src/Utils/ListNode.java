package Utils;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        val = 0;
        next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode createList(ArrayList<Integer> list) {
        if (list == null) return null;
        ListNode head = null;
        ListNode flag = null;
        for (int tmp : list) {
            ListNode tmpNode = new ListNode(tmp);
            if (head == null) {
                head = tmpNode;
            } else {
                flag.setNext(tmpNode);
            }
            flag = tmpNode;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode flag = head;
        while (flag != null) {
            System.out.print(flag.getVal() + " ");
            flag = flag.getNext();
        }
        System.out.println();
    }
}
