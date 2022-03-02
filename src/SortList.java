import Utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

public class SortList {
    public static void main(String[] args) {
        int[] num = {4, 2, 1, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int tmp : num) {
            list.add(tmp);
        }
        ListNode head = ListNode.createList(list);
        ListNode.printListNode(head);
        ListNode ansList = sortList(head);
        ListNode.printListNode(ansList);
    }

    public static ListNode sortList(ListNode head) {
        ArrayList<Integer> num = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            num.add(tmp.getVal());
            tmp = tmp.getNext();
        }
        num.sort(Comparator.naturalOrder());
        head = ListNode.createList(num);
        return head;
    }
}
