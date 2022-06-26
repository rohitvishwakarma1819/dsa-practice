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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode first = head;
        ListNode second = first;
        ListNode prev=null;
        int n=k;
        while(n>0 && second != null){
            ListNode next = second.next;
            second.next=prev;
            prev=second;
            second = next;
            n--;
        }
        if(n!=0){
            return reverseKGroup(prev,k-n);
        }
        if(second != null)
            first.next = reverseKGroup(second,k);
        return prev;
    }
}

// T -> O(N+k)
// S -> O(N) (stack frames)