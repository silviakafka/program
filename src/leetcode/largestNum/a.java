package leetcode.largestNum;

public class a {
    //------------------------------------------------------------------
    private void merge(String[] a, int left, int mid, int right){
    	if(a == null) return;
    
    	int n = mid - left + 1; //[left, mid]
    	int m = right - mid; //[mid + 1, right]
    	String[] ls = new String[n];
    	String[] rs = new String[m];
    
    	for(int k = 0; k < n; k++) { ls[k] = a[left + k]; }
    	for(int k = 0; k < m; k++) { rs[k] = a[mid + k + 1]; }
    
    	int i = n, j = m, tmp = left;
    	while(i > 0 && j > 0){
    	    //重点在这里  先拼接两个字符串然后比较其大小
    	    //如 123  23  --> str1 = 12323  str2 = 23123
    	    String str1 = ls[n - i] + rs[m - j];
    	    String str2 = rs[m - j] + ls[n - i];
    	    
    		if(str1.compareTo(str2) > 0){//if(ls[n - i] < rs[m - j]){
    			a[tmp] = ls[n - i];	i--;
    		}else{
    			a[tmp] = rs[m - j];	j--;
    		}
    		tmp++;
    	}
    	while(i > 0){ a[tmp] = ls[n - i];	i--; tmp++;	}
    	while(j > 0){ a[tmp] = rs[m - j];	j--; tmp++;	}
    
    	//delete[] ls; 	delete[] rs;
    }
    /*@brief：合并排序*/
    private void mergeSort(String[] a, int left, int right){
    	if(a == null) return;
    
    	if(left < right){
    		int mid = left + (right - left) / 2;
    		mergeSort(a, left, mid);
    		mergeSort(a, mid + 1, right);
    		merge(a, left, mid, right);
    	}
    }
    public String largestNumber(int[] num) {
        String[] strNum = new String[num.length];
        
        for(int i = 0; i < num.length; i++){
            strNum[i] = String.valueOf(num[i]);
        }
        
        mergeSort(strNum, 0, strNum.length - 1);
        
        String retStr = "";
        
        for(int i = 0; i < strNum.length; i++){
            retStr += strNum[i];
        }
        int strIdx = 0;
        for(; strIdx < retStr.length(); strIdx++){
            if(retStr.charAt(strIdx) != '0'){
                break;
            }
        }
        if(strIdx == retStr.length()) return "0";
        
        return retStr;
    }

}