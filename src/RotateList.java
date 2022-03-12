import Utils.ListNode;

import java.util.ArrayList;

public class RotateList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 0;

        ArrayList<Integer> numsArray = new ArrayList<>();
        for (int tmp : nums) {
            numsArray.add(tmp);
        }
        ListNode head = ListNode.createList(numsArray);
        ListNode ansHead = rotateRight(head, k);
        ListNode.printListNode(ansHead);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode countFlag = head;
        int count = 0;
        while (countFlag != null) {
            countFlag = countFlag.getNext();
            count++;
        }
        int realK = count == 0 ? 0 : k % count;
        if (realK == 0) {
            return head;
        }

        ListNode flag1 = head;
        ListNode flag2 = head;
        while (realK-- > 0) {
            if (flag1 == null) {
                flag1 = head;
            }
            flag1 = flag1.getNext();
        }
        while (flag1.getNext() != null) {
            flag1 = flag1.getNext();
            flag2 = flag2.getNext();
        }
        ListNode newHead = flag2.getNext();
        flag2.setNext(null);
        flag1.setNext(head);
        return newHead;
    }
}
