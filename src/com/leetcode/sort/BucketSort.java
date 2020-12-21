package com.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version V1.0
 * @Description: 桶排序(也可以不用int数组，借助map)
 * @author: 薛佳豪
 * @date: 2020-3-31 10:56
 */
public class BucketSort {
    public BucketSort(){

    }
    public void example(){
        int[] arr1 =  new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] bucket = new int[1000];
        int[] result = new int[arr1.length];
        int indexOf = 0;
        for (int i : arr1) {
            bucket[i]++;
        }
        for (int i : arr2) {
            while (bucket[i]-->0){
                result[indexOf++] = i;
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] > 0){
                while (bucket[i]-->0){
                    result[indexOf++] = i;
                }
            }
        }
    }
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        int[] bucket = new int[26];
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : arr) {
            bucket[c - 'a']++;
        }
        int end = s.length();
        while (end > 0){
            for(int i = 0; i < 26; i++){
                if(bucket[i]>0){
                    stringBuilder.append((char)(i + 'a'));
                    bucket[i]--;
                    end--;
                }
                if (end <= 0){
                    break;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(bucket[i]>0){
                    stringBuilder.append((char)(i + 'a'));
                    bucket[i]--;
                    end--;
                }
                if (end <= 0){
                    break;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
