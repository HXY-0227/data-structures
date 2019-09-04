package com;

import com.tree.AVLTree.AVLTree;
import com.tree.BST.BST;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileUtil.readFile("src/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            // Test AVL Tree
            Long startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words) {
                avl.contains(word);
            }

            Long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");

            // Test BST
            startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words) {
                bst.contains(word);
            }
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");

        }

        System.out.println();
    }
}
