package renren;

public class Test {
	public static void main(String[] args){
		String num1 = "-123456789";
		String num2 = "123456789";
		
		System.out.println(add(num1, num2));
		System.out.println(minus(num1, num2));
		
		System.out.println();
		clockPrint(21);
				
	}
	
	/*
	 * @brief: 函数加法
	 * @param: num1加数
	 * @param: num2被加数
	 * @return: String返回类型
	 * 
	 * 要考虑加数与被加数的正负性， 假设输入的数是合法的即不含空格，但可以含有-号或+号
	 * */
	public static String add(String num1, String num2){
		//加数与被加数的符号 
		boolean num1IsPositive = true;
		boolean num2IsPositive = true;
		StringBuilder n1 = new StringBuilder(num1);
		StringBuilder n2 = new StringBuilder(num2);
		StringBuilder result = null;
		
		//先判断他们的符号  然后去掉符号 做运算   注意 这里的n2  n1是指去掉符号后的数
		if(n1.charAt(0) == '-'){
			num1IsPositive = false;
			n1.deleteCharAt(0);
		}else if(n1.charAt(0) == '+'){
			n1.deleteCharAt(0);
		}
		
		if(n2.charAt(0) == '-'){
			num2IsPositive = false;
			n2.deleteCharAt(0);
		}else if(n1.charAt(0) == '+'){
			n2.deleteCharAt(0);
		}
		
		//都是正数的加法
		if(num1IsPositive && num2IsPositive){
			return addWithSameSign(n1, n2).toString();
		}
		
		//负数 与 负数 的加法
		if(!num1IsPositive && !num2IsPositive){
			result = addWithSameSign(n1, n2);
			//注意这里 负数相加的负号不要丢了
			result.insert(0, '-');
			return result.toString();
		}
		//正数 与 负数的加法
		if(num1IsPositive && !num2IsPositive){
			return minusWithSameSign(n1, n2).toString();
		}
		
		//负数  与  下数的加法   注意这里参数的调整 减数与被减数调换了位置
		if(!num1IsPositive && num2IsPositive){
			//注意这里参数的调整 减数与被减数调换了位置
			return minusWithSameSign(n2, n1).toString();
		}
		
		return null;
	}
	
	/*
	 * @brief: 减法函数
	 * @param: 被减数
	 * @param: 减数
	 * */
	public static String minus(String num1, String num2){
		boolean num1IsPositive = true;
		boolean num2IsPositive = true;
		StringBuilder n1 = new StringBuilder(num1);
		StringBuilder n2 = new StringBuilder(num2);
		StringBuilder result = null;
		//判断符号 并 去掉符号后运算  注意 这里的n2  n1是指去掉符号后的数
		if(n1.charAt(0) == '-'){
			num1IsPositive = false;
			n1.deleteCharAt(0);
		}else if(n1.charAt(0) == '+'){
			n1.deleteCharAt(0);
		}
		
		if(n2.charAt(0) == '-'){
			num2IsPositive = false;
			n2.deleteCharAt(0);
		}else if(n1.charAt(0) == '+'){
			n2.deleteCharAt(0);
		}
		
		if(num1IsPositive && num2IsPositive){
			return minusWithSameSign(n1, n2).toString();
		}
		
		if(!num1IsPositive && !num2IsPositive){
			//注意两个负数相减  只需将去掉符号后的 减数与被减数换位置就行  注意 这里的n2  n1是指去掉符号后的数
			return minusWithSameSign(n2, n1).toString();
		}
		
		if(num1IsPositive && !num2IsPositive){
			//正数 减 负数  相当于去掉符号后  他们相加
			return addWithSameSign(n1, n2).toString();
		}
		
		if(!num1IsPositive && num2IsPositive){
			//负数减正数  相当于两个负数相加
			result = addWithSameSign(n1, n2);
			result.insert(0, '-');
			return result.toString();
		}
		
		return null;
	}
	
	//同号相加  同正   同负
	public static StringBuilder addWithSameSign(StringBuilder num1, StringBuilder num2){
		StringBuilder result = new StringBuilder(); //用来存放最后的结果，保存的是倒着的结果
		int m = num1.length();
		int n = num2.length();
		int carry = 0; //进位值
		
		while(m > 0 && n > 0){
			//从后向前    即从低位向高位计算
			char c1 = num1.charAt(--m);
			char c2 = num2.charAt(--n);	
			int sum = c1 - '0' + c2 - '0' + carry;
			
			if(sum > 9){ //大于9进位
				carry = 1;
				sum = sum - 10;
			}else{ //否则将进位位置0
				carry = 0;
			}
			result.append((char)(sum + '0'));
		}
		
		while(m > 0){ //将加数或是被加数中更长的数的剩余位进行运算
			int sum = num1.charAt(--m) - '0' + carry;
			if(sum > 9){
				carry = 1;
				sum = sum - 10;
			}else{
				carry = 0;
			}
			result.append((char)(sum + '0'));
		}
		while(n > 0){  //将加数或是被加数中更长的数的剩余位进行运算
			int sum = num1.charAt(--n) - '0' + carry;
			if(sum > 9){
				carry = 1;
				sum = sum - 10;
			}else{
				carry = 0;
			}
			result.append((char)(sum + '0'));
		}
		
		if(carry == '1'){  //进位位不为0 则向更高位进1
			result.append('1');
		}
		
		return result.reverse();
	}
	
	/*
	 * @brief: 减法函数
	 * @param: num1被凑数
	 * @param: num2减数
	 * //同号相减  同正  同负  大的放在前面
	 * */
	public static StringBuilder minusWithSameSign(StringBuilder num1, StringBuilder num2){
		StringBuilder result = new StringBuilder(); //存结果
		int m = num1.length();
		int n = num2.length();
		int borrow = 0; //借位值
		boolean isSwaped = false; //大的数  与 小的数是否交换了位置
		
		//默认num1比num2大
		StringBuilder big = num1;
		StringBuilder small = num2;
		
		if(m < n){ //如果num2的长度比num1长则num2比num1大
			big = num2;
			small = num1;
			isSwaped = true; //默认的num1大被交换了位置
		}else if(m == n){ //如果长度相同则要比较 大小
			if(num1.toString().compareTo(num2.toString()) < 0){
				big = num2;
				small = num1;
				isSwaped = true;
			}else if(num1.toString().compareTo(num2.toString()) == 0){
				result.append('0');
				return result;
			}
		}
		
		m = big.length();
		n = small.length();
		while(m > 0 && n > 0){
			char c1 = num1.charAt(--m);
			char c2 = num2.charAt(--n);	
			int sum = c1 -  c2 + borrow;
			
			if(sum >= 0){
				borrow = 0; //借位位
			}else{
				borrow = -1; //高位被借过置 为-1
				sum = c1 + 10 - c2;
			}
			result.append((char)(sum + '0'));
		}
		//将被减数中长于减数的部分添加到result中
		while(m > 0){
			int sum = num1.charAt(--m) - '0' + borrow;
			if(sum >= 0){
				borrow = 0;
			}else{
				borrow = -1;
				sum = num1.charAt(--m) - '0' + 10 + borrow;
			}
			result.append((char)(sum + '0'));
		}
		while(n > 0){//将被减数中长于减数的部分添加到result中
			int sum = num1.charAt(--n) - '0' + borrow;
			if(sum >= 0){
				borrow = 0;
			}else{
				borrow = -1;
				sum = num1.charAt(--n) - '0' + 10 + borrow;
			}
			result.append((char)(sum + '0'));
		}
		result.reverse(); //将结果反转回来， 因为存时是从低位向高位
		if(result.charAt(0) == '0'){ //由于借位的原因有可能最高位被借成0了，要删除0
			result.deleteCharAt(0);
		}
		
		if(isSwaped){
			result.insert(0, '-'); //如果减数与被减数调换了位置  则要加上负号
		}
		return result;
	}
	
	public static void clockPrint(int n){
		double nn = n;
		double s = Math.sqrt(nn);
		int mSize = (int)Math.floor(s);

		if(mSize % 2 == 0) { //个数只取奇数 
			mSize++; 
		}
		
		int[][] m = new int[mSize][mSize];
		//初始化数组为0
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize; j++){
				m[i][j] = 0;
			}
		}
		int c = 1;
		int ci = mSize / 2; //数组下标 初始位置
		int cj = mSize / 2; 
		int direct = 0; //右0 --> 下1 --> 左2 --> 上3
		
		while(c <= n){
			m[ci][cj] = c++; // 中间置1 c使用后自增
			if(c > n) break;
			
			if(direct == 0){ //向右
				//cj++;
				if(m[ci + 1][++cj] == 0){//想向下		 右上角
					direct = 1;
				}
			}else if(direct == 1){ //向下
				//ci++;
				if(m[++ci][cj - 1] == 0){ //想向左		右下角
					direct = 2;
				}
			}else if(direct == 2){ //向左
				//cj--;
				if(m[ci - 1][--cj] == 0){ //想向上		左下角
					direct = 3;
				}
			}else{ //向上
				//ci--;
				if(m[--ci][cj + 1] == 0){ //想向右		 左上角
					direct = 0;
				}
			}
		}
		
		//打印
		for(int i = 0; i < mSize; i++){
			for(int j = 0; j < mSize; j++){
				if(m[i][j] != 0){ //等于0的不打印
					System.out.printf("%3d  ", m[i][j]);
				}
			}
			System.out.println();
		}
	}
}
