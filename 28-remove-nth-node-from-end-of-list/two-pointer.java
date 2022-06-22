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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode front = head;
        for(int i=1;i<n;++i)
            front=front.next;
        ListNode back = head;
        ListNode prev =null;
        while(front.next!=null)
        {
            prev=back;
            front=front.next;
            back=back.next;
        }
        if(back==head)
        return head.next;
        prev.next=back.next;
        return head;
    }
}

// T-> O(N)
// S-> O(N)