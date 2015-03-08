/*package dataStructure;

public class Hoffmantree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//把第0个空出来   方便后面运算 
		int[] x=new int[]{0,3,18,6,4,35,66,30,12,4};
		
		
		hoffmanMethod(x);
		
	}

	private static void hoffmanMethod(int[] x) {
		// TODO Auto-generated method stub
		
		int[] heap=new int[x.length];
		//创建最小堆	
		createHeap(heap,x);
		
		
		//将int型的堆转为Node型的堆
		Node[] nodeHeap=new Node[x.length];
		for(int i=0;i<heap.length;i++)
		{
			nodeHeap[i]=new Node(heap[i]);
		}
		
		//每次出来两个元素  
		for(int i=x.length-1;i>2;i--)
		{
			Node node1=nodeHeap[1];
			
			nodeHeap[1]=nodeHeap[i];
			shiftdown(nodeHeap,1,i);
		}
		
		
	}
	
	
	

	private static void createHoffman(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private static void createHeap(int[] heap,int[] num) {
		// TODO Auto-generated method stub
		for(int i=1;i<=num.length-1;i++)
		{
			heap[i]=num[i];
			if(i!=1)
				shiftup(heap,i);
		}
	}

	private static void shiftup(int[] heap, int i) {
		// TODO Auto-generated method stub
		while(heap[i]<heap[i/2]&&i>1)
		{
			swap(heap,i,i/2);
			i=i/2;
		}
	}

	
	
	
	private static void shiftdown(int[] heap, int i,int length) {
		// TODO Auto-generated method stub
		//if(2*i>length&&2*i+1>length)
		if(2*i>length)//没有左子树  肯定就没有右子树
			return;
		
		//既有左子树又有右子树
		else if(2*i+1<=length)
		{
			int tempMin=heap[2*i]<heap[2*i+1]?heap[2*i]:heap[2*i+1];
			if(heap[i]<tempMin)//比左右子树都小，已经到合适位置
				return;
			else//假设没有相等的情况   所以这里说明比左子树大 或者比右子树大  或者比左右子树都大
			{
				if(heap[2*i]<heap[2*i+1])
				{
					swap(heap,i,2*i);
					shiftdown(heap,2*i,length);
				}	
				else
				{
					swap(heap,i,2*i+1);
					shiftdown(heap,2*i+1,length);
				}
			}	
		}
		else//只有左子树
		{
			if(heap[i]>heap[2*i])
			{
				swap(heap,i,2*i);//只有左子树  也就不需要继续递归了
			}	
				
		}	
	}
	
	
	private static void shiftdown(Node[] heap, int i, int length) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//if(2*i>length&&2*i+1>length)
				if(2*i>length)//没有左子树  肯定就没有右子树
					return;
				
				//既有左子树又有右子树
				else if(2*i+1<=length)
				{
					int tempMin=heap[2*i].weight<heap[2*i+1].weight?heap[2*i].weight:heap[2*i+1].weight;
					if(heap[i].weight<tempMin)//比左右子树都小，已经到合适位置
						return;
					else//假设没有相等的情况   所以这里说明比左子树大 或者比右子树大  或者比左右子树都大
					{
						if(heap[2*i].weight<heap[2*i+1].weight)
						{
							swap(heap,i,2*i);
							shiftdown(heap,2*i,length);
						}	
						else
						{
							swap(heap,i,2*i+1);
							shiftdown(heap,2*i+1,length);
						}
					}	
				}
				else//只有左子树
				{
					if(heap[i].weight>heap[2*i].weight)
					{
						swap(heap,i,2*i);//只有左子树  也就不需要继续递归了
					}	
						
				}
	}
	
	private static void swap(int[] heap, int i, int j) {
		// TODO Auto-generated method stub
		int temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}

	private static void swap(Node[] heap, int i, int j) {
		// TODO Auto-generated method stub
		Node temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}

}

*/