package forOffer;

public class ReplaceBankSpace {

	public static void main(String[] args) {
		char[] test=new char[100];
		String a="this is a test article to be modified";
		char[] stringChar=a.toCharArray();
		
		//模拟题目中要求的情况
		System.arraycopy(stringChar, 0, test, 0, stringChar.length);
		replaceBlank(test,stringChar.length);
		
		for(int i=0;i<test.length;i++)
		{
			System.out.print(test[i]);
		}

	}

	private static void replaceBlank(char[] test, int length) {
		int blankNum=0;
		for(int i=0;i<length;i++)
		{
			if(test[i]==' ')
				blankNum++;
		}
		
		int moreCharacter=blankNum*2;
		int newLength=moreCharacter+length;
		
		int originalPlace=length-1;
		for(int newPlace=newLength-1;newPlace>=0;newPlace--)
		{
			if(test[originalPlace]==' ')
			{
				blankNum--;
				test[newPlace]='0';
				newPlace--;
				test[newPlace]='2';
				newPlace--;
				test[newPlace]='%';
				originalPlace--;
			}
			else
			{
				test[newPlace]=test[originalPlace];
				originalPlace--;
			}
		}
		
		
		
		
	}

}
