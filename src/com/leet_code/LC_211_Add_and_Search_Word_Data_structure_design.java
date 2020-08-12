package com.leet_code;

public class LC_211_Add_and_Search_Word_Data_structure_design {
    public static void main(String[] args) {
        final WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad") + " must be false");
        System.out.println(wordDictionary.search("bad") + " must be true");
        System.out.println(wordDictionary.search(".ad") + " must be true");
        System.out.println(wordDictionary.search("b..") + " must be true");
    }

    public static class TrieNode {
        public boolean termination;
        public TrieNode[] children = new TrieNode[26];
    }

    public static class WordDictionary {

        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public WordDictionary() { }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == "") { return; }
            TrieNode current = root;
            for (Character character : word.toCharArray()) {
                    final int offset = character - 'a';
                    if (current.children[offset] == null) {
                        current.children[offset] = new TrieNode();
                    }
                    current = current.children[offset];
            }
            current.termination = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            TrieNode current = root;
            return helper(word, 0, current);
        }

        public boolean helper(String word, int index, TrieNode current) {
            if (current == null) {
                return false;
            }

            if (index >= word.length()) { return current.termination; }

            final char[] charArray = word.toCharArray();
            final char character = charArray[index];
            final int triIdx = character - 'a';
            boolean res;
            if (character == '.') {
                for (int i = 0; i < 26; i++) {
                    res = helper(word, index + 1, current.children[i]);
                    if(res) {
                        return true;
                    }
                }
            } else {
                res = helper(word, index + 1, current.children[triIdx]);
                if(res) {
                    return true;
                }
            }
            return false;
        }
    }
}
