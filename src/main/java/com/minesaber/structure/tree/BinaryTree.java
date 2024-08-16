package com.minesaber.structure.tree;

/**
 * @author Minesaber
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    void preOrder() {
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode curNode) {
        if (curNode == null) return;
        System.out.print(curNode.value + " ");
        preOrder(curNode.left);
        preOrder(curNode.right);
    }

    void inOrder() {
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode curNode) {
        if (curNode == null) return;
        inOrder(curNode.left);
        System.out.print(curNode.value + " ");
        inOrder(curNode.right);
    }

    void postOrder() {
        System.out.print("后序遍历：");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode curNode) {
        if (curNode == null) return;
        postOrder(curNode.left);
        postOrder(curNode.right);
        System.out.print(curNode.value + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
