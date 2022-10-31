import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {

	public <Type extends Comparable<Type>> void insertAndSort(Type[] words, Type word, int i) {
		while(i > 0) {
			if(word.compareTo(words[i-1]) < 0) {
				words[i] = words[--i];
				continue;
			}
			words[i] = word;
			return;
		}
		words[i] = word;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to insertion sort program");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number how many words have to enter : ");
		int numberOfWords;
		while(true) {
			try {
				numberOfWords = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.print("Please enter number : ");
			}finally {
				scanner.nextLine();
			}
		}

		InsertionSort insertionSort = new InsertionSort();
		String words[] = new String[numberOfWords];
		for(int i = 0; i < numberOfWords; i++) {
			String word = scanner.nextLine().trim();
			insertionSort.insertAndSort(words, word, i);
		}
		scanner.close();
		System.out.println("**********************************");
		System.out.println("Sorted array : ");
		for(int i = 0; i < numberOfWords; i++) {
			System.out.println(words[i]);
		}
	}
}