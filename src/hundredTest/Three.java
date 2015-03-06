package hundredTest;

import java.util.Stack;

public class Three {

	public static void main(String[] args)
	{
		int[] myArray=new int[]{1,-2,3,10,-4,7,2,-5};
		myMethod(myArray);
	}

	private static void myMethod(int[] myArray) {
		// TODO Auto-generated method stub

		int[] myNewArray=new int[myArray.length];
		int sum=0;
		int j=0;
		
		for(int i=0;i<myArray.length;i++)
		{
			if(myArray[i]>0)
				sum+=myArray[i];
			else
			{
				myNewArray[j]=sum;
				
			}
		}
	}
}
