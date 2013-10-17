package graphData;

/**
 * Class that represents an undirected edge between two verticies.
 * 
 * @author pendgaft
 * 
 */
public class Edge {

	private Vertex firstVertex;
	private Vertex secondVertex;

	/**
	 * Constructor which builds an edge connecting two verticies. Order of the
	 * verticies is not important.
	 * 
	 * @param node1
	 *            - one vertex
	 * @param node2
	 *            - the other vertex
	 */
	public Edge(Vertex node1, Vertex node2) {
		this.firstVertex = node1;
		this.secondVertex = node2;
	}

	/**
	 * Fetches an array which contains both verticies.
	 * 
	 * @return - an array containing the two verticies
	 */
	public Vertex[] getVerticies() {
		Vertex[] retArray = new Vertex[2];
		retArray[0] = this.firstVertex;
		retArray[1] = this.secondVertex;
		return retArray;
	}

	/**
	 * Gets the vertex that is NOT the supplied vertex (i.e. it gets the other
	 * vertex connected to the edge).
	 * 
	 * @param avoidVertex
	 *            - the vertex we do NOT want to return
	 * @return - the other vertex that is on this edge
	 */
	public Vertex getOtherVertex(Vertex avoidVertex) {
		if (this.firstVertex.equals(avoidVertex)) {
			return this.secondVertex;
		}

		if (this.secondVertex.equals(avoidVertex)) {
			return this.firstVertex;
		}

		throw new IllegalArgumentException(
				"Ask to get other vertex, but the vertex provided to avoid isn't on the edge!");
	}

	public int hashCode() {
		return this.firstVertex.hashCode() + this.secondVertex.hashCode();
	}

	public boolean equals(Object rhsObject) {
		Edge rhsEdge = (Edge) rhsObject;
		return (this.firstVertex.equals(rhsEdge.firstVertex) && this.secondVertex.equals(rhsEdge.secondVertex))
				|| (this.secondVertex.equals(rhsEdge.firstVertex) && this.firstVertex.equals(rhsEdge.secondVertex));
	}

	public String toString() {
		return this.firstVertex.getVertexID() + " -> " + this.secondVertex.getVertexID();
	}
}
