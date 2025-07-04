package com.leetcode.graph.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重新规划路线
 *
 * @author xjh
 * @since 2025/7/3 16:31
 */
public class Solution1466 {

    public int minReorder(int n, int[][] connections) {
        boolean[] reach = new boolean[n];
        int cityCount = 1;
        int minNum = 0;
        reach[0] = true;
        while(cityCount < n) {
            for(int i = 0; i < connections.length; i++) {
                int e1 = connections[i][0];
                int e2 = connections[i][1];
                // 第一个节点如果已经访问国，但第二个节点未访问说明顺序颠倒需要调整
                if(reach[e1] && !reach[e2]) {
                    reach[e2] = true;
                    cityCount++;
                    minNum++;
                    connections[i][0] = e2;
                    connections[i][1] = e1;
                }
                // 第二个节点如果已经访问国，但第一个节点未访问说明顺序未颠倒
                if(reach[e2] && !reach[e1]) {
                    cityCount++;
                    reach[e1] = true;
                }
            }
        }
        return minNum;
    }

    public int minReorder2(int n, int[][] connections) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            Integer[] arr = new Integer[]{connections[i][0], connections[i][1]};
            if (map.containsKey(connections[i][0])) {
                map.get(connections[i][0]).add(arr);
            } else {
                List<Integer[]> itemList = new ArrayList<>();
                itemList.add(arr);
                map.put(connections[i][0], itemList);
            }
            if (map.containsKey(connections[i][1])) {
                map.get(connections[i][1]).add(arr);
            } else {
                List<Integer[]> itemList = new ArrayList<>();
                itemList.add(arr);
                map.put(connections[i][1], itemList);
            }
        }
        return dfs(map, 0);
    }

    private int dfs(Map<Integer, List<Integer[]>> map, int cur) {
        List<Integer[]> integers = map.get(cur);
        if (integers == null) {
            return 0;
        }
        map.remove(cur);
        int result = 0;
        for (Integer[] integer : integers) {
            if (integer[1] != cur && map.containsKey(integer[1])) {
                result += 1;
            }
            result += dfs(map, integer[0]) + dfs(map, integer[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] connections = {{1, 0}};
        System.out.println(new Solution1466().minReorder2(n, connections));
    }
}
