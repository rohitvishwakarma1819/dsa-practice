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
        int length=0;
        ListNode l = head;
        while(l!=null){
            length++;
            l=l.next;
            }
        ListNode ans = head;
        ListNode second = head;
        ListNode start = head;
        ListNode prev = null;
        ListNode last=null;
        int groups = length/k;
        
        for(int i=0;i<groups;++i){
            ListNode curLast = start;
            prev=null;
            for(int j=0;j<k;++j){
                ListNode next = second.next;
                second.next=prev;
                prev=second;
                second = next;
            }
            if(i==0)
                ans=prev;
            if(last!=null)
                last.next=prev;
            last=curLast;
            start=second;
            
        }
        last.next=second;
        return ans;


    }
}
// T -> O(N)
// S -> O(1)