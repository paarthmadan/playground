package dijkstra;

import java.util.List;

public class Graph {
	
	private List<Vertex> nodes;
	private List<Edge> edges;
	
	public Graph(List<Vertex> nodes, List<Edge> edges){
		this.edges = edges;
		this.nodes = nodes;
	}
	
	public List<Vertex> getNodes(){
		return nodes;
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
}
