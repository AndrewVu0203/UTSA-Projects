
public class Binary {
	char []number;
	
	Binary(){ // no need to do anything
		number = new char[32];
	}
	
	Binary(String num){ // 
		number = num.toCharArray();
	}
	
	Binary(char []num){
		number = num; 
	}
	
	void setBigInteger(char a[]) {
		number = a;
	}
	
	void setBigInteger(String num) {
		number = num.toCharArray();
	}
	
	void invertBits(){
		for(int i = 0; i < number.length; i++) {
			switch(number[i]) {
				case 1: number[i] = 0;
				case 0: number[i] = 1;
			}
		}
	}
	
	char getBit(int index) {
		return number[index];
	}
	
	char setBit(int index, char val) {
		number[index] = val;
		return number[index];
	}
	
	Binary and(Binary n) {
		Binary result = new Binary();
		
		for(int i = 0; i < number.length; i++) {
			if(this.number[i] == n.number[i]) {
				result.number[i] = '1';
			}
			else{
				result.number[i] = '0';
			}
		}
	
		return result; 
	}
	
	Binary or(Binary n) {
		Binary result = new Binary();
		
		for(int i = 0; i < number.length; i++) {
			if(this.number[i] == '1' || n.number[i] == '1') {
				result.number[i] = '1';
			}
			else {
				result.number[i] = '0';
			}
		}
	
		return result; 	
	}
	
	Binary xor(Binary n) {
		Binary result = new Binary();
		
		for(int i = 0; i < number.length; i++) {
			if(this.number[i] == '1' || n.number[i] == '1') {
				result.number[i] = '1';
			}
			if(this.number[i] == '1' && n.number[i] == '1') {
				result.number[i] = '0';
			}
			else {
				result.number[i] = '0';
			}
		}
		return result; 	
	}
	
	void show(){	
		int reachNumber = 0;
		for(int i = 0; i < number.length; i++) {
			if(number[i] != '0') {
				reachNumber = 1;
			}
			if(number[i] != '0' && reachNumber == 1) {
				System.out.println(number[i]);
			}	
		}
	}
	
	void decimal() {
		// number of decimal will increase as i go toward 0 of array
		int decimalNumber = 0;
		for(int i = number.length-1; i > 0; i--) {
			
			if(number[i] == '1') {
				
			}
		}
	}
	
	void hexadecimal() {
		
	}
	
	public static void mina(String args[]) {
		Binary x = new Binary("1011");
	
		char [ ]num = {'1', '0', '1'} ;
		// Binary y = new Binary(num);		
		// Binary z = x.and(y);
		// z.show();
	}
	
}
