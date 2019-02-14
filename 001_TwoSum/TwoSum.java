package com.leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// 测试
		int[] nums = {2, 7, 11, 15};
		int target = 9; 
		int[] res = twoSum(nums, target);
		System.out.println("[" + res[0] + "," + res[1] + "]");
	}

	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(); // 存放待搜索数组的数据结构haspMap
        int[] res = new int[2];	// 结果数组
        
        // 将待搜索数组录入hashMap中
		for(int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
        
        // 遍历hashMap找到两个目标元素的下标
        for(int i = 0; i < nums.length; i++) {
        	int temp = target - nums[i];
        	if(hashMap.containsKey(temp) && (i != hashMap.get(temp))) { // 此为大坑。切忌前面自定义的hashMap格式。<key, value> 此题中key是目标元素，value是目标元素的下标。
        		res[0] = i;
        		res[1] = hashMap.get(temp);
        		break;
        	}
        }
		
        return res; // 将结果数组返回
    }
}
