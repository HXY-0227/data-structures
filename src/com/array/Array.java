package com.array;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity 数组的初始容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数， 默认初始容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的长度
     * @return 数组的长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组中添加元素
     * @param e 添加的元素
     */
    public void add(E e) {
        if (size == data.length) {
            // 扩容
            resize(2 * data.length);
        }

        data[size] = e;
        size ++;
    }

    /**
     * 往数组中任意地方添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size -1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size ++;

    }

    /**
     * SET
     * @param index 索引
     * @param e 元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = e;
    }

    /**
     * GET
     * @param index 索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return data[index];
    }

    /**
     * 是否包含某元素
     * @param e 查询的元素
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查看数组中元素的索引
     * @param e 查询的元素
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定索引的元素
     * @param index 索引
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E removeData = data[index];

        for (int i = index + 1 ; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        // 释放内存  元素个数变成总容量的1/4才缩容，解决复杂度震荡的问题。
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return removeData;
    }

    /**
     * 删除指定元素
     * @param e 待删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
        }
     }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {
        Array arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.add(i + "hxy");
        }
        System.out.println(arr);
        arr.add("love");
        System.out.println(arr);
    }
}

