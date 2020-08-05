package com.leet_code;

public class LC_208_Implement_Trie {
    class TrieNode {
        public boolean termination;
        public TrieNode[] children = new TrieNode[26];
    }

    class Trie {
        public TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode current = root;
            for (Character character : word.toCharArray()) {
                int offset = character - 'a';
                if (current.children[offset] == null) {
                    current.children[offset] = new TrieNode();
                }
                current = current.children[offset];
            }
            current.termination = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode current = root;
            for (Character character : word.toCharArray()) {
                int offset = character - 'a';
                if (current.children[offset] != null) {
                    current = current.children[offset];
                } else {
                    return false;
                }
            }
            return current.termination;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (Character character : prefix.toCharArray()) {
                int offset = character - 'a';
                if (current.children[offset] != null) {
                    current = current.children[offset];
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
