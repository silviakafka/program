package leetcode.LongestCommonPrefix;

public class Solution {
	
	public static void main(String[] args)
	{
		String[] strs=new String[]{"c","c"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        
    	if(strs==null)return "";
    	if(strs.length==0)return "";
    	if(strs.length==1)return strs[0];
    	
    	//strs的length至少为2
    	int minLength=strs[0].length();
    	for(int i=1;i<strs.length;i++)
    	{
    		if(strs[i]==null)
    			minLength=0;
    		else if(strs[i].length()<minLength)
    			minLength=strs[i].length();
    	}
    	
    	if(minLength==0)
    		return "";
    	
    	int i=0;
    	boolean jump=true;
    	for(;i<minLength&&jump;i++)
    	{
    		for(int j=1;j<strs.length;j++)
    		{
    			if(strs[j-1].charAt(i)==strs[j].charAt(i))
    				continue;
    			else
    			{
    				jump=false;
    				break;
    			}
    		}
    	}
    	//如果是因为jump跳出的，因为在外面的for循环中本来该跳出的  但先i++了才跳出
    	if(!jump)
    	{
    		i--;
    	}
    	
    	return strs[0].substring(0,i);
    	
    }
}