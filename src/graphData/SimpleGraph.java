package graphData;

import java.util.HashMap;
import java.util.Random;

public class SimpleGraph {
	
	private HashMap<Integer, Vertex> vertexMapping;
	private Random rng;

	public SimpleGraph() {
		this.vertexMapping = new HashMap<Integer, Vertex>();
		this.rng = new Random();
	}
	

}
