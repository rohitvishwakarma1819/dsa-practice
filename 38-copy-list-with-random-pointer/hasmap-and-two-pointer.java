/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node,Node> hmap = new HashMap<>(); 
        
        Node p1 = head;
        Node resultHead = new Node(p1.val);
        Node p2 = resultHead;
        hmap.put(p1,p2);
        if(p1.random != null){
            p2.random = hmap.getOrDefault(p1.random,new Node(p1.random.val));
            hmap.put(p1.random,p2.random);
        }
            
        while(p1.next != null){
            p2.next = hmap.getOrDefault(p1.next,new Node(p1.next.val));
            hmap.put(p1.next,p2.next);
            if(p1.next.random != null){
                p2.next.random = hmap.getOrDefault(p1.next.random,new Node(p1.next.random.val));
                hmap.put(p1.next.random,p2.next.random);
                
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return resultHead;
    }
    
}

// T-> O(N)
// S -> O(N)