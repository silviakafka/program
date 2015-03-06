package divideANDconquer;


public class Multiply_digit_recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node original=new Node();
		Node original2=new Node();
		Node original3=new Node();
		Node original4=new Node();
		Node original5=new Node();
		Node original6=new Node();
		Node original7=new Node();
		original.num=1;original2.num=2;original3.num=3;original4.num=4;
		original5.num=5;original6.num=6;original7.num=7;
		original.next=original2;
		original2.next=original3;
		original3.next=original4;
		original4.next=original5;
		original5.next=original6;
		original6.next=original7;
		original7.next=null;
		
		
		System.out.println("before sorting:");
		Node tempt=original;
		while(tempt!=null)
		{
			System.out.print(tempt.num+"  ");
			tempt=tempt.next;
		}
		System.out.println("");
		System.out.println("====================================");
		
		Node result=multiply_digit(original,8);
		
		
		
		System.out.println("after sorting and multiplying:");
		tempt=result;
		while(tempt!=null)
		{
			System.out.print(tempt.num+"  ");
			tempt=tempt.next;
		}
		System.out.println("");
		System.out.println("====================================");
		
		
	}
	
	private static Node multiply_digit(Node original,int num)
	{

		original=reverse(original);
		
		System.out.println("after reverse:");
		Node tempt=original;
		while(tempt!=null)
		{
			System.out.print(tempt.num+"  ");
			tempt=tempt.next;
		}
		System.out.println("");
		System.out.println("====================================");
		
		int index=0;
		Node tempt2=original;
		while(tempt2!=null)
		{
			//˳�����Ҫ
			int tempt3=tempt2.num;
			tempt2.num=tempt2.num*num%10+index;
			index=(tempt3*num)/10;
			tempt2=tempt2.next;
		}
		return reverse(original);
	}

	
	
	//�ݹ鷽ʽ�������
	private static Node reverse(Node original) {
		// TODO Auto-generated method stub
		if(original.next==null)
		{
			return original;
		}
		Node newHead=reverse(original.next);
		
		original.next.next=original;
		original.next=null;
		return newHead;
		
		//����2��ʹ������ĺ�巨  ����ͳ
	}
	
}

class Node{
	int num;
	Node next;

	
}

