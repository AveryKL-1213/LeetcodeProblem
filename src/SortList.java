import java.util.ArrayList;
import java.util.Comparator;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortList {
    public static void main(String[] args) {
        int[] num = {4, 2, 1, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int tmp : num) {
            list.add(tmp);
        }
        ListNode head = createList(list);
        printListNode(head);
        ListNode ansList = sortList(head);
        printListNode(ansList);
    }

    public static ListNode sortList(ListNode head) {
        ArrayList<Integer> num = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            num.add(tmp.val);
            tmp = tmp.next;
        }
        num.sort(Comparator.naturalOrder());
        head = createList(num);
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode flag = head;
        while (flag != null) {
            System.out.print(flag.val + " ");
            flag = flag.next;
        }
        System.out.println();
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
                flag.next = tmpNode;
            }
            flag = tmpNode;
        }
        return head;
    }
}
