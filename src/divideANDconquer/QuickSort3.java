package divideANDconquer;

//从一头向另一头移动  适用于链表型的快速排序
//即麻省理工算法导论课程中的算法   对于数组

public class QuickSort3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myArray=new int[]{1,3,5,86,8,24,35,55,29,84,54,37,56,2,69,6};
		quickSort(myArray,0,(myArray.length-1));
		
		for(int i=0;i<myArray.length;i++)
		{
			System.out.print(myArray[i]+"  ");
		}
	}

	private static void quickSort(int[] myArray, int head,int end) {
		// TODO Auto-generated method stub
		if(head>=end)
			return;
		int temp=findPlace(myArray,head,end);
		quickSort(myArray,head,temp-1);
		quickSort(myArray,temp+1,end);
		
	}

	private static int findPlace(int[] myArray, int head,int end) {
		// TODO Auto-generated method stub
		//从一头向另一头移动  适用于链表型的快速排序
		//即哥伦比亚 算法导论课程中的算法
		int pivot=myArray[head];
		int i=head;
		int j=head+1;
		for(;j<=end;j++)
		{
			//如果myArray[j]>pivot则j++ 不需要其他操作
			if(myArray[j]<=pivot)
			{
				i++;
				swap(myArray,i,j);
				
			}
				
		}
		swap(myArray,head,i);
		return i;
		
		
	}

	private static void swap(int[] myArray, int i, int j) {
		// TODO Auto-generated method stub
		int temp=myArray[i];
		myArray[i]=myArray[j];
		myArray[j]=temp;
	}


}
