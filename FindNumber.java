import java.util.Scanner;

public class FindNumber {
	Scanner scanner = new Scanner(System.in);
	
	public int find(int low, int high) {
		if(low > high) {
			return -1;
		}
		if(low == high) {
			return low;
		}
		int mid = (low + high) / 2;
		System.out.println("enter greater if your number greater than "+mid);
		if((high - low) > 1) {
			System.out.println("enter less if your number less than "+mid);
		}
		System.out.println("enter equal if your number equal to "+mid);
		String inp = scanner.nextLine();
		if(inp.equalsIgnoreCase("greater")) {
			return find(mid + 1, high);
		} else if(inp.equalsIgnoreCase("less") && (high - low) > 1) {
			return find(low, mid - 1);
		} else if(inp.equalsIgnoreCase("equal")) {
			return mid;	
		} else {
			System.out.println("Entered incorrect option please enter correct option : ");
			return find(low, high);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to find number program");
		int upto = Integer.parseInt(args[0]);
		FindNumber findNumber = new FindNumber();
		System.out.println("Assume any number upto "+upto);
		System.out.println("press enter if done");
		findNumber.scanner.nextLine();
		System.out.println("Number you assumed is "+findNumber.find(0, upto));
	}

}
