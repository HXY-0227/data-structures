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

## 从堆中删除元素

<img src="下沉操作.png" alt="下沉操作" style="zoom:67%;" />

删除元素的过程如图所示：首先删除堆顶元素，然后将最后一个元素挪到堆顶，这个时候破坏了堆的性质，就开始执行下沉操作，让堆顶元素和孩子比较，将较大的孩子上移，堆顶元素下沉，直到符合堆的条件为止。

```
    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E maxItem = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return maxItem;
    }

    /**
     * 堆中元素的下沉
     *
     * @param index
     */
    private void siftDown(int index) {
        int childIndex = 0;
        while (getLeftChildIndex(index) < data.getSize()) {
            childIndex = getLeftChildIndex(index);
            // 找到两个孩子中最大的节点
            if (childIndex + 1 < data.getSize() &&
                    data.get(childIndex + 1).compareTo(data.get(childIndex)) > 0) {
                childIndex = getRightChildIndex(index);
            }
            if (data.get(index).compareTo(data.get(childIndex)) >= 0) {
                break;
            }
            data.swap(index, childIndex);
            index = childIndex;
        }
    }
```

## leetcode 347题

给定一个非空的整数数组，返回其中出现频率前 k高的元素。

```
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
```

解题思路参考leetcode官网

```
package com.leetcode;

import java.util.*;

/**
 * leetcode347 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Solution347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 第一步，建立一个key：元素值----value：出现频率的哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        // 维护一个大小为k的最小堆，每次新加元素和堆顶元素进行比较，如果新元素的频率大于堆顶元素，则将堆顶元素
        // 替换为新加入的元素，
        for (int key: map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        // 输出堆
        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,2,3,3,3};
//        topKFrequent(arr,2);
        System.out.println(topKFrequent(arr, 2));
    }
}

```

