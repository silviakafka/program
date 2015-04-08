package leetcode.CompareVersionNumbers;

public class Solution {

	public static void main(String[] args) {
		//String[] array1="3.23".split("\\.");
		//System.out.println(array1.length);
		//System.out.println(new Solution().compareVersion("1.23", "1.32"));
		//System.out.println(new Solution().compareVersion("01", "1"));
		//System.out.println(new Solution().compareVersion("1.0", "1"));
		System.out.println(new Solution().compareVersion("1", "1.1"));
		
		
	}
	
	public int compareVersion(String version1, String version2) {
		
		String[] array1=version1.split("\\.");
		String[] array2=version2.split("\\.");
		
		int version1Length=array1.length;
		int version2Length=array2.length;
		
		int place=0;
		for(;place<version1Length&&place<version2Length;place++)
		{
			String v1=array1[place];
			String v2=array2[place];
			int i=0,j=0;
			for(;i<v1.length();i++)
			{
				if(v1.charAt(i)=='0')continue;
				else break;
			}
			for(;j<v2.length();j++)
			{
				if(v2.charAt(j)=='0')continue;
				else break;
			}
			if((v1.length()-i)>(v2.length()-j))return 1;
			else if((v1.length()-i)<(v2.length()-j))return -1;
			else
			{
				for(;i<v1.length();i++,j++)
				{
					if(v1.charAt(i)>v2.charAt(j))return 1;
					else if(v1.charAt(i)<v2.charAt(j))return -1;
					else
						continue;
				}
			}
		}

		if(version1Length==version2Length)return 0;
		else if(version1Length>version2Length)
		{
			for(;place<version1Length;place++)
			{
				String v1=array1[place];
				for(int i=0;i<v1.length();i++)
				{
					if(v1.charAt(i)!='0')
						return 1;
					
				}
			}
			
		}
			
		else if(version1Length<version2Length)
		{
			for(;place<version2Length;place++)
			{
				String v2=array2[place];
				for(int i=0;i<v2.length();i++)
				{
					if(v2.charAt(i)!='0')
						return -1;
					
				}
			}
		}
		
		return 0;
	}

}
