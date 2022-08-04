import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> users = new HashMap<String, String>();
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("('Users', 'Save', 'Load', Or just login / Register)");
			String firstInput = sc.nextLine();
			
			
			if (firstInput.toUpperCase().equals("USERS")) {
				for(String i : users.keySet()) {
					System.out.println(i + " and the pass: " + users.get(i));
					
				}
				System.out.println("USERS PRINTED");
				
			}else if(firstInput.toUpperCase().equals("SAVE")) {
				Algorithms.WriteHashMapToFile(users);

				System.out.println("SAVED");
			}else if(firstInput.toUpperCase().equals("LOAD")){
				users = Algorithms.readHashMapFromFile();
				System.out.println("LOADED");
			}else {
				String password = sc.nextLine();
				if(users.get(firstInput) != null) {
					
					if(users.get(firstInput).equals(Algorithms.getMD5(password))) {
						System.out.println("LOGGED IN. Do you want to delete? (y/n)");
						if(sc.nextLine().equals("y")) {
							users.remove(firstInput);
							System.out.println("DELETED");
						}else {
							System.out.println("Do you want to change password? (y/n)");
							if(sc.nextLine().equals("y")) {
								users.remove(firstInput);
								System.out.println("Ok, write your new password:");
								password = sc.nextLine();
								users.put(firstInput, Algorithms.getMD5(password));
								System.out.println("PASSWORD CHANGED");
							}else {
								System.out.println("well, ok");
							}
						}
					}else {
						System.out.println("WRONG PASSWORD");
					}
					
				}else {
					users.put(firstInput, Algorithms.getMD5(password));
					System.out.println("REGISTERED");
					
				}
			}
			
			
		}
		
	}
	

}
