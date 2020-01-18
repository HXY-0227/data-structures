# 二叉堆

##  二叉堆的定义

1. 二叉堆是一颗完全二叉树

   完全二叉树：把元素一层一层放，如果每一层都放满，没有空的叶子节点，就是满二叉树，如果有空的叶子节点，那就是完全二叉树。

2. 二叉树中每一个节点的值总是小于父节点的值（最大堆）。如下图所示便是一个最大二叉堆

   <img src="二叉堆.png" alt="二叉堆" style="zoom:67%;" />
## 用数组表示表示堆

   如上二叉堆我们可以用这样一个数组表示，将堆中的元素按顺序依次放入数组中，这样的话，要表示一个节点的父子关系不如定义成树结构，可以用指针方便的表示。但其实我们观察可以发现每一个节点他的父子关系与他在数组中的索引是有一定关系的：

   节点的父元素索引：(index - 1) / 2
   节点的左孩子索引：2 * index + 1
   节点的右孩子索引：2 * index + 2

   <img src="二叉堆的数组表示.png" style="zoom:67%;" />

## 向堆中添加元素

<img src="插入元素.png" alt="插入元素" style="zoom:67%;" />

向二叉堆中插入元素的过程如上如图所示，首先插入80，发现破坏了最大堆的性质，因此将80和父元素交换位置，交换后，80和父元素71相比，需要继续交换位置，直到满足最大堆的性质。这个过程叫元素的`上浮`

代码实现：

```
    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆中元素的上浮
     *
     * @param index 要上浮元素的索引
     */
    public void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo
                (data.get(getParentIndex(index))) > 0) {
            data.swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
    
    /**
     * 交换元素
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }
```



