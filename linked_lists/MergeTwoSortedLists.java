package linked_lists;

// Time: O(n)
// Space: O(1)
// Intuition: Use a dummy node to start the new list.
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        ListNode<Integer> p1 = list1.head;
        ListNode<Integer> p2 = list2.head;
        ListNode<Integer> dummy = new ListNode<>(null);
        ListNode<Integer> cur = dummy;

        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            cur.next = p1;
            cur = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            cur.next = p2;
            cur = p2;
            p2 = p2.next;
        }

        list1.print(dummy.next);
    }
}
