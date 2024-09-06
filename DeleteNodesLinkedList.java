import java.util.HashSet;
import java.util.Set;

//Leetcode Problem 3217. Delete Nodes From Linked List Present in Array
public class DeleteNodesLinkedList {
    public ListNode deleteNodes(ListNode head, int[] nums) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        for (int node : nums) {
            set.add(node);
        }
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        DeleteNodesLinkedList deleteNodesLinkedList = new DeleteNodesLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int[] nums = {1, 2, 3};
        ListNode result = deleteNodesLinkedList.deleteNodes(head, nums);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
