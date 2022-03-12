import java.util.ArrayList;

public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        int[][] listNums = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = createList(listNums);
        printNode(head);
        System.out.println();
        Node ans = copyRandomList(head);
        printNode(ans);
    }

    public static Node copyRandomList(Node head) {
        Node ansHead = null;
        Node last = null;
        Node cur;
        Node flag = head;
        ArrayList<Node> countRandom = new ArrayList<>();
        while (flag != null) {
            countRandom.add(flag);
            if (ansHead == null) {
                ansHead = new Node(flag.val);
                last = ansHead;
            } else {
                cur = new Node(flag.val);
                last.next = cur;
                last = cur;
            }
            flag = flag.next;
        }
        flag = head;
        Node ansFlag = ansHead;
        while (flag != null) {
            int n = countRandom.indexOf(flag.random);
            if (n < 0) {
                ansFlag.random = null;
            } else {
                Node nextFlag = ansHead;
                while (n-- > 0) {
                    nextFlag = nextFlag.next;
                }
                ansFlag.random = nextFlag;
            }
            flag = flag.next;
            ansFlag = ansFlag.next;
        }
        return ansHead;
    }

    public static Node createList(int[][] listNums) {
        Node head = null;
        Node last = null;
        Node cur;
        for (int[] tmp : listNums) {
            if (head == null) {

                head = new Node(tmp[0]);
                last = head;
            } else {
                cur = new Node(tmp[0]);
                last.next = cur;
                last = cur;
            }
        }
        cur = head;
        for (int[] tmp : listNums) {
            int n = tmp[1];
            if (n < 0) {
                cur.random = null;
                cur = cur.next;
                continue;
            }
            Node nextFlag = head;
            while (n-- > 0) {
                nextFlag = nextFlag.next;
            }
            cur.random = nextFlag;
            cur = cur.next;
        }
        return head;
    }

    public static void printNode(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur + " " + cur.val + " " + cur.next + " " + cur.random);
            cur = cur.next;
        }
    }
}


