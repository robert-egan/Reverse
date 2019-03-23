class Main{
	
	public static void main(String[] args) {
		try {
			Palindrome pal1 = new Palindrome();
			Palindrome pal2 = new Palindrome();
			pal1.getLength();
			for (int i=0;i<pal1.length;i++) {
				pal1.scanIndex(i);
			}
			pal2.scanValue();
			pal1.reverseList();
			pal2.revVal = pal2.reverseValue(10, pal2.value, pal2.multiplier);
			System.out.println("Were your array and integer both palindromes?");
			if(pal1.equals(pal2)) {
				System.out.println("Yes!");
			}
			else System.out.println("No :(");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
}