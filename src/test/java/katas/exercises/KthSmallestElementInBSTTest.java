package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class KthSmallestElementInBSTTest {

    private KthSmallestElementInBST.TreeNode createSampleTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(3);
        root.right = new KthSmallestElementInBST.TreeNode(6);
        root.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.right = new KthSmallestElementInBST.TreeNode(4);
        return root;
    }

    @Test
    void testKthSmallest_ElementExists() {
        KthSmallestElementInBST.TreeNode root = createSampleTree();
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 2));
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 4));
        assertEquals(6, KthSmallestElementInBST.kthSmallest(root, 5));
    }

    @Test
    void testKthSmallest_SingleNodeTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(10);
        assertEquals(10, KthSmallestElementInBST.kthSmallest(root, 1));
    }

    @Test
    void testKthSmallest_LeftSkewedTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(5);
        root.left = new KthSmallestElementInBST.TreeNode(4);
        root.left.left = new KthSmallestElementInBST.TreeNode(3);
        root.left.left.left = new KthSmallestElementInBST.TreeNode(2);
        root.left.left.left.left = new KthSmallestElementInBST.TreeNode(1);

        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 2));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 4));
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 5));
    }

    @Test
    void testKthSmallest_RightSkewedTree() {
        KthSmallestElementInBST.TreeNode root = new KthSmallestElementInBST.TreeNode(1);
        root.right = new KthSmallestElementInBST.TreeNode(2);
        root.right.right = new KthSmallestElementInBST.TreeNode(3);
        root.right.right.right = new KthSmallestElementInBST.TreeNode(4);
        root.right.right.right.right = new KthSmallestElementInBST.TreeNode(5);

        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 2));
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 3));
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 4));
        assertEquals(5, KthSmallestElementInBST.kthSmallest(root, 5));
    }
}
