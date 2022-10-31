public class PrimePalindromAnagram extends PrimeNumbers{

	public boolean isPalindrom(String value) {
		for(int i = 0; i < value.length() / 2; i++) {
			if(value.charAt(i) != value.charAt(value.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public int[] palindroms(int[] arr) {
		int[] result = new int[arr.length];
		int palindromCounter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && arr[i] == 0) {
				break;
			}
			if(isPalindrom(String.valueOf(arr[i]))){
				result[palindromCounter++] = arr[i];
			}
		}
		return result;
	}
	
	public char[] makeCharactersArr(String value) {
		char[] characters = new char[value.length()];
		for(int i = 0; i < value.length(); i++) {
			characters[i] = value.charAt(i);
		}
		return characters;
	}
	
	public void setMin(char[] arr, int index) {
		int minIndex = index;
		for(int j = index + 1; j < arr.length; j++) {
			if(arr[minIndex] > arr[j]) {
				minIndex = j;
			}
		}
		if(minIndex != index) {
			char temp = arr[index];
			arr[index] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	public boolean isAnagram(String value1, String value2) {
		if(value1.length() == value2.length() && ! value1.equals(value2)) {
			char[] value1Arr = makeCharactersArr(value1);
			char[] value2Arr = makeCharactersArr(value2);
			for(int i = 0 ; i < value1.length(); i++) {
				setMin(value1Arr, i);
				setMin(value2Arr, i);
				if(value1Arr[i] != value2Arr[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public int[] anagrams(int[] arr) {
		int[] result = new int[arr.length];
		int anagramCounter = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(isAnagram(String.valueOf(arr[i]), String.valueOf(arr[j]))) {
					result[anagramCounter++] = arr[i];
					result[anagramCounter++] = arr[j];
				}	
			}	
		}
		return result;
	}
	
	public int[] primePalindromAnagram(int from, int upTo) {
		return anagrams(palindroms(primeNumbers(from, upTo)));
	}
	
	public static void main(String[] args) {
		System.out.println("welcome to prime palindrom anagram program");
		PrimePalindromAnagram primePalindromAnagram = new PrimePalindromAnagram();
		int[] result = primePalindromAnagram.primePalindromAnagram(0, 1000);
		for(int i = 0; i < result.length; i++) {
			if(i != 0 && result[i] == 0) {
				break;
			}
			System.out.println(result[i]);
		}
	}

}
