public class PrimeNumbers {
	
	public boolean isPrimeNumber(int number) {
		if(number == 1 || number == 2) {
			return true;
		}
		for(int i = 2; i <= number / 2; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int[] primeNumbers(int from, int upTo) {
		int[] allPrimeNumbers = new int[(upTo - from) / 2 + 1];
		int primeNumbersCount = 0;
		for(int i = from; i <= upTo; i++) {
			if(isPrimeNumber(i)) {
				allPrimeNumbers[primeNumbersCount++] = i;
			}
		}
		return allPrimeNumbers;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to prime numberes program");
		PrimeNumbers primeNumbers = new PrimeNumbers();
		int[] allPrimeNumbers = primeNumbers.primeNumbers(0, 1000);
		for(int i = 0; i < allPrimeNumbers.length; i++) {
			if(i != 0 && allPrimeNumbers[i] == 0) {
				break;
			}
			System.out.println(allPrimeNumbers[i]);
		}
	}

}