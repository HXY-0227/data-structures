# AVL树
## 定义
+ AVL树本质上还是一颗二叉搜索树，其特性是对于任意一个节点，左子树和右子树的高度差不能超过1，所以AVL树也称为平衡二叉树
+ 平衡二叉树的高度和节点数量之间的关系也是O(logN)
+ 平衡因子 `左右子树的高度差`
## 为什么需要AVL树
当我们顺序将一组从小到大的数据（1,2,3,4,5）插入到一颗空的二叉搜索树，那么你可以发现这个时候二叉搜索树已经完全退化成为了一个链表，他的各操作的时间复杂度也将从O(logN)变成为线性的O(N)。如下图所示：

## AVL树的自平衡机制
### 什么时候会破坏平衡
当插入一个节点后，会更新新节点对应的父亲节点以及祖先节点的平衡因子，导致向上的节点的左右子树高度差超过1。所以当插入一个节点后，我们应该沿着新节点向上维护AVL树的平衡性。

### 需要维护平衡的四种情况
#### AVL树的右旋转

以下情况中，当插入节点2到树中时候，根据二叉搜索树的性质，会将节点2插入到节点6的左边，从而打破本来的平衡性，使得节点9的平衡因子大于1.这个时候需要维护节点9的平衡性，这种操作称为右旋转。首先将节点6的右子树T2和节点6分离，然后将节点9下沉，挂载到节点6的右子树上，最后将节点6原来的右子树T2挂载到节点9的左子树上，此时节点9达到平衡，并且依然保持二叉搜索树的基本性质。
![右旋转](右旋转.PNG)
代码实现如下：
```
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    /**
     * 右旋转
     * @param node
     * @return
     */
    private Node rightRotate(Node y) {
        // 使X和T3脱离
        Node x = y.left;
        Node T3 = x.right;

        // 旋转过程
        x.right = y;
        y.left = T3;

        // 更新高度
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;
    }
```
#### AVL树的左旋转
代码实现如下
```
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    /**
     * 左旋转
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        // 使x和T2脱离
        Node x = y.right;
        Node T2 = x.left;

        // 左旋转过程
        x.left = y;
        y.right = T2;

        // 更新高度
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;
    }
```