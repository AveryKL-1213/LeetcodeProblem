import Utils.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LinkedListCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] numsString = line.split(" ");
        line = reader.readLine();
        int pos = Integer.parseInt(line);
        reader.close();

        ArrayList<Integer> numsArray = new ArrayList<>();
        for (String tmp : numsString) {
            numsArray.add(Integer.parseInt(tmp));
        }
        ListNode head = ListNode.createList(numsArray);
        ListNode cyclePos = null;
        if (pos >= 0) {
            cyclePos = head;
        }
        for (int i = 0; i < pos; i++) {
            cyclePos = cyclePos.getNext();
        }
        ListNode tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(cyclePos);

        ListNode.printListNodeInfo(head);
        boolean ans = hasCycle(head);
        System.out.println(ans);
    }

    public static boolean hasCycle(ListNode head) {
//        ListNode flag = head;
//        ArrayList<ListNode> listNodeArrayList = new ArrayList<>();
//        while (flag != null) {
//            if (listNodeArrayList.contains(flag)) {
//                return true;
//            }
//            listNodeArrayList.add(flag);
//            flag = flag.getNext();
//        }
//        return false;

        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
