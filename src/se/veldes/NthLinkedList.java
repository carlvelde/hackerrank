package se.veldes;

import java.util.HashMap;
import java.util.Map;

public class NthLinkedList {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        assert nthFromLast(head, 5).value == 5 : "Excpected 5 was " + nthFromLast(head, 5).value;
        assert nthFromLast(head2, 2).value == 3;

        assert nthFromLast(head2, 4).value == 1;

        assert nthFromLast(head2, 5) == null;
        assert nthFromLast(null, 1) == null;


        // nthFromLast(null, 1) should return null.
    }


    // Implement your function below.
    public static Node nthFromLastHashMap(Node head, int n) {
        if (head == null)
            return null;

        Map<Integer, Node> index = new HashMap<>();
        int count = 0;
        index.put(count, head);


        // Go to bottom and index
        Node child = head.child;
        while (child != null) {
            count++;
            index.put(count, child);
            child = child.child;
        }
        // At bottom and indexed
        return index.get(count - n + 1);

    }

    public static Node nthFromLast(Node head, int n) {
        if (head == null)
            return null;

        Node left = head;
        Node right = head;

        // Move right pointer n steps
        for (int i = 0; i < n; i++) {
            if (right == null)
                return null;
            right = right.child;
        }

        // Move both pointers until right is at end
        while (right != null) {
            left = left.child;
            right = right.child;
        }
        // Return left pointer since it is n steps from right pointer that is at the end

        return left;

    }

    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.value);
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }

    private final static class Node {
        int value;
        Node child;

        Node(int value, Node child) {
            this.value = value;
            this.child = child;
        }

        // The string representation of this node.
        // Will be used for testing.
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
