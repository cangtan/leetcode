package com.leetcode.graph.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 单词接龙
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 09:53:00
 */
public class Solution127 {
    private final Map<String, Integer> wordIdMap = new HashMap<>();
    private final List<List<Integer>> edgeList = new LinkedList<>();
    private int counter = 0;

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        wordList.forEach(this::addEdge);
//        if (!wordIdMap.containsKey(endWord)) {
//            return 0;
//        }        addEdge(beginWord);
//        int[] dist = new int[counter];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Queue<Integer> queue = new LinkedList<>();
//        Integer beginWordId = wordIdMap.get(beginWord);
//        queue.offer(beginWordId);
//        dist[beginWordId] = 0;
//        while (!queue.isEmpty()) {
//            Integer current = queue.poll();
//            if (current.equals(wordIdMap.get(endWord))) {
//                return dist[current] / 2 + 1;
//            }
//            for (Integer next : edgeList.get(current)) {
//                if (dist[next] == Integer.MAX_VALUE) {
//                    dist[next] = dist[current] + 1;
//                    queue.offer(next);
//                }
//            }
//        }
//        return 0;
//    }

    /**
     * 双向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.forEach(this::addEdge);
        if (!wordIdMap.containsKey(endWord)) {
            return 0;
        }
        addEdge(beginWord);
        int[] beginDist = new int[counter];
        Arrays.fill(beginDist, Integer.MAX_VALUE);
        Queue<Integer> beginQueue = new LinkedList<>();
        Integer beginWordId = wordIdMap.get(beginWord);
        beginQueue.offer(beginWordId);
        beginDist[beginWordId] = 0;

        Queue<Integer> endQueue = new LinkedList<>();
        Integer endWordId = wordIdMap.get(endWord);
        endQueue.offer(endWordId);
        int[] endDist = new int[counter];
        Arrays.fill(endDist, Integer.MAX_VALUE);
        endDist[endWordId] = 0;

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginQueueSize = beginQueue.size();
            for (int i = 0; i < beginQueueSize; i++) {
                Integer beginCursor = beginQueue.poll();
                if (endDist[beginCursor] != Integer.MAX_VALUE) {
                    return (beginDist[beginCursor] + endDist[beginCursor]) / 2 + 1;
                }
                for (Integer next : edgeList.get(beginCursor)) {
                    if (beginDist[next] == Integer.MAX_VALUE) {
                        beginDist[next] = beginDist[beginCursor] + 1;
                        beginQueue.offer(next);
                    }
                }
            }

            int endQueueSize = endQueue.size();
            for (int i = 0; i < endQueueSize; i++) {
                Integer endCursor = endQueue.poll();
                if (beginDist[endCursor] != Integer.MAX_VALUE) {
                    return (beginDist[endCursor] + endDist[endCursor]) / 2 + 1;
                }
                for (Integer next : edgeList.get(endCursor)) {
                    if (endDist[next] == Integer.MAX_VALUE) {
                        endDist[next] = endDist[endCursor] + 1;
                        endQueue.offer(next);
                    }
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        Integer wordId1 = wordIdMap.get(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String s = new String(chars);
            addWord(s);
            Integer wordId2 = wordIdMap.get(s);
            edgeList.get(wordId1).add(wordId2);
            edgeList.get(wordId2).add(wordId1);
            chars[i] = temp;
        }
    }

    public void addWord(String word) {
        if (!wordIdMap.containsKey(word)) {
            wordIdMap.put(word, counter++);
            edgeList.add(new LinkedList<>());
        }
    }


    public static void main(String[] args) {
        Solution127 solution = new Solution127();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordArr)));
    }
}
