package data;

import java.util.*;

public class DirectedGraph {

	private HashMap<Integer, DirectedVertex> vertexMapping;
	
	public DirectedGraph() {
		this.vertexMapping = new HashMap<Integer, DirectedVertex>();
	}
	
	public void addVertex(int vertexID, Object suppData){
		DirectedVertex newVert = new DirectedVertex(vertexID, suppData);
		this.vertexMapping.put(vertexID, newVert);
	}
	
	public void buildEdge(int sourceVertexID, int destVertexID){
		if(!this.vertexMapping.containsKey(sourceVertexID) || !this.vertexMapping.containsKey(destVertexID)){
			throw new IllegalArgumentException("Attempted to create an edge with a vertex that does not exist.");
		}
		DirectedVertex sourceNode = this.vertexMapping.get(sourceVertexID);
		DirectedVertex dstNode = this.vertexMapping.get(destVertexID);
		DirectedEdge newEdge = new DirectedEdge(sourceNode, dstNode);
		sourceNode.addEdge(newEdge);
		dstNode.addEdge(newEdge);
	}
	
	public Set<Integer> getVertexIDSet(){
		return this.vertexMapping.keySet();
	}
	
	public DirectedVertex getVertex(int vertexID){
		return this.vertexMapping.get(vertexID);
	}

	public boolean containsVertexID(int vertexID){
		return this.vertexMapping.containsKey(vertexID);
	}
	
	public String toString(){
		StringBuilder strBuild = new StringBuilder();
		for(DirectedVertex tVertex: this.vertexMapping.values()){
			strBuild.append(tVertex.toString() + "\n\n");
		}
		return strBuild.toString();
	}
}
