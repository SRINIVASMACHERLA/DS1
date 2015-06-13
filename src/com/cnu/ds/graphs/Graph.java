package com.cnu.ds.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cnu8
 * 
 */
public class Graph implements IGraph {
	private int v;
	private List<List<Integer>> adjecencyLists;
	private int e;

	public Graph(int v) {
		this.v = v;
		adjecencyLists = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			List<Integer> list = new LinkedList<>();
			adjecencyLists.add(list);
		}
	}

	public Graph(BufferedReader reader) throws IOException {
		this(valueOf(reader.readLine()));
		int e = valueOf(reader.readLine());
		for (int i = 0; i < e; i++) {
			String[] edgeVertices = reader.readLine().split(" ");
			addEdge(valueOf(edgeVertices[0]), valueOf(edgeVertices[1]));
		}
	}

	@Override
	public void addEdge(int u, int v) {
		adjecencyLists.get(u).add(0, v);
		adjecencyLists.get(v).add(0, u);
		e++;
	}

	@Override
	public int getV() {
		return v;
	}

	@Override
	public int getE() {
		return e;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adjecencyLists.get(v);
	}

	@Override
	public String toString() {
		return "Graph { v=" + v + ",\nadjecencyLists" + adjecencyLists() + "}";
	}

	private String adjecencyLists() {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (List<Integer> list : adjecencyLists) {
			builder.append("\n" + i + " -> " + list);
			i++;
		}
		builder.append("\n");
		return builder.toString();
	}

	private static int valueOf(String s) {
		return Integer.valueOf(s.trim());
	}
}
