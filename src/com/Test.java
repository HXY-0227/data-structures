package com;

import com.tree.BST.BST;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] arr = new Integer[] {16, 8, 22, 1, 9, 17, 30};
        for (int i = 0; i < arr.length; i ++) {
            bst.add(arr[i]);
        }
        //bst.remove(1);
        System.out.println(bst.minNum());
    }
}
