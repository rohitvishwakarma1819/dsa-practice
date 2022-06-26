// Data is in below form
//  1---2---3---4---5---6--NULL
//          |
//          7---8---9---10--NULL
//              |
//              11--12--NULL

class Solution {
    public Node flatten(Node head) {
        
        if(head == null)
            return null;
        flattenUtil(head);
        return head;
    }
    public Node flattenUtil(Node head) {
        if(head.next==null && head.child == null)
            return head;
        if(head.next == null){
            head.next = head.child;
            head.next.prev=head;
            head.child = null;
            return flattenUtil(head.next);
        }
        if(head.child==null){
            return flattenUtil(head.next);
        }
            Node next = head.next;
            head.next=head.child;
            head.next.prev = head;
            Node last = flattenUtil(head.child);
            head.child = null;
            last.next = next;
            last.next.prev=last;
            return flattenUtil(next);
        
    }
}