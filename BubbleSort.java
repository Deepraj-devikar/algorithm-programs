import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSort {

	public void sort(int[] numbers) {
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = 0; j < numbers.length - 1 - i; j++) {
				if(numbers[j] > numbers[j+1]) {
					int tempNumber = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tempNumber;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to bubble sort program");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter how many numbers have to enter : ");
		int numberCounts;
		while(true) {
			try {
				numberCounts = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.print("Please enter number : ");
			}finally {
				scanner.nextLine();
			}
		}

		int numbers[] = new int[numberCounts];
		System.out.println("Enter "+numberCounts+" numbers from here : ");
		for(int i = 0; i < numberCounts; i++) {
			System.out.print("Enter "+(i+1)+" number : ");
			while(true) {
				try {
					numbers[i] = scanner.nextInt();
					break;
				}catch(InputMismatchException e) {
					System.out.print("Please enter number : ");
				}finally {
					scanner.nextLine();
				}
			}	
		}
		scanner.close();
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(numbers);
		System.out.println("*************************");
		System.out.println("Sorted numbers");
		for(int i = 0; i < numberCounts; i++) {
			System.out.println(numbers[i]);
		}
	}

}
