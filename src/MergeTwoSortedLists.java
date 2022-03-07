import Utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 3};
        int[] list2 = {1, 3, 4};
        ArrayList<Integer> list1Array = new ArrayList<>();
        for (int tmp : list1) {
            list1Array.add(tmp);
        }
        ArrayList<Integer> list2Array = new ArrayList<>();
        for (int tmp : list2) {
            list2Array.add(tmp);
        }
        ListNode head1 = ListNode.createList(list1Array);
        ListNode head2 = ListNode.createList(list2Array);
        ListNode ansHead = mergeTwoLists(head1, head2);
        ListNode.printListNode(ansHead);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> ansArray = new ArrayList<>();
        ListNode flag1 = list1;
        while (flag1 != null) {
            ansArray.add(flag1.getVal());
            flag1 = flag1.getNext();
        }
        ListNode flag2 = list2;
        while (flag2 != null) {
            ansArray.add(flag2.getVal());
            flag2 = flag2.getNext();
        }
        ansArray.sort(Comparator.naturalOrder());
        System.out.println(ansArray);
        return ListNode.createList(ansArray);
    }
}
