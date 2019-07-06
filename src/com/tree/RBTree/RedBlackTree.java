package com.tree.RBTree;

/**
 * read-black tree
 * @param <AnyType>
 */
public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {

    // 根节点
    private RedBlackNode<AnyType> header;
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
        this.header = new RedBlackNode<>(null);
        this.header.left = nullNode;
        this.header.right = nullNode;
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

    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;

    /**
     * 如果一个节点有两个红色的子节点，做颜色的翻转和节点的旋转
     * @param item 正在被插入的节点
     */
    private void handleReorient(AnyType item) {
        // 该节点变为红色，两个孩子节点变为黑色
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        // 颜色改变后如果该节点的父节点也是红色，需要进行旋转操作
        if (parent.color == RED) {
            grand.color = RED;
            //    G.B
            //    / \
            //  P.R   S
            //   \
            //   X.R   大于父节点小于祖父节点，X和P旋转，X和G旋转
            //   / \
            //  B1  B2
            if ((compare(item, grand) < 0) != (compare(item, parent) < 0)) {
                parent = rotate(item, grand);
            }
            //       G.B
            //       / \
            //     P.R   S
            //     /
            //   X.R    小于父节点小于祖父节点，P和G旋转
            //   / \
            //  B   B
            current = rotate(item, great);
            current.color = BLACK;
        }

        header.right.color = BLACK;
    }

    /**
     * 执行一次或者两次旋转的内部方法
     *
     * @param item
     * @param parent
     * @return
     */
    private RedBlackNode<AnyType> rotate(AnyType item, RedBlackNode<AnyType> parent) {
        if (compare(item, parent) < 0) {
            if (compare(item, parent.left) < 0) {
                parent.left = rotateWithLeftChild(parent.left);
            } else {
                parent.left = rotateWithRightChild(parent.left);
            }
            return parent.left;
        } else {
            if (compare(item, parent.right) < 0) {
                parent.right = rotateWithLeftChild(parent.right);
            } else {
                parent.right = rotateWithRightChild(parent.right);
            }
            return parent.right;
        }
    }

    private RedBlackNode<AnyType> rotateWithLeftChild(RedBlackNode<AnyType> node) {
        return null;
    }

    private RedBlackNode<AnyType> rotateWithRightChild(RedBlackNode<AnyType> node) {
        return null;
    }

    /**
     * 判断该元素是否可能为根节点，如果不可能，直接调用compareTo方法。
     * @param item
     * @param node
     * @return
     */
    private final int compare(AnyType item, RedBlackNode<AnyType> node) {
        if (node == header) {
            return 1;
        } else {
            return item.compareTo(node.element);
        }
    }

    public void insert(AnyType item) {
        current = parent = grand = header;
        nullNode.element = item;

        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ? current.left : current.right;

            if (current.left.color == RED && current.right.color == RED) {
                handleReorient(item);
            }
        }

        if (current != nullNode) {
            return;
        }

        current = new RedBlackNode<>(item, nullNode, nullNode);

        if (compare(item, parent) < 0) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        handleReorient(item);
    }
}
