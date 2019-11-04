package se.veldes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LowestCommonAnc {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // The mapping we're going to use for constructing a tree.
        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
        // child is 2.
        TreeNode head1;
        TreeNode head2;
        TreeNode head3;

        {
            HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
            int[] childrenA = {1, 2};
            int[] childrenB = {3, 4};
            int[] childrenC = {5, 6};
            mapping1.put(0, childrenA);
            mapping1.put(1, childrenB);
            mapping1.put(2, childrenC);

            head1 = createTree(mapping1, 0);

            // This tree is:
            // head1 = 0        j 1 k 5
            //        / \
            //       1   2
            //      /\   /\
            //     3  4 5  6
        }

        {
            HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
            int[] childrenD = {1, 4};
            int[] childrenE = {3, 8};
            int[] childrenF = {9, 2};
            int[] childrenG = {6, 7};
            mapping2.put(5, childrenD);
            mapping2.put(1, childrenE);
            mapping2.put(4, childrenF);
            mapping2.put(3, childrenG);

            head2 = createTree(mapping2, 5);
            // This tree is:
            //  head2 = 5
            //        /   \
            //       1     4
            //      /\    / \
            //     3  8  9  2
            //    /\
            //   6  7
        }

        {
            HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
            int[] childrenD = {4, 8};
            int[] childrenE = {2, 5};
            int[] childrenF = {7, 9};
            int[] childrenG = {1, 3};
            mapping2.put(6, childrenD);
            mapping2.put(4, childrenE);
            mapping2.put(8, childrenF);
            mapping2.put(2, childrenG);

            head3 = createTree(mapping2, 6);
            // This tree is:
            //  head3 = 6
            //        /   \
            //       4     8
            //      /\    / \
            //     2  5  7  9
            //    /\
            //   1  3
        }


        assert isBinarySearchTree(head3, null, null);
        assert lca(head3, 3, 1).value == 2;
        assert lca(head3, 9, 3).value == 6;
        assert lca(head3, 9, 7).value == 8;
        assert lca(head3, 9, 8).value == 8;

        {

            assert lca(head1, 1, 5).value == 0;
            assert lca(head1, 3, 1).value == 1;
            assert lca(head1, 1, 4).value == 1;
            assert lca(head1, 0, 5) != null;
            assert lca(head1, 0, 5).value == 0;
            assert lca(head2, 4, 7).value == 5;
            assert lca(head2, 3, 3).value == 3;
            assert lca(head2, 8, 7).value == 1;
            assert lca(head2, 3, 0) == null;
        }
    }

    public static TreeNode lca(TreeNode root, int j, int k) {
        if (isBinarySearchTree(root, null, null))
            return lcaBinarySearch(root, j, k);
        else {
            return lcaKaos(root, j, k);
        }

    }

    public static TreeNode lcaKaos(TreeNode root, int j, int k) {

        // Search for path root -> j and root -k
        LinkedList<TreeNode> pathToJ = new LinkedList<>();
        LinkedList<TreeNode> pathToK = new LinkedList<>();
        getPathTo(root, null, j, pathToJ);
        getPathTo(root, null, k, pathToK);

        if (pathToJ.size() == 0 || pathToK.size() == 0)
            return null;

        TreeNode lcaRoot = root;

        for (int i = 0; i < pathToJ.size() && i < pathToK.size(); i++) {
            if (pathToJ.get(i) != pathToK.get(i))
                return lcaRoot;
            lcaRoot = pathToJ.get(i);

        }
        return lcaRoot;

    }

    private static TreeNode getPathTo(TreeNode node, TreeNode parent, int val, LinkedList<TreeNode> path) {

        if (node.value == val) {
            if (parent == null)
                path.addFirst(node);
            return node;
        }

        if (node.left != null) {
            TreeNode step = getPathTo(node.left, node, val, path);
            if (step != null) {
                path.addFirst(node.left);
                return node;
            }
        }
        if (node.right != null) {
            TreeNode step = getPathTo(node.right, node, val, path);
            if (step != null) {
                path.addFirst(node.right);
                return node;
            }
        }
        return null;
    }


    private static void setAllNotNullToMe(TreeNode root, Map<Integer, TreeNode> result) {
        for (Integer s : result.keySet()) {
            if (result.get(s) != null)
                result.put(s, root);
        }
    }

    private static boolean isComplete(Map<Integer, TreeNode> result) {
        for (Integer s : result.keySet()) {
            if (result.get(s) == null)
                return false;
        }
        return true;
    }


    // Implement your function below.
    public static TreeNode lcaBinarySearch(TreeNode root, int j, int k) {

        // Om j och k finns på olika sidor är nuvarande nod lca
        int searchDirJ = getBinarySearchDirection(root, j);
        int searchDirK = getBinarySearchDirection(root, k);

        if (Math.abs(searchDirJ - searchDirK) == 2)
            return root;
        else if (searchDirJ == 0 || searchDirK == 0) {
            return root;
        } else if (searchDirJ == -1 && searchDirK == -1)
            return lca(root.left, j, k);
        else {// if (searchDirJ == 1 && searchDirK == 1)
            assert searchDirJ == 1 && searchDirK == 1;
            return lca(root.right, j, k);
        }
    }

    /**
     * @param root
     * @param val
     * @return -1 if look in left, 1 if look in right
     */
    public static int getBinarySearchDirection(TreeNode root, int val) {


        if (val > root.value)
            return 1; // val is bigger than root, search right
        else if (val < root.value)
            return -1; // val is smaller than root, search left
        return 0; // val is current node
    }


    // A function for creating a tree.
    // Input:
    // - mapping: a node-to-node mapping that shows how the tree should be constructed
    // - headValue: the value that will be used for the head ndoe
    // Output:
    // - The head node of the resulting tree
    public static TreeNode createTree(HashMap<Integer, int[]> mapping, int headValue) {
        TreeNode head = new TreeNode(headValue, null, null);
        HashMap<Integer, TreeNode> nodes = new HashMap<Integer, TreeNode>();
        nodes.put(headValue, head);
        for (Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            TreeNode leftChild = new TreeNode(value[0], null, null);
            TreeNode rightChild = new TreeNode(value[1], null, null);
            nodes.put(value[0], leftChild);
            nodes.put(value[1], rightChild);
        }
        for (Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            nodes.get(key).left = nodes.get(value[0]);
            nodes.get(key).right = nodes.get(value[1]);
        }
        return head;
    }

    private static boolean isBinarySearchTree(TreeNode node, Integer lowLimit, Integer highLimit) {

        if (lowLimit != null && node.value < lowLimit) // !(
            return false;
        if (highLimit != null && highLimit < node.value) // !(node.value > lowlimit)
            return false;

        boolean leftIsBst = true;
        boolean rightIsBst = true;

        if (node.left != null) {
            leftIsBst = isBinarySearchTree(node.left, lowLimit, node.value);
        }
        if (leftIsBst && node.right != null) {
            rightIsBst = isBinarySearchTree(node.right, node.value, highLimit);
        }

        return leftIsBst && rightIsBst;

    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // The string representation of this node.
        // Will be used for testing.
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
