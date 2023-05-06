package com.leetcode.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-05 10:19:00
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }


        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    private void bfs(char[][] board, Trie trie, int i, int j, Set<String> ans) {
        char ch = board[i][j];
        int index = ch - 'a';
        if (trie.children[index] == null) {
            return;
        }
        Trie node = trie.children[index];
        if (node.word != "") {
            ans.add(node.word);
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int i1 = i + dx[k];
            int j1 = j + dy[k];
            if (i1 >= 0 && j1 >= 0 && i1 < board.length && j1 < board[0].length && board[i1][j1] != '#') {
                bfs(board, node, i1, j1, ans);
            }
        }
        board[i][j] = ch;
    }

    private static class Trie {
        private final Trie[] children;
        private String word;

        public Trie() {
            this.children = new Trie[26];
            word = "";
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.word = word;
        }
    }


    public static void main(String[] args) {
        Solution212 solution = new Solution212();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));
    }
}
