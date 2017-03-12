package dijkstra;
import java.util.*;

public class Dijkstra {
	
	Vertex startingNode;
	Vertex destinationNode;
	
	//ALGORITHM
	public Dijkstra(List<Vertex> nodes, List<Edge> edges){
		
		this.startingNode = nodes.get(0);
		this.destinationNode = nodes.get(nodes.size() - 1);
		
		//PRINTS ALL NODES
		for(Vertex v: nodes)
			System.out.println(v.getName());
		
		for(Edge e : edges)
			System.out.println(e);
		
		System.out.println("Goal: " + startingNode.getName() + " --> " + destinationNode.getName());
	}
	
}
