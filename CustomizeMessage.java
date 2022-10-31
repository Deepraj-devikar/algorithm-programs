import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomizeMessage {
	String dummyMessage;
	String firstName;
	String middleName;
	String lastName;
	String phoneNumber;
	
	public CustomizeMessage() {
		dummyMessage = "Hello <<name>>,\n"
				+ "We have your full name as <<full name>> in our system.\n"
				+ "your contact number is 91-xxxxxxxxxx.\n"
				+ "Please,let us know in case of any clarification Thank you BridgeLabz XX/XX/XXXX.";
	}
	
	public void readUserDetails() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first name : ");
		firstName = scanner.nextLine();
		System.out.print("Enter middle name : ");
		middleName = scanner.nextLine();
		System.out.print("Enter last name : ");
		lastName = scanner.nextLine();
		System.out.print("Enter phone number : ");
		phoneNumber = scanner.nextLine();
		scanner.close();
	}
	
	public String modifiedMessage() {
		return dummyMessage.replace("<<name>>", firstName)
				.replace("<<full name>>", firstName+" "+middleName+" "+lastName)
				.replace("xxxxxxxxxx", phoneNumber)
				.replace("XX/XX/XXXX", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
	}
	
	public static void main(String[] args) {
		CustomizeMessage customizeMessage = new CustomizeMessage();
		customizeMessage.readUserDetails();
		System.out.println(customizeMessage.modifiedMessage());
	}

}
