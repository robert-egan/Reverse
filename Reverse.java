import java.util.Scanner;

class Reverse{
	/*
	* Class with methods to take in user input of an integer or int array, and return the reverse of that input.
	*/
	int value, revVal, length, multiplier;
	int[] list, revlist;
	Scanner scan = new Scanner(System.in);
	
	
	public Reverse() {
		/*
		 * Variable pairs are initially set to be unequal, so they will not return
		 * a false positive in the checkPalindrome method when not changed.
		 */
		value = 0;
		revVal = 1;
		list = new int[1];
		revlist = new int [1];
		list[0]=0;
		revlist[0]=1;
		
	}
	
	//Getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int num) {
		value = num;
		multiplier = (int)(Math.pow(10,(Math.floor(Math.log10(value)))));
		/*
		 * 10 raised to the floor of the log base 10 of value
		 * Originally I had a separate method with a while loop to find the 
		 * power of 10 closest but lower than value, but realized I could do it
		 * in a single operation using logs. 
		 */
	}

	public int getIndex(int index) {
		return list[index];
	}
	public void setIndex(int index, int num) {
		list[index]=num;
	}
	//Scanners for getting user input, which call the setters
	public void scanValue() {
		System.out.println("Enter an integer: ");
		int num = scan.nextInt();
		this.setValue(num);
	}
	public void scanIndex(int index) {
		System.out.println("Enter a number for index [" + index + "]: ");
		int num = scan.nextInt();
		this.setIndex(index, num);
	}
	public void getLength() {
		/*
		 * Prompts the user for the length of the array and then reinstantiates the
		 * array to the given length
		 */
		System.out.println("How long is your array?");
		length = scan.nextInt();
		list = new int[length];
		revlist = new int[length];
	}
	
	public int reverseValue(int modder,int value, int multiplier) {
		/*
		 * Recursive function for reversing any integer. 
		 * The exit strategy is the multiplier variable being equal to 1.
		 * Uses the modulo operator and the while loop to isolate each digit in
		 * value and store it in the variable digit.
		 * On every subsequent function call, remainder is subtracted from value,
		 * modder is increased by a factor of 10, multiplier is decreased by a factor
		 * of 10, and the product of digit and multiplier is added to revVal.  
		 */
		int remainder = value % modder;
		int digit = remainder;
		while(digit>=10) digit /=10;
		if(multiplier == 1) {
			return digit;
		}
		revVal = reverseValue(modder*10,(value-remainder),multiplier/10) + (digit)*multiplier;
		return revVal;
	}
	
	public void reverseList() {
		/*
		 * Method for populating the reverse array. Starts for the beginning of the
		 * user's array and the end of the revList array, looping over each index.
		 */
		int indexCounter = list.length -1;
		for(int i=0;i<list.length;i++) {
			revlist[i]=list[indexCounter];
			indexCounter -= 1;
		}
	}
}
