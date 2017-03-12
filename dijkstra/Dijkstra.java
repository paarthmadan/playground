package dijkstra;
import java.util.*;

public class Dijkstra {
	
	//ALGORITHM
	public Dijkstra(List<Vertex> nodes, List<Edge> edges){
		
		//PRINTS ALL NODES
		for(Vertex v: nodes)
			System.out.println(v.getName());
		
		for(Edge e : edges)
			System.out.println(e);
	}
	
}
