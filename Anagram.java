public class Anagram {

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
			char[] value1Arr = value1.toCharArray();
			char[] value2Arr = value2.toCharArray();
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
	
	public static void main(String[] args) {
		System.out.println("Welcome to anagram program");
		Anagram anagram = new Anagram();
		String string1 = "heaert";
		String string2 = "eartah";
		System.out.println(string1+" and "+string2+" are"+(anagram.isAnagram(string1, string2) ? "" : " not" )+" anagram");
	}

}
