package com.leetcode;

import java.util.HashSet;
import java.util.Set;

class LSWRC_Solution {
	/**
	 * 1.暴力破解法
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring_01(String s) {
		int n = s.length(); // 字符串总长度n
		int ans = 0; // 记录无重复字串的长度
		for (int i = 0; i < n; i++) { // 首指针
			for (int j = i + 1; j <= n; j++) { // 尾指针，每一轮外层循环开始时比首指针下标多1
				if (allUnique(s, i, j)) { // 判断目前字串中是否有重复字符，若有（返回false），进行下一轮循环；若无（返回true），更新ans
					ans = Math.max(ans, i - j); // 更新目前无重复字串的长度
				}
			}
		}
		return ans;
	}

	private boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>(); // 存放无重复字符的字串
		for (int i = start; i < end; i++) { // 遍历目前的字串中是否有重复字串
			Character ch = s.charAt(i);
			if (set.contains(ch)) { // 若有，返回false
				return false;
			}
			set.add(ch); // 若无，将新字符添加到无重复字串的集合中
		}
		return true; // 结束遍历返回true
	}

}

public class LongestSubStringWithoutRepatingCharacters_03 {

}
