package divideANDconquer;

public class QuickSort1 {

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
		int x=myArray[head];
		while(end>head)
		{
			while(myArray[end]>=x&&end>head)
			{
				end--;
			}
			myArray[head]=myArray[end];
			while(myArray[head]<x&&end>head)
			{
				head++;
			}
			myArray[end]=myArray[head];
		}
		//Ìø³öÑ­»·Ê±head==end
		myArray[end]=x;
		return end;
		
	}


}
