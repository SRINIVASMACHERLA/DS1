package com.cnu.ds.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphClient {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("tinyG"));
		Graph graph = new Graph(reader);
	}
}
