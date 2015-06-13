package com.cnu.ds.graphs;

import java.io.IOException;

public class SGClient {
	public static void main(String[] args) throws IOException {
		SymbolGraph symbolGraph = new SymbolGraph("movies.txt", "/");
		Iterable<Integer> iterator = symbolGraph.getGraph().adj(
				symbolGraph.index("Walsh, J.T."));
		for (Integer index : iterator) {
			System.out.println(symbolGraph.key(index));
		}
		System.out.println();
	}
}
