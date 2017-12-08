package breadth_first_search;

import java.util.ArrayList;

public class Node {
	private int label;
	private ArrayList<Node> adjacentNodes;
	
	public Node(int label){
		this.label = label;
		this.adjacentNodes = new ArrayList<Node>();
	}
	
	public void addAdjacentNode(Node adjacentNode){
		this.adjacentNodes.add(adjacentNode);
	}
	
	public ArrayList<Node> getAdjacentNodes(){
		return this.adjacentNodes;
	}
	
	public int getLabel(){
		return this.label;
	}
}
