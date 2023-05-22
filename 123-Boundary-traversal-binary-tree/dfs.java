import java.util.*;
import java.io.*;
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }
				2
			1		3
		4		5

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList();
        ans.add(root.data);
        ArrayList<Integer> list = new ArrayList<>();
        leftView(root.left, list);
        ans.addAll(list);
        list = new ArrayList();
        bottomView(root.left, list);
        ans.addAll(list);
        list = new ArrayList();
        bottomView(root.right, list);
        ans.addAll(list);
        list = new ArrayList();
        rightView(root.right, list);
        ans.addAll(list);
        return ans;
    }

    public static void leftView(TreeNode root, ArrayList<Integer> left) {
        if (root == null)
            return;
        if (root.left != null) {
            left.add(root.data);
            leftView(root.left, left);
        } else if (root.right != null) {
            left.add(root.data);
            leftView(root.right, left);
        }
    }

    public static void rightView(TreeNode root, ArrayList<Integer> right) {
        if (root == null)
            return;
        if (root.right != null) {
            rightView(root.right, right);
            right.add(root.data);
        } else if (root.left != null) {
            rightView(root.left, right);
            right.add(root.data);
        }
    }

    public static void bottomView(TreeNode root, ArrayList<Integer> bottom) {
        if (root == null)
            return;
        bottomView(root.left, bottom);
        if (root.left == null && root.right == null) {
            bottom.add(root.data);
        }
        bottomView(root.right, bottom);
    }
}