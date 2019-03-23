class Palindrome extends Reverse{
	 
	public Palindrome() {
		super();
	}
	
	public boolean compareLists(int[] listA, int[] listB) {
		/*
		 * Helper method for checkPalindrome, returns false if any index of the two
		 * arrays are not the same integer
		 */
		
		for (int i=0;i<listA.length;i++) {
			if (listA[i] != listB[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkPalindrome() {
		/*
		 * Returns true if the reversed integer or array is equal to the original 
		 * input, otherwise returns false.
		 */
		if (this.value == this.revVal) {
			return true;
		}
		else if (compareLists(this.list,this.revlist)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override public boolean equals(Object obj) {
		/*
		 * Class specific equals method, returns true if both objects are palindromes
		 */
		if(obj==null) return false;
		if(!(obj instanceof Palindrome)) return false;
		final Palindrome other = (Palindrome) obj;
		return (this.checkPalindrome() && other.checkPalindrome());
	}

}