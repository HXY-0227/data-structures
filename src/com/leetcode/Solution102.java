package com.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Solution102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 非递归算法
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int LevelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < LevelSize; i++) {
                TreeNode node = queue.remove();
                levelList.add(node.val);

                if (null != node.left) {
                    levelQueue.offer(node.left);
                }

                if (null != node.right) {
                    levelQueue.offer(node.right);
                }
            }
            result.add(levelList);

            if (!levelQueue.isEmpty()) {
                queue.addAll(levelQueue);
                levelQueue.clear();
            }

        }

        return result;
    }

    /**
     * 非递归算法优化，官方代码
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderOptimize(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<Integer>());
            int LevelSize = queue.size();
            for (int i = 0; i < LevelSize; i++) {
                TreeNode node = queue.remove();
                result.get(level).add(node.val);

                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return result;
    }

    /**
     * 官方解决方案，1ms
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @param level
     * @param ans
     */
    public static void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
    }

    public static List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);

        TreeNode left = new TreeNode(9);

        TreeNode right = new TreeNode(20);

        tree.left = left;
        tree.right = right;

        levelOrderOptimize(tree);
    }
}
