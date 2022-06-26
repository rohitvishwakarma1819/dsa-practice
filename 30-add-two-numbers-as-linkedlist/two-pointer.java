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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans;
        ListNode head;
        int carry=0;
        int sum;
        if(l1 != null && l2 != null){
             sum=l1.val+l2.val;
            ans = new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            l2=l2.next;
        }else if(l1==null){
            ans = new ListNode(l2.val);
            l2=l2.next;
        }else{
            ans=new ListNode(l1.val);
            l1=l1.next;
        }
        head=ans;
        while(l1!=null && l2!=null){
            sum=l1.val+l2.val+carry;
            carry=sum/10;
            head.next=new ListNode(sum%10);
            l1=l1.next;
            l2=l2.next;
            head=head.next;
        }
         while(l1!=null){
            sum=l1.val+carry;
            carry=sum/10;
            head.next=new ListNode(sum%10);
            l1=l1.next;
            head=head.next;
        }
         while(l2!=null){
            sum=l2.val+carry;
            carry=sum/10;
            head.next=new ListNode(sum%10);
            l2=l2.next;
            head=head.next;
             
        }
        if(carry>0)
            head.next=new ListNode(carry);
        return ans;
        
    }
}

// T -> O(N)
// S -> O(1)