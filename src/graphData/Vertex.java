package graphData;

import java.util.*;

/**
 * Class representing verticies in an undirected graph.
 * 
 * @author pendgaft
 * 
 */
public class Vertex extends AbstractVertex {

	private HashSet<Edge> edgeSet;

	/**
	 * Creates a Vertex with the supplied ID and NULL as the supplemental data.
	 * 
	 * @param idValue
	 *            - the ID value the vertex will have
	 */
	public Vertex(int idValue) {
		super(idValue);
		this.edgeSet = new HashSet<Edge>();
	}

	/**
	 * Creates a Vertex with the supplied ID and supplemental data object.
	 * 
	 * @param idValue
	 *            - the ID value the vertex will have
	 * @param supData
	 *            - the supplemental data the vertex will store, can be NULL
	 */
	public Vertex(int idValue, Object supData) {
		super(idValue, supData);
		this.edgeSet = new HashSet<Edge>();
	}

	/**
	 * Records tells the node to store an edge that is connected to it. This
	 * handels enforcement of the simple edge policy.
	 * 
	 * @param newEdge
	 *            - the edge we're connected to
	 */
	public void addEdge(Edge newEdge) {
		this.edgeSet.add(newEdge);
	}

	/**
	 * Returns all edges that this vertex knows are connected to it.
	 * 
	 * @return a collection containing all edges this vertex knows are adjacent
	 *         to it
	 */
	public Collection<Edge> getEdges() {
		return this.edgeSet;
	}

	/**
	 * Returns all verticies that this vertex knows it is connected to via an
	 * edge
	 * 
	 * @return a collection containing all verticies that are adjacent to this
	 *         one (i.e. they share an edge)
	 */
	public Collection<Integer> getAdjecentVertexIDs() {
		HashSet<Integer> idSet = new HashSet<Integer>();

		for (Edge tEdge : this.edgeSet) {
			idSet.add(tEdge.getOtherVertex(this).getVertexID());
		}

		return idSet;
	}

	public String toString() {
		StringBuilder strBuild = new StringBuilder();

		strBuild.append("Vertex id: " + this.getVertexID() + "\n");
		for (Edge tEdge : this.edgeSet) {
			strBuild.append("  " + tEdge.toString() + "\n");
		}

		return strBuild.toString();
	}
}
