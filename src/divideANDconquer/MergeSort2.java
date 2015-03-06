package divideANDconquer;

public class MergeSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myArray = new int[] {1,3,5,86,8,24,35,55,29,84,54,37,56,2,69,6};
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + "  ");
		}
		System.out.println();
		int length = myArray.length;
		int[] temp = new int[length];

		//recursive(myArray, temp, 0, length - 1);
		mergeSort(myArray,  0, length - 1);

		System.out.println("after sorting!");
		//for (int i = 0; i < temp.length; i++) {
		//	System.out.print(temp[i] + "  ");
		//}
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + "  ");
		}
	}

/*	private static void recursive(int[] myArray, int[] temp, int a, int b) {
		// TODO Auto-generated method stub
		if (a >= b) {
			return;
			// do nothing
		}
		int first = a;
		int last = b;
		int middle = (a + b) / 2;
		//System.out.println("a = " + a + ", b = " + middle);
		recursive(myArray, temp, a, middle);
		//System.out.println("middle = " + (middle+1) + ", last = " + last);
		recursive(myArray, temp, middle + 1, last);
		merge(myArray, temp, first, middle + 1, last);

	}

	private static void merge(int[] myArray, int[] temp, int a, int b, int c) {
		// TODO Auto-generated method stub
		// a为first b middle+1 c为last
		// a为第一个子数组开始的位置 b为第二个子数组开始的位置
		int i = a;
		int start = a;
		int tempFirst = b;
		int tempNum = c;// 记录第二个数组开始的位置 因为b在遍历过程中会往后移 用tempNum与a比较作为
		// 第一个数组是否遍历完的标志 b>c作为第二个数组遍历完的标志
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		// 往temp数组i（初始值为a）到c下标里面添加元素
		while (i <= c) {

			System.out.println("a = " + myArray[a] + ",b = " + myArray[b]);
			if (myArray[a] < myArray[b]) {
				temp[i] = myArray[a];
				a++;
			} else {
				temp[i] = myArray[b];
				b++;
			}
			//System.out.println("temp[" + i + "]" + " = " + temp[i]);
			i++;
			
			// 如果第一个数组便利完了 直接把第二个数组的剩下部分全部复制进去就好
			if (a == tempFirst) {
				System.arraycopy(myArray, b, temp, i, tempNum - b + 1);
				i += tempNum - b + 1;
				//System.arraycopy(temp, tempFirst, myArray, tempFirst, c	- tempFirst);
				
				for(int k = start; k < i; k++){
					System.out.print(temp[k] + " ");
				}System.out.println();System.out.println();
				return;
			}
			// 如果第二个数组便利完了 直接把第一个数组的剩下部分全部复制进去就好
			if (b > c) {
				System.arraycopy(myArray, a, temp, i, tempFirst - a);
				//System.arraycopy(temp, tempFirst, myArray, tempFirst, c - tempFirst);
				i += tempFirst - a;
				for(int k = start; k < i; k++){
					System.out.print(temp[k] + " ");
				}System.out.println();System.out.println();
				return;
			}
		}

	}*/
	
	/*
	 * @param: arrayInt整型数组
	 * @param: left 数组左边界
	 * @param: right 数组右边界
	 * */
	public static void mergeSort(int [] arrayInt, int left, int right){
		if(left < right){ //左边界 小于右边界时才递归
			int mid = left + (right - left) / 2;
			mergeSort(arrayInt, left, mid);
			mergeSort(arrayInt, mid + 1, right);
			merge(arrayInt, left, mid, right);
		}
		
	}
	
	/*
	 * @param: arrayInt整型数组
	 * @param: left 数组左边界
	 * @param: mid 数组中间下标
	 * @param: right 数组右边界
	 * */	
	public static void merge(int [] arrayInt, int left, int mid, int right){
		int aSize = mid - left + 1;
		int bSize = right - mid;
		int [] a = new int[aSize];		//[left, mid]
		int [] b = new int[bSize];		//[mid + 1, right]
		
		System.arraycopy(arrayInt, left, a, 0, aSize); 		//copy [left, mid]
		System.arraycopy(arrayInt, mid + 1, b, 0, bSize);	//copy [mid + 1, right]
		
		int piovt = left; 	//new array index
		
		int i = 0; // index of a
		int j = 0; // index of b
		
		while(i < aSize && j < bSize){
			if(a[i] < b[j]){
				arrayInt[piovt++] = a[i++];
			}else{
				arrayInt[piovt++] = b[j++];
			}
		}
		
		if(i == aSize){ //数组a先比较完了， 只剩下b的元素
			System.arraycopy( b, j, arrayInt, piovt, bSize - j);
			return;
		}
		//数组b先比较完了， 只剩下a的元素
		System.arraycopy(a, i, arrayInt, piovt, aSize - i);

	}

}
