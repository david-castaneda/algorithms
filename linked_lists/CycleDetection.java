package linked_lists;

// Time: O(n)
// Space: O(1)
// Intuition: Keep tack of a slow and fast pointer. If fast is null a cycle doesn't exist.
// There will be a point when the fast pointer catches up to the slow pointer and they are equal.
public class CycleDetection {

    public static void main(String[] args) {
        LinkedList<Integer> linked_list = new LinkedList<>();
        linked_list.add(1);
        ListNode<Integer> two = new ListNode<>(2);
        linked_list.addNode(two);
        linked_list.add(3);
        linked_list.addNode(two); // cycle

        ListNode<Integer> cur = linked_list.head;
        ListNode<Integer> slow = cur;
        ListNode<Integer> fast = cur;

        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        System.out.printf("Has Cycle? %s", hasCycle);
    }
}
