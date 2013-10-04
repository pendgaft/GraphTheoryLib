package data;

import java.util.*;



public class DirectedVertex extends AbstractVertex {

	private HashSet<DirectedEdge> incomingEdges;
	private HashSet<DirectedEdge> outgoingEdges;
	
	public DirectedVertex(int idValue) {
		super(idValue);
		this.incomingEdges = new HashSet<DirectedEdge>();
		this.outgoingEdges = new HashSet<DirectedEdge>();
	}

	public DirectedVertex(int idValue, Object supData) {
		super(idValue, supData);
		this.incomingEdges = new HashSet<DirectedEdge>();
		this.outgoingEdges = new HashSet<DirectedEdge>();
	}
	
	public void addEdge(DirectedEdge newDirectedEdge){
		if(newDirectedEdge.getToVertex().equals(this)){
			this.incomingEdges.add(newDirectedEdge);
		} else if(newDirectedEdge.getFromVertex().equals(this)){
			this.outgoingEdges.add(newDirectedEdge);
		} else{
			throw new IllegalArgumentException("Asked to add an edge this vertex isn't on...");
		}
	}
	
	public Collection<Integer> getPredacessorVertexIDs(){
		HashSet<Integer> idSet = new HashSet<Integer>();
		
		for(DirectedEdge tEdge: this.incomingEdges){
			idSet.add(tEdge.getFromVertex().getVertexID());
		}
		
		return idSet;
	}
	
	public Collection<Integer> getReachableVertexIDs(){
		HashSet<Integer> idSet = new HashSet<Integer>();
		
		for(DirectedEdge tEdge: this.outgoingEdges){
			idSet.add(tEdge.getToVertex().getVertexID());
		}
		
		return idSet;
	}
	
	public String toString(){
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append("Vertex id: " + this.getVertexID() + "\n");
		for(DirectedEdge tEdge: this.incomingEdges){
			strBuild.append("  " + tEdge.toString() + "\n");
		}
		for(DirectedEdge tEdge: this.outgoingEdges){
			strBuild.append("  " + tEdge.toString() + "\n");
		}
		
		return strBuild.toString();
	}

}
