import Utils.ListNode;

import java.util.ArrayList;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        int[] l1 = {5};
        int[] l2 = {5};
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int tmp : l1) {
            list1.add(tmp);
        }
        for (int tmp : l2) {
            list2.add(tmp);
        }
        ListNode l1Head = ListNode.createList(list1);
        ListNode l2Head = ListNode.createList(list2);
        ListNode ansHead = addTwoNumbers(l1Head, l2Head);
        ListNode.printListNode(l1Head);
        ListNode.printListNode(l2Head);
        ListNode.printListNode(ansHead);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revers1 = getRevers(l1);
        ListNode revers2 = getRevers(l2);
        ListNode flag1 = revers1;
        ListNode flag2 = revers2;
        ListNode ans = null;
        int add = 0;
        while (flag1 != null || flag2 != null || add != 0) {
            int l1Add = flag1 != null ? flag1.getVal() : 0;
            int l2Add = flag2 != null ? flag2.getVal() : 0;
            int tmp = l1Add + l2Add + add;
            add = tmp / 10;
            tmp = tmp % 10;
            ListNode tmpAns = ans;
            ans = new ListNode(tmp);
            ans.setNext(tmpAns);
            flag1 = flag1 != null ? flag1.getNext() : null;
            flag2 = flag2 != null ? flag2.getNext() : null;
        }
        return ans;
    }

    public static ListNode getRevers(ListNode head) {
        ListNode flag = head;
        ListNode revers = null;
        while (flag != null) {
            ListNode tmpRevers = revers;
            revers = new ListNode(flag.getVal());
            revers.setNext(tmpRevers);
            flag = flag.getNext();
        }
        return revers;
    }
}
