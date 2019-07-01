package com.tree.RBTree;

/**
 * read-black tree
 * @param <AnyType>
 */
public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {

    // 根节点
    private RedBlackNode<AnyType> root;
    // 空节点
    private RedBlackNode<AnyType> nullNode;

    private static final int BLACK = 1;
    private static final int RED = 0;

    /**
     * 构造器
     */
    public RedBlackTree() {
        this.nullNode = new RedBlackNode<>(null);
        this.nullNode.left = nullNode;
        this.nullNode.right = nullNode;
        this.root = new RedBlackNode<>(null);
        this.root.left = nullNode;
        this.root.right = nullNode;
    }

    /**
     * 定义红黑树节点
     * @param <AnyType>
     */
    private static class RedBlackNode<AnyType> {

        public AnyType element;
        public RedBlackNode<AnyType> left;
        public RedBlackNode<AnyType> right;
        public int color;


        public RedBlackNode(AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt) {
            this.element = theElement;
            this.left = lt;
            this.right = rt;
            this.color = RedBlackTree.BLACK;
        }

        public RedBlackNode(AnyType theElement) {
            this(theElement, null, null);
        }
    }

    /**
     * 执行一次或者两次旋转的内部方法
     *
     * @param item
     * @param parent
     * @return
     */
    private RedBlackNode<AnyType> rotate(AnyType item, RedBlackNode<AnyType> parent) {
        return null;
    }
}
