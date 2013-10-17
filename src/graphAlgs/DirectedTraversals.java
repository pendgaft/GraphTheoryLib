package graphAlgs;

import java.util.*;
import graphData.DirectedEdge;
import graphData.DirectedGraph;
import graphData.DirectedVertex;

public class DirectedTraversals {
	
	public static Set<Integer> childNodeSet(DirectedGraph theGraph, int startingVert){
		Set<Integer> childSet = new HashSet<Integer>();
		Set<Integer> toVisit = new HashSet<Integer>();
		Set<Integer> nextPass = new HashSet<Integer>();
		
		toVisit.addAll(theGraph.getVertex(startingVert).getReachableVertexIDs());
		while(!toVisit.isEmpty()){
			nextPass.clear();
			for(int tVert: toVisit){
				if(childSet.contains(tVert)){
					continue;
				}
				
				childSet.add(tVert);
				nextPass.addAll(theGraph.getVertex(tVert).getReachableVertexIDs());
			}
			
			toVisit.clear();
			toVisit.addAll(nextPass);
		}
		
		return childSet;
	}

}
