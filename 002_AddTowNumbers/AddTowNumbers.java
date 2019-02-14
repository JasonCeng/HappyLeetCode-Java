package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}

class ATN_Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 1. Initialize
		// 1.1 Initialize current node to dummy head of the returning list.
		ListNode dummyHead = new ListNode(0);
		// 1.2 Initialize carry to 0.
		int carry = 0;
		// 1.3 Initialize p and q to head of l1 and l2 respectively.
		ListNode p = l1, q = l2, curr = dummyHead;
		// 2. Loop through lists l1 and l2 until you reach both ends.
		while (p != null || q != null) {
			// 2.1 Set x to node p's value. If p has reached the end of l1, set
			// to 0.
			int x = (p != null) ? p.val : 0;
			// 2.2 Set y to node q's value. If q has reached the end of l2, set
			// to 0.
			int y = (q != null) ? q.val : 0;
			// 2.3 Set sum = x + y + carry
			int sum = x + y + carry;
			// 2.4 Update carry = sum / 10
			carry = sum / 10;
			// 2.5 Create a new node with the digit value of (sum mod 10) and
			// set it to current node's next, then advance current node to next.
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			// 2.6 Advance both p and q.
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		// 3. Check if carry = 1, if so append a new node with digit 11
		// to the returning list.
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		// 4. Return dummy head's next node.
		return dummyHead.next;
	}
}

public class AddTowNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode l1 = stringToListNode(line);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);

			ListNode ret = new ATN_Solution().addTwoNumbers(l1, l2);

			String out = ListNodeToString(ret);

			System.out.println(out);
		}
	}

	private static String ListNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}
		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	private static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	private static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}
}
