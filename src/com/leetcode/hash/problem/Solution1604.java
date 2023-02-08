package com.leetcode.hash.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-07 09:21:00
 */
public class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String[] split = keyTime[i].split(":");
            int time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (timeMap.containsKey(keyName[i])) {
                timeMap.get(keyName[i]).add(time);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(time);
                timeMap.put(keyName[i], value);
            }
        }
        List<String> result = new ArrayList<>(timeMap.keySet().size());
        timeMap.forEach((k, v) -> {
            Collections.sort(v);
            int start = 0;
            for (int i = 1; i < v.size(); i++) {
                if (v.get(i) - v.get(start) <= 60 && i - start + 1 >= 3) {
                    result.add(k);
                    break;
                }
                if (i - start + 1 >= 3) {
                    start++;
                }
            }
        });
        return result;
    }

    public static void main(String[] args) {
        Solution1604 solution = new Solution1604();
        String[] keyName = {"alice","alice","alice","bob","bob","bob","bob"};
        String[] keyTime = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
        System.out.println(solution.alertNames(keyName, keyTime));
    }
}

