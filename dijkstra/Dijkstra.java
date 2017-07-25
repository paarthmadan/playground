package dijkstra;
import java.util.*;

public class Dijkstra {
	
	private Vertex startingNode;
	
	private List<Edge> edges;
	private List<Vertex> nodes;
	
	//data type that only stores unique vertexes (will only be added, if the vertex is not already in the set)
	private Set<Vertex> settledNodes;
	private Set<Vertex> unsettledNodes;
	
	//PARALLEL 
	//--> predecessors stores the node, and the vertex that it's route is derived from
	//--> distance stores the node, alongside the current cost
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;
	
	//ALGORITHM
	public Dijkstra(Graph graph){
		
		this.nodes = graph.getNodes();
		this.edges = graph.getEdges();
		
		this.startingNode = nodes.get(0);
		
		//PRINTS ALL NODES
		for(Vertex v: nodes)
			System.out.println(v.getName());
		
		for(Edge e : edges)
			System.out.println(e);
		
		settledNodes = new HashSet<Vertex>();
		unsettledNodes = new HashSet<Vertex>();
		
		predecessors = new HashMap<Vertex,Vertex>();
		distance = new HashMap<Vertex, Integer>();
		
		//Allocating a distance of zero to the initial node, and placing it in the unsettledNodes set
		distance.put(startingNode, 0);
		unsettledNodes.add(startingNode);
		
		while(unsettledNodes.size() > 0){
			Vertex settledNode = findMinimumNode(unsettledNodes);
			settledNodes.add(settledNode);
			unsettledNodes.remove(settledNode);
			findUnsettledNodes(settledNode);
			System.out.println("Just settled: " + settledNode.getName());
		}
		
		
	}
	
	
	
	private void findUnsettledNodes(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbouringNodes(node);
		for(Vertex target : adjacentNodes){
			if(getTotalDistance(target) > getTotalDistance(node) + distanceBetweenVertexes(node, target)){
				distance.put(target, getTotalDistance(node) + distanceBetweenVertexes(node, target));
				predecessors.put(target, node);
				unsettledNodes.add(target);
			}
		}
	}
	
	private int distanceBetweenVertexes(Vertex node, Vertex target){
		
		int weight = -1;
		
		for(Edge e : edges)
			if(e.getStartNode().equals(node) && e.getEndNode().equals(target))
				weight = e.getWeight();
		
		return weight;
	}


	private List<Vertex> getNeighbouringNodes(Vertex node){
		List<Vertex> neighbours = new ArrayList<Vertex>();
		
		for(Edge e : edges){
			if (e.getStartNode().equals(node) && !settledNodes.contains(e.getEndNode())){
				neighbours.add(e.getEndNode());
			}
		}					
		return neighbours;	
	}

	//Finds the node with the least distance
	private Vertex findMinimumNode(Set<Vertex> vertexes){
		Vertex minimumNode = null;
		
		for(Vertex v : vertexes){
			//first case
			if(minimumNode == null)
				minimumNode = v;
			else
				if(getTotalDistance(minimumNode) > getTotalDistance(v))
					minimumNode = v;
		}
		
		return minimumNode;
	}

	//gets the current total distance as per the map, and if non-existent assumes it's unreachable/infinite
	private int getTotalDistance(Vertex node) {
		int dist = Integer.MAX_VALUE;
		
		if(distance.get(node) != null)
			dist = distance.get(node);
		
		return dist;
	}
	
	public LinkedList<Vertex> getPath(Vertex targetNode){
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex currentStep = targetNode;
		
		if(predecessors.get(currentStep) == null){
			return null;
		}
		
		path.add(currentStep);
		
		while(predecessors.get(currentStep) != null){
			currentStep = predecessors.get(currentStep);
			path.add(currentStep);
		}
		
		Collections.reverse(path);
		
		return path;
	}
	
}
