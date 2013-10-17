package graphData;


public class DirectedEdge {
	
	private DirectedVertex fromVertex;
	private DirectedVertex toVertex;

	public DirectedEdge(DirectedVertex node1, DirectedVertex node2) {
		this.fromVertex = node1;
		this.toVertex = node2;
	}
	
	public DirectedVertex getFromVertex(){
		return this.fromVertex;
	}
	
	public DirectedVertex getToVertex(){
		return this.toVertex;
	}

	public int hashCode(){
		return this.fromVertex.hashCode() * 2 + this.toVertex.hashCode();
	}
	
	public boolean equals(Object rhsObject){
		DirectedEdge rhsEdge = (DirectedEdge)rhsObject;
		return this.fromVertex.equals(rhsEdge.fromVertex) && this.toVertex.equals(rhsEdge.toVertex);
	}
	
	public String toString(){
		return fromVertex.getVertexID() + " -> " + toVertex.getVertexID();
	}

}
