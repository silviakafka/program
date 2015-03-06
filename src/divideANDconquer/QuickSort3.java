package divideANDconquer;

//��һͷ����һͷ�ƶ�  �����������͵Ŀ�������
//����ʡ���㷨���ۿγ��е��㷨   ��������

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
		//��һͷ����һͷ�ƶ�  �����������͵Ŀ�������
		//�����ױ��� �㷨���ۿγ��е��㷨
		int pivot=myArray[head];
		int i=head;
		int j=head+1;
		for(;j<=end;j++)
		{
			//���myArray[j]>pivot��j++ ����Ҫ��������
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
