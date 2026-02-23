package linked_lists;

// Time: O(n)
// Space: O(1)
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linked_list = new LinkedList<>();
        linked_list.add(1);
        linked_list.add(2);
        linked_list.add(3);
        linked_list.add(4);

        ListNode<Integer> head = linked_list.head;
        ListNode<Integer> prev = null;
        ListNode<Integer> cur = head;

        while (cur != null) {
            ListNode<Integer> tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        linked_list.print(prev);
    }
}
