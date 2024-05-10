package views;

import java.util.Scanner;

import Model.User;
import dao.userDAO;
import service.GenerateOTP;
import service.SendOTP;
import service.UserService;

public class welcome {
	public void welcomescreen() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome Frnd");
		System.out.println("Press 1 to Login");
		System.out.println("Press 2 to Signup");
		System.out.println("Press 0 to exit");
		
		int choice = 0;
		
		try {
			choice = s.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch(choice) {
		case 1 : login();
				 break;
		case 2 : signUp();
				 break;
		case 0 : System.exit(0);
				 break;
		}
	}

	private void login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email : ");
		String email = s.nextLine();
		try {
			if(userDAO.isExists(email)) {
				String genOTP = GenerateOTP.getOTP();
				SendOTP.sendOTP(email, genOTP);
				System.out.print("Enter the OTP : ");
				String otp = s.nextLine();
				if(otp.equals(genOTP)) new UserView(email).home();
				else System.out.println("Wrong OTP");
			}
			else {
				System.out.println("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void signUp() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = s.nextLine();
		System.out.println("Enter Email : ");
		String email = s.nextLine();
		String genOTP = GenerateOTP.getOTP();
		SendOTP.sendOTP(email, genOTP);
		System.out.print("Enter the OTP : ");
		String otp = s.nextLine();
		if(otp.equals(genOTP)) {
			User user = new User(name,email);
			int response = UserService.saveUser(user);
			switch(response) {
			case 0 : System.out.println("User already there, no need to register again.");
					 break;
			case 1 : System.out.println("User registered");
					 break;
			}
		}
		else System.out.println("Wrong OTP");
	}
}
