class Solution {
    public ListNode rotateRight(ListNode head, int k) {
     
        if(head == null || k ==0) return head;
        
        int length=1;
        ListNode start = head;
        ListNode last=head;
        while(last.next!=null)
        {
            length++;
            last=last.next;
        }
        int actualRotations = k%length;
        if(actualRotations ==0)
            return head;
        for(int i=0;i<(length-actualRotations)-1;++i){
            start = start.next;
        }
        ListNode newHead = start.next;
        last.next=head;
        start.next = null;

     
        return newHead;
    }
}

// T -> O(N) + O(N-K)
// S -> O(1)