import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BinarySearch {

	public String[] readWordsFromFile(String fileName) {
		String words[] = new String[45];
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String word;
			int i = 0;
			while((word = bufferedReader.readLine()) != null) {
				words[i++] = word;
			}
		}
		// catch file not found exception if any data file not present
		catch (FileNotFoundException e) {
			System.out.println("can't read "+fileName+" file");
		}catch (Exception e) {
			System.out.println(e);
		}
		return words;
	}
	
	public <Type extends Comparable<Type>> void sortWords(Type[] words) {
		for(int i = 0; i < words.length-1; i++) {
			for(int j = 0; j < words.length-i-1; j++) {
				if(words[j].compareTo(words[j+1]) > 0) {
					Type tempWord = words[j];
					words[j] = words[j+1];
					words[j+1] = tempWord;
				}
			}
		}
	}
	
	public <Type extends Comparable<Type>> boolean search(Type wordToSearch, Type[] words) {
		return doBinarySearch(wordToSearch, words, 0, words.length - 1);
	}
	
	private <Type extends Comparable<Type>> boolean doBinarySearch(Type wordToSearch, Type[] words, int low, int high) {
		if(low > high) {
			return false;
		}
		int mid = (low + high) / 2;
		if(words[mid].equals(wordToSearch)) {
			return true;
		}
		if(words[mid].compareTo(wordToSearch) < 0) {
			return doBinarySearch(wordToSearch, words, mid + 1, high);
		}
		return doBinarySearch(wordToSearch, words, low, mid - 1);
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		System.out.println("Binary search");
		String[] words = binarySearch.readWordsFromFile("E:\\bridgelabz\\typing\\fruits.txt");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter word to search : ");
		String wordToSearch = scanner.nextLine().trim();
		scanner.close();
		
		binarySearch.sortWords(words);
		
		System.out.println(wordToSearch+" is"+(binarySearch.search(wordToSearch, words) ? " found" : " not found")+" in words list");
	}

}
