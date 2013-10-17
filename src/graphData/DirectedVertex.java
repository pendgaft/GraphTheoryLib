package graphData;

import java.util.*;

/**
 * Class that represents a vertex with DIRECTED edges.
 * 
 * @author pendgaft
 * 
 */
public class DirectedVertex extends AbstractVertex {

	private HashSet<DirectedEdge> incomingEdges;
	private HashSet<DirectedEdge> outgoingEdges;

	/**
	 * Constructor that builds a vertex with no edges connected. The
	 * supplemental data is set to NULL.
	 * 
	 * @param idValue
	 *            - the ID value of the vertex
	 */
	public DirectedVertex(int idValue) {
		super(idValue);
		this.incomingEdges = new HashSet<DirectedEdge>();
		this.outgoingEdges = new HashSet<DirectedEdge>();
	}

	/**
	 * Constructor that builds a vertex with no edges connected and the supplied
	 * object stored as supplemental data.
	 * 
	 * @param idValue
	 *            - the ID value of the vertex
	 * @param supData
	 *            - the supplemental data that the vertex will store, can be
	 *            NULL
	 */
	public DirectedVertex(int idValue, Object supData) {
		super(idValue, supData);
		this.incomingEdges = new HashSet<DirectedEdge>();
		this.outgoingEdges = new HashSet<DirectedEdge>();
	}

	/**
	 * Records an edge that either leads from or leads to this vertex.
	 * 
	 * @param newDirectedEdge
	 *            - the edge this vertex is on
	 */
	public void addEdge(DirectedEdge newDirectedEdge) {
		if (newDirectedEdge.getToVertex().equals(this)) {
			this.incomingEdges.add(newDirectedEdge);
		} else if (newDirectedEdge.getFromVertex().equals(this)) {
			this.outgoingEdges.add(newDirectedEdge);
		} else {
			throw new IllegalArgumentException("Asked to add an edge this vertex isn't on...");
		}
	}

	/**
	 * Gets all node IDs that have an edge that leads from them to us. In
	 * otherwords the set of verticies that can reach us directly.
	 * 
	 * @return - a collection containing the vertex IDs of all verticies that
	 *         can directly reach this vertex
	 */
	public Collection<Integer> getPredacessorVertexIDs() {
		HashSet<Integer> idSet = new HashSet<Integer>();

		for (DirectedEdge tEdge : this.incomingEdges) {
			idSet.add(tEdge.getFromVertex().getVertexID());
		}

		return idSet;
	}

	/**
	 * Fetches the vertex IDs of all verticies that we can directly reach. In
	 * otherwords the set of all verticies with an edge from this vertex to
	 * them.
	 * 
	 * @return - a collection containing all vertex IDs that can be directly
	 *         reached from this vertex
	 */
	public Collection<Integer> getReachableVertexIDs() {
		HashSet<Integer> idSet = new HashSet<Integer>();

		for (DirectedEdge tEdge : this.outgoingEdges) {
			idSet.add(tEdge.getToVertex().getVertexID());
		}

		return idSet;
	}

	public String toString() {
		StringBuilder strBuild = new StringBuilder();

		strBuild.append("Vertex id: " + this.getVertexID() + "\n");
		for (DirectedEdge tEdge : this.incomingEdges) {
			strBuild.append("  " + tEdge.toString() + "\n");
		}
		for (DirectedEdge tEdge : this.outgoingEdges) {
			strBuild.append("  " + tEdge.toString() + "\n");
		}

		return strBuild.toString();
	}

}
