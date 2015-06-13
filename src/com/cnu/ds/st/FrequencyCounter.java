package com.cnu.ds.st;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCounter {
	public static void main(String[] args) throws IOException {
		SymbolTable<String, Integer> symbolTable = new SequentailSearchST<>();
		File file = new File("ST_DATA\\tale.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.length() >= 1) {
				String words[] = line.split(" ");
				for (String word : words) {
					if (symbolTable.contains(word)) {
						symbolTable.put(word, symbolTable.get(word) + 1);
					} else {
						symbolTable.put(word, 1);
					}
				}
			}
		}
		bufferedReader.close();
		Iterable<String> keys = symbolTable.keys();
		int count = 0;
		int _8Size = 0, _10Size = 0;
		for (String key : keys) {
			count += symbolTable.get(key);
			System.out.println(key + " : " + symbolTable.get(key));
			if (key.length() >= 10) {
				_10Size++;
			}
			if (key.length() >= 8) {
				_8Size++;
			}
		}
		System.out.println("Total Words: " + count);
		System.out.println("Total Words of min length 8 words: " + _8Size);
		System.out.println("Total Words of min length 10 words: " + _10Size);
	}
}
