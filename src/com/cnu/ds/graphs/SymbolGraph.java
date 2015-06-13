package com.cnu.ds.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SymbolGraph {
	private Graph graph;
	private String keys[];
	private Map<String, Integer> reverseIndex;

	public SymbolGraph(String fileName, String del) throws IOException {
		reverseIndex = new HashMap<>();
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while ((line = reader.readLine()) != null) {
			String[] keys = line.split(del);
			for (int i = 0; i < keys.length; i++) {
				if (!contains(keys[i])) {
					reverseIndex.put(keys[i], reverseIndex.size());
				}
			}
		}
		reader.close();

		this.keys = new String[reverseIndex.size()];
		graph = new Graph(reverseIndex.size());
		Iterator<String> keys = reverseIndex.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			this.keys[index(key)] = key;
		}

		reader = new BufferedReader(new FileReader(fileName));
		line = null;
		while ((line = reader.readLine()) != null) {
			String[] keys1 = line.split(del);
			int u = reverseIndex.get(keys1[0]);
			for (int i = 1; i < keys1.length; i++) {
				graph.addEdge(u, index(keys1[i]));
			}
		}
		reader.close();

	}

	public int index(String key) {
		return reverseIndex.get(key);
	}

	public String key(int index) {
		return keys[index];
	}

	public boolean contains(String key) {
		return reverseIndex.containsKey(key);
	}

	public Graph getGraph() {
		return graph;
	}

}
