
/* 
class Node {
    int key;
    Node left;
    Node right;
    public Node(int key) {
        this.key = key;
    }
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class Solution {
    void findPreSuc(Node root, Node pre, Node suc, int key) {
        // Your code goes here
        Node curr = root;
        while (curr) {
            if (curr.key < key) {
                pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        curr = root;
        while (curr) {
            if (curr.key > key) {
                suc = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

    }
};
