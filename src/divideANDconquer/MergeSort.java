package divideANDconquer;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myArray=new int[]{1,3,5,86,8,24,35,55,29,84,54,37,56,2,69,6};
		for(int i=0;i<myArray.length;i++)
		{
			System.out.print(myArray[i]+"  ");
		}
		int length=myArray.length;
		int[] temp=new int[length];
		
		recursive(myArray,temp,0,length-1);
		
		System.out.println("after sorting!");
		for(int i=0;i<temp.length;i++)
		{
			System.out.print(temp[i]+"  ");
		}
	}

	private static void recursive(int[] myArray, int[] temp, int a, int b) {
		// TODO Auto-generated method stub
		if(a==b)
		{
			return;
			//do nothing
		}
		int first=a;
		int last=b;
		int middle=(a+b)/2;
		recursive(myArray,temp,a,middle);
		recursive(myArray,temp,middle+1,last);
		merge(myArray,temp,first,middle+1,last);
		
		
		
	}

	private static void merge(int[] myArray, int[] temp, int a, int b,int c) {
		// TODO Auto-generated method stub
		//a为first   b  middle+1   c为last
		//a为第一个子数组开始的位置   b为第二个子数组开始的位置
		int i=a;
		
		int tempFirst=a;
		int tempNum=b;//记录第二个数组开始的位置  因为b在遍历过程中会往后移     用tempNum与a比较作为
		//第一个数组是否遍历完的标志     b>c作为第二个数组遍历完的标志
		
		
		//往temp数组i（初始值为a）到c下标里面添加元素
		while(i<=c)
		{
			//如果第一个数组便利完了   直接把第二个数组的剩下部分全部复制进去就好
			if(a==tempNum)
			{
				System.arraycopy(myArray, b, temp, i,c-i+1);
				System.arraycopy(temp, tempFirst, myArray, tempFirst,c-tempFirst+1);
				return;
			}
			
			//如果第二个数组便利完了   直接把第一个数组的剩下部分全部复制进去就好
			if(b>c)
			{
				System.arraycopy(myArray, a, temp, i, c-i+1);
				System.arraycopy(temp, tempFirst, myArray, tempFirst,c-tempFirst+1);
				return;
			}
				
			
			if(myArray[a]<myArray[b])
			{
				temp[i]=myArray[a];
				i++;
				a++;
			}
			else
			{
				temp[i]=myArray[b];
				i++;
				b++;
			}
		}
		
	}

}
