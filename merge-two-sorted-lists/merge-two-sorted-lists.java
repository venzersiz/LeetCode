/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode();

            if (l1 == null && l2 == null) {
                return null;
            } else if (l1 == null) {
                addLast(head, l2);
                return head.next;
            } else if (l2 == null) {
                addLast(head, l1);
                return head.next;
            }

            ListNode current = head;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = new ListNode(l1.val);
                    current = current.next;

                    l1 = l1.next;
                } else if (l1.val > l2.val) {
                    current.next = new ListNode(l2.val);
                    current = current.next;

                    l2 = l2.next;
                } else {
                    current.next = new ListNode(l1.val);
                    current = current.next;
                    current.next = new ListNode(l1.val);
                    current = current.next;

                    l1 = l1.next;
                    l2 = l2.next;
                }
            }

            if (l1 == null && l2 != null) {
                addLast(current, l2);
            } else if (l2 == null && l1 != null) {
                addLast(current, l1);
            }

            return head.next;
    }
    
    private void addLast(ListNode source, ListNode target) {

        while (target != null) {
            source.next = target;
            source = source.next;

            target = target.next;
        }
    }
}