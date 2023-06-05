import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the TreeNode class structure
 * 
 * class TreeNode<T>
 * {
 * public:
 * T data;
 * TreeNode<T> left;
 * TreeNode<T> right;
 * 
 * TreeNode(T data)
 * {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * };
 * 
 ************************************************************/

public class Solution {

    public static int findCeil(TreeNode<Integer> root, int X) {

        // Write your code here
        int num = -1;
        while (root != null) {
            if (root.data >= X) {
                num = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return num;
    }
}
