package linked_lists;

class ListNode<T> {

    T value;
    ListNode<T> next;
    ListNode<T> prev;

    public ListNode(T value) {
        this.value = value;
    }

}

class LinkedList<T> {

    ListNode<T> head = null;
    ListNode<T> tail = null;

    void add(T value) {
        ListNode<T> node = new ListNode<>(value);
        if (head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail.next.prev = this.tail;
        this.tail = node;
    }

    ListNode<T> find(T value) {
        ListNode<T> curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return curr;
            }
            curr = curr.next;
        }
        return curr;
    }

    void delete(T value) {
        ListNode<T> node = find(value);
        if (node == null) {
            return;
        }
        if (node.prev == null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            node.prev.next = node.next;
        }
    }

    void print(ListNode<T> head) {
        ListNode<T> curr = head;
        if (curr == null) {
            System.out.println("[]");
        }
        while (curr != null) {
            if (curr.next == null) {
                System.out.printf("%s\n", curr.value);
            } else {
                System.out.printf("%s -> ", curr.value);
            }
            curr = curr.next;
        }
    }

}

public class LinkedListTemplate {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        System.out.println("Node: " + ll.find(3));
        System.out.println("Node: " + ll.find(5));
        ll.print(ll.head);
        ll.delete(1);
        ll.print(ll.head);
        ll.delete(2);
        ll.print(ll.head);
        ll.delete(3);
        ll.print(ll.head);
        ll.delete(4);
        ll.print(ll.head);
        ll.add(10);
        ll.add(11);
        ll.add(12);
        ll.add(13);
        ll.add(14);
        ll.add(15);
        ll.print(ll.head);
        ll.delete(14);
        ll.print(ll.head);
    }
}
