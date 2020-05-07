package dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DijkstraClient {
	
	static List<Vertex> nodes = new ArrayList<Vertex>();
	static List<Edge> edges = new ArrayList<Edge>();
	
	private final static String STARTING_NODE = "A";
	private final static String ENDING_NODE = "G";
	
	public static void main(String [] args){		
		for(int i = 0; i < 7; i++){
			Vertex currentVertex = new Vertex((String)(getCharForNumber(i)).toUpperCase());
			nodes.add(currentVertex);			
		}
		
		edges.add(createEdge("A", 1, "B"));
		edges.add(createEdge("A", 6, "C"));
		edges.add(createEdge("B", 2, "C"));
		edges.add(createEdge("B", 4, "E"));
		edges.add(createEdge("C", 2, "D"));
		edges.add(createEdge("D", 3, "F"));
		edges.add(createEdge("E", 1, "G"));
		edges.add(createEdge("F", 3, "G"));
	
		Dijkstra d = new Dijkstra(new Graph(nodes, edges), getVertexWithName(STARTING_NODE));
		LinkedList<Vertex> path = d.getPath(getVertexWithName(ENDING_NODE));
		
		for(Vertex v : path){
			if(v.equals(getVertexWithName(ENDING_NODE)))
				System.out.print(v);
			else
				System.out.print(v + " --> ");
		}
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
	
	public static Edge createEdge(String vertexStart, int weight, String vertexEnd){
		return new Edge(getVertexWithName(vertexStart), weight, getVertexWithName(vertexEnd));
	}
	
}
