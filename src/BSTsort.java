

public class BSTsort {

	public static void main(String[] args)
	{
		int[] num={3,45,66,73,95,46,77,120,343,5,34,78,94,520};
		bstSort(num);
		
	}

	private static void bstSort(int[] num) {
		// TODO Auto-generated method stub
		//插入需要nlgn
		Tree head=insertTree(num);
		
		//遍历输出n
		inorderTreeWalk(head);
	}


	private static Tree insertTree(int[] num) {
		// TODO Auto-generated method stub
		Tree head=new Tree();
		head.num=num[0];
		Tree p;
		boolean flag=true;
		for(int i=1;i<num.length-1;i++)
		{
			flag=true;
			p=head;
			while(flag)
			{
				while(num[i]>p.num)
				{
					if(p.right==null)
					{
						Tree temp=new Tree();
						temp.num=num[i];
						p.right=temp;
						flag=false;
						break;
					}
					else
					{
						p=p.right;
					}
				}
				while(num[i]<p.num)
				{
					if(p.left==null)
					{
						Tree temp=new Tree();
						temp.num=num[i];
						p.left=temp;
						flag=false;
						break;
					}
					else
					{
						p=p.left;
					}
				}
			}
			
		}
		return head;
	}
	
	private static void inorderTreeWalk(Tree head) {
		// TODO Auto-generated method stub
		if(head==null)
			return;
		inorderTreeWalk(head.left);
		System.out.println(head.num);
		inorderTreeWalk(head.right);
	}
	
	
	
}


