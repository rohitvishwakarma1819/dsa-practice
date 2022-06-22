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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1=list1;
        ListNode l2 = list2;
        ListNode ans;
        
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        if(l1.val<l2.val){
            ans = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            ans = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode head = ans;
        while(l1 != null || l2 != null){
            if(l1==null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2==null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                if(l1.val<l2.val){
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            head = head.next;
        }
        
        return ans;
    }
}

// T -> O(N)
// S -> O(N)