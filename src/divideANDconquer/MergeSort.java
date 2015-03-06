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
		//aΪfirst   b  middle+1   cΪlast
		//aΪ��һ�������鿪ʼ��λ��   bΪ�ڶ��������鿪ʼ��λ��
		int i=a;
		
		int tempFirst=a;
		int tempNum=b;//��¼�ڶ������鿪ʼ��λ��  ��Ϊb�ڱ��������л�������     ��tempNum��a�Ƚ���Ϊ
		//��һ�������Ƿ������ı�־     b>c��Ϊ�ڶ������������ı�־
		
		
		//��temp����i����ʼֵΪa����c�±��������Ԫ��
		while(i<=c)
		{
			//�����һ�������������   ֱ�Ӱѵڶ��������ʣ�²���ȫ�����ƽ�ȥ�ͺ�
			if(a==tempNum)
			{
				System.arraycopy(myArray, b, temp, i,c-i+1);
				System.arraycopy(temp, tempFirst, myArray, tempFirst,c-tempFirst+1);
				return;
			}
			
			//����ڶ��������������   ֱ�Ӱѵ�һ�������ʣ�²���ȫ�����ƽ�ȥ�ͺ�
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
