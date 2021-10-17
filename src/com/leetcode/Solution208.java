package com.leetcode;

/**
 * @author : HXY
 * @date : 2021-10-16 15:51
 **/
public class Solution208 {
    private static class Node {
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

    public Solution208() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return true;
    }
}
