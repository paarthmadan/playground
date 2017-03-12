package dijkstra;

public class Edge {
	
	private Vertex startNode;
	private Vertex endNode;
	private int weight;
	
	public Edge(Vertex startNode, int weight, Vertex endNode){
		this.startNode = startNode;
		this.weight = weight;
		this.endNode = endNode;
	}
	
	public Vertex getStartNode(){
		return startNode;
	}
	
	public Vertex getEndNode(){
		return startNode;
	}
	
	public int getWeight(){
		return weight;
	}
	
	@Override
	public String toString(){
		return startNode.getName() + " to " + endNode.getName() + " by weight " + this.getWeight();
	}
	
}
