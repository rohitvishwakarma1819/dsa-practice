class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> arr = new ArrayList<>();
      solve(root, arr, 0);
      return arr;
    }
    
    public void solve(Node root, ArrayList<Integer> arr, int height) {
        if(root == null) return;
        if(height >= arr.size()) arr.add(root.data);
        solve(root.left, arr, height + 1);
        solve(root.right, arr, height + 1);
    }
}