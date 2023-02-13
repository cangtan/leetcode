package com.leetcode.string.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 删除子文件夹
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-08 13:56:00
 */
public class Solution1233 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new LinkedList<>();
        Arrays.sort(folder);
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String preStr = result.get(result.size() - 1);
            int pre = preStr.length();
            if (!(pre < folder[i].length() && folder[i].substring(0, pre).equals(preStr) && folder[i].charAt(pre) == '/')) {
                result.add(folder[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1233 solution = new Solution1233();
        String[] folders = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(solution.removeSubfolders(folders));
    }
}
