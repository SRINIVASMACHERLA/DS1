package com.cnu.ds.graphs;

public interface IGraph {
	int getE();

	int getV();

	Iterable<Integer> adj(int v);

	String toString();

	void addEdge(int u, int v);
}
