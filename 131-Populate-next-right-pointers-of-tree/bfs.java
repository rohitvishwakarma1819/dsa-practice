/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node n1 = root;
        Node n2 = null;
        Node n3 = null;
        while (n1 != null) {
            Node node = n1;
            if (node.left == null) {
                n1 = n1.next;
                continue;
            }
            if (n2 == null) {
                n2 = node.left;
                n3 = n2;
                n2.next = node.right;
                n2 = n2.next;
            } else {
                n2.next = node.left;
                n2 = n2.next;
                n2.next = node.right;
                n2 = n2.next;
            }
            n1 = n1.next;

            if (node.next == null) {
                n1 = n3;
                n2 = null;
            }
        }
        return root;
    }
}