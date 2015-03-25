package renren;

import java.io.IOException;
import java.util.Stack;

//import leetcode.addTwoNumbers.ListNode;

public class AddTwoBigNum {

	public static void main(String[] args) throws IOException {
		System.out.println(addTwoNumbers("-123", "-877"));
		System.out.println(addTwoNumbers("123", "877"));
		System.out.println(addTwoNumbers("-123", "119"));

		System.out.println(minusTwoNumbers("123", "119"));
		System.out.println(minusTwoNumbers("119", "123"));
		System.out.println(minusTwoNumbers("119", "-123"));
		System.out.println(minusTwoNumbers("-119", "-123"));
		System.out.println(minusTwoNumbers("-119", "123"));
		System.out.println(minusTwoNumbers("-119", null));

	}

	/*
	 * @brief: 函数加法
	 * @param: num1加数
	 * @param: num2被加数
	 * @return: String返回类型
	 * 
	 * 要考虑加数与被加数的正负性， 假设输入的数是合法的即不含空格，但可以含有-号(假设正数不含+号)
	 */
	public static String addTwoNumbers(String num1, String num2) {

		
		// 边界值特殊处理
		// 保证.length .charAt操作不出现异常
		if (num1 == null)
			return num2;
		if (num2 == null)
			return num1;		
		
		// 当num1 num2前面带有负号的时候
		if (num1.charAt(0) == '-' && num2.charAt(0) != '-')
			return minusTwoNumbers(num2, num1.substring(1));
		else if (num2.charAt(0) == '-' && num1.charAt(0) != '-')
			return minusTwoNumbers(num1, num2.substring(1));
		else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
			return "-" + addTwoNumbers(num1.substring(1), num2.substring(1));
		}

		// 边界值特殊处理
		// 保证下面遍历时length2-1不为负数
		if (num1.length() == 0)
			return num2;
		if (num2.length() == 0)
			return num1;

		int length1 = num1.length();
		int length2 = num2.length();

		// 保证num1 比num2长   num1比num2短时 交换两者
		// 方便后面运算
		if (length1 < length2) {
			String temp = num1;
			num1 = num2;
			num2 = temp;

			int tempN = length1;
			length1 = length2;
			length2 = tempN;
		}

		// 思路：从num1 num2最后一位开始逆向遍历 并且相加。并记录进位
		// 使用堆栈保存每一位相加的和
		//最后堆栈出栈就是我们的结果
		Stack<Integer> myResult = new Stack<Integer>();

		// 开始设置进位为0
		int jinwei = 0;
		// 从num最后一位开始
		int place1 = length1 - 1;
		for (int place2 = length2 - 1; place2 >= 0; place2--) {
			int sum = (num1.charAt(place1) - '0') + (num2.charAt(place2) - '0')
					+ jinwei;// 用-'0'取出字符对应的数字
			if (sum > 9) {
				sum = sum % 10;
				jinwei = 1;
			} else
				jinwei = 0;

			myResult.push(sum);
			place1--;

		}
		// 此时place2为-1
		for (; place1 >= 0; place1--) {
			if (jinwei > 0) {
				int sum = (num1.charAt(place1) - '0') + jinwei;
				if (sum > 9) {
					sum = sum % 10;
					jinwei = 1;
				} else
					jinwei = 0;

				myResult.push(sum);
			} else// 已经没有进位了
			{
				myResult.push((num1.charAt(place1) - '0'));
			}
		}

		// 如果num1已经到底 还有进位的话
		if (jinwei != 0)
			myResult.push((jinwei));

		StringBuffer result = new StringBuffer();
		while (!myResult.isEmpty()) {
			result.append(myResult.pop());
		}
		return result.toString();
	}

	/*
	 * @brief: 减法函数
	 * 
	 * @param:num1 被减数
	 * @param:num2 减数 
	 * * 要考虑减数与被减数的正负性， 假设输入的数是合法的即不含空格，但可以含有-号(假设正数不含+号)
	 */
	public static String minusTwoNumbers(String num1, String num2) {
		
		// 边界值特殊处理
		// 保证.length .charAt操作不出现异常
		if (num1 == null)
			return "-" + num2;
		if (num2 == null)
			return num1;		
		
		
		// 当num1 num2前面带有负号的时候
		if (num1.charAt(0) == '-' && num2.charAt(0) != '-')
			return "-" + addTwoNumbers(num2, num1.substring(1));
		else if (num2.charAt(0) == '-' && num1.charAt(0) != '-')
			return addTwoNumbers(num1, num2.substring(1));
		else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
			return minusTwoNumbers(num2.substring(1), num1.substring(1));
		}


		// 边界值特殊处理
		// 保证下面遍历时length2-1不为负数
		if (num1.length() == 0)
			return "-" + num2;
		if (num2.length() == 0)
			return num1;

		int length1 = num1.length();
		int length2 = num2.length();

		// 用于记录返回的是正数还是负数
		boolean flag = true;

		if (length1 < length2) {
			// 结果为负数
			// 交换num1 num2
			flag = false;

			String temp = num1;
			num1 = num2;
			num2 = temp;

			int tempN = length1;
			length1 = length2;
			length2 = tempN;
		}

		// 保证nun1 大于num2 方便后面的计算
		else if (length1 == length2) {
			int i = 0;
			for (; i < length1; i++) {
				if (num1.charAt(i) > num2.charAt(i))
					break;
				else if (num1.charAt(i) == num2.charAt(i))
					continue;
				else {
					// 结果为负数
					flag = false;
					// 交换num1 num2
					String temp = num1;
					num1 = num2;
					num2 = temp;

					int tempN = length1;
					length1 = length2;
					length2 = tempN;
					break;
				}
			}

			if (i == length1)// 两个数完全相等
				return "0";
		}

		// 前面已经保证nun1 大于num2了
		// 思路：从num最后一位开始逆向遍历 并且相减。并记录借位
		// 使用堆栈保存每一位相减的结果
		// 对于最后的结果，可能出现前面有多个无效0的结果  去除多余的0
		Stack<Integer> myResult = new Stack<Integer>();

		// 开始设置借位为0
		int jiewei = 0;
		// 从num最后一位开始
		int place1 = length1 - 1;
		for (int place2 = length2 - 1; place2 >= 0; place2--) {
			int minus = (num1.charAt(place1) - '0')
					- (num2.charAt(place2) - '0') - jiewei;// 用-'0'取出字符对应的数字
			if (minus < 0) {
				// 借了一位
				minus = minus + 10;
				jiewei = 1;
			} else
				jiewei = 0;

			myResult.push(minus);
			place1--;

		}

		// 此时place2为-1
		for (; place1 >= 0; place1--) {
			if (jiewei > 0) {
				int minus = (num1.charAt(place1) - '0') - jiewei;
				if (minus < 0) {
					// 借了一位
					minus = minus + 10;
					jiewei = 1;
				} else
					jiewei = 0;

				myResult.push(minus);
			} else// 已经没有借位了
			{
				myResult.push((num1.charAt(place1) - '0'));
			}
		}

		// 因为保证了num1大于num2 所以不可能有多余的借位
		StringBuffer result = new StringBuffer();
		while (!myResult.isEmpty()) {
			result.append(myResult.pop());
		}

		//可能出现前面有多个无效0的结果  去除多余的0
		int index = 0;
		while (result.charAt(index) == '0') {
			index++;
		}

		return flag ? result.substring(index) : "-" + result.substring(index);
	}

}
