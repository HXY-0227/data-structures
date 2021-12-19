package com.tree.trie;

import java.util.*;

/**
 * Trie树：https://gitee.com/hxy-0227/learn-note#https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/树/树结构的演变以及实现/树结构的演变以及实现.md#通过树结构的演变以及实现来辩证的看数据结构
 *
 * @author : HXY
 * @date : 2021-10-16 11:48
 **/
public class Trie {

    private class Node {
        boolean isWord;

        Node[] next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new Node[52];
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("graph");
        words.add("green");
        words.add("error");
        words.add("occurred");
        words.add("grand");

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        boolean graph = trie.isPrefix("graph");
        System.out.println(graph);
    }
}
