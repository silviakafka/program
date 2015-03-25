package renren;

public class DrawCircle {

	public static void main(String[] ars) {
		draw(27);
		// draw(109);
	}

	/*
	 * 
	 * @brief: 画圆圈函数
	 * 
	 * @param: x 圆圈里面最大的数
	 * 
	 * @return: void 直接在函数内部打印了
	 */
	private static void draw(int x) {
		// 每一圈最右上角是这一圈的最大的一个数 圈的大小分别是 1 3 5 7 ......（一定是奇数）
		// 右上角分别是 1 9 25 49.....
		// 所以需要sqrt函数。系统提供的是 double sqrt(double num)方式,但会进行不必要操作， 所以自己实现了 int
		// sqrt(int num) （通过二分查找法）
		// 通过自定义的int sqrt（int num）函数算得最接近的圈大小
		// 比如 109会介于 100和121之间（即10^2和11^2之间） 所以这个圈的大小是11
		int length = sqrt(x) + 1;
		if (length % 2 == 0)
			length++;// 如果是偶数则要加1 因为圈的大小 一定要是奇数

		int[][] myArray = new int[length][length];
		for (int i = length; i >= 1; i = i - 2) {
			// 填入每圈的数字（每一圈都是遵循相同的规律 1.正方形 2.右上角为边长的平方 3.上一条边从右到左递减 4.左边从上到下 递减
			// 5.下面从左到右递减 6右边从下到上递减）
			fillData(myArray, length, i);
		}

		// 打印输出这个数组
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				// 遍历输出整个数组 小于我们要求的数 我们输出为空
				if (myArray[i][j] <= x) {
					String temp = myArray[i][j] + "";
					switch (temp.length()) {// 为了整齐 暂时定为总共占8位
					case 1:
						System.out.print("   " + temp + "    ");
						break;
					case 2:
						System.out.print("   " + temp + "   ");
						break;
					case 3:
						System.out.print("  " + temp + "   ");
						break;
					case 4:
						System.out.print("  " + temp + "  ");
						break;
					case 5:
						System.out.print(" " + temp + "  ");
						break;
					case 6:
						System.out.print(" " + temp + " ");
						break;
					}
				} else
					System.out.print("        ");
			}
			System.out.println("");
		}

	}

	private static void fillData(int[][] myArray, int length, int current) {

		if (current == 1) {
			myArray[(length - 1) / 2][(length - 1) / 2] = 1;
			return;
		}

		// 右上角肯定是i^2
		int rightCorner = current * current;
		int temp = rightCorner;

		// 上一条边从右到左递减
		int up = (length - current) / 2;
		for (int j = up + current - 1; j >= up; j--) {
			myArray[up][j] = temp;
			temp--;
		}
		// 左边从上到下 递减
		int left = (length - current) / 2;
		for (int j = left + 1; j <= left + current - 1; j++) {
			myArray[j][left] = temp;
			temp--;
		}
		// 下面从左到右递减
		int bottom = up + current - 1;
		for (int j = up + 1; j <= up + current - 1; j++) {
			myArray[bottom][j] = temp;
			temp--;
		}
		// 右边从下到上递减
		int right = up + current - 1;
		for (int j = up + current - 2; j > up; j--) {
			myArray[j][right] = temp;
			temp--;
		}
	}

	// 自己编写的对int型开平方函数 返回最近的int结果（小于的） 通过二分查找法
	public static int sqrt(int x) {
		if (x <= 0)
			return 0;
		if (x == 1)
			return 1;

		// 不能用int去定义 否则int型和int型相乘再强转long还是会出错 因为相乘时已经越界了
		// long result=middle*middle; 所以全部都应该定义为long
		long right = x;
		long left = 1;

		long middle = (int) ((left + right) / 2);
		// 因为int的最大数为2的31次方（2147483647）
		// 所以传进来的int最大2的31次方 对它进行开方得到2的（15.5）次方 即介于2的15次方（32768）和2的16次方（65535）之间
		// 所以防止越界（java中没有unsigned类型），二分法的情况下 如果middle任然大于65535 我们可以直接将它赋值为65535
		if (middle > 65535)
			middle = 65535;
		long result = 0;
		while (true) {
			result = middle * middle;
			if (result > x) {
				right = middle;
				middle = (int) ((left + right) / 2);
				if (middle == left)
					return (int) middle;
			} else if (result == x)
				return (int) middle;
			else if (result < x) {
				left = middle;
				middle = (int) ((left + right) / 2);
				if (middle == left)
					return (int) middle;
			}
		}

	}

}
