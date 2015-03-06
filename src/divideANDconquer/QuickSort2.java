package divideANDconquer;

public class QuickSort2 {

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
		int headLink=head;
		headLink++;
		while(end>headLink)
		{
			while(myArray[end]>=x&&end>headLink)
			{
				end--;
			}
			while(myArray[headLink]<x&&end>headLink)
			{
				headLink++;
			}
			int temp=myArray[headLink];
			myArray[headLink]=myArray[end];
			myArray[end]=temp;
			
			end--;
			headLink++;
			
		}
		//跳出循环时情况1：headLink==end
		//情况2：headLink=end+1
		//情况3：headLink=end+2
		if(headLink==end)
		{
			if(myArray[end]<x)
			{
				myArray[head]=myArray[end];
				myArray[end]=x;
				return end;
			}
			else
			{
				myArray[head]=myArray[end-1];
				myArray[end-1]=x;
				return end-1;
			}
		}
		else if(headLink==end+1)
		{
			myArray[head]=myArray[end];
			myArray[end]=x;
			return end;
		}
		else if(headLink==end+2) 
		{
			end++;
			if(myArray[end]<x)
			{
				myArray[head]=myArray[end];
				myArray[end]=x;
				return end;
			}
			else
			{
				myArray[head]=myArray[end-1];
				myArray[end-1]=x;
				return end-1;
			}
		}
		
		return end;
		
		
		
	}


}
