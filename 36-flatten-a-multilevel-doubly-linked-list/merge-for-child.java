import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
	public static Node flattenLinkedList(Node start) {
		if(start == null)
            return null;
        Node second  = flattenLinkedList(start.next);
        if(second ==null)
            return start;
        
        Node head=start;
        Node prev=head;
        while(head != null && second != null){
            if(head.data<second.data){
                prev=head;
                head=head.child;
            }else{
                Node child1 = head;
                Node child2 = second.child;
                prev.child = second;
                second.child=head;
                prev=second;
                second=child2;

                head=child1;
            }
        }
       if(second!=null)
           prev.child=second;
        start.next=null;
        return start;
        
	}
}

