package com.leetcode.graph.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 最小基因变化
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-15 09:24:00
 */
public class Solution433 {

    private final Map<String, Integer> map = new HashMap<>();
    private final List<List<Integer>> list = new LinkedList<>();
    private Integer id = 0;

    public int minMutation(String startGene, String endGene, String[] bank) {
        for (String s : bank) {
            addWord(s);
        }
        if (!map.containsKey(endGene)) {
            return -1;
        }
        addWord(startGene);
        Integer startId = map.get(startGene);
        Queue<Integer> startQueue = new LinkedList<>();
        startQueue.add(startId);
        int[] startDist = new int[id];
        Arrays.fill(startDist, Integer.MAX_VALUE);
        startDist[startId] = 0;

        Queue<Integer> endQueue = new LinkedList<>();
        Integer endId = map.get(endGene);
        endQueue.add(endId);
        int[] endDist = new int[id];
        Arrays.fill(endDist, Integer.MAX_VALUE);
        endDist[endId] = 0;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            Integer wordId1 = startQueue.poll();
            List<Integer> startNextList = list.get(wordId1);
            for (Integer nextId : startNextList) {
                if (endDist[nextId] != Integer.MAX_VALUE) {
                    return (startDist[wordId1] + endDist[nextId]) / 2 + 1;
                }
                if (startDist[nextId] == Integer.MAX_VALUE) {
                    startQueue.add(nextId);
                    startDist[nextId] = startDist[wordId1] + 1;
                }
            }
            Integer wordId2 = endQueue.poll();
            List<Integer> endNextList = list.get(wordId2);
            for (Integer nextId : endNextList) {
                if (startDist[nextId] != Integer.MAX_VALUE) {
                    return (endDist[wordId2] + startDist[nextId]) / 2 + 1;
                }
                if (endDist[nextId] == Integer.MAX_VALUE) {
                    endQueue.add(nextId);
                    endDist[nextId] = endDist[wordId2] + 1;
                }
            }
        }
        return -1;
    }

    private void addEdge(String word) {
        char[] chars = word.toCharArray();
        Integer id1 = map.get(word);
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String s = new String(chars);
            if (map.containsKey(s)) {
                Integer id2 = map.get(s);
                list.get(id2).add(id1);
                list.get(id1).add(id2);
            } else {
                Integer id2 = id;
                map.put(s, id2);
                LinkedList<Integer> item = new LinkedList<>();
                item.add(id1);
                list.add(item);
                list.get(id1).add(id2);
                id++;
            }
            chars[i] = temp;
        }
    }

    private void addWord(String word) {
        map.put(word, id++);
        list.add(new LinkedList<>());
        addEdge(word);
    }

    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        Solution433 solution = new Solution433();
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = {"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};
        System.out.println(solution.minMutation(startGene, endGene, bank));
    }

    public static void test2() {
        Solution433 solution = new Solution433();
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(solution.minMutation(startGene, endGene, bank));
    }
}
