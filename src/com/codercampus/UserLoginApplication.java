package com.codercampus;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static User[] users;

	public static void main(String[] args) throws IOException {

		UserService userService = new UserService();

		String[] lines = userService.readFile("data.txt");
		users = userService.createUserArray(lines);

		Scanner sc = new Scanner(System.in);

		try {
			int loginCtr = 0;
			while (loginCtr < 6) {
				System.out.println("Enter your email: ");
				String username = sc.nextLine();
				System.out.println("Enter your password: ");
				String password = sc.nextLine();

				User validUser = userService.defineValidUser(username, password);

				if (validUser != null) {
					System.out.println("Welcome " + validUser.getName());
					System.exit(0);
				} else {
					System.out.println("Invalid login, please try again. ");
					loginCtr++;
					if (loginCtr == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						System.exit(0);
					}

				}
			}

		} finally {
			sc.close();
		}
	}
}
