package graphData;

import java.util.HashMap;
import java.util.Collection;

/**
 * Class representing a simple, undirected graph. By the rules of simple graphs,
 * there can only be at most a single edge that exists between each pair of
 * verticies.
 * 
 * @author pendgaft
 * 
 */
public class SimpleGraph {

	private HashMap<Integer, Vertex> vertexMapping;

	/**
	 * Constructor that creates an empty graph
	 */
	public SimpleGraph() {
		this.vertexMapping = new HashMap<Integer, Vertex>();
	}

	/**
	 * Adds a new vertex to the graph with the given ID and supplied
	 * supplemental data
	 * 
	 * @param vertexID
	 *            - the ID of the new vertex you wish to add
	 * @param supplementalData
	 *            - the supplemental data you wish the vertex to store, can be
	 *            NULL
	 */
	public void addVertex(int vertexID, Object supplementalData) {
		if (this.vertexMapping.containsKey(vertexID)) {
			throw new IllegalArgumentException("Attempted to add a vertex with ID equal to an existing vertex: "
					+ vertexID);
		}

		this.vertexMapping.put(vertexID, new Vertex(vertexID, supplementalData));
	}

	/**
	 * Adds a new edge between two verticies.
	 * 
	 * @param firstID
	 *            - one vertex
	 * @param secondID
	 *            - the other vertex
	 */
	public void buildEdgeBetween(int firstID, int secondID) {
		if (!this.vertexMapping.containsKey(firstID) || !this.vertexMapping.containsKey(secondID)) {
			throw new IllegalArgumentException("One or more of the supplied vertexes do not exist.");
		}

		Vertex lhs = this.vertexMapping.get(firstID);
		Vertex rhs = this.vertexMapping.get(secondID);
		Edge newEdge = new Edge(lhs, rhs);
		lhs.addEdge(newEdge);
		rhs.addEdge(newEdge);
	}

	/**
	 * Returns a collection containing all current verticies that exist in the
	 * graph.
	 * 
	 * @return - the collection of all vertex IDs in the graph
	 */
	public Collection<Integer> getVertexIDSet() {
		return this.vertexMapping.keySet();
	}

	/**
	 * Predicate to test if a given vertex is in the graph currently.
	 * 
	 * @param vertexID
	 *            - the vertex id we wish to test
	 * @return - true if the graph contains a vertex with that ID, false
	 *         otherwise
	 */
	public boolean containsID(int vertexID) {
		return this.vertexMapping.containsKey(vertexID);
	}

	/**
	 * Fetches the vertex mapped to a given ID.
	 * 
	 * @param id
	 *            - the id matching the vertex object we wish to fetch
	 * @return - the vertex mapped to the given ID
	 */
	public Vertex getVertexByID(int id) {
		if (!this.vertexMapping.containsKey(id)) {
			throw new IllegalArgumentException("Attempted to fetch a non-existant vertex: " + id);
		}
		return this.vertexMapping.get(id);
	}

	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		for (Vertex tVertex : this.vertexMapping.values()) {
			strBuild.append(tVertex.toString() + "\n\n");
		}
		return strBuild.toString();
	}

}
