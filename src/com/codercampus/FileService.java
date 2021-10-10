package com.codercampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	static String line;
	
	public static String[] readFile(String filename) throws IOException {
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
}
