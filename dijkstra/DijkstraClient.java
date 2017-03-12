package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraClient {
	
	static List<Vertex> nodes = new ArrayList<Vertex>();
	static List<Edge> edges = new ArrayList<Edge>();
	
	
	public static void main(String [] args){		
		for(int i = 0; i < 7; i++){
			Vertex currentVertex = new Vertex((String)(getCharForNumber(i)).toUpperCase());
			nodes.add(currentVertex);			
		}
		
		edges.add(new Edge(getVertexWithName("A"), 2, getVertexWithName("B")));
		edges.add(new Edge(getVertexWithName("A"), 1, getVertexWithName("C")));
		edges.add(new Edge(getVertexWithName("B"), 4, getVertexWithName("C")));
		edges.add(new Edge(getVertexWithName("B"), 5, getVertexWithName("G")));
		edges.add(new Edge(getVertexWithName("C"), 1, getVertexWithName("D")));
		edges.add(new Edge(getVertexWithName("C"), 2, getVertexWithName("E")));
		edges.add(new Edge(getVertexWithName("E"), 3, getVertexWithName("G")));
	
		Dijkstra d = new Dijkstra(nodes, edges);
		
	}
	
	
	//GETS CHARACTER WITH GIVEN INTERGER INDEX
	public static String getCharForNumber(int i) {
	    return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
	}
	
	public static Vertex getVertexWithName(String name){
		for(Vertex i : nodes){
			if(i.getName().equals(name))
				return i;
		}
		return null;
	}
	
	
}
