/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = checkCycle(head);
        if(fast == null)
            return null;
        ListNode entry = head;
        while(entry != fast) {
            entry = entry.next;
            fast = fast.next;
        }
        return entry;
    }
    public ListNode checkCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
           
            slow=slow.next;
            fast=fast.next.next;
             if(slow == fast)
                return slow;
        }
        return null;
    }
}
// T -> O(N)
// S -> O(1)

// The intuition behind algo is that:
// For loop detection -> After slow pointer enters the loop the distance between fast and slow reduces
//  so there will be point that the distance is zero means they intersect

// For finding start of loop ->
// let A -> distance from starting node to loop starting node
// let B -> distance from loop starting node to intersecting point
// let C -> distance of loop

// Now since fast pointer takes 2 steps and slow takes one then its obvious that
// distance travelled by fast pointer  = 2 * (distance travelled by slow pointer)
// or
// 2 * (A + B + yC) = A + B + nC 
// 2A + 2B 2yC  = A + B + nC
// A + B = (n-2y)C
// let n-2y = k
// A + B = kC
// if(k==1) => A + B = C => A = C - B
// means the distance between intersecting point and start of linked list is A (the distance from starting node to loop starting node)
// means wow
// if we start from start of ll and from intersecting point then after travelling A distance we will surely meet at loop starting point
// wow
// wow
// wow