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
        HashMap<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            Node clonedNode = clone(currNode, map);
            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    stack.push(neighbor);
                }
                clonedNode.neighbors.add(clone(neighbor, map));

            }
        }

        return map.get(node);
    }

    public Node clone(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);
        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);
        return clonedNode;
    }
}

// T -> O(N)
// S -> O(H)