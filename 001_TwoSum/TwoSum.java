package com.leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// ����
		int[] nums = {2, 7, 11, 15};
		int target = 9; 
		int[] res = twoSum(nums, target);
		System.out.println("[" + res[0] + "," + res[1] + "]");
	}

	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(); // ��Ŵ�������������ݽṹhaspMap
        int[] res = new int[2];	// �������
        
        // ������������¼��hashMap��
		for(int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
        
        // ����hashMap�ҵ�����Ŀ��Ԫ�ص��±�
        for(int i = 0; i < nums.length; i++) {
        	int temp = target - nums[i];
        	if(hashMap.containsKey(temp) && (i != hashMap.get(temp))) { // ��Ϊ��ӡ��м�ǰ���Զ����hashMap��ʽ��<key, value> ������key��Ŀ��Ԫ�أ�value��Ŀ��Ԫ�ص��±ꡣ
        		res[0] = i;
        		res[1] = hashMap.get(temp);
        		break;
        	}
        }
		
        return res; // ��������鷵��
    }
}
