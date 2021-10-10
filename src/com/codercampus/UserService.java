package com.codercampus;

import java.io.IOException;

public class UserService {
	User[] users = new User[4];
	String line;

	public User[] populateUsersFromFile(String filename) throws IOException {
		String[] userDetails = FileService.readFile(filename);
		for (int i = 0; i < userDetails.length; i++) {
			line = userDetails[i];
			User user = new User(line.split(","));
			users[i] = user;
		}
		return users;
	}

	public User getUserByUsernameAndPassword(String usernameInput, String passwordInput) throws IOException {
		for (User user : users) {
			if (user.getUsername().equals(usernameInput.toLowerCase()) && user.getPassword().equals(passwordInput)) {
				return user;
			}
		}
		return null;
	}
}
