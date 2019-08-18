package com;

import com.tree.AVLTree.AVLTree;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileUtil.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Test AVL Tree
            Long startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            Long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }

        System.out.println();
    }
}
