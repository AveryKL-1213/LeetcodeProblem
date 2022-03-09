import Utils.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numString = reader.readLine();
        String[] nums = numString.split(" ");
        ArrayList<Integer> numsArray = new ArrayList<>();
        for (String tmp : nums) {
            numsArray.add(Integer.parseInt(tmp));
        }
        ListNode head = ListNode.createList(numsArray);
        ListNode ansHead = deleteDuplicates(head);
        ListNode.printListNode(ansHead);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ansHead = new ListNode();
        ansHead.setNext(head);
        ListNode ansCur = ansHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.getNext() != null && cur.getVal() == cur.getNext().getVal()) {
                while (cur.getNext() != null && cur.getVal() == cur.getNext().getVal()) {
                    cur = cur.getNext();
                }
                ansCur.setNext(cur.getNext());
            } else {
                ansCur = cur;
            }
            cur = cur.getNext();
        }
        return ansHead.getNext();
    }
}
