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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        if(head.next.next==null)
            return head.val==head.next.val;
        ListNode head1=head;
        ListNode middle = middle(head);
        int length = length(head);
        ListNode head2;
        if(length%2 == 0){
            head2 = reverse(middle.next.next);
            middle.next.next=null;
        }else{
            head2 = reverse(middle.next);
        }
        while(head1 != null){
            if(head1.val != head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
        
    }
    public int length(ListNode head){
        int l=0;
        while(head!=null){
            head=head.next;
            l++;
        }
        return l;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode next = head;
        while(next != null){
            ListNode nextNext = next.next;
            next.next=prev;
            prev=next;
            next=nextNext;
        }
        return prev;
    }
    
    public ListNode middle(ListNode head) {
        ListNode slow=head;
        ListNode fast = head.next.next;
        while(fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}

// T -> O(N) + O(N/2) + O(N/2)
// S -> O(1)