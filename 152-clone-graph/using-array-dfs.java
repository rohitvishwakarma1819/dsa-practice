/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node[] copyGraph = new Node[101];
        Node root = new Node(node.val);
        clone(node, root, copyGraph);
        return root;
    }

    public void clone(Node node, Node copy, Node[] copyGraph) {
        copyGraph[copy.val] = copy;
        for (Node neighbor : node.neighbors) {
            if (copyGraph[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                copy.neighbors.add(newNode);
                clone(neighbor, newNode, copyGraph);
            } else {
                copy.neighbors.add(copyGraph[neighbor.val]);
            }
        }
    }
}

// T -> O(N)
// S -> O(H)