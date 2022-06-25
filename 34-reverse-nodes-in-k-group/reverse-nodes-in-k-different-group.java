import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
        return reverseUtil(head,b,0);
	}
    public static Node reverseUtil(Node head, int[] arr, int i){
          if(head == null )
            return null;
        if(i>=arr.length)
            return head;
        if(arr[i]==0)
            return reverseUtil(head,arr,i+1);
        Node first = head;
        Node second = first;
        Node prev=null;
        int k = arr[i];
        int n=k;
        while(n>0 && second != null){
            Node next = second.next;
            second.next=prev;
            prev=second;
            second = next;
            n--;
        }
        if(second != null)
            first.next = reverseUtil(second,arr,i+1);
        return prev;
    }
}




