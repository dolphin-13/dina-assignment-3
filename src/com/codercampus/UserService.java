package com.codercampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	User[] users = new User[4];
	String line;

	public User[] createUserArray(String[] lines) throws IOException {
		for (int i = 0; i < lines.length; i++) {
			line = lines[i];
			User user = new User(line.split(","));
			users[i] = user;
		}
		return users;
	}

	public String[] readFile(String filename) throws IOException {
		String[] lines = new String[4];
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				lines[i++] = line;
			}
		} finally {
			fileReader.close();
		}
		return lines;
	}

	public User defineValidUser(String usernameInput, String passwordInput) throws IOException {
		for (User user : users) {
			if (user.getUsername().equals(usernameInput.toLowerCase()) && user.getPassword().equals(passwordInput)) {
				return user;
			}
		}
		return null;
	}
}
