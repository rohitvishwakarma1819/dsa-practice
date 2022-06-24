/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength=listSize(headA);
        int bLength=listSize(headB);
        ListNode big = aLength > bLength ? headA : headB;
        ListNode small = headB;
        if(big==headB)
            small=headA;
        int bl = Math.max(aLength,bLength);
        int sl =  Math.min(aLength,bLength);
        while(bl != sl){
            big = big.next;
            bl--;
        }
        ListNode intersect = null;
        while(big!=null){
            if(big == small){
                intersect = big;
                break;
            }
            big = big.next;
            small = small.next;
        }
        
        return intersect;
        
    }
    
    public int listSize(ListNode node){
        int size=0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }
}

// T-> O(N)
// S-> O(1)